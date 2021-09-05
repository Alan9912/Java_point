package com.ManagerSystempackage;

import java.util.Scanner;
import java.util.ArrayList;

public class ManagerSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choose;
        String sid, name, age, city;
        ArrayList<Student> students = new ArrayList<Student>();
        while (true) {
            System.out.println("----------欢迎来到学生管理系统！！！----------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看所有学生");
            System.out.println("5.退出系统");
            System.out.print("请输入您需要进行的操作：");
            choose = sc.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("请输入学生学号：");
                    sid = sc.nextLine();
                    if (checkSid(students, sid)) {
                        System.out.println("输入学号重复，请检查后重试。");
                        break;
                    }
                    System.out.println("请输入学生姓名：");
                    name = sc.nextLine();
                    System.out.println("请输入学生年龄：");
                    age = sc.nextLine();
                    System.out.println("请输入学生所在城市：");
                    city = sc.nextLine();
                    Student addStudent = new Student(sid, name, age, city);
                    students.add(addStudent);
                    System.out.println("添加学生信息成功,添加的学生信息如下");
                    showOneStudent(students, students.size() - 1);
                    break;
                case "2":
                    showStudents(students);
                    System.out.println("请输入需要删除的学生学号：");
                    sid = sc.nextLine();
                    System.out.println("确定要删除" + sid + "吗？确认删除请输入yes或y，不删除输入no或n");
                    String enter = sc.nextLine();
                    if (enter.equals("yes") || enter.equals("y")) {
                        int index = -1;
                        for (int i = 0; i < students.size(); i++) {
                            Student temp = students.get(i);
                            if (temp.getSid().equals(sid)) {
                                students.remove(i);
                                index = i;
                            }
                        }
                        if (index == -1) {
                            System.out.println("该学生不存在，请确认后重试");
                        }
                    }
                    break;
                case "3":
                    showStudents(students);
                    System.out.println("请输入需要修改的学生学号：");
                    sid = sc.nextLine();
                    int index = -1;
                    for (int i = 0; i < students.size(); i++) {
                        Student temp = students.get(i);
                        if (temp.getSid().equals(sid)) {
                            System.out.println("请输入学生新的学号：");
                            sid = sc.nextLine();
                            if (checkSid(students, sid)) {
                                System.out.println("输入学号重复，请检查后重试。");
                                index = 1;
                                break;
                            }
                            System.out.println("请输入学生新的姓名：");
                            name = sc.nextLine();
                            System.out.println("请输入学生新的年龄：");
                            age = sc.nextLine();
                            System.out.println("请输入学生新的所在城市：");
                            city = sc.nextLine();
                            Student changeStudent = new Student(sid, name, age, city);
                            students.set(i, changeStudent);
                            index = i;
                            System.out.println("修改学生信息成功,修改的学生信息如下");
                            showOneStudent(students, i);
                        }
                    }
                    if (index == -1) {
                        System.out.println("该学生不存在，请确认后重试");
                    }
                    break;
                case "4":
                    if (students.size() == 0) {
                        System.out.println("--------------------");
                        System.out.println("暂时没有学生数据，请添加后再进行查看。");
                        break;
                    }
                    showStudents(students);
                    break;
                case "5":
                    System.out.println("----------成功退出学生管理系统，期待下次使用。----------");
                    System.exit(0);
                default:
                    System.out.println("--------------------");
                    System.out.println("选择错误，请重新选择。");
            }
        }
    }

    public static void showOneStudent(ArrayList<Student> students, int i) {
        System.out.println("----------学生信息----------");
        System.out.println("学号\t\t\t姓名\t\t\t\t年龄\t\t\t所在城市");
        Student showStudent = students.get(i);
        System.out.println(showStudent.getSid() + "\t\t\t" + showStudent.getName() + "\t\t\t" + showStudent.getAge() + "\t\t\t" + showStudent.getCity());
    }

    public static void showStudents(ArrayList<Student> students) {
        System.out.println("----------学生信息----------");
        System.out.println("学号\t\t\t姓名\t\t\t\t年龄\t\t\t所在城市");
        for (int i = 0; i < students.size(); i++) {
            Student showStudent = students.get(i);
            System.out.println(showStudent.getSid() + "\t\t\t" + showStudent.getName() + "\t\t\t" + showStudent.getAge() + "\t\t\t" + showStudent.getCity());
        }
    }

    public static boolean checkSid(ArrayList<Student> students, String sid) {
        boolean flag = false;
        for (int i = 0; i < students.size(); i++) {
            Student testSid = students.get(i);
            if (testSid.getSid().equals(sid)) {
                flag = true;
            }
        }
        return flag;
    }
}
