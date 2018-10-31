import numpy as np 
from random import randint


campo = np.zeros((10,10), dtype=np.float64)


i = 0
j = 0
vX = [2,3,4,5,6,7]
while i < 1:

    x = randint(0,9)
    y = randint(0,9)
    
    if campo[x][y] == 0:

        x = randint(0,9)
        y = randint(0,9) 
        campo[x][y] = 5
        v1 = y
        v2 = x  
        

    print(v1)
    
    
    while j < 1:
        if v1 >= 8:
            campo[x][y] = 0
            print('entrou' , j)
            y = randint(0,9)
            campo[x][y] = 5
            
        elif(v1 < 2):
            campo[x][y] = 0
            print('entrou' , j)
            y = randint(0,9)
            campo[x][y] = 5

        if y in vX:
            j = 1    
    
    i = 1


x = 0
y = 0
# Gerando submarinos

i = 0

while i < 4:

    x = randint(0,9)
    y = randint(0,9)

    if campo[x][y] == 0:
       x = randint(0,9)
       y = randint(0,9) 
       campo[x][y] = 1
       i = i+1








print(campo)

