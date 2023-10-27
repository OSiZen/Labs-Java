public class lab3_task3 {
    public static void main(String[] args) {
        Complex[] obj = {
            new Complex(3, 4),
            new Complex(2.5, 3),
            new Complex(7, -12.2),
            new Complex(1.99, 5.74)
        };
        System.out.print("\n");
        for (int i = 0; i < obj.length - 1; i++) {
            System.out.println("Комплекснi числа: (" + obj[i].getReal() + " + " + obj[i].getImaginary() + "i) та " + "(" + obj[i + 1].getReal() + " + " + obj[i + 1].getImaginary() + "i)");
            print("Сума", obj[i].sum(obj[i + 1]));
            print("Добуток", obj[i].product(obj[i + 1]));
            System.out.print("\n");
        }
    }

    private static void print(String title, Complex complex) {
        System.out.print(title + " = " + complex.getReal());
        System.out.print(complex.getImaginary() < 0 ? " - " + Math.abs(complex.getImaginary()) : " + " + complex.getImaginary());
        System.out.print("i\n");
    }
}

class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public Complex sum(Complex other) {
        double a = this.real + other.real;
        double b = this.imaginary + other.imaginary;
        return new Complex(Math.round(a * 100.0) / 100.0, Math.round(b * 100.0) / 100.0);
    }

    public Complex product(Complex other) {
        double a = this.real * other.real - this.imaginary * other.imaginary;
        double b = this.real * other.imaginary + this.imaginary * other.real;
        return new Complex(Math.round(a * 100.0) / 100.0, Math.round(b * 100.0) / 100.0);
    }
}