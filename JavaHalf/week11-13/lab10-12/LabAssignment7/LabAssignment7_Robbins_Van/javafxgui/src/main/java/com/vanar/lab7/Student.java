package com.vanar.lab7;

public class Student {
    private String name;
    private int age;
    private String gender;
    private String grade;
    private String major;
    private double gpa;
    public Student(String name, int age, String gender, String grade, String major, double gpa){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.grade=grade;
        this.major=major;
        this.gpa=gpa;
    }
    public Student(String name, int age, String gender){
        this.name=name;
        this.age=age;
        this.gender=gender;
    }
    public Student(String grade, String major, double gpa){
        this.grade=grade;
        this.major=major;
        this.gpa=gpa;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    public double getGpa() {
        return gpa;
    }
    public String getGrade() {
        return grade;
    }
    public String getMajor() {
        return major;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
