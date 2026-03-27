package javax.servlet.http;

import javax.servlet.ServletResponse;
import java.io.IOException;

public interface HttpServletResponse extends ServletResponse {
    void sendRedirect(String location) throws IOException;
}