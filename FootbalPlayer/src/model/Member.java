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
        System.out.println("Nhập vào tuổi");
        age = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào quốc tịch");
        nationality = sc.nextLine();
        System.out.println("Nhập vào lương");
        salary = Integer.parseInt(sc.nextLine());
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
        System.out.println(toString());
    }
}
