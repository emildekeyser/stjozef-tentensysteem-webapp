package ucll.project.domain.user;

import ucll.project.domain.DomainException;
import ucll.project.domain.Grade;
import ucll.project.domain.StudentClass;

public class Teacher extends User{
    private StudentClass studentClass;

    public Teacher(Integer primaryKey, String userName, String firstName, String lastName, String email, Gender gender) {
        super(primaryKey, userName, firstName, lastName, email, gender);
    }

    public void setClass(StudentClass c) {
        if (c == null) {
            throw new DomainException("Cant add student to no class");
        }

        if (this.studentClass == null) {
            this.studentClass = c;
        }

        c.setTeacher(this);
    }

    public StudentClass getStudentClass() {
        return this.studentClass;
    }
}
