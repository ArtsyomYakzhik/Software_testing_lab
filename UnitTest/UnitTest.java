import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Tests {
    
    public Triangle triangle = new Triangle();
    
    @Test
    void FirstTest(){
        
        assertEquals(triangle.isCanBe(1,1,1), true);
        
    }

    @Test
    void SecondTest(){
        
        assertEquals(triangle.isCanBe(1,1,0), false);
        
    }

    @Test
    void ThirdTest(){

        assertEquals(triangle.isCanBe(3,4,5), true);
        
    }

    @Test
    void FourthTest(){

        assertEquals(triangle.isCanBe(0,0,0), false);
        
    }

    @Test
    void FifthTest(){

        assertEquals(triangle.isCanBe(4,5,-6), false);
        
    }

    @Test
    void SixthTest(){

        assertEquals(triangle.isCanBe(1,2,3), false);
        
    }

    @Test
    void SeventhTest(){

        assertEquals(triangle.isCanBe(1,2,4), false);
        
    }

    @Test
    void EighthTest(){

        assertEquals(triangle.isCanBe(0,0,0), false);
        
    }

    @Test
    void NinethTest(){

        assertEquals(triangle.isCanBe(3,2,3), true);
        
    }

    @Test
    void TenthTest(){

        assertEquals(triangle.isCanBe(1,2,3000000000000000000000000000000000000000000), false);
        
    }
}
