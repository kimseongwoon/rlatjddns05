#한줄짜리 단축키 -> 블럭을 지정하고 Ctrl + /
print("Hello World")

a=1
b=4
print(a+b)

a = "Python"
print(a)

def add(a, b):
    return a+b

print(add(3,4))
print("Hello World")

a = 0o177
print(a)
a = 0o7
print(a)
a = 0x8FF
b = 0xabc
print(a)
print(b)
# 10진수 -> 0~9  0 1 2 3 4 5 6 7 8 9 10 11
#   - 188 = 100 * 1 + 10 * 8 + 1 * 8
# 8진수 -> 0~7 0 1 2 3 4 5 6 7 10 11 12 13
# 16진수 -> 0~F 0 1 2 3 4 5 6 7 8 9 A B C D E F 10 11 ... 1A

a = 3
b = 4
print(a + b)
print(a - b)
print(a * b)
print(a / b)
print(a ** b)
print(7 % 3)
print(3 % 7)
print(7 / 4)
print(7 // 4)

a = 1
a = a + 1
print(a)

a = 1
a += 1   # a = a + 1과 같음
print(a)

a = 1
a -= 1   # a = a - 1과 같음
print(a)

a = 16
a %= 5   # a = a % 5와 같음

a = 18
a **= 2  # a = a ** 2 -> a = 18 * 18와 같음
print(a)