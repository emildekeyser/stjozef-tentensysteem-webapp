package ucll.project.db;

public class DatabasEntityTestClass extends DatabaseEntity<String> {

    private String name;

    public DatabasEntityTestClass(String name) {
        super(name); // Set name as primary key
        setName(name);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }


}
