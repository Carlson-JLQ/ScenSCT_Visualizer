// No implicit Intent source exists in the dataflow should not be flagged as implicit Intent to PendingIntent flow.
package scensct.core.neg;

import android.content.Intent;
import android.app.PendingIntent;

public class NegCase1 {
    public void test() {
        // Explicit Intent creation, no implicit Intent source
        Intent explicitIntent = new Intent("com.example.ACTION");
        explicitIntent.setPackage("com.example.package");
        // PendingIntent from explicit Intent, no implicit flow
        PendingIntent pendingIntent = PendingIntent.getActivity(null, 0, explicitIntent, PendingIntent.FLAG_IMMUTABLE);
        // Send to unspecified third party (placeholder)
        sendPendingIntent(pendingIntent);
    }

    private void sendPendingIntent(PendingIntent pi) {
        // Placeholder for sending to third party
    }
}