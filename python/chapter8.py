import cv2
import numpy as np

#이미지 나열하는 함수
def stackImages(scale, imgArray):
    rows = len(imgArray)
    cols = len(imgArray[0])
    rowsAvailable = isinstance(imgArray[0], list)
    width = imgArray[0][0].shape[1]
    height = imgArray[0][0].shape[0]
    if rowsAvailable:
        for x in range(0, rows):
            for y in range(0, cols):
                if imgArray[x][y].shape[:2] == imgArray[0][0].shape[:2]:
                    imgArray[x][y] = cv2.resize(imgArray[x][y], (0, 0), None, scale, scale)
                else:
                    imgArray[x][y] = cv2.resize(imgArray[x][y], (imgArray[0][0].shape[1], imgArray[0][0].shape[0]),
                                                None, scale, scale)
                if len(imgArray[x][y].shape) == 2: imgArray[x][y] = cv2.cvtColor(imgArray[x][y], cv2.COLOR_GRAY2BGR)
        imageBlank = np.zeros((height, width, 3), np.uint8)
        hor = [imageBlank] * rows
        hor_con = [imageBlank] * rows
        for x in range(0, rows):
            hor[x] = np.hstack(imgArray[x])
        ver = np.vstack(hor)
    else:
        for x in range(0, rows):
            if imgArray[x].shape[:2] == imgArray[0].shape[:2]:
                imgArray[x] = cv2.resize(imgArray[x], (0, 0), None, scale, scale)
            else:
                imgArray[x] = cv2.resize(imgArray[x], (imgArray[0].shape[1], imgArray[0].shape[0]), None, scale, scale)
            if len(imgArray[x].shape) == 2: imgArray[x] = cv2.cvtColor(imgArray[x], cv2.COLOR_GRAY2BGR)
        hor = np.hstack(imgArray)
        ver = hor
    return ver


#해당 이미지에 윤곽을 표시하고 이름을 붙여주는 함수
def getContours(img):
    contours, hierarchy = cv2.findContours(img, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_NONE)

    #갯수만큼 영역표시
    for cnt in contours:
        area = cv2.contourArea(cnt)
        print(area)
        objectType = ""
        if area > 500: #500보다 큰거 드로우. 및 색상으로표시
            cv2.drawContours(imgContour, cnt, -1, (255, 0, 0), 3)
            peri = cv2.arcLength(cnt, True)
            print(peri)
            apporox = cv2.approxPolyDP(cnt, 0.02 * peri, True)
            print(len(apporox))


            objCor = len(apporox) #모서리 갯수 구하기
            x, y, w, h = cv2.boundingRect(apporox)

            if objCor == 3:objectType = "Tri"

            # 직사각형인지 정사각형인지 구하기
            elif objCor == 4:
                aspRatio = w/float(h)
                if aspRatio > 0.95 and aspRatio < 1.05 : objectType = "Square"
                else : objectType = "Rectangle"
            #오각형 이상은 원으로 간주.
            elif objCor > 4 : objectType = "Cirle"

            else : objectType ="None"

            #영역 표시
            cv2.rectangle(imgContour, (x, y), (x + w, y + h), (0, 255, 0), 2)

            #텍스트 표시
            cv2.putText(imgContour,objectType,(x+(w//2)-10,y+(h//2)-10),cv2.FONT_HERSHEY_SIMPLEX,0.8
                        ,(0,0,0),2)


path = "Resources/imgT3.PNG"
img = cv2.imread(path)
imgContour = img.copy()

imgGray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
imgBlur = cv2.GaussianBlur(imgGray, (7, 7), 1)
imgCanny = cv2.Canny(imgBlur, 50, 50)

#빈화면 출력
imgBlank = np.zeros_like(img)

#대조군 만들기
getContours(imgCanny)

# cv2.imshow("imgs",img)
# cv2.imshow("Gray",imgGray)
# cv2.imshow("Blur",imgBlur)
imagestack = stackImages(0.8, ([img, imgGray, imgBlur], [imgCanny, imgContour, imgBlank]))
cv2.imshow("Stack", imagestack)
cv2.waitKey(0)
