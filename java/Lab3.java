import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab3 {

    public static double func(double x){
        return Math.exp(x) / x * Math.log10(x);
    }

    public static void main(String[] args) {
        /* 1
        Вывести на экран в виде таблицы (протабулировать)
        значения функций sin(x), e^x / x * lg(x) для значений x из интервала
        [π/15..pi], меняющихся с шагом π/15. Для столбца со значениями
        аргумента нужно использовать представление с фиксированной точкой,
        ширина столбца - 10 позиций, точность - 5 знаков после запятой. Для
        столбца со значениями функции: экспоненциальное представление,
        ширина 15 позиций, точность 7 знаков.
        */

//        System.out.printf("%10s%15s%15s\n","x","sin(x)","func(x)");
//        for(double x=Math.acos(-1)*2/15;x<=Math.acos(-1);x+=Math.acos(-1)/15){
//            System.out.printf("%10.5f%15.7e%15.7e\n",x,Math.sin(x),func(x));
//        }

        /* 2
        Реализовать алгоритм нахождения наибольшего
        отрицательного элемента двумерного массива, содержащего
        произвольное число строк и столбцов и, быть может, различное число
        элементов в каждой строке
         */

//        int x[][] = new int[3][];
//        x[0] = new int[2];
//        x[1] = new int[3];
//        x[2] = new int[5];
//        for (int i=0;i<x.length;i++){
//            for (int j=0;j<x[i].length;j++) {
//                x[i][j] = (int) (Math.random() * (100)-50);
//                System.out.printf("%5d",x[i][j]);
//            }
//            System.out.println();
//
//        }
//        int min = 0;
//        int i=0
//        outerloop:
//        for (;i<x.length;i++){
//            for (int j=0;j<x[i].length;j++){
//                if(x[i][j]<0) {
//                    min = x[i][j];
//                    break outerloop;
//                }
//            }
//        }
//        for (;i<x.length;i++){
//            for (int j=0;j<x[i].length;j++){
//                if(x[i][j]<0 && x[i][j]>min) {
//                    min = x[i][j];
//                }
//            }
//        }
//        if (min == 0)
//            System.out.println("otricatelnih net");
//        else
//            System.out.println("Max otr " + min);

        /* 3
        Написать приложение для реализации следующего
        алгоритма: упорядочить по возрастанию элементы каждой строки
        матрицы 3x3. Вывести матрицу на экран до сортировки и после
         */

//        int[][] a = {{3,2,1},{4,5,6},{8,9,7}};
//        for (int i=0;i<a.length;i++){
//            for (int j=0;j<a[i].length;j++){
//               System.out.printf("%3d",a[i][j]);
//            }
//            System.out.println();
//        }
//        for (int i=0;i<a.length;i++){
//            for (int j=0;j<a[i].length-1;j++){
//                for (int k=0;k<a[i].length-1-j;k++){
//                    if(a[i][k]>a[i][k+1]){
//                        int t = a[i][k+1];
//                        a[i][k+1] = a[i][k];
//                        a[i][k] = t;
//                    }
//                }
//            }
//        }
//        System.out.println("-----------------------");
//        for (int i=0;i<a.length;i++){
//            for (int j=0;j<a[i].length;j++){
//                System.out.printf("%3d",a[i][j]);
//            }
//            System.out.println();
//        }

        /* 4
        Создать класс с методом, реализующим следующий
        алгоритм: на плоскости размещены две окружности, центр первой в
        координатах x1, y1 и ее радиус r1, а центр и радиус другой в x2, y2, r2,
        конкретные значения передаются методу через его аргументы или
        хранятся в полях класса. Определить пересекаются ли окружности в
        одной точке (касаются), в двух точках, совпадают, не пересекаются и ни
        одна из окружностей не является вложенной в другую, вторая
        окружность вложена в первую, первая вложена во вторую. Метод
        должен возвращать целое значение, соответствующее возникшей
        ситуации. Протестировать работу метода, запрашивая у пользователя
        (ввод с клавиатуры) параметры окружностей и выводя сообщение о их
        взаимоположении.
         */


//        Scanner in = new Scanner(System.in);
//        double x,y,r;
//        System.out.println("Введите x y r 1-ого круга");
//        x = in.nextDouble();
//        y = in.nextDouble();
//        r = in.nextDouble();
//        circle c1 = new circle(x,y,r);
//        System.out.println("Введите x y r 2-ого круга");
//        x = in.nextDouble();
//        y = in.nextDouble();
//        r = in.nextDouble();
//        circle c2 = new circle(x,y,r);
//        System.out.println(circleChek(c1,c2));

        /* 6
        Написать метод, реализующий алгоритм численного
        интегрирования левыми прямоугольниками. В программе-тесте
        протабулировать функцию y(x) = e^x-x^3  на интервале, который задает
        пользователь (например, от 0 до 4) с постоянным шагом так, чтобы
        получить значения аргумента x и функции y в 101 точке (два массива).
        Передать массивы методу интегрирования. Посчитать значение
        интеграла аналитически и сравнить результат, возвращаемый методом
        с точным значением
         */

//        Scanner in = new Scanner(System.in);
//        double[] x = new double [101];
//        double[] y = new double [101];
//        System.out.println("Введите интервал x1 и x2");
//        x[0] = in.nextDouble();
//        x[100] = in.nextDouble();
//        y[0]=f2(x[0]);
//        double shag = (x[100]-x[0])/100;
//        for (int i = 1;i<100;i++){
//            x[i]=x[i-1]+shag;
//            y[i]=f2(x[i]);
//        }
//        y[100]=f2(x[100]);
//        for (int i = 0;i<101;i++){
//            System.out.printf("%5.3f\t%7.3f\n",x[i],y[i]);
//        }
//        System.out.println("-------------------------");
//        integralLeft(x,y);
//        System.out.println("-------------------------");
//        for (int i = 0;i<101;i++){
//            System.out.printf("%5.3f\t%7.3f\n",x[i],integral(x[i]));
//        }


        /* 7
        Написать приложение для преобразования целого числа из
        десятичного представления в представление в заданной системе
        счисления (от 2 до 8 включительно). Для проверки правильности работы
        программы используйте методы классов-оболочек toString(value, base),
        где value - преобразуемое десятичное значение, base - основание
        системы счисления, в которую нужно переводить value. Например,
        String val3 = Integer.toString( 12, 3 ); // 12 в троичную систему счисления
        (в своем алгоритме использовать toString нельзя!).
         */

//        Scanner in = new Scanner(System.in);
//        int x,b;
//        int n =0;
//        System.out.println("Введите 10чное число и основание новой системы исчисления<=8");
//        x = in.nextInt();
//        b = in.nextInt();
//        while (x>Math.pow(b,n)){
//            n++;
//        }
//
//        int[] p = new int[n];
//        n--;
//        while(n>=0){
//            while(x>=Math.pow(b,n)){
//                x-=Math.pow(b,n);
//                p[p.length-n-1]++;
//            }
//            n--;
//        }
//        for(int i=0;i<p.length;i++){
//            System.out.print(p[i]);
//        }
//        System.out.println("\n"+Integer.toString( x, b ));

        /* 8
        Реализуйте вычисление значения полинома n-й степени по
        схеме Горнера. Суть схемы в том, что запись полинома
        P(x) = an * x
        n + an-1 * x
        n-1 + … + a0 преобразуется в
        P(x) = (…((an * x + an-1) * x + an-2) * x + …) * x + a0
        Полином в программе представляется массивом его коэффициентов
        (массив из n+1 элемента), а сами вычисления выполняются в цикле так,
        что в начале P = an * x + an-1, а затем на каждой итерации P = P * x + ai.
         */

//        double[] a = { 1,2,3,4};
//        double x= 2;
//        double p = a[0];
//        for (int i=1;i<a.length;i++){
//            p=p*x+a[i];
//        }
//        System.out.println(p);

        /* 9
        Сформируйте регулярное выражение для проверки того,
        содержит ли заданная строка представление одиннадцатизначного
        (федерального) телефонного номера российского оператора связи. В
        начале должны быть либо символы +7, либо 8. Кроме того, номер может
        содержать в определенных позициях пробелы, дефисы, круглые скобки.
        Например, правильными будут следующие варианты
        +79043781661 +7 904 378 1661 +7 904 378 16 61
        +7-904-378-16-61 +7(904)3781661 +7(904) 378-16 61
        89043781661 8 904 378-16-61
        Круглыми скобками могут быть выделены только три цифры после
        префикса +7 или 8. Пробелы могут быть после префикса, после трех
        цифр, следующих за префиксом, после следующих трех цифр, после
        следующих двух цифр. На тех же позициях могут встречаться дефисы.
        Проверьте корректность полученного регулярного выражения на
        приведенных выше примерах и для других вариантов (допустимых и не
        допустимых) представления телефонных номеров.
        2) Сформируйте регулярное выражение для проверки того, содержится
        ли где-то в заданной строке представление семизначного
        (муниципального) телефонного номера Ростова-на-Дону. Номер
        должен начинаться с цифры 2 или 3, эта цифра может быть отделена
        от остальной части номера пробелом или дефисом (а может быть и не
        отделена ничем), далее каждая из трех пар цифр также может
        отделяться пробелом или дефисом. Например, содержимое следующей
        строки должно соответствовать построенному регулярному выражению
        "Мои номера 220-30-40 и 8904-378-16-61 не считая служебных"

         */

        /* 10
        Используйте регулярные выражения из предыдущего
        задания для того, чтобы извлечь из строки
        "Мои номера 220-30-40 и 8904-378-16-61 не считая служебных"
        все содержащиеся в ней номера телефонов
         */

//        String mobilPhone = "([+]7|8)([(]|\s|-?)\\d{3}([)]|\s|-?)(\s|-?)\\d{3}(\s|-?)\\d{2}(\s|-?)\\d{2}";
//        String homePhone = "(2|3)(\s|-?)\\d{2}(\s|-?)\\d{2}(\s|-?)\\d{2}";
//        Pattern mobilPhon = Pattern.compile(mobilPhone+"|"+homePhone);
//        String text = "Мои номера 8(904)-378-16-61 и +7(904)3781661. Мои номера 220-30-40 и 8904-378-16-61 не считая служебных.";
//        Matcher m = mobilPhon.matcher(text);
//        while (m.find()) {
//            int begin = m.start();
//            int end = m.end();
//            System.out.println(text.substring(begin, end));
//        }

    }


////////////////////////////////////////
    public static void integralLeft(double[] x,double[] y){
        double[] y2 = new double[101];
        for (int i = 0;i<100;i++){
            y2[i]= y[i]*(x[i+1]-x[i]);
            System.out.printf("%5.3f\t%7.3f\n",x[i],y2[i]);
        }

    }

    public static double integral(double x){
        return Math.exp(x)-x*x*x*x/4;

    }

    public static double f2(double x){
        return Math.exp(x)-x*x*x;
    }


    public static circleСrossing circleChek(circle c1, circle c2){
        double r = Math.sqrt(Math.pow(Math.abs(c2.x-c1.x),2)+Math.pow(Math.abs(c2.y-c1.y),2));
        if(r>c1.r+c2.r){
            System.out.println("Круги не пересекаются");
            return circleСrossing.crossing0;
        } else if(r == c1.r+c2.r){
            System.out.println("Круги касаются");
            return circleСrossing.crossing1;
        }else if(r < c1.r+c2.r && r>Math.abs(c1.r-c2.r)){
            System.out.println("Круги имеют 2 точки пересечения");
            return circleСrossing.crossing2;
        } else if(r == 0){
            System.out.println("Круги совпадают");
            return circleСrossing.coincidence;
        } else if(r == Math.abs(c1.r-c2.r)){
            System.out.println("Круги касаются");
            if(c1.r<c2.r){
                System.out.println("Круг 1 внутри 2");
                return circleСrossing.circle1in2crossing;
            }else if(c1.r>c2.r){
                System.out.println("Круг 2 внутри 1");
                return circleСrossing.circle2in1crossing;
            }
        }else if(r < Math.abs(c1.r-c2.r)){
            if(c1.r<c2.r){
                System.out.println("Круг 1 внутри 2");
                return circleСrossing.circle1in2;
            }else if(c1.r>c2.r){
                System.out.println("Круг 2 внутри 1");
                return circleСrossing.circle2in1;
            }
        }
        return circleСrossing.crossing404;
    }
}

enum circleСrossing{ crossing0,crossing1, crossing2,coincidence,circle1in2,circle2in1,circle1in2crossing,circle2in1crossing,crossing404}

class circle{
    double x;
    double y;
    double r;

    public circle(double x,double y,double r){
        this.x=x;
        this.y=y;
        this.r=r;
    }
}
