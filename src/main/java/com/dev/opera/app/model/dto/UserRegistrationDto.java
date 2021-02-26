package com.dev.opera.app.model.dto;

import com.dev.opera.app.annotation.EmailConstraint;
import com.dev.opera.app.annotation.PasswordConstraint;
import javax.validation.constraints.Size;

@PasswordConstraint(
        password = "password",
        repeatPassword = "repeatPassword",
        message = "Passwords do not match!"
)
public class UserRegistrationDto {
    @EmailConstraint
    private String email;
    @Size(min = 3)
    private String password;
    @Size(min = 3)
    private String repeatPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
