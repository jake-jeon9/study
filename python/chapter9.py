import cv2

faceCascade = cv2.CascadeClassifier("Resources/haarcascade_frontalface_default.xml")

# img = cv2.imread("Resources/iu3.jpg")
# imgGray = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
#
# #사용자에 따라 설정가능
# faces = faceCascade.detectMultiScale(imgGray,1.1,4)
# for (x,y,w,h) in faces :
#     cv2.rectangle(img,(x,y),(x+w,y+h),(255,0,0),2)
#
# cv2.imshow("Result", img)
# cv2.waitKey(0)


cap = cv2.VideoCapture(0) #파라미터로 카메라 ID를 입력.// 카메라가 1개이고 연결된 상태라면 0번  다른게 있다면 아이디를 입력
cap.set(3,640) #설정옵션과 가로
cap.set(4,480) # 설정옵션과 세로
cap.set(10,100) #밝기 조절

while True :
    success , img = cap.read()
    imgGray =cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
    faces = faceCascade.detectMultiScale(imgGray, 1.1, 4)
    for (x, y, w, h) in faces:
        cv2.rectangle(img, (x, y), (x + w, y + h), (255, 0, 0), 2)
        cv2.putText(img,"face",(x,y),cv2.FONT_HERSHEY_PLAIN,4,(0,0,0),2)


    cv2.imshow("Video",img)
    if cv2.waitKey(1) & 0xFF == ord('q') : # q를 누르면 바로 종료.
        break;