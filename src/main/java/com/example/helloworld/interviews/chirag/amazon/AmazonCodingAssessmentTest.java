package com.example.helloworld.interviews.chirag.amazon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AmazonCodingAssessmentTest {

}
class AmazonCodingAssessmentTestProblem1 {

    /*
     * Complete the 'maxSetSize' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY riceBags as parameter.
     */

    public static int maxSetSize(List<Integer> riceBags) {
        // Write your code here
        Set<Long> s = new HashSet<>();
        for(int i=0; i < riceBags.size(); i++) {
            s.add(riceBags.get(i).longValue());
        }

        int ans = 0;


        for(int i=0; i<riceBags.size(); i++){
            int tempAns = 1;
            long item = riceBags.get(i);
            while(s.contains(item*item)){
                item = item*item;
                tempAns ++;
            }
            if(ans < tempAns)
                ans = tempAns;
        }

        return ans<2 ? -1 : ans;
    }

}


class AmazonCodingAssessmentTestProblem2 {

    /*
     * Complete the 'findMaxProducts' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY products as parameter.
     */


    public static long findMaxProducts(List<Integer> products) {
        int noOfProducts = products.size();
        long ans = 0;

        for (int i = noOfProducts - 1; i >= 0; --i) {
            if (i != noOfProducts - 1 && products.get(i) < products.get(i + 1))
                continue;

            long tempAns = products.get(i);
            long prev = tempAns;
            for (int idx = i - 1; idx >= 0; --idx) {
                prev = Math.min(prev - 1, products.get(idx));
                tempAns += prev;
                if (prev == 1) break;
            }
            ans = Math.max(tempAns, ans);
        }
        return ans;
    }


}
