package javax.validation;

public interface ValidatorFactory {
    Validator getValidator();
    MessageInterpolator getMessageInterpolator();
}