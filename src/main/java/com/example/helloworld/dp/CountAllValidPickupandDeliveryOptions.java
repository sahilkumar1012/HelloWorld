package com.example.helloworld.dp;

/**
 * leetcode 1359. Count All Valid Pickup and Delivery Options
 *  reference video : https://youtu.be/p1tvA-eQFqk
 *  solution : https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/solution/
 *
 * Given n orders, each order consist in pickup and delivery services.
 *
 * Count all valid pickup/delivery possible sequences such that delivery(i) is always after of pickup(i).
 *
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: 1
 * Explanation: Unique order (P1, D1), Delivery 1 always is after of Pickup 1.
 * Example 2:
 *
 * Input: n = 2
 * Output: 6
 * Explanation: All possible orders:
 * (P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1) and (P2,D2,P1,D1).
 * This is an invalid order (P1,D2,P2,D1) because Pickup 2 is after of Delivery 2.
 * Example 3:
 *
 * Input: n = 3
 * Output: 90
 *
 *
 * Constraints:
 *
 * 1 <= n <= 500
 *
 */
public class CountAllValidPickupandDeliveryOptions {
    // mathematics
    // video solution : https://youtu.be/JlBSoswl87c
    public int countOrders(int n) {
        int M = 1000000007;
        if( n == 1 ) return 1;
        long result = 1;

        for(int i=2; i<=n; i++){
            int spaces = (i-1) * 2 + 1;  //         _ p1 _ d1 _
            int possibility = ( spaces * (spaces+1) ) /2;

            result *= possibility;
            result %= M ;
        }

        return (int)result;
    }

}

class CountAllValidPickupandDeliveryOptionsRecursive {
    private int MOD = 1_000_000_007;
    private long[][] memo;

    private long totalWays(int unpicked, int undelivered) {
        if (unpicked == 0 && undelivered == 0) {
            // We have completed all orders.
            return 1;
        }

        if (unpicked < 0 || undelivered < 0 || undelivered < unpicked) {
            // We can't pick or deliver more than N items
            // Number of deliveries can't exceed number of pickups
            // as we can only deliver after a pickup.
            return 0;
        }

        if (memo[unpicked][undelivered] != 0) {
            // Return cached value, if already present.
            return memo[unpicked][undelivered];
        }

        long ans = 0;

        // Count all choices of picking up an order.
        ans += unpicked * totalWays(unpicked - 1, undelivered);
        // Handle integer overflow.
        ans %= MOD;

        // Count all choices of delivering a picked order.
        ans += (undelivered - unpicked) * totalWays(unpicked, undelivered - 1);
        // Handle integer overflow.
        ans %= MOD;

        return memo[unpicked][undelivered] = ans;
    }

    public int countOrders(int n) {
        memo = new long[n + 1][n + 1];
        return (int)totalWays(n, n);
    }
}