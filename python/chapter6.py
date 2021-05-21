import cv2
import numpy as np

img = cv2.imread('Resources/ocr.webp')

#가로로 2개의이미지 출력하기.
imgHor = np.hstack((img,img))

#세로로 2개의 이미지 출력
imgVer = np.vstack((img,img))

#만약 여러개의 이미지를 출력하고 싶으면 ?
#함수를 구축.


cv2.imshow("Horizontal",imgHor)
cv2.imshow("Vertical",imgVer)

cv2.waitKey(0)