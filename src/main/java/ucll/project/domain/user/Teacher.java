package ucll.project.domain.user;

import ucll.project.domain.DomainException;
import ucll.project.domain.Grade;
import ucll.project.domain.StudentClass;

public class Teacher extends User{
    public Teacher(Integer primaryKey, String userName, String firstName, String lastName, String email, Gender gender) {
        super(primaryKey, userName, firstName, lastName, email, gender);
    }

    @Override
    public String toString() {
        return "Teacher" + super.toString();
    }
}
