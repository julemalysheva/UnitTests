package task6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyClassTest {
    @Test
    void sumListsShouldBeCorrect(){
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> result = new ArrayList<>(Arrays.asList(5, 4, 6));
        List<Integer> resultTest = MyClass.sumLists(list1, list2);

        assertEquals(result, resultTest, "Сумма списков не равна");

    }
}
