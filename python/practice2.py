import cv2
import numpy as np

# 사이즈 정의
widthImg, heightImg = 640, 480

# img = cv2.imread("Resources/imgT3.PNG")
cap = cv2.VideoCapture(0)  # 파라미터로 카메라 ID를 입력.// 카메라가 1개이고 연결된 상태라면 0번  다른게 있다면 아이디를 입력
cap.set(3, widthImg)  # 설정옵션과 가로
cap.set(4, heightImg)  # 설정옵션과 세로
cap.set(10, 150)  # 밝기 조절


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


def preProcessing(img):
    imgGray = cv2.cvtColor(img, cv2.COLOR_RGB2GRAY)
    imgBulr = cv2.GaussianBlur(imgGray, (5, 5), 1)
    imgCanny = cv2.Canny(imgBulr, 200, 200)
    # 케니를 리턴해도 잘보이지만 가끔 그림자로 인해 구분이 안될 수 있어서 아래와같이 코드를 추가하여
    # 이를 보완함

    kernel = np.ones((5, 5))
    imgDial = cv2.dilate(imgCanny, kernel, iterations=2)
    imgThres = cv2.erode(imgDial, kernel, iterations=1)

    return imgThres


def getContours(img):
    contours, hierarchy = cv2.findContours(img, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_NONE)
    biggest = np.array([])
    maxArea = 0
    # 갯수만큼 영역표시
    for cnt in contours:
        area = cv2.contourArea(cnt)

        if area > 5000:  # 500보다 큰거 드로우. 및 색상으로표시
            # cv2.drawContours(imgContour, cnt, -1, (255, 0, 0), 3)
            peri = cv2.arcLength(cnt, True)
            apporox = cv2.approxPolyDP(cnt, 0.02 * peri, True)

            if area > maxArea and len(apporox) == 4:
                biggest = apporox
                maxArea = area
    cv2.drawContours(imgContour, biggest, -1, (255, 0, 0), 10)
    return biggest


def reorder(myPoints):
    # 아래 숫자는 비게스트 쉐이프에서 추출된 숫자.
    myPoints = myPoints.reshape((4, 2))
    newMyPoint = np.zeros((4, 1, 2), np.int32)
    add = myPoints.sum(1)
    # print("add : ", add)
    # print("myPoints : ", myPoints)
    # print("np.argmin(add)", np.argmin(add))
    # print("np.argmax(add)", np.argmax(add))

    newMyPoint[0] = myPoints[np.argmin(add)]
    newMyPoint[3] = myPoints[np.argmax(add)]
    diff = np.diff(myPoints, axis=1)
    newMyPoint[1] = myPoints[np.argmin(diff)]
    newMyPoint[2] = myPoints[np.argmax(diff)]
    # print("newMyPoint", newMyPoint)
    return newMyPoint


def getWrap(img, biggest):
    # print("biggest", biggest)
    # print("biggest.shape", biggest.shape)

    biggest = reorder(biggest)

    pts1 = np.float32(biggest)
    pts2 = np.float32([[0, 0], [widthImg, 0], [0, heightImg], [widthImg, heightImg]])
    matrix = cv2.getPerspectiveTransform(pts1, pts2)
    imgOutput = cv2.warpPerspective(img, matrix, (widthImg, heightImg))

    # 여백자르기
    imgCropped = imgOutput[20:imgOutput.shape[0] - 20, 20:imgOutput.shape[1] - 20]
    imgCropped = cv2.resize(imgCropped, (widthImg, heightImg))
    return imgCropped


while True:
    success, img = cap.read()
    cv2.resize(img, (widthImg, heightImg))
    imgContour = img.copy()
    imgTres = preProcessing(img)
    biggest = getContours(imgTres)

    #대조군 없을때 첫 이미지 캡쳐
    imgBlank = np.zeros_like(img)
    imgWarped = imgBlank


    #오류 방지
    try:
        if biggest.size != 0:
            imgWarped = getWrap(img, biggest)
            imgArray = ([img, imgTres], [imgContour, imgWarped])
        else:
            imgArray = ([img, imgTres], [img, img])
    except Exception as E:
        pass

    cv2.imshow("red Image", imgWarped)
    stackedImage = stackImages(0.6, imgArray)
    cv2.imshow("Stuck Image", stackedImage)

    if cv2.waitKey(1) & 0xFF == ord('q'):  # q를 누르면 바로 종료.
        break;
