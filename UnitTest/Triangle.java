import java.io;

public class Triangle {

public Boolean isCanBe(double a, double b, double c) {
  
    return (a + b > c && a + c > b && c + b > a);
  
}

}
