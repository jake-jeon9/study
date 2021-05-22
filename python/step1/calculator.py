def add(a, b):
    result = a + b
    return result


def div(a, b):
    result = a / b
    return result


if __name__ == "__main__":
    a, b = 1, 2
    print("%d 와 %d 의 합은 %d이다." % (a, b, add(a, b)))
