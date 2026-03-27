package android.app;

public class PendingIntent {
    public static final int FLAG_MUTABLE = 0;
    public static final int FLAG_IMMUTABLE = 0;
    public static PendingIntent getActivity(android.content.Context context, int requestCode, android.content.Intent intent, int flags) { return null; }
    public void send() throws CanceledException {}
    public static class CanceledException extends Exception {}
}