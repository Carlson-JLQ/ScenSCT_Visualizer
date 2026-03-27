package javax.validation;

public interface ConstraintValidatorContext {
    ConstraintViolationBuilder buildConstraintViolationWithTemplate(String messageTemplate);
    
    interface ConstraintViolationBuilder {
        ConstraintValidatorContext addConstraintViolation();
    }
}