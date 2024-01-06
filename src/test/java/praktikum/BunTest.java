package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class BunTest
{
    private Bun bun;

    @Parameterized.Parameter
    public String name;
    @Parameterized.Parameter(1)
    public float price;

    @Parameterized.Parameters()
    public static Object[][] data()
    {
        return new Object[][]{
                {"абра кодабра", 1f},
                {"second", 2.05f}
        };
    }

    @Test
    public void getNameTest()
    {
        bun =new Bun(name, price);
        String actualResult = bun.getName();
        assertEquals("\nОшибка! \nимя не верное",name, actualResult);
    }

    @Test
    public void getPriceTest()
    {
        bun = new Bun(name, price);
        float actualResult = bun.getPrice();
        assertEquals("\nОшибка! \nцена не верна", price, actualResult, 0);
    }
}
