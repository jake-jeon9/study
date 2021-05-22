import cv2
import numpy as np


def stackImages(scale,imgArray):
    rows = len(imgArray)
    cols = len(imgArray[0])
    rowsAvailable = isinstance(imgArray[0], list)
    width = imgArray[0][0].shape[1]
    height = imgArray[0][0].shape[0]
    if rowsAvailable:
        for x in range ( 0, rows):
            for y in range(0, cols):
                if imgArray[x][y].shape[:2] == imgArray[0][0].shape [:2]:
                    imgArray[x][y] = cv2.resize(imgArray[x][y], (0, 0), None, scale, scale)
                else:
                    imgArray[x][y] = cv2.resize(imgArray[x][y], (imgArray[0][0].shape[1], imgArray[0][0].shape[0]), None, scale, scale)
                if len(imgArray[x][y].shape) == 2: imgArray[x][y]= cv2.cvtColor( imgArray[x][y], cv2.COLOR_GRAY2BGR)
        imageBlank = np.zeros((height, width, 3), np.uint8)
        hor = [imageBlank]*rows
        hor_con = [imageBlank]*rows
        for x in range(0, rows):
            hor[x] = np.hstack(imgArray[x])
        ver = np.vstack(hor)
    else:
        for x in range(0, rows):
            if imgArray[x].shape[:2] == imgArray[0].shape[:2]:
                imgArray[x] = cv2.resize(imgArray[x], (0, 0), None, scale, scale)
            else:
                imgArray[x] = cv2.resize(imgArray[x], (imgArray[0].shape[1], imgArray[0].shape[0]), None,scale, scale)
            if len(imgArray[x].shape) == 2: imgArray[x] = cv2.cvtColor(imgArray[x], cv2.COLOR_GRAY2BGR)
        hor= np.hstack(imgArray)
        ver = hor
    return ver

img = cv2.imread("Resources/1.jpg")
kernel = np.ones((5,5),np.uint8)

imgGray = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
#RGB가 맞지만 오픈소스cv는 GBG이며, 우리가 읽을 색상은 GRAY이기떄문에 그레이로 컨버트

imgBlur = cv2.GaussianBlur(imgGray,(7,7),0)
# 컬러 이미지던 그레이이미지던 사용  kernel size : 3,3 / 5,5 /7,7  ) sigma 0

imgCanny = cv2.Canny(img, 100,100)
#파라미터는 케니의 정도를 나타냄 파라미터값을 높이면 엣지의 정도가 낮아짐.

imgDilation = cv2.dilate(imgCanny,kernel,iterations=1)
#kernel 사이즈를 정의하고, canny의 라인 두께를 재정의함.

imgEroded = cv2.erode(imgDilation,kernel,iterations=1)
#kernel 사이즈를 정의하고, imgDilation 라인 두께를 재정의함.

array = ([img,imgGray,imgBlur],[imgCanny,imgDilation,imgEroded])

newimg = stackImages(0.6,array)
# cv2.imshow("original Image",img)
# cv2.imshow("Gray Image",imgGray)
# cv2.imshow("Blur Image",imgBlur)
# cv2.imshow("canny Image",imgCanny)
# cv2.imshow("dilation Image",imgDilation)
# cv2.imshow("eroded Image",imgEroded)
cv2.imshow("check",newimg)
cv2.waitKey(0)