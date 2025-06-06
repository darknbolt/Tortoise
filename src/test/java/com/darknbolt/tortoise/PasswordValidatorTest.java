package com.darknbolt.tortoise;

import com.darknbolt.tortoise.Services.PasswordValidatorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {
    private PasswordValidatorService service = new PasswordValidatorService();

    @Test
    public void testValidPasswordReturnsTrue() {
        String[] passwords = {"aBcde1/G", "dadfgafwacsADSECAd312/+++", "///////2aB"};
        for(String password : passwords) assertTrue(service.validatePassword(password));

    }

    @Test
    public void testInvalidPasswordReturnsFalse() {
        String[] passwords = {"abcdef1/", "ABCd1/", "mjknjcANMCJENMCJK2131"};
        for(String password : passwords) assertFalse(service.validatePassword(password));
    }
}
