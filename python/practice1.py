import cv2
import numpy as np


def empty(a):
    pass


frameWidth = 640
frameHeight = 480

cap = cv2.VideoCapture(0)
cap.set(3, frameWidth)
cap.set(4, frameHeight)
cap.set(10, 150)

str = ["orange", "lightBlue", "hotPink"]

#특정 색을 추출하는 리스트
myColors = [[1, 99, 190, 103, 184, 255],
            [77, 27, 174, 100, 80, 255],
            [143, 95, 0, 179, 255, 255]]

#지정한 컬러 설정
myColorsValues = [ [51,153,255],  # BGR
                   [255,0,255],
                   [0,255,0]]


myPoints = [] #[x,y,colorId] 만들 리스트


def findCOlor(img, myColors,myColorsValues):
    imgHSV = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)
    i = 0
    newPoints = []
    for color in myColors:
        lower = np.array(color[0:3])
        upper = np.array(color[3:6])
        mask = cv2.inRange(imgHSV, lower, upper)
        x,y = getContours(mask)
        cv2.circle(imgResult,(x,y),10,myColorsValues[i],cv2.FILLED)

        if x != 0 and y != 0 :
            newPoints.append([x,y,i])
        #cv2.imshow(str[i], mask)
        i += 1
    return newPoints


def getContours(img):
    contours, hierarchy = cv2.findContours(img, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_NONE)
    x,y,h,w = 0,0,0,0
    for cnt in contours:
        area = cv2.contourArea(cnt)
        objectType = ""
        if area > 500:
            cv2.drawContours(imgResult, cnt, -1, (255, 0, 0), 3)
            peri = cv2.arcLength(cnt, True)
            apporox = cv2.approxPolyDP(cnt, 0.02 * peri, True)
            x, y, w, h = cv2.boundingRect(apporox)
    return x+w//2,y

def drawOnCanvas(myPoints,myColorsValues) :
    for point in myPoints :
        cv2.circle(imgResult, (point[0],point[1]), 10, myColorsValues[point[2]], cv2.FILLED)


while True:
    success, img = cap.read()
    imgResult = img.copy()
    newPoints = findCOlor(img, myColors,myColorsValues)
    if len(newPoints) !=0:
        for newP in newPoints :
            myPoints.append(newP) #리스트 만들기
    if len(myPoints) != 0 :
        drawOnCanvas(myPoints,myColorsValues)


    cv2.imshow("Video", imgResult)

    if cv2.waitKey(1) & 0xFF == ord('q'):  # q를 누르면 바로 종료.
        break;
