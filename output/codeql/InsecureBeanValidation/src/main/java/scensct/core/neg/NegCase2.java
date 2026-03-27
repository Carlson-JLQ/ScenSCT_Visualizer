// User input in Bean Validation constraint message with safe custom message interpolator should not be flagged as EL injection.
package scensct.core.neg;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.MessageInterpolator;
import java.util.Locale;

public class NegCase2 {
    public static class SafeInterpolator implements MessageInterpolator {
        private final MessageInterpolator delegate;
        
        public SafeInterpolator(MessageInterpolator delegate) {
            this.delegate = delegate;
        }
        
        @Override
        public String interpolate(String messageTemplate, Context context) {
            // Safe interpolation explicitly disabling EL evaluation
            return messageTemplate; // Direct return without EL processing
        }
        
        @Override
        public String interpolate(String messageTemplate, Context context, Locale locale) {
            return messageTemplate; // Direct return without EL processing
        }
    }
    
    public static class User {
        @NotNull(message = "Invalid input: ${validatedValue}") // User input flows into message via validatedValue
        private String input;
        
        public void setInput(String input) {
            this.input = input;
        }
    }
    
    public static void main(String[] args) {
        // Configure global safe message interpolator preventing EL injection
        ValidatorFactory factory = Validation.byDefaultProvider()
            .configure()
            .messageInterpolator(new SafeInterpolator(null))
            .buildValidatorFactory();
        Validator validator = factory.getValidator();
        
        User user = new User();
        user.setInput(args.length > 0 ? args[0] : "test"); // User input from request parameter
        validator.validate(user); // Validation with safe interpolator
    }
}