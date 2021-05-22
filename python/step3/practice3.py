import cv2
import pytesseract

#테사렛 path
pytesseract.pytesseract.tesseract_cmd = r'C:\Users\Jeon Seonghwan\AppData\Local\Tesseract-OCR\tesseract.exe'

frameWidth = 640
frameHeight = 480
numberPlatecase = cv2.CascadeClassifier("Resources/haarcascade_russian_plate_number.xml")
minArea = 500
color = (255,0,255)
count = 0

# img = cv2.imread("Resources/imgT3.PNG")
cap = cv2.VideoCapture(0)  # 파라미터로 카메라 ID를 입력.// 카메라가 1개이고 연결된 상태라면 0번  다른게 있다면 아이디를 입력
cap.set(3, frameWidth)  # 설정옵션과 가로
cap.set(4, frameHeight)  # 설정옵션과 세로
cap.set(10, 300)  # 밝기 조절


plate_chars = []

while True :
    success , img =cap.read()

    imgGray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    numberPlates = numberPlatecase.detectMultiScale(imgGray, 1.1, 4)
    for (x, y, w, h) in numberPlates:
        area = w*h

        #번호판을 인식시켜서 해당 창을 업로드함.
        if area > minArea :
            cv2.rectangle(img, (x, y), (x + w, y + h), (255, 0, 0), 2)
            cv2.putText(img, "Number Plate", (x, y-5),
                        cv2.FONT_HERSHEY_PLAIN, 1, color, 2)
            imgRoi = img[y:y+h,x:x+w]
            cv2.imshow("ROI",imgRoi)

            chars = pytesseract.image_to_string(imgRoi, lang='kor', config='--psm 7 --oem 0')

            result_chars = ''
            has_digit = False
            for c in chars:
                if ord('가') <= ord(c) <= ord('힣') or c.isdigit():
                    if c.isdigit():
                        has_digit = True
                    result_chars += c

            print(result_chars)
            plate_chars.append(result_chars)


    cv2.imshow("Result" , img)
    if cv2.waitKey(1) & 0xFF == ord('q'):  # q를 누르면 바로 종료.
        break;

    #단축키를 통해 저장
    elif cv2.waitKey(1) & 0xFF == ord('s') : # s를 눌러 저장
        cv2.imwrite("Resources/savedPhoto/NoPlate_"+str(count)+".jpg",imgRoi)
        cv2.rectangle(img,(0,200),(640,300),(0,255,0),cv2.FILLED)
        cv2.putText(img,"Scan Saved",(0,20),cv2.FONT_HERSHEY_PLAIN,
                    2,(0,0,255),2)

        cv2.imshow("Result",img)
        cv2.waitKey(500)
        count +=1
