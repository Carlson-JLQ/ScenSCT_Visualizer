package javax.servlet.http;

public interface HttpServletResponse {
    void setHeader(String name, String value);
    void addHeader(String name, String value);
    void addCookie(Cookie cookie);
}