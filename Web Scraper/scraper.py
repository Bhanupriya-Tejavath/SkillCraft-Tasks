import requests
from bs4 import BeautifulSoup
import pandas as pd

url = "https://books.toscrape.com/"
response = requests.get(url)
response.encoding = "utf-8"
soup = BeautifulSoup(response.text, "html.parser")

products = []
prices = []
ratings = []

items = soup.find_all("article", class_="product_pod")

for item in items:
    name = item.h3.a["title"]
    price = item.find("p", class_="price_color").text

    rating_tag = item.find("p", class_="star-rating")
    rating = rating_tag["class"][1]

    products.append(name)
    prices.append(price)
    ratings.append(rating)

df = pd.DataFrame({
    "Product Name": products,
    "Price": prices,
    "Rating": ratings
})

df.to_csv("products.csv", index=False)

print("Data saved to products.csv")
print(df)