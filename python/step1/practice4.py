
def write():
    subject = input("제목을 입력하세요 : ")

    if not subject:
        subject = "default.txt"

    text = input("메모를 입력하세요 :")
    f = open(subject+".txt", 'w', encoding='UTF-8')
    f.write(text)
    f.close()


def read():
    subject = input("제목을 입력하세요 : ")
    if not subject:
        subject = "default.txt"

    f = open(subject+".txt", 'r', encoding="UTF-8")
    text = ""
    for n in f.readlines():
        text += n
    print(text)
    f.close()


try:
    mode = int(input("모드를 선택하세요. 1 : 쓰기, 2: 읽기, 3: 종료 : "))
except Exception as e:
    print(e)
else:
    while True:
        if mode == 1:
            write()
            break
        elif mode == 2:
            read()
            break
        elif mode == 3:
            break
        else:
            print("1,2번 모드만 사용가능합니다.")
