def reverse(n):
    if n == 0:
        return ""
    else:
        last_digit = n % 10
        remaining_digits = n // 10
        return str(last_digit) + reverse(remaining_digits)

print('Введите число: ')
n=int(input())
print(reverse(n))