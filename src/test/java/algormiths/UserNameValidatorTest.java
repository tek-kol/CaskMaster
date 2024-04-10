package algormiths;

import com.example.caskmaster.validator.UserNameValidator;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.RegexConversion;

import java.util.List;
import java.util.regex.*;

public class UserNameValidatorTest {
    // Todo:
    //  [+] Accept input
    //  [+] Validate Input
    //      [+] Limit char 8-15(inc)
    //      [+] Only [a-zA-Z0-9_]
    //      [+] Starts with [a-zA-Z]
    //      [-] At least one '_' && [0-9]
    //  [ ] Return Valid (true)
    //  StringUtils && Char?

    // W

    UserNameValidator userNameValidator = new UserNameValidator();

    @Test
    void isValidNameTest(){
        Assertions.assertTrue(userNameValidator.isValidLength("123456789012345"));

    }

    @Test
    void startsWithLetterTest(){
        Assertions.assertTrue(userNameValidator.startsWithLetter("A2345678"));
    }

    @Test
    void isOnlyAlphanumericTest(){
        Assertions.assertTrue(userNameValidator.isOnlyAlphanumeric("5qw23"));
    }

    @Test
    void hasUnderscoreTest(){
        Assertions.assertTrue(userNameValidator.hasUnderscore("Tane_dfd83"));
    }


    @Test
    void isValidUsernameTest(){
        Assertions.assertFalse(userNameValidator.isValidUsername("12"));
        Assertions.assertFalse(userNameValidator.isValidUsername("Ifhdddaj89"));
        Assertions.assertTrue(userNameValidator.isValidUsername("Tane_dfd83"));
    }


}


//    // "^[a-zA-Z][a-zA-Z0-9]{8,15}$"
//    boolean validateUsername(String input){
//        return Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$", input);
//    }