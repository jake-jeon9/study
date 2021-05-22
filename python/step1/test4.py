from copy import copy
a = [1, 2, 3, 4]

b = a

a[0] = 0

print(b[0])

print(id(a))
print(id(b))

c = a[:]
print(id(c))

d = copy(a)

a = 5
b = 3

a, b = b, a
print(a)
print(b)
