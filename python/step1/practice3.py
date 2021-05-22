# 게시판 페이징하기

def getTotalPage(m):
    pageitemsize = 10
    totalpage = 0
    if m % 10 == 0:
        totalpage = (m//pageitemsize)
    else:
        totalpage = m//pageitemsize + 1

    return totalpage


print(getTotalPage(int(input("게시물 수? : "))))
