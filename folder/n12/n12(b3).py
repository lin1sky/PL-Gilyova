def output():
    def f():
        nonlocal c
        n = int(input())
        if n != 0:
            if c % 2 == 1:
                print(n)
            c += 1
            f()
    c = 1
    f()

output()
