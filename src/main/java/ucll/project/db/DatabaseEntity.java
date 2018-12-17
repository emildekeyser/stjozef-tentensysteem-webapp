package ucll.project.db;

public class DatabaseEntity<K> {

    public DatabaseEntity(K primaryKey) {
        setPrimaryKey(primaryKey);
    }

    private K primaryKey;

    public K getPrimaryKey() {
        return primaryKey;
    }

    private void setPrimaryKey(K primaryKey) {
        this.primaryKey = primaryKey;
    }

}
