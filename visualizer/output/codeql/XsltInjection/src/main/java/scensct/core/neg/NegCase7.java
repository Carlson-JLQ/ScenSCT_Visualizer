// Tainted user input is sanitized before reaching XSLT injection sink.
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

public class NegCase7 {
    // Simple sanitizer that removes risky characters (example logic).
    private static String sanitize(String input) {
        if (input == null) return "";
        // Basic sanitization: allow only alphanumeric and safe XML chars.
        return input.replaceAll("[^a-zA-Z0-9< >/\"'=-]", "");
    }

    public void safeTransform(HttpServletRequest request) throws Exception {
        // Scenario 7: Tainted source.
        String userXsl = request.getParameter("xslInput");
        // Sanitization along the flow path before sink.
        String cleanedXsl = sanitize(userXsl);
        TransformerFactory factory = TransformerFactory.newInstance();
        // Sink receives sanitized data.
        factory.newTransformer(new StreamSource(new StringReader(cleanedXsl)));
    }
}