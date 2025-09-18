package com.example.helloworld.design;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * leetcode 3408. Design Task Manager , Google interview question
 *
 * code harmony explanation video :
 *
 *
 * There is a task management system that allows users to manage their tasks, each associated with a priority. The system should efficiently handle adding, modifying, executing, and removing tasks.
 *
 * Implement the TaskManager class:
 *
 * TaskManager(vector<vector<int>>& tasks) initializes the task manager with a list of user-task-priority triples. Each element in the input list is of the form [userId, taskId, priority], which adds a task to the specified user with the given priority.
 *
 * void add(int userId, int taskId, int priority) adds a task with the specified taskId and priority to the user with userId. It is guaranteed that taskId does not exist in the system.
 *
 * void edit(int taskId, int newPriority) updates the priority of the existing taskId to newPriority. It is guaranteed that taskId exists in the system.
 *
 * void rmv(int taskId) removes the task identified by taskId from the system. It is guaranteed that taskId exists in the system.
 *
 * int execTop() executes the task with the highest priority across all users. If there are multiple tasks with the same highest priority, execute the one with the highest taskId. After executing, the taskId is removed from the system. Return the userId associated with the executed task. If no tasks are available, return -1.
 *
 * Note that a user may be assigned multiple tasks.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * ["TaskManager", "add", "edit", "execTop", "rmv", "add", "execTop"]
 * [[[[1, 101, 10], [2, 102, 20], [3, 103, 15]]], [4, 104, 5], [102, 8], [], [101], [5, 105, 15], []]
 *
 * Output:
 * [null, null, null, 3, null, null, 5]
 *
 * Explanation
 *
 * TaskManager taskManager = new TaskManager([[1, 101, 10], [2, 102, 20], [3, 103, 15]]); // Initializes with three tasks for Users 1, 2, and 3.
 * taskManager.add(4, 104, 5); // Adds task 104 with priority 5 for User 4.
 * taskManager.edit(102, 8); // Updates priority of task 102 to 8.
 * taskManager.execTop(); // return 3. Executes task 103 for User 3.
 * taskManager.rmv(101); // Removes task 101 from the system.
 * taskManager.add(5, 105, 15); // Adds task 105 with priority 15 for User 5.
 * taskManager.execTop(); // return 5. Executes task 105 for User 5.
 *
 *
 * Constraints:
 *
 * 1 <= tasks.length <= 105
 * 0 <= userId <= 105
 * 0 <= taskId <= 105
 * 0 <= priority <= 109
 * 0 <= newPriority <= 109
 * At most 2 * 105 calls will be made in total to add, edit, rmv, and execTop methods.
 * The input is generated such that taskId will be valid.
 */
class TaskManager {

    // Max-heap: stores [taskId, priority]
    // Comparator: higher priority first, tie -> higher taskId first
    PriorityQueue<int[]> pq;

    // Map: taskId -> [userId, priority]
    // Keeps track of the latest valid state of each task
    Map<Integer, int[]> map;

    // Initialize with given tasks
    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];   // tie-breaker: larger taskId first
            }
            return b[1] - a[1];       // otherwise: larger priority first
        });
        map = new HashMap<>();

        // Insert all initial tasks into both heap and map
        for (List<Integer> task : tasks) {
            int uid = task.get(0);  // userId
            int tid = task.get(1);  // taskId
            int p   = task.get(2);  // priority

            pq.offer(new int[]{tid, p});      // push into heap
            map.put(tid, new int[]{uid, p});  // record in map
        }
    }

    // Add a new task
    public void add(int userId, int taskId, int priority) {
        pq.offer(new int[]{taskId, priority});          // push into heap
        map.put(taskId, new int[]{userId, priority});   // record in map
    }

    // Edit priority of an existing task
    public void edit(int taskId, int newPriority) {
        int[] value = map.get(taskId);
        value[1] = newPriority;                         // update map
        pq.offer(new int[]{taskId, newPriority});       // push new version into heap
        // (old one becomes stale)
    }

    // Remove a task (lazy removal: only from map)
    public void rmv(int taskId) {
        map.remove(taskId);
        // The heap may still contain this task, but it will be skipped
        // later in execTop because it's missing from the map
    }

    // Execute the task with highest priority (tie -> highest taskId)
    // Return its userId, or -1 if no tasks available
    public int execTop() {
        while (!pq.isEmpty()) {
            int[] top = pq.poll();   // get best candidate from heap
            int taskId = top[0];

            int[] value = map.get(taskId);
            // If task doesn't exist in map (removed) OR
            // priority differs (stale entry due to edit), skip it
            if (value == null || value[1] != top[1]) {
                continue;
            }

            // Valid entry → remove from map and return userId
            map.remove(taskId);
            return value[0];
        }
        return -1;  // no tasks available
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId, taskId, priority);
 * obj.edit(taskId, newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
