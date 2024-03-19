import com.example.Calculator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

 class CalculatorTest {

    @Test
     void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(8, calculator.add(5, 3));
    }

    @Test
     void testSubtraction() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
     void testMultiplication() {
        Calculator calculator = new Calculator();
        assertEquals(15, calculator.multiply(5, 3));
    }

    @Test
     void testDivision() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.divide(5, 3));
    }

    @Test
     void testDivisionByZero() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(5, 0));
    }
}
