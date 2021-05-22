import cv2
import numpy as np

img = cv2.imread("Resources/iu3.jpg")
print(img.shape)

imgResize = cv2.resize(img,(300,200))

imgCroppred = img[0:200,200:400] # height and width 

cv2.imshow("image",img)
cv2.imshow("Resizing image",imgResize)
cv2.imshow("Cropped image",imgCroppred)

cv2.waitKey(0)
