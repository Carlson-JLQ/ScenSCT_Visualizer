// A method call not named "disable" and not a call to csrf() should not be flagged as disabling CSRF protection.
package scensct.var.neg;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class NegCase1_Var1 {
    public void configure(HttpSecurity http) throws Exception {
        // Variant 1: Introduce a temporary variable for the HttpSecurity object
        HttpSecurity securityConfig = http;
        securityConfig.authorizeHttpRequests();
    }
}