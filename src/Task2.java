import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введие начальные и конечные координаты движения шахматной фигуры КОНЬ, через \' - \'  или слово 'end' для выхода (образец: с3-а1):");
        String step = in.next();
        moveRepetitionClass(in, step);
        in.close();
    }
    private static void moveRepetitionClass(Scanner in, String step) {
        String nextStep;
        String currentPosition;
        while (!"end".equals(step)) {
            currentPosition = step.split("-")[0].toLowerCase();
            nextStep = step.split("-")[1].toLowerCase();
            if (rightStep(currentPosition.charAt(0), Character.digit(currentPosition.charAt(1), 10),
                    nextStep.charAt(0), Character.digit(nextStep.charAt(1), 10))) {
                System.out.println("Ход возможен");
            } else System.out.println("Конь так не ходит.");
            System.out.println("Попробуйте снова или введите слово \'end\' для закрытия программы");
            step = in.next();
        }
    }
    public static boolean fieldOutputCheck(char letter, int num) {
        return ((letter >= 'a' && letter <= 'h') && (num >= 1 && num <= 8));
    }
    public static boolean rightStep(char currentLetter, int currentNum, char nextLetter, int nextNum) {
        return (fieldOutputCheck(currentLetter, currentNum) && fieldOutputCheck(nextLetter, nextNum)
                && Math.abs(currentLetter - nextLetter) + Math.abs(currentNum - nextNum) == 3 &&
                Math.abs(currentLetter - nextLetter) < 3 && Math.abs(currentNum - nextNum) < 3);
    }
}
