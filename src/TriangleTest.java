import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    @ParameterizedTest
    @CsvSource({
            "1, 0, 1",
            "0, 1, 1",
            "1, 1, 0",
            "-1, 1, 1",
            "1, -1, 1",
            "1, 1, -1",
            "1000000001, 1, 1",
            "1, 1000000001, 1",
            "1, 1, 1000000001"
    })
    public void testIsInvalidInput_InvalidInput(int side1, int side2, int side3) {
        assertTrue(Triangle.isInvalidInput(side1, side2, side3));
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
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThrows(InputMismatchException.class, () -> Triangle.main(new String[]{}));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 3",
            "1, 3, 1",
            "3, 1, 1"
    })
    public void testIsTriangle_NotATriangle(int side1, int side2, int side3) {
        assertFalse(Triangle.isTriangle(side1, side2, side3));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 1",
            "1000000000, 1000000000, 1000000000"
    })
    public void testIsEquilateral_EquilateralTriangle(int side1, int side2, int side3) {
        assertTrue(Triangle.isEquilateral(side1, side2, side3));
    }

    @Test
    public void testIsEquilateral_NotEquilateral() {
        assertFalse(Triangle.isEquilateral(3, 4, 5));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 2",
            "2, 1, 2",
            "2, 2, 1",
            "999999999, 1000000000, 1000000000",
            "1000000000, 999999999, 1000000000",
            "1000000000, 1000000000, 999999999",
            "8, 8, 11",
            "8, 11, 8",
            "11, 8, 8"
    })
    public void testIsIsosceles_IsoscelesTriangle(int side1, int side2, int side3) {
        assertTrue(Triangle.isIsosceles(side1, side2, side3));
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
