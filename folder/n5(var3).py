n=int(input())
i=1
c=0
if n>0:
    while i<n:
        i*=2
        c+=1
    print(c-1, i//2)    
else:
    print('error')