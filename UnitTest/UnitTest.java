import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Tests {
    @Test
    void FirstTest(){
        Triangle triangle = new Triangle();

        assertEquals(triangle.isCanBe(1,1,1), true);
    }

    @Test
    void SecondTest(){
        Triangle triangle = new Triangle();

        assertEquals(triangle.isCanBe(1,1,0), false);
    }

    @Test
    void ThirdTest(){
        Triangle triangle = new Triangle();

        assertEquals(triangle.isCanBe(3,4,5), true);
    }

    @Test
    void FourthTest(){
        Triangle triangle = new Triangle();

        assertEquals(triangle.isCanBe(0,0,0), false);
    }

    @Test
    void FifthTest(){
        Triangle triangle = new Triangle();

        assertEquals(triangle.isCanBe(4,5,-6), false);
    }

    @Test
    void SixthTest(){
        Triangle triangle = new Triangle();

        assertEquals(triangle.isCanBe(1,2,3), false);
    }

    @Test
    void SeventhTest(){
        Triangle triangle = new Triangle();

        assertEquals(triangle.isCanBe(1,2,4), false);
    }

    @Test
    void EighthTest(){
        Triangle triangle = new Triangle();

        assertEquals(triangle.isCanBe(0,0,0), false);
    }

    @Test
    void NinethTest(){
        Triangle triangle = new Triangle();

        assertEquals(triangle.isCanBe(3,2,3), true);
    }

    @Test
    void TenthTest(){
        Triangle triangle = new Triangle();

        assertEquals(triangle.isCanBe(1,2,3000000000000000000000000000000000000000000), false);
    }
}