package javax.validation;

import java.util.Set;

public interface Validator {
    <T> Set validate(T object, Class<?>... groups);
}