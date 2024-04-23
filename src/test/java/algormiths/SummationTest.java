package algormiths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import java.util.stream.Collectors;

public class SummationTest {
    List<String> list = List.of("54177742244","21212", "437343652","0", "3202233");


    @Test
    void runTest(){
        for (String item : list) {
            System.out.println(doSummations(item));
        }
    }

    int doSummations(String input){
       input = input.substring(1);

       int sum = 0;
       String temp = "";
       while (!input.isEmpty()){
           temp = input.substring(0, 2);
           sum += Integer.parseInt(temp);
           input = input.substring(2);
       }
       return sum;
    }


}
