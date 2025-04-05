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

/**
 * A simple implementation of the Snake game logic.
 * - The snake moves in a 2D board.
 * - It grows every 5 moves.
 * - The game ends when the snake collides with itself.
 */

class TestSnakeGame {
    public static void main(String[] args) {
        Snake snake = new Snake(5, 5); // Board size: 5x5
        snake.moveSnake('L');
        snake.moveSnake('U');
        System.out.println("Game Over: " + snake.isGameOver());
    }
}

interface SnakeGame {
    void moveSnake(char snakeDirection);
    boolean isGameOver();
}

class Snake implements SnakeGame {
    private boolean isAlive;
    private int counter;
    private final int n, m;
    private final Deque<int[]> snakeLocation;
    private final Set<String> snakeLocationSet;

    public Snake(int n, int m) {
        this.n = n;
        this.m = m;
        this.isAlive = true;
        this.counter = 0;

        // Initialize the snake's starting position
        snakeLocation = new LinkedList<>();
        snakeLocation.addLast(new int[]{0, 0});
        snakeLocation.addLast(new int[]{0, 1});
        snakeLocation.addLast(new int[]{1, 1});

        snakeLocationSet = new HashSet<>();
        snakeLocationSet.add("0,0");
        snakeLocationSet.add("0,1");
        snakeLocationSet.add("1,1");
    }

    public void moveSnake(char direction) {
        if (!isAlive) return;

        int[] head = snakeLocation.getLast();
        int[] newHead = {head[0], head[1]};

        // Compute new head position based on direction
        switch (direction) {
            case 'L': newHead[1] = (newHead[1] - 1 + m) % m; break;
            case 'R': newHead[1] = (newHead[1] + 1) % m; break;
            case 'U': newHead[0] = (newHead[0] - 1 + n) % n; break;
            case 'D': newHead[0] = (newHead[0] + 1) % n; break;
        }

        String newHeadStr = newHead[0] + "," + newHead[1];
        int[] tail = snakeLocation.peekFirst();
        String tailStr = tail[0] + "," + tail[1];

        counter++;

        // Remove tail only if counter < 5 (i.e., no growth yet)
        if (counter < 5) {
            snakeLocation.pollFirst();
            snakeLocationSet.remove(tailStr);
        } else if (counter == 5) {
            counter = 0; // Reset counter after growth
        }

        // Check for self-collision (excluding the tail as it moves)
        if (snakeLocationSet.contains(newHeadStr) && !newHeadStr.equals(tailStr)) {
            isAlive = false;
            System.out.println("Game Over! Snake collided at: " + newHeadStr);
            return;
        }

        // Move the snake
        snakeLocation.offerLast(newHead);
        snakeLocationSet.add(newHeadStr);
    }

    public boolean isGameOver() {
        return !isAlive;
    }
}
