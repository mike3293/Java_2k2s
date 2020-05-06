import org.junit.AfterClass;
import org.junit.Assert;
import java.lang.*;
import org.testng.annotations.*;

public class ExampleTest {
    Example ex = new Example();
    int num = 1;
    @BeforeMethod
    public void beforeSuite() throws Exception {
        System.out.println("Тест номер " + num++);
    }

    @Test(groups = {"first","second"})
    public void testSum() throws Exception {
        int r_a = (int)Math.random()*3;
        int r_b = (int)Math.random()*3;
        int r_c = (int)Math.random()*6;
        Assert.assertEquals(r_c, ex.sum(r_a,r_b));
    }
    @Test(groups = "first", timeOut = 1 )
    public void multSum() throws Exception {
        Assert.assertEquals(6, ex.mult(2,3));
    }
    @Test(enabled = false,groups = "first")
    public void pureTest() throws Exception { }

    @Test(groups = "second")
    public void sumConvTest() throws Exception
    {
        Assert.assertEquals("5", converter.sumConv(ex,2,3));
    }
}
