package com.gerantech.extension.firebase;

import android.os.Bundle;

import org.haxe.extension.Extension;
import org.haxe.lime.HaxeObject;
import com.google.firebase.analytics.FirebaseAnalytics;

public class FirebaseWrapper extends Extension {

	private static String gameId;
	private static boolean initialized;
	public static HaxeObject callbackObject;
	private static FirebaseWrapperListener listener;

    private static FirebaseAnalytics mFirebaseAnalytics;

	private static int ordinal = 1;

	public static void init(HaxeObject cbo, String id, boolean testMode, boolean debugMode) {

		if (initialized) {
			listener.onInitialize(false, "Firebase already initialized.");
			return;
		}
		callbackObject = cbo;
		gameId = id;

		listener = new FirebaseWrapperListener();

        
        mainActivity.runOnUiThread (new Thread(new Runnable() {  
            public void run() {
				
             }
        }));

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(mainContext);
	}

	public static void logEvent(String placementId) {
		Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, placementId);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, placementId);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "text");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
	}
}