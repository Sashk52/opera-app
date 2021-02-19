package com.dev.movietheatre.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, Object> {
    private String password;
    private String repeatPassword;

    public void initialize(PasswordConstraint constraint) {
        this.password = constraint.password();
        this.repeatPassword = constraint.repeatPassword();
    }

    public boolean isValid(Object user, ConstraintValidatorContext context) {
        Object passwordField = new BeanWrapperImpl(user).getPropertyValue(password);
        Object passwordRepeatField = new BeanWrapperImpl(user).getPropertyValue(repeatPassword);
        return passwordField != null & passwordField.equals(passwordRepeatField);
    }
}
