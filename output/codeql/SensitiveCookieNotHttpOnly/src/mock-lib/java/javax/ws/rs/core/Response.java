package javax.ws.rs.core;

public class Response {
    public static ResponseBuilder ok() { return null; }
    public static class ResponseBuilder {
        public ResponseBuilder cookie(NewCookie... cookies) { return this; }
        public Response build() { return null; }
    }
}