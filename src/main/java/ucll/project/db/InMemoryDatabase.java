package ucll.project.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryDatabase<T extends DatabaseEntity<K>,K> implements IDatabase<T,K> {

    private Map<K, T> records = new HashMap<>();

    @Override
    public boolean contains(K primaryKey) {
        if(primaryKey == null){
            throw new NullPointerException("Primary key is null");
        }
        return records.containsKey(primaryKey);
    }

    @Override
    public T get(K primaryKey) {
        if(primaryKey == null){
            throw new NullPointerException("Primary key is null");
        }
        return records.get(primaryKey);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<T>(records.values());
    }

    @Override
    public void add(T record) {
        if(record == null){
            throw new NullPointerException("The given record is null");
        }
        if (records.containsKey(record.getPrimaryKey())) {
            throw new DatabaseException("The given record already exists");
        }
        records.put(record.getPrimaryKey(), record);
    }

    @Override
    public void update(T record) {
        if(record == null){
            throw new NullPointerException("The given record is null");
        }
        if(!records.containsKey(record.getPrimaryKey())){
            throw new DatabaseException("The given record does not exist");
        }
        records.put(record.getPrimaryKey(), record);
    }

    @Override
    public void delete(K primaryKey) {
        if(primaryKey == null){
            throw new NullPointerException("Primary key is null");
        }
        records.remove(primaryKey);
    }

    @Override
    public int getCount() {
        return records.size();
    }
}
