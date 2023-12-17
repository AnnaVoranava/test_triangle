import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1, 1, Треугольник равносторонний!",
            "3, 4, 5, Треугольник неравносторонний",
            "5, 5, 8, Треугольник равнобедренный!",
            "12, 12, 12, Треугольник равносторонний!",
            "7, 10, 5, Треугольник неравносторонний",
            "1, 2, 2, Треугольник равнобедренный!"
    })
    public void testClassifyTriangle(int side1, int side2, int side3, String expectedClassification) {
        assertEquals(expectedClassification, Triangle.classifyTriangle(side1, side2, side3));
    }

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
    public void testIsInvalidInput(int side1, int side2, int side3) {
        assertTrue(Triangle.isInvalidInput(side1, side2, side3));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 4, 5",
            "8, 15, 17",
            "5, 12, 13"
    })
    public void testIsValidInput(int side1, int side2, int side3) {
        assertFalse(Triangle.isInvalidInput(side1, side2, side3));
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

    @ParameterizedTest
    @CsvSource({
            "3, 4, 5",
            "7, 7, 10",
            "8, 8, 12"
    })
    public void testIsEquilateral_NotEquilateral(int side1, int side2, int side3) {
        assertFalse(Triangle.isEquilateral(side1, side2, side3));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 2",
            "2, 1, 2",
            "2, 2, 1"
    })
    public void testIsIsosceles_IsoscelesTriangle(int side1, int side2, int side3) {
        assertTrue(Triangle.isIsosceles(side1, side2, side3));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 4, 5",
            "7, 10, 5",
            "1, 2, 3"
    })
    public void testIsIsosceles_NotIsosceles(int side1, int side2, int side3) {
        assertFalse(Triangle.isIsosceles(side1, side2, side3));
    }
}
