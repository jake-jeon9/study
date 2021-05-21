import cv2
import numpy as np

img = cv2.imread("Resources/ocr.webp")

width ,height = 498,432

#네모의 각 꼭지점 위치 지정
pts1 = np.float32([[210,120],[270,125],[200,185],[270,180]])

# 대상의 크기설정.
pts2 = np.float32([[0,0,],[width,0],[0,height],[width,height]])

#새롭게 이미지 만들기
matrix = cv2.getPerspectiveTransform(pts1,pts2)

#원본크기의 이미지를 크롭한걸 가져오기
imgOutput = cv2.warpPerspective(img,matrix,(width,height))

cv2.imshow("image",img)
cv2.imshow("Output",imgOutput)


cv2.waitKey(0)