package com.example.caskmaster.validator;

import com.example.caskmaster.exception.DataValidationException;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserNameValidator {
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 15;

    public boolean isValidUsername(String input) {

        return (isValidLength(input) && startsWithLetter(input) && isOnlyAlphanumeric(input) && hasUnderscore(input));
    }

    private boolean isValidLength(String input) {
        boolean isOk = (StringUtils.length(input) >= MIN_LENGTH && StringUtils.length(input) <= MAX_LENGTH);
        if (!isOk) {
            throw new DataValidationException("Invalid string length");
        }
        return isOk;
    }

    private boolean startsWithLetter(String input) {
        boolean isOk = Character.isLetter(input.charAt(0));
        if (!isOk) {
            throw new DataValidationException("Invalid Starting Char");
        }
        return isOk;
    }

    private boolean isOnlyAlphanumeric(String input) {
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch) || Character.isDigit(ch) || ch == '_') {
                continue;
            } else {
                throw new DataValidationException("String contains invalid chars");
            }
        }
        return true;
    }

    private boolean hasUnderscore(String input) {
        for (char ch : input.toCharArray()) {
            if (ch == '_') {
                return true;
            }
        }
        throw new DataValidationException("String is missing an '_'");
    }


}
