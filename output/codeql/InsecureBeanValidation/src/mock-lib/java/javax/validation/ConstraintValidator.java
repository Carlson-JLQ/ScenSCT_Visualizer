package javax.validation;

public interface ConstraintValidator<A, T> {
    void initialize(A constraintAnnotation);
    boolean isValid(T value, ConstraintValidatorContext context);
}