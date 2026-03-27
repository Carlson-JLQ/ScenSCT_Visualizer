// Implicit Intent with mutable PendingIntent sent to third party, including allowed implicit read of parcelable extra, should be flagged as unsafe.
package scensct.ref.pos;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

public class PosCase1_FN1 {
    public void sendPendingIntentToThirdParty(Context context, Parcelable extraData) {
        // Implicit Intent creation
        Intent implicitIntent = new Intent("com.example.ACTION_TRIGGER");
        // Allowed implicit read of parcelable extra (policy allows reading parcelable extras)
        implicitIntent.putExtra("key", extraData);
        // Create mutable PendingIntent from implicit Intent
        PendingIntent pending = PendingIntent.getActivity(
            context,
            0,
            implicitIntent,
            PendingIntent.FLAG_MUTABLE
        );
        // Send to unspecified third party (e.g., via startActivity)
        Intent thirdPartyIntent = new Intent();
        thirdPartyIntent.putExtra("pending", pending);
        context.startActivity(thirdPartyIntent);
    }
}