'''
동네에 항상 대기 손님이 있는 맛있는 치킨집이 있습니다.
대기 손님의 치킨 요리 시간을 줄이고자 자동 주문 시스템을 제작하였습니다.
시스템 코드를 확인하고 적절한 예외처리 구문을 넣으시오
'''

# 조걱 1 : 1보다 작거나 숫자가 아닌 입력값이 들어올 떄는 valueError 로 처리
# 출력 메세지 : "잘못된 값을 입력하였습니다."
# 조건2 : 대기손님이 주문할 수 있는 총 치킨향은 10마리 한점
# 치킨 소진시 상요자 정의 에러 soldoutExcetion 를 발생시키고  종료
# 출력 메세지 : 재고가 소진되어 더이상 주문을 받지 않습니다.

chicken = 10

wating = 0
while(True):
    print("현재 치킨은 {} 마리 남았습니다.".format(str(chicken)))
    try:
        order = int(input("주문하실 치킨 량은? :"))

        if order > chicken:  # case 1 : 재고부족
            raise ItemLeakException(chicken, order)

        if not 0 < order < 10:  # case2 : 최소 및 최대 구매량 오류
            print("1회 주문량 오류. 최소 1회 또는 10이하로 주문만 가능합니다.")

        if chicken == 0:
            raise soldOutExtion
    except ItemLeakExceptiond as e1:
        print(e1)
    except soldOutExtion as e2:
        print(e2)
    except ValueError:
        print("숫자만 입력하세요.")
        continue
    else:
        chicken -= order
        wating += 1
    finally:
        if not chicken == 0 and not order == 0:
            print("대기번호 {}님 주문하신 치킨{}마리 나왔습니다.".format(wating, order))
        else:
            print("영업종료.")


class ItemLeakException(Exception):
    def __init__(self, chicken, order):
        self.chicken = chicken
        self.order = order

    def __str__(self):
        return "주문량은 {1}이며, 잔여 치킨은 {0}입니다 ".format(self.chicken, self.order)


class soldOutExtion(Exception):
    def __init__(self):
        pass

    def __str__(self):
        return "오늘 재고소진되어 판매 중단."
