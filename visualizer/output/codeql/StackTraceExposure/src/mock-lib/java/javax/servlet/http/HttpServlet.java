package javax.servlet.http;

import javax.servlet.ServletContext;

public abstract class HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) {}
    public ServletContext getServletContext() { return null; }
}