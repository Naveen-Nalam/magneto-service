package com.magneto.java.model;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

public class UserinforRequest implements Serializable {

    @NotNull(message = "First Name cannot be null")
    public String firstName;

    public String middleName;

    @NotNull(message = "last Name cannot be null")
    public String lastName;

    public String emailaddress;

    @Size(min = 6, message = "About Me must be atleast 6 characters")
    public String password;

    @Size(min = 6, message = "About Me must be atleast 6 characters")
    public String confirmationPassword;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fistName) {
        this.firstName = fistName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmationPassword() {
        return confirmationPassword;
    }

    public void setConfirmationPassword(String confirmationPassword) {
        this.confirmationPassword = confirmationPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserinforRequest that = (UserinforRequest) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(middleName, that.middleName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(emailaddress, that.emailaddress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, middleName, lastName, emailaddress);
    }


}
