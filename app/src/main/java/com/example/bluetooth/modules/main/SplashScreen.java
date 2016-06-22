package com.example.bluetooth.modules.main;

import com.example.bluetooth.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;


public class SplashScreen extends Activity {
	// Splash screen timer
	private ProgressBar progressBar;
	private int progressStatus = 0;
	private Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		progressBar = (ProgressBar) findViewById(R.id.progressBar1);

		// Start long running operation in a background thread
		new Thread(new Runnable() {
			public void run() {
				while (progressStatus < 100) {
					progressStatus += 1;
					// Update the progress bar and display the current value in
					// the text view
					handler.post(new Runnable() {
						public void run() {
							progressBar.setProgress(progressStatus);

						}
					});
					try {
						// Sleep for 200 milliseconds. Just to display the
						// progress slowly
						Thread.sleep(25);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
					Intent i = new Intent(SplashScreen.this, MainActivity.class);
					startActivity(i);
					finish();
			}
		}).start();
	}
}