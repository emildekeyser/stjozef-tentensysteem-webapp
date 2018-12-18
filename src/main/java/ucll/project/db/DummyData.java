package ucll.project.db;

import ucll.project.domain.Answer;
import ucll.project.domain.Grade;
import ucll.project.domain.Question;
import ucll.project.domain.Tent;

public class DummyData {

    public static void addData(DatabaseService service) {

        Tent tent1 = new Tent(0, "Intelligentie" , "Hoe intelligent ben jij?", 0);
        Question question1 = new Question(0, "Hoeveel is 1+1?", Grade.Grade1);
        question1.addAnswer(new Answer(0, "2", 10));
        question1.addAnswer(new Answer(1, "11", 5));
        Question question2 = new Question(1, "Wat is je naam?", Grade.Grade1);
        question2.addAnswer(new Answer(2, "Gerard", 10));
        question2.addAnswer(new Answer(3, "Marie-jeanne", 5));


        Tent tent2 = new Tent(1, "it" , "IT knowledge?", 1);
        Question question3 = new Question(2, "wat is javascript?", Grade.Grade1);
        question3.addAnswer(new Answer(4, "slecht", 10));
        question3.addAnswer(new Answer(5, "niet zo slecht", 2));
        Question question4 = new Question(3, "HTML!", Grade.Grade1);
        question4.addAnswer(new Answer(6, "nee", 10));
        question4.addAnswer(new Answer(7, "ja", 5));

        service.addTent(tent1);
        service.addTent(tent2);
    }

}
