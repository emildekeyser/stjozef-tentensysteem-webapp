package ucll.project.domain;

import org.junit.Before;
import org.junit.Test;
import ucll.project.domain.DomainException;
import ucll.project.domain.Grade;
import ucll.project.domain.Question;
import ucll.project.domain.Tent;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TentTest {

    private Tent tent2;

    @Before
    public void setUp() {
        tent2 = new Tent(1, "name", "desc");
    }

    @Test
    public void createTentTest() {
        Tent tent = new Tent(1, "tentName", "this is a description");

        assertEquals(tent.getName(), "tentName");
        assertEquals(tent.getDescription(), "this is a description");
    }

    @Test(expected = DomainException.class)
    public void createTentWithoutNameThrowsExceptionTest() {
        Tent tent = new Tent(1, null, "description");
    }

    @Test(expected = DomainException.class)
    public void createTentWithoutDescriptionThrowsExceptionTest() {
        Tent tent = new Tent(1, "tentName", null);
    }

    @Test(expected = DomainException.class)
    public void createTentWithEmptyNameThrowsExceptionTest() {
        Tent tent = new Tent(1, "", "description");
    }

    @Test(expected = DomainException.class)
    public void createTentWithEmptyDescriptionThrowsExceptionTest() {
        Tent tent = new Tent(1, "tentName", "");
    }

    @Test
    public void addQuestionsToTentTest() {
        Question q = new Question(1, "question", Grade.Grade1);

        tent2.addQuestion(q);
        assertEquals(q, tent2.getQuestion("question"));
    }

    @Test
    public void getQuestionsTest() {
        Question q1 = new Question(1, "q1", Grade.Grade1);
        Question q2 = new Question(1, "q2", Grade.Grade1);

        tent2.addQuestion(q1);
        tent2.addQuestion(q2);

        List<Question> questions = new ArrayList<>();
        questions.add(q1);
        questions.add(q2);

        assertEquals(questions, tent2.getQuestions());
    }

    @Test(expected = DomainException.class)
    public void addNullToQuestionsThrowsExceptionTest() {
        tent2.addQuestion(null);
    }

    @Test(expected = DomainException.class)
    public void addSameQuestionTwiceThrowsExceptionTest() {
        Question q = new Question(1, "q", Grade.Grade1);
        tent2.addQuestion(q);
        tent2.addQuestion(q);
    }

    @Test
    public void addMultipleQuestionsTest() {
        Question q1 = new Question(1, "q1", Grade.Grade1);
        Question q2 = new Question(1, "q2", Grade.Grade1);

        List<Question> questions = new ArrayList<>();

        questions.add(q1);
        questions.add(q2);

        tent2.addQuestions(questions);
        assertEquals(questions, tent2.getQuestions());
    }

    @Test
    public void addMultipleQuestionsWithDifferentGradeTest() {
        Question q1 = new Question(1, "q1", Grade.Grade1);
        Question q2 = new Question(1, "q2", Grade.Grade2);

        List<Question> questions = new ArrayList<>();

        questions.add(q2);

        tent2.addQuestions(questions);
        assertEquals(questions, tent2.getQuestions(Grade.Grade2));
    }

    @Test(expected = DomainException.class)
    public void addNullAsQuestionsThrowsExceptionTest() {
        tent2.addQuestions(null);
    }

    @Test(expected = DomainException.class)
    public void addEmptyListOfQuestionsThrowsExceptionTest() {
        tent2.addQuestions(new ArrayList<>());
    }
}
