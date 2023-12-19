package com.example.helloworld.array.others;

/**
 * leetcode 661. Image Smoother
 * https://leetcode.com/problems/image-smoother/
 *
 * An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by rounding down the average of the cell and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother). If one or more of the surrounding cells of a cell is not present, we do not consider it in the average (i.e., the average of the four cells in the red smoother).
 *
 *
 * Given an m x n integer matrix img representing the grayscale of an image, return the image after applying the smoother on each cell of it.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: img = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[0,0,0],[0,0,0],[0,0,0]]
 * Explanation:
 * For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * Example 2:
 *
 *
 * Input: img = [[100,200,100],[200,50,200],[100,200,100]]
 * Output: [[137,141,137],[141,138,141],[137,141,137]]
 * Explanation:
 * For the points (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
 * For the points (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
 * For the point (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
 *
 *
 * Constraints:
 *
 * m == img.length
 * n == img[i].length
 * 1 <= m, n <= 200
 * 0 <= img[i][j] <= 255
 */
public class ImageSmoother {
    // all 9 indices to check
    int[][] dir = {
            {-1,-1},{-1,0},{-1,1},
            {0,-1},{0,0},{0,1},
            {1,-1},{1,0},{1,1}
    };
    int m,n;    // dimension

    public int[][] imageSmoother(int[][] img) {
        m = img.length;
        n = img[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // storing both the values
                img[i][j] |= (smoother(img, i, j) << 8 );
            }
        }

        // keep only smoothed values in img
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                img[i][j] >>= 8;
            }
        }

        // returning smoothed image
        return img;
    }

    private int smoother(int[][] img, int i, int j) {
        int sum = 0, count = 0;

        // iterate over all the 9 possible indices
        for(int[] d : dir){
            int i_ = i + d[0];
            int j_ = j + d[1];

            // if it's not a valid neighbor
            if( i_ <0 || i_>=m || j_ <0 || j_>=n){
                continue;
            }
            // extract original value of img[i_][j_]
            sum += img[i_][j_] & 255;
            count++;
        }
        // rounded down average value
        return (sum/count);
    }

}
