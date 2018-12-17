package ucll.project.db;

import java.util.List;

public interface IDatabase<T extends DatabaseEntity,K> {

    boolean contains(K primaryKey);

    T get(K primaryKey);

    List<T> getAll();

    void add(T record);

    void update(T record);

    void delete(K primaryKey);

    int getCount();

}
