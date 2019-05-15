package tu.practise.firm.services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

public class TestinTesting {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgumentExceptionIfIconIsNull() {
        exception.expect(IllegalArgumentException.class);
//        exception.expectMessage("Icon is null, not a file, or doesn't exist.");
        new BigDecimal("bbb");
    }
}
