package javax.servlet.http;

public interface HttpServletResponse {
    void addCookie(Cookie cookie);
    void setHeader(String name, String value);
    void setContentType(String type);
    java.io.PrintWriter getWriter();
}