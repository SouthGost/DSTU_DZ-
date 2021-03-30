package Lab4;

/* 4
В Задании 1 двигатель автомобиля представлен только
одной своей характеристикой - мощностью. А самом деле каждый
двигатель имеет серийный (заводской) номер, и, помимо мощности,
рабочий объем, расход топлива, вид топлива, число цилиндров и т.д.
Поэтому для такого важного понятия удобно ввести отдельный класс.
Создайте класс Engine, включив в него несколько важных характеристик
двигателя и методы доступа к этим характеристикам. Определите и
реализуйте нужный конструктор (или конструкторы) класса Engine.
Замените в классе Car поле "мощность" на поле "двигатель" (engine).
Измените код тестирования для проверки работоспособности новой
версии класса Car и класса Engine
*/

public class Engine {
    String serialNumber;
    double power;
    double volume;
    double fuelConsumption;
    String fuelType;
    int cylinders;

    public Engine(
            String serialNumber,
            double power,
            double volume,
            double fuelConsumption,
            String fuelType,
            int cylinders
    ){
        this.serialNumber = serialNumber;
        this.power = power;
        this.volume = volume;
        this.fuelConsumption = fuelConsumption;
        this.fuelType = fuelType;
        this.cylinders = cylinders;
    }

    public void showInf(){
        System.out.println("Двигатель "+serialNumber+":");
        System.out.println("\tМощность: " + power);
        System.out.println("\tОбъем двигателя: " + volume);
        System.out.println("\tРасход топлива: " + fuelConsumption);
        System.out.println("\tТип топлива: " + fuelType);
        System.out.println("\tЧисло цилиндров: " + cylinders);
    }
}
