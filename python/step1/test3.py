
s1 = set([1, 2, 3])
s2 = {1, 2, 3}

print(type(s2))


beforeList = [1, 2, 3, 4, 4, 3, 2, 1, 5]
newList = list(set(beforeList))
print(beforeList)
print(newList)

s3 = set("Hello")
print(s3)


s4 = set([1, 2, 3, 4, 5, 6])
s5 = set([3, 4, 5, 6, 7, 8])
print(s4 & s5)
print(s4.intersection(s5))

s4 = set([1, 2, 3, 4, 5, 6])
s5 = set([3, 4, 5, 6, 7, 8])
print(s4 | s5)
print(s4.union(s5))

s4 = set([1, 2, 3, 4, 5, 6])
s5 = set([3, 4, 5, 6, 7, 8])
print(s4-s5)
print(s4.difference(s5))

s4.add(7)
print(s4)

s4.update([8, 9, 10])
print(s4)
