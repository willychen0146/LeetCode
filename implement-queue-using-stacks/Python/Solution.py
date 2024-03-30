class MyQueue:

    def __init__(self):
        self.front = []
        self.end = []
        
    def push(self, x: int) -> None:
        self.front.append(x)
        
    def pop(self) -> int:
        if(not self.end):
            while(self.front):
                self.end.append(self.front.pop())

        return self.end.pop()

    def peek(self) -> int:
        if(not self.end):
            while(self.front):
                self.end.append(self.front.pop())

        return self.end[-1]
        
    def empty(self) -> bool:
        return not self.front and not self.end
        
# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()