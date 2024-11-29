def is_symmetric(a):
    n = len(a)

    for i in range(n):
        for j in range(i + 1, n):
            if a[i][j] != a[j][i]:
                return False
    return True

a=[]
with open('E:\ГилеваАлинаСергеевна_У243_vvod.txt','r') as file:
    l = file.readlines()
for line in l:
    row = list(map(int, line.strip().split()))
    a.append(row)

with open('E:\ГилеваАлинаСергеевна_У243_vivod.txt','w') as file:
    result = "Матрица симметрична." if is_symmetric(a) else "Матрица несимметрична."
    file.write(result)

print(f'Результат записан в файл')

