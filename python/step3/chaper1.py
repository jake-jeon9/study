import cv2

print("package imported")

#read images
#img = cv2.imread("Resources/OCR-Desktop-front.png")
#cv2.imshow("Output" , img)
#cv2.waitKey(1000) # -> ms

#read video
#cap = cv2.VideoCapture("Resources/KakaoTalk.mp4")
# while True :
#     success , img = cap.read()
#     cv2.imshow("Video",img)
#     if cv2.waitKey(1) & 0xFF == ord('q') : # q를 누르면 바로 종료.
#         break;

#read webcam
cap = cv2.VideoCapture(0) #파라미터로 카메라 ID를 입력.// 카메라가 1개이고 연결된 상태라면 0번  다른게 있다면 아이디를 입력
cap.set(3,640) #설정옵션과 가로
cap.set(4,480) # 설정옵션과 세로
cap.set(10,100) #밝기 조절

while True :
    success , img = cap.read()
    cv2.imshow("Video",img)
    if cv2.waitKey(1) & 0xFF == ord('q') : # q를 누르면 바로 종료.
        break;