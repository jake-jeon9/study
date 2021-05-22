
# 지역변수와 전역변수
a = 1


def vartest(a):
    a = a + 1
    return a


a = vartest(a)
print(a)

b = 1


def vartest2():
    global b
    b = b + 1


vartest2()
print(b)


def add(a, b):
    return a+b


def add(a, b): return a + b


mylist = [lambda a, b: a+b, lambda a, b:a*b]
print(mylist[0](1, 2))
