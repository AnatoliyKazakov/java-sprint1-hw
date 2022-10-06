public class StepTracker {

    int stepsPerDay = 10000;
    int stepsSum = 0;
    int averSteps = 0;
    int stepsMax = 0;
    int seria = 0;
    int miniSeria = 0;
    String result = "";
    MonthData[] monthToData;

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
        result = "";
        for (int i = 0; i < data.dayToData.length; i++) {
            result += (i +1) + " день: " + data.dayToData[i];
           if (i != data.dayToData.length -1){
                result +=", ";
            }
            if (data.dayToData[i] > stepsMax) {
                stepsMax = data.dayToData[i];
            }
        }
    }

    void printSumSteps(int month) {
        MonthData data = monthToData[month - 1];
        stepsSum = 0;
        for (int i = 0; i < data.dayToData.length; i++) {
            stepsSum += data.dayToData[i];
        }
        averSteps = stepsSum / data.dayToData.length;
    }

    void printSeriaSteps(int month) {
        MonthData data = monthToData[month - 1];
        seria = 0;
        for (int i = 0; i < data.dayToData.length; i++) {
            if (data.dayToData[i] >= stepsPerDay) {
                ++miniSeria;
                if (miniSeria >= seria) {
                    seria = miniSeria;
                }
            }  else {
                miniSeria = 0;
            }
        }
        miniSeria = 0;
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