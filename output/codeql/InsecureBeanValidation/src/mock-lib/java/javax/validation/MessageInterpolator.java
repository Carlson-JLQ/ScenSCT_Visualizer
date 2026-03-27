package javax.validation;

import java.util.Locale;

public interface MessageInterpolator {
    String interpolate(String messageTemplate, Context context);
    String interpolate(String messageTemplate, Context context, Locale locale);
    interface Context {}
}