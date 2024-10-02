n=int(input())
if n<=1440:
    hours=n%(60*24)//60
    minutes=n%60
    print(hours,':',minutes)
else:
    days=n//(60*24)
    hours=n%(60*24)//60
    minutes=n%60
    print(days, hours,':',minutes)