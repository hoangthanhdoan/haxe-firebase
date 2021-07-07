package com.gerantech.extension.firebase;
import android.util.Log;
public class FirebaseWrapperListener {
	public static final String TAG = "firebase";

	public void onInitialize(boolean succeed, String message) {
		send("init", succeed, message);
	}

	// @Override
	public void onReady(String placementId) {
		send("ready", placementId, "");
	}


	private void send(String type, Object arg0, Object arg1) {
		Log.w(TAG, arg0 + " " + arg1);
		FirebaseWrapper.callbackObject.call3("listen", type, arg0, arg1);
	}
}