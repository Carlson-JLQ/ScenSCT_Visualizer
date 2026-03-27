// permitAll() with authorizeCall qualifiers of HttpSecurityMatcherCall/HttpSecurityMatchersCall but not linked via lambda/zero-arg/anyRequest patterns should not be flagged as actuator endpoint vulnerability.
package scensct.core.neg;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class NegCase2 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Scenario: permitAll exists with authorizeCall having HttpSecurityMatcherCall qualifier
        // but permitAll is not the body of lambda argument to authorizeCall with SpringAnyRequestCall
        // or RegistryRequestMatchersCall qualifier
        http
            .authorizeRequests()
                .antMatchers("/public/**").permitAll() // Matcher-based but not for actuator endpoints
                .anyRequest().authenticated(); // Different matcher chain
    }
}