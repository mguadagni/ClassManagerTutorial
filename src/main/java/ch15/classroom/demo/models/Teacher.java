package ch15.classroom.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer salary;

    @ManyToOne
    @JoinColumn(name = "school_id", referencedColumnName = "id")
    @JsonIncludeProperties({"id", "name"})
    private School school;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    @JsonIncludeProperties({"name", "id"})
    private Set<Student> students;

    public Teacher() {
    }

    public Teacher(String name, Integer salary, School school) {
        this.name = name;
        this.salary = salary;
        this.school = school;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Set<Student> getStudents() {
        return students;
    }
}
