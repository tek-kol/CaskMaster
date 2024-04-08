package algormiths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.RegexConversion;

import java.util.regex.*;

public class UserNameValidatorTest {
    // Todo:
    //  [+] Accept input
    //  [+] Validate Input
    //      [+] Limit char 8-15(inc)
    //      [+] Only [a-zA-Z0-9_]
    //      [ ] Starts with [a-zA-Z]
    //      [ ] At least one '_' && [0-9]
    //  [] Return Valid (true)

    @Test void UserNameValidator(){
        String name = "a234567890123";
        System.out.println(validateUsername(name));
    }

    boolean validateUsername(String name){
        return Pattern.matches("^[a-zA-Z][a-zA-Z0-9]{8,15}+_.*", name);
    }
}

