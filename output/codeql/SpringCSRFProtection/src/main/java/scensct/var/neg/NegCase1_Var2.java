// A method call not named "disable" and not a call to csrf() should not be flagged as disabling CSRF protection.
package scensct.var.neg;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class NegCase1_Var2 {
    public void configure(HttpSecurity http) throws Exception {
        // Variant 2: Wrap the call in a conditional that always executes
        if (System.currentTimeMillis() > 0) {
            http.authorizeHttpRequests();
        }
    }
}