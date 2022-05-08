package com.example.helloworld.interviews.sahil.coinbase;

import java.util.*;
/*

# Coinbase karat coding interview test.

Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID.

The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.

Example:
logs1 = [
    ["58523", "user_1", "resource_1"],
    ["62314", "user_2", "resource_2"],
    ["54001", "user_1", "resource_3"],
    ["200", "user_6", "resource_5"],
    ["215", "user_6", "resource_4"],
    ["54060", "user_2", "resource_3"],
    ["53760", "user_3", "resource_3"],
    ["58522", "user_22", "resource_1"],
    ["53651", "user_5", "resource_3"],
    ["2", "user_6", "resource_1"],
    ["100", "user_6", "resource_6"],
    ["400", "user_7", "resource_2"],
    ["100", "user_8", "resource_6"],
    ["54359", "user_1", "resource_3"],
]

Example 2:
logs2 = [
    ["300", "user_1", "resource_3"],
    ["599", "user_1", "resource_3"],
    ["900", "user_1", "resource_3"],
    ["1199", "user_1", "resource_3"],
    ["1200", "user_1", "resource_3"],
    ["1201", "user_1", "resource_3"],
    ["1202", "user_1", "resource_3"]
]

Example 3:
logs3 = [
    ["300", "user_10", "resource_5"]
]

Write a function that takes the logs and returns the resource with the highest number of accesses in any 5 minute window, together with how many accesses it saw.

Expected Output:
most_requested_resource(logs1) # => ('resource_3', 3)
Reason: resource_3 is accessed at 53760, 54001, and 54060

most_requested_resource(logs2) # => ('resource_3', 4)
Reason: resource_3 is accessed at 1199, 1200, 1201, and 1202

most_requested_resource(logs3) # => ('resource_5', 1)
Reason: resource_5 is accessed at 300

Complexity analysis variables:

n: number of logs in the input
*/


public class Round1CodingProblem {
    public static void main(String[] argv) {
        String[][] logs1 = new String[][] {
                { "58523", "user_1", "resource_1" },
                { "62314", "user_2", "resource_2" },
                { "54001", "user_1", "resource_3" },
                { "200", "user_6", "resource_5" },
                { "215", "user_6", "resource_4" },
                { "54060", "user_2", "resource_3" },
                { "53760", "user_3", "resource_3" },
                { "58522", "user_22", "resource_1" },
                { "53651", "user_5", "resource_3" },
                { "2", "user_6", "resource_1" },
                { "100", "user_6", "resource_6" },
                { "400", "user_7", "resource_2" },
                { "100", "user_8", "resource_6" },
                { "54359", "user_1", "resource_3"},
        };

        String[][] logs2 = new String[][] {
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_3"},
                {"900", "user_1", "resource_3"},
                {"1199", "user_1", "resource_3"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_3"},
                {"1202", "user_1", "resource_3"}
        };

        String[][] logs3 = new String[][] {
                {"300", "user_10", "resource_5"}
        };


        // sort on the basis of time.
        // track count of all the resources access in the given window.
        // keep track of the maximum for each recource in every window.

        // Approach 2 , using map.
        // Map key = resource-id , value (list) time in sorted manner

        System.out.println(helper(logs1));
        System.out.println(helper(logs2));
        System.out.println(helper(logs3));
    }

    private static String helper(String[][] logs1){
        Map<String, List<Integer>> map = new HashMap<>();
        for(String[] log : logs1){
            String resource = log[2];
            map.putIfAbsent(resource, new ArrayList<>());
            map.get(resource).add(Integer.parseInt(log[0]));
        }

        // System.out.println(map);
        int maxAns = 0; String resource = "";
        // sort the times for each resource
        for(String key : map.keySet()){
            List<Integer> list = map.get(key);
            Collections.sort(list);

            // find max for each resource in every window(300)
            int ans = 0;
            for(int i=0; i<list.size(); i++ ){
                int start = list.get(i);
                int startIdx = i;
                while(startIdx < list.size() && start + 300 >= list.get(startIdx)){
                    ans = Math.max(ans, startIdx-i+1);
                    startIdx++;
                }
            }
            if(maxAns < ans){
                resource = key;
                maxAns = ans;
            }
        }


        String ans = "resource : " + resource + " , " + "count : " + maxAns;
        return ans;
    }
}
