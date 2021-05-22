import time
import pickle

print(time.time())
year, month, day, hour, minute, second = "year", "month", "day", "hour", "minute", "second"

a = list(zip([year, month, day, hour, minute, second],
             list(time.localtime(time.time()))))

print(a)

results = {}
try:
    f = open('currentTime.txt', 'wb')
except Exception as e:
    print(e)
else:
    for time, value in a:
        result = {time: value}
        results.update(result)
    pickle.dump(results, f)
finally:
    f.close()

try:
    f = open("currentTime.txt", 'rb')
    data = pickle.load(f)
except Exception as e:
    print(e)
else:
    print(data)
finally:
    f.close()
