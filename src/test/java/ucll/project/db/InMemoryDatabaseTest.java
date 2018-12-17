package ucll.project.db;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InMemoryDatabaseTest {

    private IDatabase<DatabasEntityTestClass, String> inMemoryDatabase;

    @Before
    public void setUp() {
        inMemoryDatabase = new InMemoryDatabase<>();
    }

    @After
    public void tearDown() {
        inMemoryDatabase = null;
    }

    @Test
    public void addAndGetTest(){
        DatabasEntityTestClass testobject = new DatabasEntityTestClass("testKey");
        inMemoryDatabase.add(testobject);
        DatabasEntityTestClass retrievedObject = inMemoryDatabase.get("testKey");
        assertEquals(testobject, retrievedObject);
    }

}
