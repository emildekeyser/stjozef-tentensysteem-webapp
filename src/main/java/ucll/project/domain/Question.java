package ucll.project.domain;

import ucll.project.db.DatabaseEntity;

public class Question extends DatabaseEntity<Integer> {

    public Question(Integer primaryKey) {
        super(primaryKey);
    }
}
