class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // method 1: naive implement
        // int oldColor = image[sr][sc];
        // if(oldColor == color)
        //     return image;
        // image[sr][sc] = color;
        // if(sr+1 < image.length && image[sr+1][sc] == oldColor){
        //     floodFill(image, sr+1, sc, color);
        // }
        // if(sr-1 >= 0 && image[sr-1][sc] == oldColor){
        //     floodFill(image, sr-1, sc, color);          
        // }
        // if(sc+1 < image[0].length && image[sr][sc+1] == oldColor){
        //     floodFill(image, sr, sc+1, color);             
        // }
        // if(sc-1 >= 0 && image[sr][sc-1] == oldColor){
        //     floodFill(image, sr, sc-1, color);
        // }
        // return image;

        // method 2: more clearly implemtent
        int oldColor = image[sr][sc];
        // if old color == new color, return
        if(oldColor == color)
            return image;
        connectedPixel(image, sr, sc, color, oldColor);
        return image;
    }
    public void connectedPixel(int[][] image, int sr, int sc, int newColor, int oldColor){
        if(sr >= image.length || sr < 0 ||
           sc >= image[0].length || sc < 0 ||
           image[sr][sc] != oldColor){
            return;
        }
        image[sr][sc] = newColor;

        connectedPixel(image, sr+1, sc, newColor, oldColor);
        connectedPixel(image, sr, sc+1, newColor, oldColor);
        connectedPixel(image, sr-1, sc, newColor, oldColor);
        connectedPixel(image, sr, sc-1, newColor, oldColor);
    }
}