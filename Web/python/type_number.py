#!/usr/bin/python3
# 헤더 추가
print("Content-Type: text/html; charset=UTF-8\n")

# 숫자는 그대로
print(1+1)
a = 2*3
print(a)

# 문자도 별거 없다
print('Hello world')
print("hello world")
print("Hell'o' world")
print("Hell\"o\" world") # 큰 다옴표 내에서 큰 따옴표 표기만 주의
print("서식문자도 비슷하게 사용한다.")

# 개행문자
print("개행은 \n 이렇게")

#docstring
print('''또는
이렇게 docstring을 사용''')

#
# # boolean
# x = True
# y = False
#
# x and y
# not x
# x or y
