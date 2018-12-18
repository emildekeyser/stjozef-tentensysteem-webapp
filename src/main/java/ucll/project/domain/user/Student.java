package ucll.project.domain.user;

import ucll.project.domain.DomainException;
import ucll.project.domain.Grade;
import ucll.project.domain.StudentClass;

public class Student extends User{
    private StudentClass studentClass;

    public Student(Integer primaryKey, String userName, String firstName, String lastName, String email, Gender gender) {
        super(primaryKey, userName, firstName, lastName, email, gender);
    }

    public void setClass(StudentClass c) {
        if (c == null) {
            throw new DomainException("Cant add student to no class");
        }

        if (this.studentClass != null) {
            studentClass.removeStudent(this);
        } else {
            this.studentClass = c;
            c.addStudent(this);
        }
    }

    public Grade getGrade() {
        return this.getStudentClass()==null?null:this.getStudentClass().getGrade();
    }

    public StudentClass getStudentClass() {
        return this.studentClass;
    }
}
