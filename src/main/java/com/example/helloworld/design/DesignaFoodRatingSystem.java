package com.example.helloworld.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

class Pair{
    Integer key;
    String value;

    public Pair(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(getKey(), pair.getKey()) && Objects.equals(getValue(), pair.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValue());
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}


class FoodRatings {

    // food : rating
    private Map<String, Integer> foodRatingMap = new HashMap();

    // food : cuisine
    private Map<String, String> foodCuisineMap = new HashMap();

    // cuisine : orderd set ( Pair [food, rating] )
    private Map<String, TreeSet<Pair> > cuisineFoodMap = new HashMap();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i=0; i<foods.length; i++){
            foodRatingMap.put(foods[i], ratings[i]);
            foodCuisineMap.put(foods[i], cuisines[i]);

            if(cuisineFoodMap.get(cuisines[i]) == null){
                cuisineFoodMap.put(cuisines[i] , new TreeSet<Pair> ((a,b) -> {
                    if(a.getKey().equals(b.getKey())){
                        return a.getValue().compareTo(b.getValue());
                    }
                    return b.getKey() - a.getKey();
                }) );
            }
            cuisineFoodMap.get(cuisines[i]).add( new Pair(ratings[i], foods[i]) );
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisineMap.get(food);

        TreeSet<Pair> cuisineSet = cuisineFoodMap.get(cuisine);
        cuisineSet.remove( new Pair(foodRatingMap.get(food), food) );

        foodRatingMap.put(food, newRating);

        cuisineSet.add( new Pair(newRating, food) );
    }

    public String highestRated(String cuisine) {
        return cuisineFoodMap.get(cuisine).first().getValue();      // heighest rated food
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */