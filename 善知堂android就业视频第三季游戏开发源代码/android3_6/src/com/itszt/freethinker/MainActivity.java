package com.itszt.freethinker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	private GameView gameView;

	// 通过配置文件设定全屏
	// android:theme="@android:style/Theme.Black.NoTitleBar.Fullscreen"
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		gameView = new GameView(this);
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
//		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(gameView);
	}
}