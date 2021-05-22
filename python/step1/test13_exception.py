
try:
    4 / 0
except Exception as e:
    print(e)

try:
    f = open('noe', 'r')
except Exception as e:
    print(e)
else:
    data = f.read()
    print(data)
    f.close()
finally:
    print("종료")


f = open('foo.txt', 'w')
try:
    data = f.read()
    print(data)
except Exception as e:
    print(e)
finally:
    f.close()


class BignumberExceoption(Exception):
    def __init__(self, msg):
        self.msg = msg

    def __str__(self):
        return self.msg


try:
    num1 = 10
    if num1 > 0:
        raise BignumberExceoption("메세지")
except BignumberExceoption as ef:
    print(ef)
