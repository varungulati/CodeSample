import copy
from sys import stdin

class Queue:
    def __init__(self):
        self.queue = []
    def dequeue(self):
        return self.queue.pop(0)
    def enqueue(self,element):
        self.queue.append(element)
    def isEmpty(self):
        return len(self.queue) == 0

def findCost():
    N = int(stdin.readline())
    M = int(stdin.readline())
    pairs = []
    for _ in range(M):
        temp = stdin.readline().split(' ')
        pairs.append((int(temp[0]), int(temp[1])))
        
    all_inmates = []
    for i in range(1, N + 1):
        all_inmates.append(i)
        
    temp = copy.deepcopy(all_inmates)
    for (x, y) in pairs:
        if x in temp:
            temp.remove(x)
        if y in temp:
            temp.remove(y)
    
    singles_cost = len(temp)
    
    q = Queue()
    size_list = []
    for (x, y) in pairs:
        group_size = 2
        q.enqueue(x)
        q.enqueue(y)
        pairs.remove((x, y))
        while not q.isEmpty():
            elem = q.dequeue()
            for (a, b) in pairs:
                if elem in (a, b):
                    q.enqueue(a)
                    q.enqueue(b)
                    pairs.remove((a, b))
                    group_size += 1
        size_list.append(group_size)
    
    total_cost = singles_cost
    for size in size_list:
        total_cost += size**(1/2) + 1
    print total_cost

    
if __name__=="__main__":
    findCost()