l = [1,2,3]

import itertools

a, b = itertools.tee(l)
next(b, None)
it = itertools.izip(a, b)


while(it):
    try:
        print it.next()
    except StopIteration:
        pass