package algormiths;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import java.util.stream.Collectors;

public class SummationTest {
    // Todo:
    //  [+] Remove the first digit (not needed to return sum)(Save to count # of iterations?)
    //  [+] Split string into 2.len segments to new List<String>
    //  [+] Parse Strings -> Int to new List<Int>
    //  [+] Loop num list add i to sum
    //  [+] Return the sum
    List<String> input = List.of("54177742244","21212", "437343652","0", "3202233");

    @Test
    void doSummations() {
        doSummations(input);

    }

    void doSummations(List<String> inputList){
        for (String item : inputList){
            System.out.println(calculateSumOfString(item));
        }
    }
    int calculateSumOfString(String numStr){
        numStr = numStr.substring(1);
        List<String> numStrings = segmentStringByN(numStr, 2);
        List<Integer> nums = parseStringToInt(numStrings);

        return calculateSum(nums);
    }

    List<Integer> parseStringToInt(List<String> numStrings){
        List<Integer> nums = new ArrayList<>();
        for (String i : numStrings) {
            nums.add(Integer.parseInt(i));
        }
        return nums;
    }
    Integer calculateSum(List<Integer> nums){
        Integer sum = 0;
        for (Integer i : nums){
            sum += i;
        }
        return sum;
    }

    // @Baeldung (Thx)
    public static List<String> segmentStringByN(String text, int n) {
        return Pattern.compile(".{1," + n + "}")
                .matcher(text)
                .results()
                .map(MatchResult::group)
                .collect(Collectors.toList());
    }



}
