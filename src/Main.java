import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter(75, 50, 1000);
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                System.out.println("Введите месяц:");
                int month;
                while (true) {
                    month = scanner.nextInt();
                    if (month < 1 || month > 12) {
                        System.out.println("Введите месяц от 1 до 12!");
                    } else {
                        break;
                    }
                }
                System.out.println("Введите день от 1 до 30:");
                int day;
                while (true){
                    day = scanner.nextInt();
                    if (day < 1 || day > 30) {
                        System.out.println("Неверный формат! Введите день от 1 до 30:");
                    } else {
                        break;
                    }
                }
                System.out.println("Введите количество пройденных шагов:");
                int steps;
                while (true){
                    steps = scanner.nextInt();
                    if (steps < 0) {
                        System.out.println("Количество шагов не может быть отрицательным! Введите количество шагов:");
                    } else {
                        break;
                    }
                }
                stepTracker.addSteps(month, day, steps);
            } else if (userInput == 2) {
                System.out.println("Введите месяц:");
                int month = scanner.nextInt();
                stepTracker.printStatSteps(month);
                stepTracker.printSumSteps(month);
                stepTracker.printSeriaSteps(month);
                System.out.println("Количество пройденных шагов по дням:");
                System.out.println(stepTracker.result);
                System.out.println("В этом месяце вы прошли: " + stepTracker.stepsSum + " шагов.");
                System.out.println("Максимальное пройденное количество шагов в месяце: " + stepTracker.stepsMax + " шагов.");
                System.out.println("Среднее количество шагов в день: " + stepTracker.averSteps + ".");
                converter.convert(stepTracker.stepsSum);
                System.out.println("Лучшая серия: " + stepTracker.seria + " дней подряд выполнили цель дня!");
            } else if (userInput == 3) {
                System.out.println("Введите новый план шагов в день:");
                int newPlan = scanner.nextInt();
                stepTracker.stepsChange(newPlan);
            } else if (userInput == 0) {
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день;");
        System.out.println("2 - Напечатать статистику за определённый месяц;");
        System.out.println("3 - Изменить цель по количеству шагов в день;");
        System.out.println("0 - Выход");
    }
}