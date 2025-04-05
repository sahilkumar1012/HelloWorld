package com.example.helloworld.design;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowRateLimiter {
    private final int maxRequests;
    private final long windowSizeInMillis;
    private final ConcurrentHashMap<String, UserBucket> userBuckets = new ConcurrentHashMap<>();

    public FixedWindowRateLimiter(int maxRequests, long windowSizeInSeconds) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInSeconds * 1000;
    }

    public synchronized boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();
        userBuckets.putIfAbsent(userId, new UserBucket(maxRequests, currentTime));

        UserBucket bucket = userBuckets.get(userId);

        // Reset bucket if time window has passed
        if (currentTime - bucket.lastResetTime >= windowSizeInMillis) {
            int unusedRequests = maxRequests - bucket.requestCount.get();
            bucket.credits = Math.min(bucket.credits + unusedRequests / 2, maxRequests); // Carry forward half of unused requests
            bucket.requestCount.set(0);
            bucket.lastResetTime = currentTime;
        }

        if (bucket.requestCount.get() < maxRequests + bucket.credits) {
            bucket.requestCount.incrementAndGet();
            return true;
        }
        return false;
    }

    private static class UserBucket {
        AtomicInteger requestCount;
        long lastResetTime;
        int credits;

        public UserBucket(int maxRequests, long startTime) {
            this.requestCount = new AtomicInteger(0);
            this.lastResetTime = startTime;
            this.credits = 0;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FixedWindowRateLimiter rateLimiter = new FixedWindowRateLimiter(5, 10); // 5 requests per 10 seconds
        String userId = "user123";

        // Simulating requests
        for (int i = 0; i < 7; i++) {
            System.out.println("Request " + (i + 1) + ": " + rateLimiter.allowRequest(userId));
            Thread.sleep(1000); // Simulate some delay
        }
    }
}
