package ucll.project.domain;

import ucll.project.domain.user.Student;
import ucll.project.domain.user.Teacher;

import java.util.List;

public class StudentClass {
    private Teacher teacher;
    private List<Student> students;
    private String name;
    private Grade grade;

    public StudentClass(Teacher teacher, String name, Grade grade) {
        setTeacher(teacher);
        setName(name);
        this.grade = grade;
    }
    public Teacher getTeacher() {
        return teacher;
    }

    public void removeStudent(Student s) {
        if (s == null) {
            throw new DomainException("Cant remove null from class");
        }
        if (this.students.contains(s)) {
            this.students.remove(s);
        } else {
            throw new DomainException("Student not in class");
        }
    }

    public void setTeacher(Teacher teacher) {
        if (teacher == null) {
            throw new DomainException("Teacher can't be empty");
        }
        this.teacher = teacher;
    }

    public void addStudent(Student s) {
        if (s == null) {
            throw new DomainException("Student can't be empty");
        }
        if (this.students.contains(s)) {
            throw new DomainException("Student already in class!");
        }
        this.students.add(s);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudents(List<Student> students) {
        if (students == null || students.isEmpty()) {
            throw new DomainException("can't add empty list of students");
        }
        for (Student s : students) {
            this.addStudent(s);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new DomainException("name can't be empty");
        }
        this.name = name;
    }
}
