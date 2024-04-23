package codeWar;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ex01 {

//    Your task is to make a function that can take any non-negative integer as an argument and return it with its digits in descending order.
//    Essentially, rearrange the digits to create the highest possible number.

    @ParameterizedTest
    @ValueSource( ints = 823756419 )
    void theTest(int input){
        Assertions.assertEquals(987654321, sortDesc(input));
    }

    public static int sortDesc(int input){
        int num = input;
        int digitCounter = 0;
        int result = 0;
        List<Integer> list = new ArrayList<>();

        // deconstructs int, places digits in list
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
            digitCounter ++;
        }

        // Todo:reorder list

        // reorder method, sorts from Hi->Lo
        Collections.sort(list, Collections.reverseOrder());

        // reconstructs int from list
        while (digitCounter > 0){
            result += (int) (list.get(0) * (Math.pow(10, digitCounter -1 )));
            list.remove(0);
            digitCounter--;
        }
        System.out.println(result);
        return result;
    }





}
