package ucll.project.db;

import ucll.project.domain.Answer;
import ucll.project.domain.Tent;
import ucll.project.domain.Question;
import ucll.project.domain.user.User;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

public class DatabaseService {

    IDatabase<Tent,Integer> competences;
    IDatabase<Question,Integer> questions;
    IDatabase<Answer,Integer> answers;
    IDatabase<User,Integer> users;

    public DatabaseService() {
        competences = new InMemoryDatabase<Tent,Integer>();
        questions = new InMemoryDatabase<Question,Integer>();
        answers = new InMemoryDatabase<Answer,Integer>();
        //users = new InMemoryDatabase<>();

        DummyData.addData(this);
    }

    public Tent getTent(int primaryKey) {
        return competences.get(primaryKey);
    }

    public Tent getNextTent(Tent tent) {
        try {
            return competences.get(tent.getPlaceNumber());
        } catch(Exception ex) {
            return null;
        }
    }

    public List<Tent> getAllTenten() {
        return competences.getAll();
    }

    public Answer getAnswer(int primaryKey) {
        return answers.get(primaryKey);
    }

    public Question getQuestion(int primaryKey) {
        return questions.get(primaryKey);
    }

    public void addTent(Tent tent) {

        competences.add(tent);

        List<Question> tentQuestions = tent.getQuestions();

        for (Question question: tentQuestions) {
            addQuestion(question);
        }
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public void addQuestion(Question question) {
        questions.add(question);

        List<Answer> questionAnswers = question.getAnswers();

        for (Answer answer: questionAnswers) {
            addAnswer(answer);
        }
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
