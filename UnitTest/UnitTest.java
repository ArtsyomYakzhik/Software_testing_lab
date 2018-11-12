import org.testing.Assert;
import org.testing.annotations.Test;

public class Tests {
    
    public Triangle triangle = new Triangle();
    
    @Test
    void aZeroArgument(){
        assertEquals(triangle.isCanBe(0,1,1), false);
    }
    
    @Test
    void bZeroArgument(){
        assertEquals(triangle.isCanBe(1,0,1), false);
    }

    @Test
    void cZeroArgument(){
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
    void withSumEqualThridArgument(){
        assertEquals(triangle.isCanBe(1,2,3), false);
    }

    @Test
    void differenceOfSumAndThirdArgumentBy1(){
        assertEquals(triangle.isCanBe(1,2,4), false);        
    }

    @Test
    void oneNotZeroArgument(){
        assertEquals(triangle.isCanBe(6,0,0), false);        
    }

    @Test
    void equilateralTriangle(){
        assertEquals(triangle.isCanBe(3,3,3), true);        
    }

    @Test
    void isoscelesTriangle(){
        assertEquals(triangle.isCanBe(3,6,3), true);        
    }
}
