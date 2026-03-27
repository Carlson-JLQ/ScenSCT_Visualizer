// Unsanitized user input used directly in custom constraint message without safe interpolator should be flagged as EL injection.
package scensct.ref.pos;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import javax.servlet.http.HttpServletRequest;

public class PosCase1_FN1 {
    // Custom constraint annotation with message attribute vulnerable to EL injection
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = MyConstraintValidator.class)
    public @interface MyConstraint {
        String message() default ""; // Will be set with user input
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }

    // Validator for the custom constraint
    public static class MyConstraintValidator implements ConstraintValidator<MyConstraint, String> {
        @Override
        public void initialize(MyConstraint constraintAnnotation) {}
        
        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            return value != null && !value.isEmpty();
        }
    }

    // Field with annotation using EL placeholder (simulating user input interpolation)
    @MyConstraint(message = "Error: ${userInput}")
    private String data;

    // Method receiving unsanitized user input
    public void validateUserInput(HttpServletRequest request) {
        String userInput = request.getParameter("input"); // Unsanitized user input
    }
}