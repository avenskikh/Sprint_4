package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean expectedResult;

    public AccountTest(String name, boolean expectedResult) {
        this.name = name;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                //пробел стоит вначале
                {" Тимоти Шалаламе", false},
                //пробел стоит вконце
                {"Тимоти Шалаламе ", false},
                //нет пробела
                {"ТимотиШалаламе", false},
                //граничные значения 19 символов
                {"Тимоти Шалалалаламе", true},
                //граничные значения 3 символа
                {"Т Ш", true},
                //граничные значения 2 символа
                {"Т ", false},
                //граничные значения 20 символов
                {"Тимоти Шалалалалааме", false},
        };
    }

    @Test
    public void paramTest() {
        Account account = new Account(name);
        Assert.assertEquals(expectedResult, account.checkNameToEmboss());
        System.out.println("Имя " + name + " подходит? " + expectedResult);
    }
}