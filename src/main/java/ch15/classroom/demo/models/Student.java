package ch15.classroom.demo.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer fees = 30000_00;
    private String name;
    private String grade;
    private Integer feesPaid = 0;

    @ManyToOne
    @JoinColumn(name="school_id", referencedColumnName = "id")
    @JsonIncludeProperties({"id", "name"})
    private School school;

    @ManyToOne
    @JoinColumn(name="teacher_id", referencedColumnName = "id")
    @JsonIncludeProperties({"id", "name"})
    private Teacher teacher;

    public Student() {
    }

    public Student(String name, String grade, Teacher teacher, School school) {
        this.name = name;
        this.grade = grade;
        this.teacher = teacher;
        this.school = school;
    }

    public Long getId() {
        return id;
    }

    public Integer getFees() {
        return fees;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getFeesPaid() {
        return feesPaid;
    }

    public void payFees(Integer payment) {
        this.feesPaid += payment;
    }

    public School getSchool() {
        return school;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
