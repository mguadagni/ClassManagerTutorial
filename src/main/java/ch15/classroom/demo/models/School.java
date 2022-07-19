package ch15.classroom.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "school", fetch=FetchType.LAZY)
    @JsonIncludeProperties("name")
    private Set<Teacher> teachers;

    @OneToMany(mappedBy = "school", fetch=FetchType.LAZY)
    @JsonIncludeProperties("name")
    private Set<Student> students;

    public School() {
    }

    public School(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMoneyEarned() {
        Integer sum = 0;
        for (Student student: students) {
            sum += student.getFeesPaid();
        }

        return sum;
    }

    public Integer getMoneySpent() {
        return getMoneyEarned() - getTeacherSalaries();
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    @JsonIgnore
    private Integer getTeacherSalaries() {
        Integer sum = 0;
        for (Teacher teacher: teachers) {
            sum += teacher.getSalary();
        }

        return sum;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String getName() {
        return name;
    }
}
