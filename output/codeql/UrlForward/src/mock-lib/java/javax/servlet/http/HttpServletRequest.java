package javax.servlet.http;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;

public interface HttpServletRequest extends ServletRequest {
    String getParameter(String name);
    RequestDispatcher getRequestDispatcher(String path);
    String getRequestURI();
}