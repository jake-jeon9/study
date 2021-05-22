
# 파읽 읽고 쓰기

f = open("새파일.txt", 'a', encoding="UTF-8")
for i in range(1, 11):
    data = "%d 번쨰 줄입니다.\n" % i
    f.write(data)
f.close()

f = open("새파일.txt", 'r', encoding="UTF-8")
line = f.readline()
print(line)
f.close()

f = open("새파일.txt", 'r', encoding="UTF-8")
while True:
    line = f.readline()
    if not line:
        break
    print(line)
f.close()

f = open("새파일.txt", 'r', encoding="UTF-8")
lines = f.readlines()
for line in lines:
    print(line, end="")
f.close()

with open("foo.txt", 'w') as f:
    f.write("Life is too shorty, you need this language")
