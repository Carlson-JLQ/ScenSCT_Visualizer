// A method call not named "disable" and not a call to csrf() should not be flagged as disabling CSRF protection.
package scensct.var.neg;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class NegCase1_Var4 {
    public void configure(HttpSecurity http) throws Exception {
        // Variant 4: Use a try-finally block where the call is in the try block
        try {
            http.authorizeHttpRequests();
        } finally {
            // No-op, just structural variation
        }
    }
}