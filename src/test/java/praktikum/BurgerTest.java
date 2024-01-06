package praktikum;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static praktikum.constants.NamesConst.*;
import static praktikum.constants.PriceConst.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest
{
    private Burger burger;
    @Mock
    Bun bun;
    @Mock
    private Ingredient ingredient, ingredient2, ingredient3;

    @Before
    public void newBurger()
    {
        burger = new Burger();
    }

    @Test
    public void getPriceTest()
    {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(FIRST_INGREDIENT_PRICE);
        Mockito.when(ingredient2.getPrice()).thenReturn(SECOND_INGREDIENT_PRICE);

        float expected = BUN_PRICE * 2 + FIRST_INGREDIENT_PRICE + SECOND_INGREDIENT_PRICE;
        float actualResult = burger.getPrice();

        assertEquals("\nОшибка! \nСтоимость не верна!", expected, actualResult, 0);
    }

    @Test
    public void getReceiptTest()
    {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        Mockito.when(bun.getName()).thenReturn(BURGER_NAME);
        Mockito.when(ingredient.getName()).thenReturn(FIRST_INGREDIENT_NAME);
        Mockito.when(ingredient2.getName()).thenReturn(SECOND_INGREDIENT_NAME);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(FIRST_INGREDIENT_PRICE);
        Mockito.when(ingredient2.getPrice()).thenReturn(SECOND_INGREDIENT_PRICE);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);

        String price = String.format("%f", BUN_PRICE * 2 + FIRST_INGREDIENT_PRICE + SECOND_INGREDIENT_PRICE);

        String expectedResult =
                "(==== " + BURGER_NAME + " ====)\r\n" +
                        "= sauce " + FIRST_INGREDIENT_NAME + " =\r\n" +
                        "= filling " + SECOND_INGREDIENT_NAME + " =\r\n" +
                        "(==== " + BURGER_NAME + " ====)\r\n" +
                        "\r\n" +
                        "Price: " + price + "\r\n";
        String actualResult = burger.getReceipt();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void addIngredientTest()
    {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        int expectedResult = 3;

        assertEquals(expectedResult, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest()
    {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        int indexOfIngredientForRemove = 1;
        burger.removeIngredient(indexOfIngredientForRemove);
        int expectedResult = 2;
        assertEquals(expectedResult, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest()
    {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        burger.moveIngredient(0,2);
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient3, burger.ingredients.get(1));
    }
}
