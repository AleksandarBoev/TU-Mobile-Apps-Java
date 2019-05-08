package tu.practise.firm.validations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import tu.practise.firm.classes.Person;

public class ValidationsUnitTest {
    private Person person;

    @Before
    public void init(){
        person = new Person();
        person.setId(1);
        person.setName("Aleksandar");
    }

    @Test
    public void what() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getIdMethod = Person.class.getDeclaredMethod("getId");
        getIdMethod.setAccessible(true);
        int personId = (int)getIdMethod.invoke(person);
        getIdMethod.setAccessible(false);

        Assert.assertEquals(1, personId);
    }
}
