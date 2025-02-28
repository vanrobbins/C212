import random
import os
cwd=os.getcwd()
print(cwd);
newFile = open(cwd+"/numbers.txt",'w')
i=0

#amount of sets 
amountSets=20;
#amount of num per set
maxNumPerSet=10;
minNumPerSet=5;
amountNumPerSet=0;
while(i<amountSets):
    amountNumPerSet=(random.randint(minNumPerSet,maxNumPerSet))+1
    j=0
    while(j<amountNumPerSet):
        if j==0:
            newFile.write(str(random.randint(1,4)))
        else:
            newFile.write(str(random.randint(10,99)))
        if(j<(amountNumPerSet-1)):
            newFile.write(', ');
        j+=1
    if i<(amountSets-1):
        newFile.write("\n");
    i+=1