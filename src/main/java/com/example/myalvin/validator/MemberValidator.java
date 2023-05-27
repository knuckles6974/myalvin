package com.example.myalvin.validator;


import com.example.myalvin.dto.member.MemberLoginRequestDto;
import com.example.myalvin.dto.member.MemberSignupDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

@Component
@Slf4j
public class MemberValidator implements ConstraintValidator<ValidMemberSignupDto, MemberSignupDto> {

    public static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    public static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=?\"{}\\[\\]<>,./:;|\\\\~`]).{8,20}$";

    public static final String PHONE_NUMBER_REGEX = "^\\+[0-9]{1,3}\\s?[0-9]{6,14}$";

    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(PHONE_NUMBER_REGEX);
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);




    @Override
    public void initialize(ValidMemberSignupDto constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberSignupDto msdto, ConstraintValidatorContext context) {
        boolean isValid = true;

        if (msdto.getPhone() != null && !PHONE_NUMBER_PATTERN.matcher(msdto.getPhone()).matches()) {
            isValid = false;
        }

        if (msdto.getEmail() != null && !EMAIL_PATTERN.matcher(msdto.getEmail()).matches()) {
            isValid = false;
        }

        if (msdto.getPassword() != null && !PASSWORD_PATTERN.matcher(msdto.getPassword()).matches()) {
            isValid = false;
        }

        return isValid;
    }


}
