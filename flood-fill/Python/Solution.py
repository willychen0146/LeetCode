class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        old_color = image[sr][sc]
        if old_color != color:
            self.fillnext(image, sr, sc, color, old_color)
        return image

    def fillnext(self, image: List[List[int]], sr: int, sc: int, color: int, old_color: int):
        if(sr < 0 or sr > len(image)-1 or sc < 0 or sc > len(image[0])-1):
            return
        if(image[sr][sc] != old_color):
            return
        image[sr][sc] = color
        self.fillnext(image, sr+1, sc, color, old_color)
        self.fillnext(image, sr, sc+1, color, old_color)
        self.fillnext(image, sr-1, sc, color, old_color)
        self.fillnext(image, sr, sc-1, color, old_color)