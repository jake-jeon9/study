class Calculator:
    def __init__(self, first, second):
        self.first = first
        self.second = second

    def add(self):
        result = self.first + self.second
        return result

    def div(self):
        result = self.frist / self.second
        return result


class Child(Calculator):
    def pow(self):
        result = self.first ** self.second
        return result

    def div(self):
        if self.second == 0:
            return 0
        elif self.first == 0:
            return 0
        else:
            return self.first / self.second


a = Child(1, 0)
print(a.add())
print(a.pow())
print(a.div())
