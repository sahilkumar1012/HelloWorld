package com.example.helloworld.interviews.sahil.meesho;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Meesho {
    // find below solution of Sahil (sahilkumar1012@gmail.com)
}

class Product{
    String productId;
    String productName;
    Integer availableCount;     // available product quantity to be used in our future orders.

    public Product(String productId, String productName, Integer availableCount) {
        this.productId = productId;
        this.productName = productName;
        this.availableCount = availableCount;
    }
}
class Order{
    String orderId;
    Map<String, Integer> products; // productId vs product count needed
    Date lastUpdated;   // we'll discard our orders on the basis of our lastUpdated time for order
    String orderStatus;         // active , done etc.

    public Order(String orderId, Map<String, Integer> products, Date lastUpdated, String orderStatus) {
        this.orderId = orderId;
        this.products = products;
        this.lastUpdated = lastUpdated;
        this.orderStatus = orderStatus;
    }
}
class Result {

    // in memory data structures to store our inventory/orders
    Map<String, Product> productInventory;
    Map<String, Order> orders;     // order-id vs order details.
    // priority queue in increasing order of timestamp
    Queue<Order> orderQueue;

    public Result(){
        productInventory = new ConcurrentHashMap<>();
        orders = new ConcurrentHashMap<>();
        orderQueue = new PriorityQueue<>(Comparator.comparingLong(x -> x.lastUpdated.getTime()));
    }

    public void createProduct(String productId, String name, Integer count){
        // if product already exist in that case we can just increase the current count of the product.
        productInventory.put(productId, new Product(productId, name, count));
    }
    /*
     * Complete the 'getInventory' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING productId as parameter.
     */
    public int getInventory(String productId) {
        // Write your code here
        cleanUpOrderQueue();
        return productInventory.get(productId).availableCount;
    }


    public void blockInventory(String productId, Integer count, String orderId){
        // considering it as a valid order, assuming that validation checks are already performed on inputs.
//        valid();
        cleanUpOrderQueue();

        if(!orders.containsKey(orderId)){
            Order order = new Order(orderId, new HashMap<>(), new Date(), "Active");
            orders.put(orderId, order);
        }

        Map<String, Integer> products = orders.get(orderId).products;

        // delete from inventory
        productInventory.get(productId).availableCount -= count;

        // add in order
        if(!products.containsKey(productId)){
            products.put(productId, count);
        }else{
            products.put(productId, products.get(productId)+count);
        }

        orders.get(orderId).lastUpdated = new Date();
    }

    public void confirmOrder(String orderId){ // 100
        cleanUpOrderQueue();

        Date currentTime = new Date();
        Order order = orders.get(orderId);

        if(order == null){
            System.out.println("This order has been expired.");
        }else{
            order.orderStatus = "Done";
        }
    }

    private synchronized void cleanUpOrderQueue() {
        Date currentTime = new Date();
        // discard expired orders.
        while(!orderQueue.isEmpty()){
            Order peek = orderQueue.peek();

            if(peek.orderStatus.equals("Done")){                  // completed order
                orderQueue.poll();
            }else if(currentTime.getTime() - peek.lastUpdated.getTime() > 300000){        // order expired. ( more than 5 min)
                discardOrder(orderQueue.poll());
            }else                               // nothing to do
                break;
        }
    }

    /**
     * Return all the products within this order back to the product inventory.
     * @param order order from which all the products will go back to the inventory.
     */
    private synchronized void discardOrder(Order order) {
        for(String productId : order.products.keySet()){
            Product productFromInventory = productInventory.get(productId);
            productFromInventory.availableCount += order.products.get(productId);
        }
        orders.remove(order.orderId);
    }

}
