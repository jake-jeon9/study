class Bird:
    def fly(self):
        raise NotImplementedError


class Eagle(Bird):
    def fly(self):
        print("very fast")


eagle = Eagle()
eagle.fly()

print(dir([1, 2, 3]))


def positive(x):
    return x > 0


a = list(filter(positive, [1, -3, 2, 0, -6, 3]))
print(a)
