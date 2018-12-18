package ucll.project.domain;

import ucll.project.db.DatabaseEntity;

public class Answer extends DatabaseEntity<Integer> {
    private String value;
    private int point;

    public Answer(Integer primaryKey, String value, int point) {
        super(primaryKey);
        this.setValue(value);
        this.setPoint(point);
    }

    public String getValue() {
        return this.value;
    }

    public int getPoint() {
        return this.point;
    }

    public void setValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new DomainException("value can't be empty");
        }
        this.value = value;
    }

    public void setPoint(int point) {
        if (point < 0) {
            throw new DomainException("Point can't be negative");
        }
        if (point >= Integer.MAX_VALUE) {
            throw new DomainException("Points can't be infinity");
        }
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Answer) {
            Answer a = (Answer)o;
            boolean b = true;
            if (!this.getValue().equals(a.getValue())) b = false;
            if (this.getPoint() != a.getPoint()) b = false;
            return b;
        } else return false;
    }

    @Override
    public String toString() {
        return this.value+" - " + point;
    }
}
