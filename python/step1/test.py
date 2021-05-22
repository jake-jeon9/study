
the_world_is_flat = True
if the_world_is_flat:
    print("Be careful not to fall off!")
    print(3**4)

a = "Life is too Short, you need python"
print(a[:8])

a = "I eat %d apples" % 3
print(a)

number = 10
day = "three"
a = "I ate %d apples. so i was sick for %s days." % (number, day)
print(a)

a = "asdfasdfafasdf {name} asdfklasdf은 {age}".format(name="제이크", age=6)
print(a)

a = 'hooy'
print(a.find('o'))

a = ",".join(["a", "b", "c"])
b = ["a", "b", "c"]
print(a)
print(b)

a = "Life is too short"
a.replace("Life", "Your leg")
print(a.replace("Life", "Your leg"))

a = "A:B:C:D"
a.split(":")
print(a.split(":"))

a = [1, 2, 3]
b = [4, 5, 6]
print(a+b)

print(a*3)

a[0:2] = ["숫자1", "숫자2"]
print(a)

a[0:2] = []
print(a)

a.append(4)
print(a)
a.insert(0, 4)
print(a)

c = [1, 5, 3]
c.sort()
print(c)

c.reverse()
print(c)

print(c.index(5))

a = [1, 5, 3]
print(a)
print(a.pop())
print(a)

c = [1, 2, 3, 1, 2, 1, 1, 1]
print(c.count(1))

c.extend([2, 3, 2, 3, 2, 3])
print(c)

del c[1]
print(c)
