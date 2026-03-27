package javax.ws.rs.core;

import javax.servlet.http.Cookie;

public class NewCookie {
    public NewCookie(String name, String value, String path, String domain, int version, String comment, int maxAge, java.util.Date expiry, boolean secure, boolean httpOnly) {}
    public NewCookie(Cookie cookie, String comment, int maxAge, String domain, String path, boolean httpOnly) {}
    public String toString() { return null; }
}