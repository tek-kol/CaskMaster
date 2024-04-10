package com.example.caskmaster.validator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserNameValidator {
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 15;

    public boolean isValidUsername(String input){
        boolean isValid = false;
        isValid = (
                isValidLength(input) &&
                startsWithLetter(input) &&
                isOnlyAlphanumeric(input) &&
                hasUnderscore(input)
                );
        return isValid;
    }

    public boolean isValidLength(String input){
        return (StringUtils.length(input) >= MIN_LENGTH && StringUtils.length(input) <= MAX_LENGTH);
    }

    public boolean startsWithLetter(String input){
        char first = input.charAt(0);
        return (Character.isLetter(first));
    }

    public boolean isOnlyAlphanumeric(String input){
        for (char ch : input.toCharArray()){
            if (Character.isLetter(ch) || Character.isDigit(ch) || ch == '_'){
                continue;
            } else { return false; }
        }
       return true;
    }

    public boolean hasUnderscore(String input){
        boolean hasUnderscore = false;
        for (char ch : input.toCharArray()){
            if (ch == '_'){
                hasUnderscore = true;
            }
        }
        return hasUnderscore;
    }


}
