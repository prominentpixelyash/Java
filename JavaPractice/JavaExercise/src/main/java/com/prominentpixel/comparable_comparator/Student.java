package com.prominentpixel.comparable_comparator;

import java.util.Objects;

public class Student {

    private int id;
    private String collage;
    private String name;
    private String grade;

    public Student() {
    }

    public Student(int id, String collage, String name, String grade) {
        this.id = id;
        this.collage = collage;
        this.name = name;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(collage, student.collage) && Objects.equals(name, student.name) && Objects.equals(grade, student.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, collage, name, grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", collage='" + collage + '\'' +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
