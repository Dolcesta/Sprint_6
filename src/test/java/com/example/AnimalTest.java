package com.example;
import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
@RunWith(MockitoJUnitRunner.class)
public class AnimalTest {
    @Mock
    Animal animal;
    @Test
    public void incorrectAnimalKindShouldThrowException()  {
        Exception e = assertThrows(Exception.class, () -> {
            Animal animal = new Animal();
            animal.getFood("Всеядное");});
        String expected = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        String actual = e.getMessage();
        assertEquals(expected, actual);}
    @Test
    public void felineGetFood() throws Exception {
        Animal animal = new Animal();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), animal.getFood("Хищник"));

    }

    @Test
    public void notFelineGetFood() throws Exception {
        Animal animal = new Animal();
        Assert.assertEquals(List.of("Трава", "Различные растения"), animal.getFood("Травоядное"));
    }

    @Test
    public void getFamily() {
        Animal animal = new Animal();
        Assert.assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }
}
