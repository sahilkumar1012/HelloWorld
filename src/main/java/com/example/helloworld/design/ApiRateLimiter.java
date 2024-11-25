package com.example.helloworld.design;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;


class ApiRateLimiter {
    private static volatile ApiRateLimiter instance;  // Singleton instance
    private static final ReentrantLock lock = new ReentrantLock();  // Lock for thread safety
    private final Map<String, CustomerRequestData> requestDataMap;  // Data for each customer

    // Maximum number of requests per customer
    private final int maxRequests;
    private final int timeWindowInSeconds;  // Time window in seconds

    // Private constructor to enforce Singleton pattern
    private ApiRateLimiter(int maxRequests, int timeWindowInSeconds) {
        this.maxRequests = maxRequests;
        this.timeWindowInSeconds = timeWindowInSeconds;
        this.requestDataMap = new HashMap<>();
    }

    // Public method to get the Singleton instance
    public static ApiRateLimiter getInstance(int maxRequests, int timeWindowInSeconds) {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new ApiRateLimiter(maxRequests, timeWindowInSeconds);
                }
            }
        }
        return instance;
    }

    // Method to check if a customer can make a request
    public boolean isRequestAllowed(String customerId) {
        long currentTime = System.currentTimeMillis() / 1000; // Current time in seconds
        CustomerRequestData requestData;

        // Lock to ensure thread-safety when accessing or modifying requestDataMap
        synchronized (requestDataMap) {
            requestData = requestDataMap.getOrDefault(customerId, new CustomerRequestData());

            // Check if the time window has expired
            if (currentTime - requestData.getLastTime() >= timeWindowInSeconds) {
                // Reset the request count if the time window has passed
                requestData.setRequestCount(0);
                requestData.setLastTime(currentTime);       // time is added only here.
            }

            // If the request count exceeds the limit, deny the request
            if (requestData.getRequestCount() >= maxRequests) {
                return false;
            }

            // Otherwise, allow the request and increment the count
            requestData.setRequestCount(requestData.getRequestCount() + 1);
            requestDataMap.put(customerId, requestData);
            return true;
        }
    }

    // Inner class to hold request data for a customer
    private static class CustomerRequestData {
        private int requestCount;
        private long lastTime;

        public CustomerRequestData() {
            this.requestCount = 0;
            this.lastTime = 0;
        }

        public int getRequestCount() {
            return requestCount;
        }

        public void setRequestCount(int requestCount) {
            this.requestCount = requestCount;
        }

        public long getLastTime() {
            return lastTime;
        }

        public void setLastTime(long lastTime) {
            this.lastTime = lastTime;
        }
    }

    public static void main(String[] args) {
        // Example usage
        ApiRateLimiter rateLimiter = ApiRateLimiter.getInstance(5, 10); // Allow 5 requests every 10 seconds

        // Simulating requests from a customer (customerId: "customer1")
        for (int i = 0; i < 15; i++) {
            boolean allowed = rateLimiter.isRequestAllowed("customer1");
            System.out.println("Request " + (i + 1) + " allowed: " + allowed);
            try {
                Thread.sleep(1000);  // Simulate a 1 second delay between requests
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

