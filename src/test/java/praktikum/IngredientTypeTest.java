package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.constants.IngredientConst.FILLING;
import static praktikum.constants.IngredientConst.SAUCE;

public class IngredientTypeTest
{
    @Test
    public void sauceTest()
    {
        assertEquals(SAUCE, IngredientType.SAUCE.toString());
    }

    @Test
    public void fillingTest()
    {
        assertEquals(FILLING, IngredientType.FILLING.toString());
    }
}
