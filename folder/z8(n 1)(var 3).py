import math
def g(x,y):
    g=math.hypot(x,y)
    return g
a=[]
for i in range(1,3):
    print('Введите катеты',i,'-го треугольника:')
    k1=int(input())
    k2=int(input())
    print('k1:',k1,'k2:',k2)
    a.append(g(k1,k2))
if (a[0])>(a[1]):
    c=a[0]-a[1]
    print(a[0],'- 1-ая гипотенуза,',a[1],'- 2-ая гипотенуза,','Разница: ',c)
elif (a[1])>(a[0]):
    c=a[1]-a[0]
    print(a[0],'- 1-ая гипотенуза,',a[1],'- 2-ая гипотенуза,','Разница: ',c)
else:
    print('Гипотенузы равны')
    
