package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest
{
    private Ingredient ingredient;
    @Parameterized.Parameter
    public IngredientType type;
    @Parameterized.Parameter(1)
    public String name;
    @Parameterized.Parameter(2)
    public float price;

    @Parameterized.Parameters()
    public static Object[][] data()
    {
        return new Object[][]{
                {SAUCE,"абра кодабра", 1f},
                {FILLING, "second", 2.05f}
        };
    }
    @Test
    public void getNameTest()
    {
        ingredient =new Ingredient(type, name, price);
        String actualResult = ingredient.getName();
        assertEquals("\nОшибка! \nимя не верное",name, actualResult);
    }

    @Test
    public void getPriceTest()
    {
        ingredient = new Ingredient(type, name, price);
        float actualResult = ingredient.getPrice();
        assertEquals("\nОшибка! \nцена не верна", price, actualResult, 0);
    }

    @Test
    public void getTypeTest()
    {
        ingredient = new Ingredient(type, name, price);
        IngredientType actualResult = ingredient.getType();
        assertEquals("\nОшибка! \nтип не верен", type, actualResult);
    }
}
