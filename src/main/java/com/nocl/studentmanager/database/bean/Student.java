package com.nocl.studentmanager.database.bean;

public class Student {
    private String uid;
    private String name;
    private Integer age;
    private String gender;
    private String addr;
    private String academy;
    private String specialized;
    private String studentClass;

    public Student getStudent() {
        return this;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getSpecialized() {
        return specialized;
    }

    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", addr='" + addr + '\'' +
                ", academy='" + academy + '\'' +
                ", specialized='" + specialized + '\'' +
                ", studentClass='" + studentClass + '\'' +
                '}';
    }

    public Object[] toObject() {
        return new Object[] {
                this.uid,
                this.name,
                this.age,
                this.gender,
                this.addr,
                this.academy,
                this.specialized,
                this.studentClass
        };
    }
}
