package algormiths;

import com.example.caskmaster.exception.DataValidationException;
import com.example.caskmaster.validator.UserNameValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
        assertExceptionMessageEquals(input, "Invalid string length");
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
            "&_3456789"
    })
    void hasInvalidStartingChar(String input) {
        assertExceptionMessageEquals(input, "First character needs to be a letter");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "A_345678",
            "A_3456789012345"
    })
    void hasValidStartingChar(String input){
        Assertions.assertTrue(userNameValidator.isValidUsername(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "A_!45678",
            "A_#456789012345"
    })
    void hasInvalidChars(String input){
        assertExceptionMessageEquals(input, "String contains invalid characters");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "a2345678"
    })
    void hasNoUnderscoreTest(String input){
        assertExceptionMessageEquals(input, "String is missing an '_'");
    }

    @Test
    void isBlank() {
        assertExceptionMessageEquals(null, "Input is null");
    }


    private void assertExceptionMessageEquals(String input, String errMsg){
        Throwable exception = Assertions.assertThrows(
                DataValidationException.class, () -> {
                    userNameValidator.isValidUsername(input);
                }
        );

        Assertions.assertEquals(errMsg, exception.getMessage());
    }
}

