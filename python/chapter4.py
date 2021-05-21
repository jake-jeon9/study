import cv2
import numpy as np

img = np.zeros((512,512,3),np.uint8)
print(img.shape)

#img[200:300,100:300] = 255,0,0 #BRG
#특정부분의 좌표 색상을 설정하는 명령

#cv2.line(img,(0,0),(300,300),(0,255,255))
#이미지, 시작포인트, 끝포인트 , 컬러색상 , 라인두께, 라인타입

cv2.line(img,(0,0),(img.shape[1],img.shape[0]),(0,255,0),3)

#네모만들기
cv2.rectangle(img,(0,0),(250,350),(0,0,255),2)

#원만들기
cv2.circle(img,(400,50),30,(255,255,0),5)

#글자 쓰기
cv2.putText(img,"OPEN CV",(300,100),cv2.FONT_HERSHEY_PLAIN,1,(0,150,0),1)

cv2.imshow("image",img)


cv2.waitKey(0)