import java.util.*;
import java.util.function.*;

public class Calculator {

    private Map<String, BinaryOperator<Double>> functions= new HashMap<>();

    public Calculator() {
    
    functions.put("+", (a, b)->a+b);
    functions.put("-", (a, b)->a-b);
    functions.put("*", (a, b)->a*b);
    functions.put("/", (a, b)->a/b);


    }

    public Double GetResult(String type, Double x, Double y) {

    return (( functions.get( type )).apply(x, y));

    }
//Comments

}
