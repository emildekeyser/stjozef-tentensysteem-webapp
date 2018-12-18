package ucll.project.db;

import ucll.project.domain.Answer;
import ucll.project.domain.Tent;
import ucll.project.domain.Question;

import java.util.ArrayList;

public class DatabaseService {

    IDatabase<Tent,Integer> competences;
    IDatabase<Question,Integer> questions;
    IDatabase<Answer,Integer> answers;

    public Tent getTent(int primaryKey) {
        return competences.get(primaryKey);
    }

    public Answer getAnswer(int primaryKey) {
        return answers.get(primaryKey);
    }

    public Question getQuestion(int primaryKey) {
        return questions.get(primaryKey);
    }

    public void addTent(Tent tent) {
        competences.add(tent);
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public boolean containsTent(int primaryKey) {
        return questions.contains(primaryKey);
    }

    public boolean containsAnswer(int primaryKey) {
        return answers.contains(primaryKey);
    }

    public boolean containsQuestion(int primaryKey) {
        return questions.contains(primaryKey);
    }

    public boolean containsTent(Tent tent) {
        return competences.contains(tent);
    }

    public boolean containsAnswer(Answer answer) {
        return answers.contains(answer);
    }

    public boolean containsQuestion(Question question) {
        return questions.contains(question);
    }

}
