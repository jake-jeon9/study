for i in range(1, 101):

    if i % 3 == 0 & i % 5 == 0:
        print("fizzBuzz")
    elif i % 3 == 0:
        print("FIzz")
    elif i % 5 == 0:
        print("BUzz")
    else:
        continue
