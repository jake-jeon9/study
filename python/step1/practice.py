def maker_gugudan(n):
    result = []
    number = 1
    while number < 10:
        result.append(number*int(n))
        number += 1
    return result


print(maker_gugudan(input("출력할 구구단 단을 입력하세요 : ")))
