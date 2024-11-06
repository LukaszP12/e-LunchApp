package pl.strefakursow.eLunchApp.DTO;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginDataDTO {

    @Size(min = 3)
    private String string;

    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$")
    private String password;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
