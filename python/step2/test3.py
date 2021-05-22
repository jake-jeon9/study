# 예제 50명승객
# 조건 1 승객별 운행 소요 시간은 5~50분사이의 난수
# 조건2 당신은 소요 시간 5~ 15분 사이의 승객만 매칭해야 합니다.


from random import *

count = 0
for i in range(1, 51):
    takenTime = randrange(5, 51)

    if 5 <= takenTime < 15:
        print("[0] %d 번째 손님 ( 소요시간 : %d분)" % (i, takenTime))
        count += 1
    else:
        print("[ ] %d 번째 손님 ( 소요시간 : %d분)" % (i, takenTime))

print("총 탑승 승객 : {} 분".format(count))


def getnum(num):
    data = {}
    count = 0

    for i in range(0, num):
        data[i] = count
        count += 1

    return data.get(0), data.get(1), data.get(2)


a, b, c = getnum(3)
print(a)
print(b)
print(c)
