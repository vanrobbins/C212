import random
import os
cwd=os.getcwd()+"/C++Half/week5-6/lab4-5/labActivities/lab4Calculator";
print(cwd);
newFile = open(cwd+"/input.txt",'w')
i=0
#amount of student score sets 
amountCalculations=20;
operators=["+","-","*","/"];
while(i<amountCalculations):
    if(i<amountCalculations-1):
        newFile.write(operators[random.randint(0,3)]+" "+str(random.randint(0,25))+" "+str(random.randint(0,25))+"\n");
    else:
        newFile.write(operators[random.randint(0,3)]+" "+str(random.randint(0,25))+" "+str(random.randint(0,25)));
    i+=1
