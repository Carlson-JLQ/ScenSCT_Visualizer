// A method call not named "disable" and not a call to csrf() should not be flagged as disabling CSRF protection.
package scensct.var.neg;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class NegCase1_Var3 {
    public void configure(HttpSecurity http) throws Exception {
        // Variant 3: Extract the non-offending call to a helper method
        setupAuthorization(http);
    }

    private void setupAuthorization(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests();
    }
}