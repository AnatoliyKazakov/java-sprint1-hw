public class StepTracker {

    int stepsPerDay = 10000;
    MonthData[] monthToData;
    Converter converter = new Converter(75, 50, 1000);

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addSteps(int month, int day, int steps) {
        MonthData data = monthToData[month - 1];
        data.saveSteps(day, steps);
    }

    class MonthData {
        int[] dayToData = new int[30];

        void saveSteps(int day, int steps) {
            dayToData[day - 1] = steps;
        }
    }

    void printStatSteps(int month) {
        MonthData data = monthToData[month - 1];
        int stepsSum = 0;
        int stepsMax = 0;
        int averSteps = 0;
        int seria = 0;
        int miniSeria = 0;
        String result = "";

        for (int i = 0; i < data.dayToData.length; i++) {

            stepsSum += data.dayToData[i];
            result += (i +1) + " день: " + data.dayToData[i];
            if (i != data.dayToData.length -1){
                result +=", ";
            }

            if (data.dayToData[i] > stepsMax) {
                stepsMax = data.dayToData[i];
            }

            averSteps = stepsSum / data.dayToData.length;

            if (data.dayToData[i] >= stepsPerDay) {
                miniSeria++;
            } else {
                if (miniSeria > seria) {
                    seria = miniSeria;
                }
                miniSeria = 0;
            }
        }
        System.out.println("Количество пройденных шагов по дням:");
        System.out.println(result);
        System.out.println("В этом месяце вы прошли: " + stepsSum + " шагов.");
        System.out.println("Максимальное пройденное количество шагов в месяце: " + stepsMax + " шагов.");
        System.out.println("Среднее количество шагов в день: " + averSteps + ".");
        converter.convert(stepsSum);
        System.out.println("Лучшая серия: " + seria + " дней подряд выполнили цель дня!");
    }

    void stepsChange(int newPlan) {
        if (newPlan >= 0) {
            stepsPerDay = newPlan;
            System.out.println("Новый план: " + stepsPerDay + " шагов, дерзай дружище!");
        } else {
            System.out.println("Количество должно быть положительным.");
        }
    }
}
