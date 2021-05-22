import requests

url = "http://api-b.booxen.com/API/BookSaleInfoOnline"

strJson = requests.get(url).json()

print(strJson)
