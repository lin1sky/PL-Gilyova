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


a=[]

with open('E:\ГилеваАлинаСергеевна_У243_vvod.txt','r') as file:
    l = file.readlines()

m = int(l[0].strip()[:2])
n = int(l[1].strip()[:2])
for line in l:
    row = list(map(int, line.strip().split()))
    a.append(row)

max_row, max_col = find_max_el(a) #Нахождение максимального элемента и его координат
swap_rows(a, max_row, 0) #Перемещение строки с максимальным элементом вверх
swap_columns(a, max_col, 0) #Перемещение столбца с максимальным элементом влево

with open('E:\ГилеваАлинаСергеевна_У243_vivod2.txt','w') as file:
    for row in a:
        file.write(" ".join(map(str, row)) + "\n")
print('Новая матрица записана в файл')
