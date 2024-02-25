import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    @Test
    public void testAdd_EmptyString_ReturnsZero() {
        StringCalculator calc = new StringCalculator();
        assertEquals(0, calc.add(""));
    }

    @Test
    public void testAdd_SingleNumber_ReturnsNumber() {
        StringCalculator calc = new StringCalculator();
        assertEquals(1, calc.add("1"));
    }

    @Test
    public void testAdd_TwoNumbers_ReturnsSum() {
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("1,2"));
    }
    @Test
    public void testAdd_NewLineBetweenNumbers_ReturnsSum() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1\n2,3"));
    }

    @Test
    public void testAdd_CustomDelimiter_ReturnsSum() {
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("//;\n1;2"));
    }

    @Test
    public void testAdd_NegativeNumbers_ThrowsException() {
        StringCalculator calc = new StringCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.add("-1,2,-3"));
    }
}
