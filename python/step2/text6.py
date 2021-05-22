# 주어진 코드를 활용하여 부동산 프로그램을 작성하시오.
'''
총 3대의 매물이 있습니다.
강남 아파트 매매 10억 2010년
마포 오피스텔 전세 5억 2007년
송파 빌라 월세 500/50 2000년

'''
# 코드


class House:
    # 초기화

    def __init__(self, location, typeOfHouse, typeOfDeal, price, builded):
        self.location = location
        self.typeOfHouse = typeOfHouse
        self.typeOfDeal = typeOfDeal
        self.price = price
        self.builded = builded
        global total_item

    # 정보
    def show_detail(self):
        print(self.location, self.typeOfHouse,
              self.typeOfDeal, self.price, self.builded)


house = []
house1 = House("강남", "아파트", "매매", "10억", "2010년")
house2 = House("마포", "오피스텔", "전세", "10억", "2017년")
house3 = House("송파", "빌라", "월세", "500/30", "2000년")

house.append(house1)
house.append(house2)
house.append(house3)

print("총 {}의 매물이 있습니다.".format(len(house)))

for i in house:
    i.show_detail()
