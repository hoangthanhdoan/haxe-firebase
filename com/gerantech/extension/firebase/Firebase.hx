package com.gerantech.extension.firebase;

class Firebase {
	///callbacks haxe
	public static var onInit:Bool->String->Void = null;
	public static var onReady:String->Void = null;

	private static var _instance:Firebase = null;

	public static function init(stringID:String):Void {
		libInit(getInstance(), stringID, true, true);
	}

	public static function getInstance():Firebase {
		if (_instance == null)
			_instance = new Firebase();
		return _instance;
	}

	////java binings
	private static var libInit:UnityAds->String->Bool->Bool->Void =
		#if (android && openfl)
		lime.system.JNI.createStaticMethod("com/gerantech/extension/firebase/FirebaseWrapper", "init", "(Lorg/haxe/lime/HaxeObject;Ljava/lang/String;ZZ)V");
		#else
		function(o:Firebase, s:String):Void {};
		#end

	// event handlers
	public function new() {}

	@:keep
	public function listen(type:String, arg0:Dynamic, arg1:Dynamic):Void {
		if (type == "init" && onInit != null)
			onInit(arg0, arg1);
		else if (type == "ready" && onReady != null) {
			onReady(arg0);
        }
	}
}
