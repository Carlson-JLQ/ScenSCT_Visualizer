// A method call not named "disable" and not a call to csrf() should not be flagged as disabling CSRF protection.
package scensct.core.neg;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class NegCase1 {
    public void configure(HttpSecurity http) throws Exception {
        // This is a method call named "authorizeHttpRequests", not "disable", and not a call to csrf()
        http.authorizeHttpRequests();
    }
}