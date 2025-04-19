package com.vanar.lab7;

import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class WriteStuToFile {
    public static void writeStudent(File fileDir, Student studentInfo){
        try{
            FileWriter studenFileWriter = new FileWriter(fileDir);
            studenFileWriter.write("Student Information:\n");
            writeDashLine(studenFileWriter);
            studenFileWriter.write("Name:  "+studentInfo.getName()+
              "\nAge:  "+studentInfo.getAge()+
              "\nGender:  "+studentInfo.getGender()+
              "\n\nSchool Details:\n"
            );
            writeDashLine(studenFileWriter);
            studenFileWriter.write("Grade Level:  "+studentInfo.getGrade()+
              "\nMajor:  "+studentInfo.getMajor()+
              "\nGPA:  "+studentInfo.getGpa()
            );
            System.out.println("Info successfully added to file");
            studenFileWriter.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred."+e);
        };
    }
    private static void writeDashLine(FileWriter currWriter){
        char dash = '-';
        try{
            for(int i=0;i<24; i++){
                currWriter.append(dash);
            }
            currWriter.append("\n");
        }
        catch (IOException e) {
            System.out.println("An error occurred."+e);
        };
    }
}
