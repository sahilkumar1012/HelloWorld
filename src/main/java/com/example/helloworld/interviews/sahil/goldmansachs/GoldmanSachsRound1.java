package com.example.helloworld.interviews.sahil.goldmansachs;

public class GoldmanSachsRound1 {
}

/*
 * Click `Run` to execute the snippet below!
 */

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val ){
        this.val = val;
    }
}
class TreeNode{
    int val;
    TreeNode left, right;
    public TreeNode(int val){
        this.val = val;
    }
}
/*
Input  : 2->1->2->1->1->2->0->1->0
Output : 0->0->1->1->1->1->2->2->2

list1
0 > 0 > 1 > 1 > 1 > 1 > 2 > 2 > 2

list2
> 2 > 2 > 2

list3

*/
class Solution {

    int ans, idx;
    public int sumOfLeafs(int[] preorder){
        ans = 0; idx = 0;
        helper( preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return ans;
    }
    // 1 2 4
    private TreeNode helper(int[] preorder, int lb, int ub){
        if(idx == preorder.length || preorder[idx] < lb || preorder[idx] > ub )
            return null;

        int val = preorder[idx++];
        TreeNode root = new TreeNode(val);

        root.left = helper(preorder, lb, val); // 1 , 1
        root.right = helper(preorder, val, ub);

        if(root.left == null && root.right == null)
            ans += root.val;

        return root;
    }

    // O(n) time , O(1) time.
    public ListNode sortList(ListNode head){
        ListNode list1 = new ListNode(-1), tail1 = list1;
        ListNode list2 = new ListNode(-1), tail2 = list2;
        ListNode list3 = new ListNode(-1), tail3 = list3;

        while(head != null){
            if(head.val == 0){
                tail1.next = head;
                tail1 = tail1.next;
            }else if(head.val == 1){
                tail2.next = head;
                tail2 = tail2.next;
            }else if(head.val == 2){
                tail3.next = head;
                tail3 = tail3.next;
            }
            head = head.next;
        }
        tail3.next = null;


        if(list1.next != null){   // 0 > 1 > 2
            head = list1.next;
            tail1.next = list2.next;
            if(tail1.next == null){   // 0 > 2 | 0 > 0 > 0
                tail2 = tail1;
            }
            tail2.next = list3.next;
        }else if( list2.next != null){      // 1 > 2
            head = list2.next;          // 2 > 2 > 2
            tail2.next = list3.next;
        }else{
            return list3.next;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println( new Solution().sumOfLeafs(new int[]{1,2,4}));
        System.out.println( new Solution().sumOfLeafs(new int[]{1,2,4,3,5}) );
    }
}

// Your previous Plain Text content is preserved below:

// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you'd like to use for your interview,
// simply choose it from the dropdown in the top bar.

// You can also change the default language your pads are created with
// in your account settings: https://app.coderpad.io/settings

// Enjoy your interview!





//Find the sum of all Leaf nodes of a BST given a preorder traversal


//  I/P: [1, 2, 4, 5, 3]



