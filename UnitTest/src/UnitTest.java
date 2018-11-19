import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class Tests {
    
    public Triangle triangle = new Triangle();

    @Test
    void allArgumentsIsOne(){
        assertEquals(triangle.isCanBe(1,1,1), true);
    }

    @Test
    void withOneZeroArgument(){
        assertEquals(triangle.isCanBe(1,1,0), false);
    }

    @Test
    void rightArguments(){

        assertEquals(triangle.isCanBe(3,4,5), true);

    }

    @Test
    void allArgumentsIsZero(){
        assertEquals(triangle.isCanBe(0,0,0), false);
    }

    @Test
    void withNegativeArgument(){
        assertEquals(triangle.isCanBe(4,5,-6), false);
    }

    @Test
    void withSumEqualToThridArgument(){
        assertEquals(triangle.isCanBe(1,2,3), false);
    }

    @Test
    void differenceOfSumAndThirdArgumentBy1(){
        assertEquals(triangle.isCanBe(1,2,4), false);
    }

    @Test
    void OneNotZeroArgument(){
        assertEquals(triangle.isCanBe(6,0,0), false);
    }

    @Test
    void EquilateralTriangle(){
        assertEquals(triangle.isCanBe(3,3,3), true);
    }

    @Test
    void OverridedArgument(){
        assertEquals(triangle.isCanBe(1,2,3000000000000000000000000000000000000000000), false);
    }
}
