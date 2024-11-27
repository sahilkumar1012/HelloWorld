package com.example.helloworld.interviews.sahil.Atlassian;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


/**
 * Remember the old phone game of Snake? If not, let’s look at this first: http://playsnake.org/
 *
 * The snake can move up, down, left or right in a 2-dimensional board of arbitrary size.
 *
 * Let’s try to implement the base logic of this game.
 *
 * Rules:
 *
 * Every time moveSnake() is called, the snake moves up, down, left or right
 *
 * The snake’s initial size is 3 and grows by 1 every 5 moves
 *
 * The game ends when the snake hits itself
 *
 * We can use the following as a starting point (pseudo-code):
 *
 * interface SnakeGame {
 *     moveSnake(snakeDirection);
 *     bool isGameOver();
 * }
 *
 *  n * m size board 2D
 *  sanke d
 *  3 3
 *
 *  a b c d
 *
 *
 *  a ,b  , R
 *  %n , %m
 *  find next location
 *      - eaitng itself / snake location
 *      - not crossing boudry
 *
 *  deque
 *  Set ( "i,j")
 *  counter
 *
 *  Time  : O(1)
 *  Space : O(n*m)
 */
class TestSnakeGame{
    public static void main(String[] args) {
        Snake snake = new Snake(5,5);
        snake.moveSnake('L');
        snake.moveSnake('U');
        System.out.println(snake.isGameOver());
//        snake.moveSnake('R');
//        snake.moveSnake('R');
    }
}

interface SnakeGame {
    void moveSnake(char snakeDirection);
    boolean isGameOver();
}
class Snake implements SnakeGame {
    boolean state;
    int counter;
    int n, m;
    Deque<int[]> snakeLocation;
    Set<String> snakeLocationSet;

    public Snake(int n, int m){
        this.n = n;
        this.m = m;
        this.state = true;
        this.counter = 0;
        snakeLocation = new LinkedList<>();
        snakeLocation.addLast(new int[]{0,0});
        snakeLocation.addLast(new int[]{0,1});
        snakeLocation.addLast(new int[]{1,1});

        snakeLocationSet = new HashSet<>();
        snakeLocationSet.add("0,0");
        snakeLocationSet.add("0,1");
        snakeLocationSet.add("1,1");
    }
    public void moveSnake(char snakeDirection) {       // L R T D
        int[] currLocation = snakeLocation.getLast();
        int[] newLocation = new int[]{currLocation[0], currLocation[1]};

        switch(snakeDirection){
            case 'L':
                newLocation[1] = (newLocation[1]-1+m)%m;
                break;
            case 'R':
                newLocation[1] = (newLocation[1]+1)%m;;
                break;
            case 'U':
                newLocation[0] = (newLocation[0]-1+n)%n;     // (0-1)%n,1 -> n,1
                break;
            case 'D':
                newLocation[0] = (newLocation[0]+1)%n;;
                break;
        }

        String newLocationString = newLocation[0] + "," + newLocation[1];
        int[] tail =  snakeLocation.peekFirst();
        String tailString = tail[0] + "," + tail[1];

        counter++;
        if(counter < 5){
            snakeLocation.pollFirst();
            snakeLocationSet.remove(tailString);
        }else if (counter == 5){
            counter = 0;
        }

        if( snakeLocationSet.contains(newLocationString) ){
            System.out.println("inside negative case" + newLocationString);
//            if( !newLocationString.equals(tailString) )
            state = false;
        }

        snakeLocation.offerLast(newLocation);
        snakeLocationSet.add(newLocationString);

    }

    public boolean isGameOver(){
        return !state;
    }

}

/**
 *
 *  _> 0,1
 *
 * 1,0   1,1
 */