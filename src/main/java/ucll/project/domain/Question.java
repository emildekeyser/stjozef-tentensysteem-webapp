package ucll.project.domain;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String value;
    private Grade grade;
    private List<Answer> answers = new ArrayList<>();

    public Question(String value, Grade grade1) {
        this.setGrade(grade1);
        this.setValue(value);
    }

    public String getValue() {
        return this.value;
    }

    public Grade getGrade() {
        return this.grade;
    }

    public void addAnswer(Answer answer) {
        if (answer == null) {
            throw new DomainException("Answer can't be null");
        }
        if (this.answers.contains(answer)) {
            throw new DomainException("Answer already exists");
        }
        this.answers.add(answer);
    }



    public Answer getAnswer(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new DomainException("Value can't be empty");
        }

        for (Answer a : this.answers) {
            if (a.getValue().equals(value)) {
                return a;
            }
        }

        throw new DomainException("Answer is not in answers");
    }

    public List<Answer> getAnswers() {
        return this.answers;
    }

    public void setValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new DomainException("Value can't be empty");
        }
        this.value = value;
    }

    public void setGrade(Grade grade) {
        if (grade == null) {
            throw new DomainException("Grade can't be empty");
        }
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Question) {
            Question q = (Question)o;
            boolean b = true;
            if (!this.getValue().equals(q.getValue())) b = false;
            if (!this.getGrade().equals(q.getGrade())) b = false;
            return b;
        } else return false;
    }

    @Override
    public String toString() {
        return this.getValue()+" - "+this.getGrade().toString()+" - "+this.answers.size()+" answers";
    }
}
