def find_max_el(a):
    max_el = a[0][0]
    max_row = 0
    max_col = 0
    for i in range(len(a)):
        for j in range(len(a[0])):
            if a[i][j] > max_el:
                max_el = a[i][j]
                max_row = i
                max_col = j
    return max_row, max_col
def swap_rows(a, r1, r2):
    a[r1], a[r2] = a[r2], a[r1]
def swap_columns(a, c1, c2):
    for i in range(len(a)):
        a[i][c1], a[i][c2] = a[i][c2], a[i][c1]

m=int(input('Введите количество строк: '))
n=int(input('Введите количество столбцов: '))
a=[]
for i in range(m):
    b=[]
    for j in range(n):
        print('Введите [', i,',', j,'] элемент: ')
        b.append(int(input()))
    a.append(b)
#Вывод начальной матрицы
for i in range(m):
    for j in range(n):
        print(a[i][j],end=' ')
    print()

max_row, max_col = find_max_el(a) #Нахождение максимального элемента и его координат
swap_rows(a, max_row, 0) #Перемещение строки с максимальным элементом вверх
swap_columns(a, max_col, 0) #Перемещение столбца с максимальным элементом влево

#Вывод новой матрицы
print("\nНовая матрица:")
for row in a:
    print(*row)