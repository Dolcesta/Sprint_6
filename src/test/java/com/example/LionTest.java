package com.example;

import com.example.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void getKittensShouldReturnOneKitten() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expected = 1;
        int actual = lion.getKittens();
        assertEquals(expected, actual);
    }

    @Test
    public void incorrectLionSexShouldThrowException()  {
        Exception e = assertThrows(Exception.class, () -> {
            Lion lion = new Lion(feline, "Male");});
        String expected = "Используйте допустимые значения пола животного - самец или самка";
        String actual = e.getMessage();
        assertEquals(expected, actual);}

    @Test
    public void checkLionIsEatingMeat() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }
}