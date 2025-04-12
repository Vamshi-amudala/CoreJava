package Edu_Bridge.StudentManagement;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.Scanner;

public class StudentImp {

    int id;

    String name;

    int age;

    String course;

    String email;

    public StudentImp(int id, String name, int age, String course, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "StudentImp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
