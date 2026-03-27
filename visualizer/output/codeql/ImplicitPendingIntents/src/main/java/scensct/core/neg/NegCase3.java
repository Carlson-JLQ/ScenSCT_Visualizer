// All implicit Intent sources have a taint state other than NoState should not be flagged as implicit Intent to PendingIntent flow.
package scensct.core.neg;

import android.content.Intent;
import android.app.PendingIntent;

public class NegCase3 {
    public void test() {
        // Implicit Intent source, but setPackage makes it explicit-like, taint state may not be NoState
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setPackage("com.example.package"); // Changes state from NoState
        // PendingIntent sink with mutable flag
        PendingIntent pendingIntent = PendingIntent.getActivity(null, 0, intent, PendingIntent.FLAG_MUTABLE);
        sendPendingIntent(pendingIntent);
    }

    private void sendPendingIntent(PendingIntent pi) {
        // Placeholder
    }
}