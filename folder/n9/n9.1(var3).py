def is_symmetric(a):
    n = len(a)

    for i in range(n):
        for j in range(i + 1, n):
            if a[i][j] != a[j][i]:
                return False
    return True

m=int(input('Введите количество строк: '))
n=int(input('Введите количество столбцов: '))
a=[]
for i in range(m):
    b=[]
    for j in range(n):
        print('Введите [', i,',', j,'] элемент: ')
        b.append(int(input()))
    a.append(b)
for i in range(m):
    for j in range(n):
        print(a[i][j],end=' ')
    print()

if is_symmetric(a):
    print("Матрица симметрична.")
else:
    print("Матрица несимметрична.")

