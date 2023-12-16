import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    private ByteArrayInputStream inputStream;

    @BeforeEach
    public void setUp() {
                inputStream = null;
    }

    @AfterEach
    public void tearDown() {
                if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testIsInvalidInput_InvalidInput() {
        assertTrue(Triangle.isInvalidInput(1, 0, 1));
        assertTrue(Triangle.isInvalidInput(0, 1, 1));
        assertTrue(Triangle.isInvalidInput(1, 1, 0));
        assertTrue(Triangle.isInvalidInput(-1, 1, 1));
        assertTrue(Triangle.isInvalidInput(1, -1, 1));
        assertTrue(Triangle.isInvalidInput(1, 1, -1));
        assertTrue(Triangle.isInvalidInput(1000000001, 1, 1));
        assertTrue(Triangle.isInvalidInput(1, 1000000001, 1));
        assertTrue(Triangle.isInvalidInput(1, 1, 1000000001));
    }

    @Test
    public void testIsInvalidInput_ValidInput() {
        assertFalse(Triangle.isInvalidInput(3, 4, 5));
        assertFalse(Triangle.isInvalidInput(65, 72, 97));
        assertFalse(Triangle.isInvalidInput(999999999, 999999998, 1000000000));
    }

    @Test
    public void testInputMismatchException() {
        String input = "3\n4\nx\n";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThrows(InputMismatchException.class, () -> Triangle.main(new String[]{}));
    }

    @Test
    public void testIsTriangle_NotATriangle() {
        assertFalse(Triangle.isTriangle(1, 1, 3));
        assertFalse(Triangle.isTriangle(1, 3, 1));
        assertFalse(Triangle.isTriangle(3, 1, 1));
    }

    @Test
    public void testIsEquilateral_EquilateralTriangle() {
        assertTrue(Triangle.isEquilateral(1, 1, 1));
        assertTrue(Triangle.isEquilateral(1000000000, 1000000000, 1000000000));
    }

    @Test
    public void testIsEquilateral_NotEquilateral() {
        assertFalse(Triangle.isEquilateral(3, 4, 5));
    }

    @Test
    public void testIsIsosceles_IsoscelesTriangle() {
        assertTrue(Triangle.isIsosceles(1, 2, 2));
        assertTrue(Triangle.isIsosceles(2, 1, 2));
        assertTrue(Triangle.isIsosceles(2, 2, 1));
        assertTrue(Triangle.isIsosceles(999999999, 1000000000, 1000000000));
        assertTrue(Triangle.isIsosceles(1000000000, 999999999, 1000000000));
        assertTrue(Triangle.isIsosceles(1000000000, 1000000000, 999999999));
        assertTrue(Triangle.isIsosceles(8, 8, 11));
        assertTrue(Triangle.isIsosceles(8, 11, 8));
        assertTrue(Triangle.isIsosceles(11, 8, 8));
    }

    @Test
    public void testClassifyTriangle_EquilateralTriangle() {
        assertEquals("Треугольник равносторонний!", Triangle.classifyTriangle(1, 1, 1));
    }

    @Test
    public void testClassifyTriangle_IsoscelesTriangle() {
        assertEquals("Треугольник равнобедренный!", Triangle.classifyTriangle(8, 8, 11));
    }

    @Test
    public void testClassifyTriangle_ScaleneTriangle() {
        assertEquals("Треугольник неравносторонний", Triangle.classifyTriangle(3, 4, 5));
    }

    @Test
    public void testClassifyTriangle_NotATriangle() {
        assertEquals("Не треугольник. Сумма длин двух сторон должна быть больше, чем длина третьей стороны",
                Triangle.classifyTriangle(1, 1, 3));
    }
}
