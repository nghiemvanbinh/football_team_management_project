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
<<<<<<< HEAD
        fullname = namecheck(sc);
        System.out.println("Nhập vào tuổi");
        age = numcheck(sc, 15);
=======
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
>>>>>>> 448a8a804567f0677c389097dd4897b6179943b6
        System.out.println("Nhập vào quốc tịch");
        nationality = namecheck(sc);
        System.out.println("Nhập vào lương");
<<<<<<< HEAD
        salary = numcheck(sc, 0 );
=======
        try {
            salary = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e){
            e.getMessage();
        }if(age < 0){
            throw new IllegalArgumentException("Wages cannot be a negative number");
        }
>>>>>>> 448a8a804567f0677c389097dd4897b6179943b6
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
