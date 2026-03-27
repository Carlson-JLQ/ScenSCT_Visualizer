package javax.validation;

public interface Configuration<T extends Configuration<T>> {
    T messageInterpolator(MessageInterpolator interpolator);
    ValidatorFactory buildValidatorFactory();
}