package algormiths;

import com.example.caskmaster.exception.DataValidationException;
import com.example.caskmaster.validator.UserNameValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserNameValidatorTest {

    UserNameValidator userNameValidator = new UserNameValidator();
    @ParameterizedTest
    @ValueSource(strings = {
            "123456",
            "1234567890123456"
    })
    void isInvalidLengthTest(String input){
        try {
            userNameValidator.isValidUsername(input);
        } catch (DataValidationException err) {
            Assertions.assertEquals("Invalid string length", err.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "A_345678",
            "A_3456789012345"
    })
    void isValidLengthTest(String input){
        Assertions.assertTrue(userNameValidator.isValidUsername(input));
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "123456789",
            "!23456789",
            "A_3456789"
    })
    void hasInvalidStartingChar(String input) {
        try {
            userNameValidator.isValidUsername(input);
        } catch (DataValidationException err) {
            Assertions.assertEquals("Invalid Starting Char", err.getMessage());
        }
        // Todo: this last value isn't be returning the message. Test passes, should it?
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "A_345678",
            "A_3456789012345"
    })
    void hasValidStartingChar(String input){
        Assertions.assertTrue(userNameValidator.isValidUsername(input));
    } // Todo: This is already in the prior test

    @ParameterizedTest
    @ValueSource(strings = {
            "A_!45678",
            "A_#456789012345"
    })
    void hasInvalidChars(String input){
        try {
            userNameValidator.isValidUsername(input);
        } catch (DataValidationException err) {
            Assertions.assertEquals("String contains invalid chars", err.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1234567",
            "12345678",
            "a!345678",
            "a_345678"
    })
    void hasNoUnderscoreTest(String input){
        try {
            userNameValidator.isValidUsername(input);
        } catch (DataValidationException err) {
            Assertions.assertEquals("String is missing an '_'", err.getMessage());
        }
    }


}

