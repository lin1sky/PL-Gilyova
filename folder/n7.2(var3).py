from random import*
n=8
d=[randint(0,100) for i in range (n)]
print('Изначальный массив:', d)
for i in range(n):
    if d[i]<15:
        d[i]*=2
print('Преобразованный массив:', d)