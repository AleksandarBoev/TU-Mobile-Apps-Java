package tu.practise.firm.services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import tu.practise.firm.exceptions.InvalidTownException;

public class BaseValidationTesting {

    /**
     * Exception testing of methods, taken via reflection, can't be done normally.
     * @param testedObject object with which the method will be called
     * @param methodName
     * @param parameter
     * @param expectedException
     * @param expectedExceptionMessage
     * @return null if everything correct exception is thrown with correct message
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @SuppressWarnings("unchecked")
    public String singleParameterValidationTest(Object testedObject, String methodName, Object parameter,
                                                Class expectedException, String expectedExceptionMessage) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method validateTownNameNotNullMethod =
                testedObject.getClass().getDeclaredMethod(methodName, parameter.getClass());
        validateTownNameNotNullMethod.setAccessible(true);
        String result = "";
        try {
            validateTownNameNotNullMethod.invoke(testedObject, parameter);
        } catch (InvocationTargetException ite) {
            //since the exception is thrown via invoking a method, taken with reflection, it is
            //automatically a "InvocationTargetException" and needs to be casted via .getCause()
            Throwable realException = ite.getCause();
            String actualExceptionName = realException.getClass().getSimpleName();
            String expectedExceptionName = expectedException.getSimpleName();
            String actualExceptionMessage = realException.getMessage();

            if (!actualExceptionName.equals(expectedException.getSimpleName()))
                result += String.format("%nWrong exception thrown!%n\tExpected - %s%n\tActual - %s",
                        expectedExceptionName, actualExceptionName);

            if (!actualExceptionMessage.equals(expectedExceptionMessage))
                result += String.format("%nWrong exception message!%n\tExpected - \"%s\"%n\tActual - \"%s\"",
                        expectedExceptionMessage, actualExceptionMessage);
        }
        validateTownNameNotNullMethod.setAccessible(false);

        if (result.equals(""))
            return null;

        return result;
    }

    protected String strRepeat(char character, int count) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sb.append(character);
        }

        return sb.toString();
    }
}
