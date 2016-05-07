d = {'(': ')', '[': ']', '{': '}'}

class Stack:
  def __init__(self):
    self.__storage = []

  def isEmpty(self):
    return len(self.__storage) == 0

  def push(self,p):
    self.__storage.append(p)

  def pop(self):
    return self.__storage.pop()


def validateString(value):

    i = 0
    stack = Stack()
    while i < len(value):
        if value[i] in d.keys():
            stack.push(value[i])
        else:
            if stack.isEmpty():
                return "NO"
            bracket = stack.pop()
            if d.get(bracket) != value[i]:
                return "NO"
        i = i + 1
    if not stack.isEmpty():
        return "NO"
    return "YES"

    
if __name__=="__main__":
    value = "["
    print validateString(value)
    