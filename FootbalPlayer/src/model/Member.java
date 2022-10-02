package model;

import java.util.Scanner;

public class Member {
    private String fullname;
    private int age;
    private String nationality;
    private int salary;



    public Member() {
    }

    public Member(String fullname, int age, String nationality, int salary) {
        this.fullname = fullname;
        this.age = age;
        this.nationality = nationality;
        this.salary = salary;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void Input(Scanner sc){
        System.out.println("Nhập vào họ tên");
        fullname = sc.nextLine();
        if(fullname.matches("^[a-zA-Z]*$")){}
        else System.out.println("Name doesnt qualified");
        System.out.println("Nhập vào tuổi");
        try {
            age = Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            e.getMessage();
        }if(age < 15){
            throw new IllegalArgumentException("U-15 cannot be eligible for professional football player/coach");
        }
        System.out.println("Nhập vào quốc tịch");
        nationality = sc.nextLine();
        System.out.println("Nhập vào lương");
        try {
            salary = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e){
            e.getMessage();
        }if(age < 0){
            throw new IllegalArgumentException("Wages cannot be a negative number");
        }
    }

    @Override
    public String toString() {
        return "Member{" +
                "fullname='" + fullname + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", salary=" + salary +
                '}';
    }
    public void showInfo(){
        System.out.print(toString());
    }
}
