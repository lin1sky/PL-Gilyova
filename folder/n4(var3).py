a=int(input())
b=int(input())
while a>b:
    for i in range(a+a%2-1, b-1, -2):
        print(i, end=';')
    break
else:
    print ('Error: A<B')