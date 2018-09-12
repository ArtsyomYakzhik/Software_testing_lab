public class Calculator {

    private double x, y;
    private const double pi=3.14;

    public Calculator(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double Plus() {
        return x+y;
    }

    public double Multiply() {
        return x*y;
    }

    public double Divide() {
        return x/y;
    }

    public double Minus() {
        return x-y;
    }
//Comments

}
