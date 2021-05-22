# 회원 20명중 1등 1명에게 치킨을
# 2등 3명에겐 커피를 추첨

from random import *

getnum1 = randrange(1, 21)
getnum2 = sample(range(1, 21), 3)
print(getnum1 in getnum2)
while getnum1 in getnum2:
    getnum1 = randrange(1, 21)

getnum2.sort()
print("치킨 당첨자는 % d" % getnum1)
print("커피 당첨자는 {}".format(getnum2))


user = range(1, 21)
user = list(user)
shuffle(user)

winner = sample(user, 4)
