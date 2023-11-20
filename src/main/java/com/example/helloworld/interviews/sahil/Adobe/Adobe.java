package com.example.helloworld.interviews.sahil.Adobe;

import java.util.HashMap;
import java.util.Map;

// Adobe interview question for CS-1
public class Adobe {
    public static void main(String[] args) {
        Adobe obj = new Adobe();
        obj.validIP("255255255255");
        obj.validIP("0000");
        obj.validIP("255000");
        obj.validIP("300000");
    }

    Map<String, Boolean> map = new HashMap<>();
    private void validIP(String ip){
        if(ip.length() < 4 || ip.length() > 12) // 0000 , 255255255255
            System.out.println("Not a valid IP");

        solve(ip, 0, 4, "");
    }
    // 2. 5625 6256256 0000
    private boolean solve(String ip, int index, int block, String ipString){
        String key = index+"-"+block;

        if(block == 0 && index >= ip.length()){
            System.out.println(ipString.substring(0,ipString.length()-1));
            return true;
        }

        if(map.containsKey(key)){
            return map.get(key);
        }

        for(int i=1; i<=3; i++){
            if(index+i <= ip.length()){
                String substring = ip.substring(index, index+i);
                if(validIPBlock(substring)){
                    boolean isValid = solve(ip, index+i, block-1, ipString + substring + ".");
                    if(isValid) {
                        map.put(key , true);
                        return true;
                    }
                    else{
                        map.put(key , false);
                    }
                }
            }
        }

        return false;
    }

    private boolean validIPBlock(String block){
        int val = Integer.parseInt(block);
        if( val == 0 && block.length() > 1 )
            return false;
        return val >=0 && val <= 255;
    }
}
