class Uint:
    def __init__(self, name, hp):
        self.name = name
        self.hp = hp


class AttackUnit(Uint):
    def __init__(self, name, hp, damage):
        Uint.__init__(self, name, hp)
        self.damage = damage
        print("{} 유닛이 생성되었습니다.".format(name))
        print("체력 {}, 공격력 {}".format(hp, damage))

    def attack(self, location):
        print("{} : {} 방향으로 적군을 공격합니다 공격력{}"
              .format(self.name, location, self.damage))

    def attacked(self, damaged):
        print("{} : {} 데미지를 입었습니다."
              .format(self.name, damaged))
        self.hp -= damaged
        print("{} : 현재 체력은 {} 입니다.".format(self.name, self.hp))
        if self.hp <= 0:
            print("{} : 파괴되었습니다.")


class Flyable:
    def __init__(self, flying_speed):
        self.flying_speed = flying_speed

    def fly(self, name, location):
        print("{}: {} 방향으로 날라갑니다 속도{}".format(
            name, location, self.flying_speed))


class FlyableAttackUnit(AttackUnit, Flyable):
    def __init__(self, name, hp, damage, flying_speed):
        AttackUnit.__init__(self, name, hp, damage)
        Flyable.__init__(self, flying_speed)


marin = AttackUnit("marin", 300, 5)
marin.update = 1
if marin.update == 1:
    marin.damage = marin.damage + 1

marin.attack("5시")
marin.attacked(25)
marin.attacked(25)

balkiry = FlyableAttackUnit("balkiry", 200, 6, 5)
balkiry.fly(balkiry.name, "3시")
