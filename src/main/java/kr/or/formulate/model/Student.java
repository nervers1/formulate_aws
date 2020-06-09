package kr.or.formulate.model;

public class Student extends Person {
    private String grade;
    private String schoolName;

    public Student(String name, int age) {
        super(name, age);
    }

    public Student(String name, int age, String grade, String schoolName) {
        super(name, age);
        this.grade = grade;
        this.schoolName = schoolName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
