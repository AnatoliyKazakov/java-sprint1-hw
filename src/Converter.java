public class Converter {
    double distance;
    int calories;
    int kilocalorie;

    Converter(double sm, int kal, int kkal){
        distance = sm;
        calories = kal;
        kilocalorie = kkal;
    }
    void convert(int step){
        System.out.println("Вы прошли: " + (step*distance)/100000 + "км.");
        System.out.println("Вы сожгли: "+ (step*calories)/kilocalorie + " килокалорий.");
    }
}