from random import*
n=int(input('Введите длину массива:'))
d=[randint(0,100) for i in range (n)]
print(d)
sum=0
for i in range(n):
    if i%2!=0:
        sum+=d[i]
print('Сумма:',sum)
