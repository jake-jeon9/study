def sum(a, b):
    result = a + b
    return result


a = 5
b = 7
print(sum(a, b))


def say():
    return 'Hi'


print(say())


def check1(a, b):
    result = a + b
    print("%d와 %d 의 합은 %d 입니다." % (a, b, result))


print(check1(a, b))


def sum_alot(*args):
    sum = 0
    for i in args:
        sum = sum + i
    return sum


print(sum_alot(1, 2, 3, 4, 5, 6))


def print_kwarge(**kwargs):
    for k in kwargs.keys():
        if(k == "name"):
            print("당신의 이름은 %s 입니다" % kwargs.get(k))


print(print_kwarge(name="조석간만의 차", b="2"))


def sum_and_mul(a, b):
    return a+b, a*b, a-b


print(sum_and_mul(6, 3))


def say_myeself(name, old, gender=True):
    print("나의 이름은 %s 입니다" % name)
    print("나의 나이는 %d 살입니다" % old)
    if gender:
        print("성별은 남자입니다.")
    else:
        print("성별은 여자입니다.")


say_myeself("감자", 12)
say_myeself("고구마", 22, False)
