package Lab4;
/*  2
В Java отсутствует стандартный класс для представления
комплексных чисел. Создайте такой класс (Complex), поддерживающий
операции получения действительной, мнимой частей числа, сложения,
вычитания, умножения, деления, комплексного сопряжения, проверки
двух чисел на равенство, вывода значения комплексного числа в
алгебраической и тригонометрической формах. Так как действительное
число, это комплексное число с нулевой мнимой частью, должны
поддерживаться также арифметические операции, в которых один из
аргументов действительное число (тип double).
*/
public class Complex {
    double real;
    double imaginary;

    public Complex(double real){
        this.real = real;
        this.imaginary=0;
    }

    public Complex(double real, double imaginary){
        this.real = real;
        this.imaginary=imaginary;
    }



    public void soprezenie(){
        imaginary*=-1;
    }

    public boolean equally(Complex z1,Complex z2){
        if (z1.real == z2.real && z1.imaginary==z2.imaginary)
            return true;
        else
            return false;
    }

    public void showAlgeb(){
        if(imaginary!=0)
            System.out.println(real + "+i"+ imaginary);
        else
            System.out.println(real);
    }

    public void showTrigonom(){
        double r = Math.sqrt(real*real+imaginary*imaginary);
        double fi = Math.atan(imaginary/real)*Math.PI;
        System.out.println("z="+r+"(cos("+ fi +"/π)+i*sin("+ fi +"/π))");
    }

    public static void main(String[] args) {
        Complex z1 = new Complex(5,7);
        Complex z2 = new Complex(3,-1);
        Complex z = new Complex(0,0);
        z = add(z1,z2);
        z.showAlgeb();
        z.showTrigonom();
        z = minus(z1,z2);
        z.showAlgeb();
        z =mul(z1,z2);
        z.showAlgeb();
        z = div(z1,z2);
        z.showAlgeb();
    }


    public static Complex add(Complex z1,Complex z2){
        Complex z = new Complex(0,0);
        z.real=z1.real+z2.real;
        z.imaginary=z1.imaginary+z2.imaginary;
        return z;
    }

    public static Complex minus(Complex z1,Complex z2){
        Complex z = new Complex(0,0);
        z.real=z1.real-z2.real;
        z.imaginary=z1.imaginary-z2.imaginary;
        return z;
    }

    public static Complex mul(Complex z1,Complex z2){
        Complex z = new Complex(0,0);
        z.real=z1.real*z2.real-z1.imaginary*z2.imaginary;
        z.imaginary=z1.real*z2.imaginary+z2.real*z1.imaginary;
        return z;
    }

    public static Complex div(Complex z1,Complex z2){
        Complex z = new Complex(0,0);
        z.real=(z1.real*z2.real+z1.imaginary*z2.imaginary)/(z2.real*z2.real+z2.imaginary*z2.imaginary);
        z.imaginary=(z2.real*z1.imaginary-z1.real*z2.imaginary)/(z2.real*z2.real+z2.imaginary*z2.imaginary);
        return z;
    }

/*  3
Реализуйте методы для вычисления элементарных
функций комплексного переменного
*/

    public static void sin(){

    }

}
