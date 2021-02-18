package com.dev.movietheatre.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {
    private String password;
    private String repeatPassword;

    public void initialize(PasswordConstraint constraint) {
        this.password = constraint.password();
        this.repeatPassword = constraint.repeatPassword();
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {
        Object passwordField = new BeanWrapperImpl(obj).getPropertyValue(password);
        Object passwordRepeatField = new BeanWrapperImpl(obj).getPropertyValue(repeatPassword);
        return passwordField != null & passwordField.equals(passwordRepeatField);
    }
}
