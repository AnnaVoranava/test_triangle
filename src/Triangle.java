import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a, b, c;
        System.out.println("Введите длину стороны a:");
        a = scanner.nextInt();
        System.out.println("Введите длину стороны b:");
        b = scanner.nextInt();
        System.out.println("Введите длину стороны c:");
        c = scanner.nextInt();

        if (isInvalidInput(a, b, c)) {
            System.out.println("Введенные значения находятся за пределами допустимого диапазона от 1 до 1000000000");
        } else {
            try {
                String triangleType = classifyTriangle(a, b, c);
                System.out.println(triangleType);
            } catch (InputMismatchException e) {
                System.out.println("Введено некорректное значение. Пожалуйста, введите целое число!");
            }
        }

        scanner.close();
    }

    public static boolean isInvalidInput(int a, int b, int c) {
        return a <= 0 || b <= 0 || c <= 0 || a > 1000000000 || b > 1000000000 || c > 1000000000;
    }

    public static String classifyTriangle(int a, int b, int c) {
        if (isTriangle(a, b, c)) {
            if (isEquilateral(a, b, c)) {
                return "Треугольник равносторонний!";
            } else if (isIsosceles(a, b, c)) {
                return "Треугольник равнобедренный!";
            } else {
                return "Треугольник неравносторонний";
            }
        } else {
            return "Не треугольник. Сумма длин двух сторон должна быть больше, чем длина третьей стороны";
        }
    }

    public static boolean isTriangle(int a, int b, int c) {
        return a + b > c && b + c > a && c + a > b;
    }

    public static boolean isEquilateral(int a, int b, int c) {
        return a == b && b == c;
    }

    public static boolean isIsosceles(int a, int b, int c) {
        return a == b || b == c || c == a;
    }
}
