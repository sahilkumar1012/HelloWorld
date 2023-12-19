package com.example.helloworld.array.others;

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
