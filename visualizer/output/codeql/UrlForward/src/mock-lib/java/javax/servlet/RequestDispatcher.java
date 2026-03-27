package javax.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public interface RequestDispatcher {
    void forward(ServletRequest request, ServletResponse response) throws ServletException, IOException;
}