package Lab4;

import java.util.regex.Pattern;

/*  1
Создайте класс Car, представляющий понятие
"автомобиль". Каждый автомобиль должен иметь, как минимум,
следующие характеристики: ||регистрационный знак, марка, вид, цвет,
мощность двигателя, количество колес. Для вновь созданного,
конкретного автомобиля такие характеристики как || марка, вид, цвет,
мощность двигателя, количество колес должны быть заданы
непременно, но регистрационного номера у него до поры до времени
может и не быть (а может и быть). Все характеристики автомобиля,
кроме марки, вида и количества колес можно изменять в процессе его
эксплуатации. Вид автомобиля - легковой, грузовой, автобус. Создайте
и используйте для задания вида автомобиля перечислимый тип. Для
легковых, грузовых автомобилей и автобусов с нормальным
креплением знака (тип 1) согласно ГОСТ Р 50577-2018 [6] знак имеет
следующий формат: X 000 XX 00 RUS или X 000 XX 000 RUS. Здесь 0 в
реальном знаке заменяется какой-то арабской цифрой, а X - одной из
12 букв кириллицы (в верхнем регистре), написание которой совпадает
с написанием латинской буквы: А, В, Е, К, М, Н, О, Р, С, Т, У, Х. Попытка
задания неправильного знака должна пресекаться соответствующим
методом класса. Для проверки используйте регулярное выражение.
Создайте код для тестирования класса Car с заданием начальных
характеристик, запросом новых значений для тех характеристик,
которые можно изменять и выводом на экран текущих значений всех
характеристик.
*/

abstract class Car{
    String sign;
    String mark;
    String color;
    Engine engine;
    int wheels;

    public Car(
        String mark,
        String color,
        Engine engine,
        int wheels
    ){
        this.mark = mark;
        this.color = color;
        this.engine = engine;
        this.wheels = wheels;
    }

    protected boolean checckSign(String sign){
        return Pattern.matches("([АВЕКМНОРСТУХ])(\s)(\\d{3})(\s)([АВЕКМНОРСТУХ]{2})(\s)((\\d{2})|(\\d{3}))(R)(U)(S)", sign);
    }

    public final  void setSign(String sign){
        if (checckSign(sign))
            this.sign = sign;
        else
            System.out.println("не существующий номер");
    }

    public Car(
        String mark,
        String color,
        Engine engine,
        int wheels,
        String sign
    ){
        this.mark = mark;
        this.color = color;
        this.engine = engine;
        this.wheels = wheels;
        setSign(sign);
    }

    public void showInf(){
        System.out.println("Марка: "+mark);
        System.out.println("Цвет: "+color);
        engine.showInf();
        System.out.println("Колес " +wheels+" штук");
        System.out.println("Номер: "+sign);
    }

    public final  void setColor(String color) {
        this.color = color;
    }

    public final void setEngine(Engine engine) {
        this.engine = engine;
    }

    public final void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public static void main(String[] args) {
        Engine eng = new Engine("1121314",100,15,3,"Shel", 6);
        Engine eng2 = new Engine("151690100",700,100,10,"Shel", 12);
        Polise lada = new Polise("lada","red",eng,4,"А 0001 61RUS");
        Bus pedgoiet = new Bus("pedgoiet","gray",eng,4,"А 130 НН 61RUS");
        SimplCar lamba = new SimplCar("lamba","blue",eng,4,"А 557 МА 61RUS");
        Fura manka = new Fura("MAN","gray",eng2,6,"А 557 МА 61RUS");

        AvtoBaza garaz = new AvtoBaza(4);
        garaz.addAvto(lada);
        garaz.addAvto(pedgoiet);
        garaz.addAvto(lamba);
        garaz.addAvto(manka);
        garaz.showBaza();
    }

}

/* 5
В Заданиях 1, 4 вид автомобиля задается как
предопределенное значение. Появление новых видов будет приводить
к необходимости модифицировать класс Car. Кроме того, для новых
видов автомобилей правила формирования регистрационного знака
могут быть другими. Более гибкое решение - каждый вид автомобиля
представлять собственным классом. С другой стороны, все автомобили
29
будут обладать одинаковым набором некоторых базовых
характеристик. Не разумно при возникновении нового вида автомобиля
всякий раз повторять в нем объявления этих базовых характеристик и
определять методы доступа к ним. Нужно использовать семейство
родственных классов, в котором один (Car) будет содержать все общие
характеристики, а другие - классы для конкретных видов автомобилей
дополнительные характеристики и/или конкретные значения для
базовых характеристик. Измените нужным образом класс Car, создайте
классы для следующих видов автомобилей: легковой, грузовой,
автобус, специальный (например, пожарная машина, или автомобиль
для дипломатических миссий). Для специальных автомобилей
придумайте свою схему формирования регистрационного знака (или
возьмите из ГОСТ Р 50577-2018 [6])
*/

class SimplCar extends Car{
    String type = "Car";

    public SimplCar(String mark, String color, Engine engine, int wheels) {
        super(mark, color, engine, wheels);
    }

    public SimplCar(String mark, String color, Engine engine, int wheels, String sign) {
        super(mark, color, engine, wheels, sign);
    }

    @Override
    public void showInf(){
        System.out.println("Тип: "+type);
        System.out.println("Марка: "+mark);
        System.out.println("Цвет: "+color);
        engine.showInf();
        System.out.println("Колес " +wheels+" штук");
        System.out.println("Номер: "+sign);
    }
}

class Fura extends Car{
    String type = "Fura";

    public Fura(String mark, String color, Engine engine, int wheels) {
        super(mark, color, engine, wheels);
    }

    public Fura(String mark, String color, Engine engine, int wheels, String sign) {
        super(mark, color, engine, wheels, sign);
    }

    @Override
    public void showInf(){
        System.out.println("Тип: "+type);
        System.out.println("Марка: "+mark);
        System.out.println("Цвет: "+color);
        engine.showInf();
        System.out.println("Колес " +wheels+" штук");
        System.out.println("Номер: "+sign);
    }
}

final class Bus extends Car{
    String type = "Bus";

    public Bus(String mark, String color, Engine engine, int wheels) {
        super(mark, color, engine, wheels);
    }

    public Bus(String mark, String color, Engine engine, int wheels, String sign) {
        super(mark, color, engine, wheels, sign);
    }

    @Override
    public void showInf(){
        System.out.println("Тип: "+type);
        System.out.println("Марка: "+mark);
        System.out.println("Цвет: "+color);
        engine.showInf();
        System.out.println("Колес " +wheels+" штук");
        System.out.println("Номер: "+sign);
    }
}

class Polise extends Car{
    String type = "Polise";

    public Polise(String mark, String color, Engine engine, int wheels) {
        super(mark, color, engine, wheels);
    }

    @Override
    protected boolean checckSign(String sign){
        return Pattern.matches("([АВЕКМНОРСТУХ])(\s)(\\d{4})(\s)((\\d{2})|(\\d{3}))(R)(U)(S)", sign);
    }

    public Polise(String mark, String color, Engine engine, int wheels, String sign) {
        super(mark, color, engine, wheels, sign);
    }

    @Override
    public void showInf(){
        System.out.println("Тип: "+type);
        System.out.println("Марка: "+mark);
        System.out.println("Цвет: "+color);
        engine.showInf();
        System.out.println("Колес " +wheels+" штук");
        System.out.println("Номер: "+sign);
    }
}

/* 7
Создайте класс "Автобаза". На базе может размещаться
некоторое фиксированное количество автомобилей разных видов
(классы производные от Car). Для хранения объектов, представляющих
автомобили нужно использовать массив фиксированного размера.
Максимально возможный размер для конкретной автобазы (конкретного
объекта класса) задается при создании объекта. Каждый автомобиль
может находиться в одном из трех допустимых состояний: на базе, в
рейсе, в ремонте. Нужно обеспечить добавление нового автомобиля
(если еще есть место для размещения автомобиля). Удаление
30
(списание) автомобиля. Отправку исправного автомобиля в рейс.
Отправку неисправного автомобиля в ремонт. Возврат автомобиля из
рейса или из ремонта. Отображение на экране списка находящихся на
базе исправных автомобилей, списка автомобилей, находящихся в
рейсе, списка неисправных автомобилей (отдельные методы).
*/

class AvtoBaza{
    private int length;
    private Car[] baza;

    public AvtoBaza(int lenth){
        this.baza = new Car[lenth];
        this.length = 0;
    }

    public void addAvto(Car car){
        if(length < baza.length) {
            baza[length] = car;
            length+=1;
        }
    }

    public void showBaza(){
        System.out.println("Baza start-------------------------------");
        for(int i =0;i<length;++i){
            System.out.println((i+1)+")");
            baza[i].showInf();
            System.out.println();
        }
        System.out.println("Baza end-------------------------------");
    }
}