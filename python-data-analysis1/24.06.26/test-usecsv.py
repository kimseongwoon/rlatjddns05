import usecsv
import os

print(os.getcwd())
os.chdir(r'c:\Users\human-01\python-data-analysis1\24.06.26')

a = [['국어','영어','수학'],[99,88,77]]
usecsv.writecsv('test.csv', a)

total = usecsv.opencsv(r'c:\Users\human-01\python-data-analysis1\24.06.26\popSeoul2023.csv')
print(usecsv.switch(total))