package model;

import java.io.IOException;
import java.util.InputMismatchException;
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
        fullname = namecheck(sc);
        System.out.println("Nhập vào tuổi");
        age = numcheck(sc, 15);
        System.out.println("Nhập vào quốc tịch");
        nationality = namecheck(sc);
        System.out.println("Nhập vào lương");
        salary = numcheck(sc, 0 );
    }

    @Override
    public String toString() {
        return ",{" +
                "fullname='" + fullname + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", salary=" + salary +
                '}';
    }

    public void showInfo() {
        System.out.print(toString());
    }

    public String namecheck(Scanner s) {
        boolean c = false;
        String res = null;
        do {
            try {
                res = s.nextLine();
                c = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input words is only included here");
            }
        } while (c == false);
        return res;
    }

    public int numcheck(Scanner s, int check) {
        boolean c = false;
        boolean cp = false;
        int res = 0;
        do {
            try {
                res = Integer.parseInt(s.nextLine());
                c = true;
            } catch (NumberFormatException e) {
                System.out.println("Try a number this time");
            }
            do {
                if (res < check) {
                    try {
                        System.out.println("Invalid number, number must be greater than " + check);
                        res = Integer.parseInt(s.nextLine());
                        c = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Try a number this time");
                    }
                } else {
                    cp = true;
                }
            } while (cp == false);
            return res;
        } while (c == false);
    }
}
