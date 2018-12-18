package ucll.project.domain;

import java.util.ArrayList;
import java.util.List;

import ucll.project.db.DatabaseEntity;

public class Tent extends DatabaseEntity<Integer> {

    private String name;
    private String description;
    private List<Question> questions = new ArrayList<>();

    public Tent(Integer primaryKey, String name, String description) {
        super(primaryKey);
        this.setName(name);
        this.setDescription(description);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new DomainException("Name can't be empty");
        }
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new DomainException("Description can't be empty");
        }
        this.description = description;
    }

    public List<Question> getQuestions() {
        return this.questions;
    }

    public Question getQuestion(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new DomainException("value can't be empty");
        }

        for (Question q : this.questions) {
            if (q.getValue().equals(value)) {
                return q;
            }
        }
        throw new DomainException("Question not in tent");
    }

    public void addQuestion(Question q) {
        if (q == null) {
            throw new DomainException("Question can't be null");
        }
        if (questions.contains(q)) {
            throw new DomainException("Question already exists");
        }
        this.questions.add(q);
    }

    public List<Question> getQuestions(Grade g) {
        if (g == null) {
            throw new DomainException("Grade can't be null");
        }


        List<Question> questions = new ArrayList<>();

        for (Question q : this.questions) {
            if(q.getGrade().equals(g)) questions.add(q);
        }

        return questions;
    }

    public int getQuestionsSize() {
        return this.questions.size();
    }

    public void addQuestions(List<Question> questions) {
        if (questions == null || questions.isEmpty()) {
            throw new DomainException("Cant add empty list of questions");
        }

        for(Question q : questions) {
            if (!this.questions.contains(q)) {
                this.addQuestion(q);
            }
        }
    }

    @Override
    public String toString() {
        return this.name + ": " + this.description;
    }
}
