package com.itszt.freethinker;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

public class Android3_1Activity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);
		LinearLayout layout = new LinearLayout(this);
		MyButton button = new MyButton(this);
		button.setBackgroundColor(Color.BLUE);
		button.setTextColor(Color.RED);
		button.setText("button");
		layout.addView(button);
		setContentView(layout);
	}
}