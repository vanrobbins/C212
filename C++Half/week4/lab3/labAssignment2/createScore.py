import random
import os
cwd=os.getcwd()+"/C++Half/week4/lab3/labAssignment2";
print(cwd);
newFile = open(cwd+"/score.txt",'w')
i=0
#amount of student score sets 
amountStudents=500;
#amount of scores per student
amountScoresPerStudent=5
while(i<amountStudents):
    j=0
    while(j<amountScoresPerStudent):
        newFile.write(str(random.randint(50,100)))
        if(j<(amountScoresPerStudent-1)):
            newFile.write(', ');
        j+=1
    if i<(amountStudents-1):
        newFile.write("\n");
    i+=1
