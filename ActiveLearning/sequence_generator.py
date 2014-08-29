# Sequence types

import itertools

# Super class to all type of sequences.
class Sequence():
    L = []
    
    def __init__(self, L):
        self.L = L

    def display(self):
        print self.L

class Arithmetic(Sequence):
    L = []
    first_term = None
    difference = None
    
    def __init__(self, L):
        self.L = L
        if not self.isArithmetic():
            raise ValueError("Not Arithmetic.")
        self.first_term = L[0]
        self.difference = L[1] - L[0]
        
    def getNext(self):
        while(True):
            next_number = self.L[-1] + self.difference
            self.L.append(next_number)
            yield next_number

    def isArithmetic(self):
        return all((i - j) == (j - k) for i, j, k in zip(self.L[:-2], self.L[1:-1], self.L[2:]))

class Geometric(Sequence):
    L = []
    ratio = None
    first_term = None
    
    def __init__(self, L):
        self.L = L
        if not self.isGeometric():
            raise ValueError("Not Geometric.")
        self.ratio = L[1]/L[0]
        self.first_term = L[0]
        
    def getNext(self):
        while(True):
            next_number = self.L[-1] * self.ratio
            self.L.append(next_number)
            yield next_number

    def isGeometric(self):
        if self.L.count(0) != 0:
            return False
        r = self.L[1]/float(self.L[0])
        return all(self.L[i]/float(self.L[i-1]) == r for i in xrange(2,len(self.L)))

class Fibonacci(Sequence):
    L = []
    last_number = None
    second_last_number = None
    
    def __init__(self, L):
        self.L = L
        if not self.isFibonacci():
            raise ValueError("Not Fibonacci.")
        self.last_number = self.L[-1]
        self.second_last_number = self.L[-2]
        
    def getNext(self):
        while(True):
            next_number = self.last_number + self.second_last_number
            self.L.append(next_number)
            self.second_last_number = self.last_number
            self.last_number = self.L[-1]
            yield next_number
            
    def isFibonacci(self):
        if self.L.__len__() < 3:
            return True
        for i in range(2, self.L.__len__()):
            if self.L[i] != self.L[i-1] + self.L[i-2]:
                return False
        return True

# Rules or hypotheses.
RULES = {
        'is_increasing': [Arithmetic, Geometric, Fibonacci],
        'is_decreasing': [Arithmetic, Geometric],
        'is_constant': [Arithmetic, Geometric],
        'is_random': [Geometric, Fibonacci],
        'is_constant_difference': [Arithmetic],
        'is_increasing_difference': [Geometric, Fibonacci],
        'is_decreasing_difference': [Geometric]
}

CLASSIFIERS = {}

# Check if increasing sequence.
def isIncreasing(L):
    return all(x<y for x, y in zip(L, L[1:]))

# Check if decreasing sequence.
def isDecreasing(L):
    return all(x>y for x, y in zip(L, L[1:]))

# Check if random sequence.
def isRandom(L):
    return isIncreasing(L) == isDecreasing(L)

# Check if constant sequence.
def isConstant(L):
    return all(x==y for x, y in zip(L, L[1:]))

# Check if constant difference.
def isConstantDifference(L):
    if(L.__len__() <= 1):
        return True
    
    a, b = itertools.tee(L)
    next(b, None)
    it = itertools.izip(a, b)
    C = L[1] - L[0]
    
    while(it):
        try:
            x, y = it.next()
            if(y - x != C):
                return False
        except StopIteration:
            break
    return True

# Check if increasing difference.
def isIncreasingDifference(L):
    if(L.__len__() <= 1 or isConstantDifference(L) == True):
        return False
    
    a, b = itertools.tee(L)
    next(b, None)
    it = itertools.izip(a, b)
    C = L[1] - L[0]
    
    while(it):
        try:
            x, y = it.next()
            if(y - x < C):
                return False
            else:
                C = y - x
        except StopIteration:
            break
    return True

# Check if decreasing difference.
def isDecreasingDifference(L):
    if(L.__len__() <= 1 or isConstantDifference(L) == True):
        return False
    
    a, b = itertools.tee(L)
    next(b, None)
    it = itertools.izip(a, b)
    C = L[1] - L[0]
    
    while(it):
        try:
            x, y = it.next()
            if(y - x > C):
                return False
            else:
                C = y - x
        except StopIteration:
            break
    return True

def isRandomDifference(L):
    return isIncreasingDifference(L) == isDecreasingDifference(L)

def updateClassifier(numbers):
    CLASSIFIERS['is_increasing'] = isIncreasing(numbers)
    CLASSIFIERS['is_decreasing'] = isDecreasing(numbers)
    CLASSIFIERS['is_random'] = isRandom(numbers)
    CLASSIFIERS['is_constant'] = isConstant(numbers)
    CLASSIFIERS['is_constant_difference'] = isConstantDifference(numbers)
    CLASSIFIERS['is_increasing_difference'] = isIncreasingDifference(numbers)
    CLASSIFIERS['is_decreasing_difference'] = isDecreasingDifference(numbers)
#     CLASSIFIERS['is_random_difference'] = isRandomDifference(numbers)

def runSequenceGenerator():
    # Take input in the form "1 2 3 4".
    user_input = raw_input()
    # Convert input into list data structure.
    numbers = map(float, user_input.split())
    updateClassifier(numbers)

    if numbers.__len__() <= 1:
        print "Please enter more than one number."
        return
        
    solution_set = ()
    # Check for possible sequence type as per rules defined.
    # Eliminate hypotheses.
    for k, v in CLASSIFIERS.iteritems():
        if v:
            possible_solutions = []
            possible_solutions = RULES.get(k)
        else:
            continue
        
        if not solution_set:
            possible_solution_set = possible_solutions
        else:
            possible_solution_set = list(set(possible_solution_set).intersection(possible_solutions))
            
    sequence_object = None
    for sequence in possible_solution_set:
        try:
            sequence_object = sequence(numbers)
            break
        except ValueError:
            pass
    
    # Check if sequence is recognized as per the rule.
    # Print next 10 numbers if recognized.
    # Else print sequence not recognized.
    if sequence_object:
        for _ in range(10):
            print sequence_object.getNext().next(),
    else:
        print "Sequence not recognized. Code supports only Arithmetic, Geometric and Fibonacci sequences."
        

if __name__ == "__main__":
    runSequenceGenerator()
