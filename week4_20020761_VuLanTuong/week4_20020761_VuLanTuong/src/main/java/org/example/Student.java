package org.example;

public class Student {
    private String id;
    private String name;


    private Clazz className;


    public Student() {
    }

    public Student(String id, String name, Clazz className) {
        this.id = id;
        this.name = name;
        this.className = className;
    }

    public Clazz getClassName() {
        return className;
    }

    public void setClassName(Clazz className) {
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

