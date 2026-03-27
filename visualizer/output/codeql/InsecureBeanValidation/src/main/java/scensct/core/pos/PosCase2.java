// Unsanitized user input used in custom constraint message with unsafe interpolator should be flagged as EL injection.
package scensct.core.pos;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.MessageInterpolator;
import javax.validation.Validator;
import java.lang.annotation.*;
import javax.servlet.http.HttpServletRequest;

public class PosCase2 {
    // Custom constraint annotation
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = MyConstraintValidator.class)
    public @interface MyConstraint {
        String message() default "";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }

    // Validator
    public static class MyConstraintValidator implements ConstraintValidator<MyConstraint, String> {
        @Override
        public void initialize(MyConstraint constraintAnnotation) {}
        
        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            return value != null && !value.isEmpty();
        }
    }

    // Field with annotation using constant expression (test scenario adjusted)
    @MyConstraint(message = "Invalid: ${userInput}")
    private String data;

    // Method with unsafe interpolator configuration
    public void validateWithUnsafeInterpolator(HttpServletRequest request) {
        String userInput = request.getParameter("input"); // Unsanitized user input
        
        // Configuring unsafe interpolator (default, which enables EL)
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        MessageInterpolator unsafeInterpolator = factory.getMessageInterpolator();
        ValidatorFactory customFactory = Validation.byDefaultProvider()
            .configure()
            .messageInterpolator(unsafeInterpolator) // Unsafe interpolator
            .buildValidatorFactory();
        // Use the validator to trigger validation with the unsafe interpolator
        Validator validator = customFactory.getValidator();
        // Validate this instance to process the annotation message with EL
        validator.validate(this);
    }
}