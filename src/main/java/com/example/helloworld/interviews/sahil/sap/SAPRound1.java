package com.example.helloworld.interviews.sahil.sap;

public class SAPRound1 {
    // check the dump text below for three coding questions and java scenario based questions(based on HashMap/ good key  etc )
}

// Input is String
// Output is boolean saying whether given string is a palindorme or not

//    public boolean isPalindrome(String str){
//        if(str == null) return true;
//
//        int l = 0, r = str.length() - 1;
//
//        while(l<r){
//            if(str.charAt(l) != str.charAt(r)){
//                return false;
//            }
//            l++; r--;
//        }
//
//        return true;
//    }

//-------


//public class TreeNode {
//
//
//    public int val ;
//
//    public TreeNode left;
//
//    public TreeNode rigjht
//
//    public TreeNode(int val){
//        this.val = val;
//    }
//
//}


// Input - TreeNode tr1, TreeNode tr2
// Output - Boolean saying whether tr1 and tr2 are mirror images of each other,
//  tr2 is  tr1's mirror image

//    public boolean areMirrors(TreeNode tr1, TreeNode tr2){
//        if( tr1 == null && tr2 == null ){
//            return true;
//        }
//        if( tr1 == null || tr2 == null ){
//            return false;
//        }
//
//        return tr1.val == tr2.val && areMirrors(tr1.left, tr2.right) && areMirrors(tr1.right, tr2.left);
//    }

//--------


// Input - 2D Character Array, STRING expected
// Output - Boolean
/*
        Whether name SAHIL is present in 2d Array
        4D  - Up, Down, Left, Right


        approach : checking all the possible scenarios starting with s.charAt(0) and going in all 4 directions, keeping track of the visited
        nodes while moving in directions.


        > input string : sms
        > input char matrix :
        a b c
        s m n
        p q r
*/
class Solution{
    int m,n;
    int[][] dir = new int[][]{ {1,0}, {-1,0}, {0,1}, {0,-1}};	// right, left, top, bottom

    public boolean present(char[][] grid, String name){
        if( name == null || name.length() == 0 ) return true;
        if( grid.length == 0 ) return false;

        m = grid.length;
        n = grid[0].length;
        boolean present = false;
        // iterate through matrix
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == name.charAt(0))
                    present |= dfs(grid, name, i, j, 0, new boolean[m][n]);  		// 0,0
            }
        }

        return present;
    }

    private boolean dfs(char[][] grid, String name, int i, int j, int idx, boolean[][] visited){
        if(i < 0 || j < 0 || i>=m || j>=n || grid[i][j] != name.charAt(idx) || visited[i][j]){
            return false;
        }
        if(idx == name.length()-1){
            return true;
        }

        boolean res = false;
        visited[i][j] = true;
        for(int[] d : dir){
            int nrow = i + d[0];
            int ncol = j + d[1];
            res |= dfs(grid, name, nrow, ncol, idx + 1, visited);
        }
        visited[i][j] = false;

        return res;
    }

}


//--------

/*


public final class Employee {

    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    private int id;

    private String name;

    public int hashcode() {

        //based on id and name
    }

}

public class SubEmployee extends Employee{

    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    private int id;

    public String name;

}


public class Accounting {

    public Accounting(int accNo, String branch, long salary){
        this.accNo = accNo;
        this.branch = branch;
        this.salary = salary;
    }


    public int accNo;

    public String branch;

    public long salary;

}




    Map<Employee, Accounting> accMap = new HashMap<>();

    Employee ajay = new Employee(1, "Ajay");

    Accounting acc1 = new Accounting(1, "Blr", 100000);

	accMap.put(ajay, acc1);

            //ajay.name = "Ajay Kumar";

            Accounting accRetrieved = accMap.get(ajay);

// Is accRetrieved Null or acc1.

*/









