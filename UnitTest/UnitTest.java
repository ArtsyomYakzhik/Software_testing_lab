import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Tests {
    
    public Triangle triangle = new Triangle();
    
    @Test
    void AllArgumentsIsOne(){
        
        assertEquals(triangle.isCanBe(1,1,1), true);
        
    }

    @Test
    void WithOneZeroArgument(){
        
        assertEquals(triangle.isCanBe(1,1,0), false);
        
    }

    @Test
    void RightArguments(){

        assertEquals(triangle.isCanBe(3,4,5), true);
        
    }

    @Test
    void AllArgumentsIsZero(){

        assertEquals(triangle.isCanBe(0,0,0), false);
        
    }

    @Test
    void WithNegativeArgument(){

        assertEquals(triangle.isCanBe(4,5,-6), false);
        
    }

    @Test
    void WithSumEqualToThridArgument(){

        assertEquals(triangle.isCanBe(1,2,3), false);
        
    }

    @Test
    void DifferenceOfSumAndThirdArgumentBy1(){

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
