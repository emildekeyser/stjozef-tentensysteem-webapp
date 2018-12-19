package ucll.project.db;

import ucll.project.domain.Answer;
import ucll.project.domain.Grade;
import ucll.project.domain.Question;
import ucll.project.domain.Tent;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RealDummyData
{
    private List<Answer> genericAnswers;

    public RealDummyData()
    {
        this.genericAnswers = new ArrayList(6);
        int i = 0;
        genericAnswers.add(makeAnswer("Ik ben hier niet mee bezig", i++));
        genericAnswers.add(makeAnswer("Ik vind dit belangrijk en wil hieraan werken", i++));
        genericAnswers.add(makeAnswer("Ik oefen hierop", i++));
        genericAnswers.add(makeAnswer("Het lukt me meestal", i++));
        genericAnswers.add(makeAnswer("Het lukt me vlot", i++));
        genericAnswers.add(makeAnswer("Ik kan anderen helpen om dit ook te kunnen", i++));
    }

    private Answer makeAnswer(String answerString, int i)
    {
        int PRIMARYFUCKINGKEYWTF = new BigInteger(answerString).intValue();
        return new Answer(PRIMARYFUCKINGKEYWTF, answerString, i);
    }

    public List<Tent> getDummyData()
    {
        List<Tent> tents = new ArrayList<>(10);
        int i = 0;
        tents.add(makeTent("samenwerken", i++, new String[]{"bij een groepswerk kan ik goed de afspraken nakomen", "ik speel eerlijk bij spel / sport", "ik bespreek hoe ik een taak moet maken of moet studeren"}));
        tents.add(makeTent("probleem-oplossend denken", i++, new String[]{"Ik kan een onderzoeksvraag stellen", "als ik niet direct een oplossing vind, zoek ik verder", "wanneer ik een moeilijke opdracht krijg, geef ik niet op"}));
        tents.add(makeTent("creativiteit", i++, new String[]{"ik waardeer kunst", "ik durf mezelf creatief uiten", "ik vind een originele oplossing voor problemen / taken"}));
        tents.add(makeTent("mediawijsheid / kritisch", i++, new String[]{"Ik weet hoe ik juiste en betrouwbare informatie vind", "Ik gedraag me correct op sociale media", "Ik herken fake-news"}));
        tents.add(makeTent("leercompetenties", i++, new String[]{"Ik maak een plan voor een opdracht", "Ik weet hoe ik best studeer, wat mijn talent is.", "na een brainstorm kan ik bruikbare ideeën kiezen"}));
        tents.add(makeTent("zelfzorg", i++, new String[]{"ik kom op voor mezelf als ik me niet goed voel", "ik leef gezond", "ik kan EHBO toepassen"}));
        tents.add(makeTent("kennis / leerinhoud", i++, new String[]{"ik studeer voldoende voor de verschillende vakken", "ik verbind wat ik leer met wat ik reeds weet ", "ik maak oefeningen op de leerstof"}));
        tents.add(makeTent("betrokkenheid", i++, new String[]{"Ik zet me in voor medeleerlingen", "ik draag zorg voor het milieu", "ik ben respectvol naar iedereen"}));
        tents.add(makeTent("ICT competenties", i++, new String[]{"Ik kan met een pc een tekst / taak maken ", "Ik weet hoe ik een nieuw programma goed en snel leer gebruiken", "Informatie die ik op internet vind, kan op de correcte manier gebruiken"}));
        tents.add(makeTent("taal leren gebruiken", i++, new String[]{"ik lees graag", "ik let op mijn taal bij taken", "ik kan goed presenteren / vertellen"}));

        return tents;
    }

    private Tent makeTent(String name, int i, String[] questions)
    {
        int PRIMARYFUCKINGKEYWTF = new BigInteger(name).intValue();
        Tent tent = new Tent(PRIMARYFUCKINGKEYWTF, name, name, i);
        tent.addQuestions(questionListFromStringArray(questions));
        return tent;
    }

    private List<Question> questionListFromStringArray(String[] questions)
    {
        List<Question> questionsList = new ArrayList<>(questions.length);
        for (String questionString : questions)
        {
            int PRIMARYFUCKINGKEYWTF = new BigInteger(questionString).intValue();
            Question question = new Question(PRIMARYFUCKINGKEYWTF, questionString, Grade.Grade1);
            addGenericAnswers(question);
        }
        return questionsList;
    }

    private void addGenericAnswers(Question question)
    {
        for(Answer answer : this.genericAnswers)
        {
            question.addAnswer(answer);
        }
    }
}
