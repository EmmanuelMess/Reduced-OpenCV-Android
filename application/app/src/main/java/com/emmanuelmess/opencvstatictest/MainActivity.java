package com.emmanuelmess.opencvstatictest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	// Used to load the 'native-lib' library on application startup.
	static {
		System.loadLibrary("native-lib");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.test);

		Bitmap bmp32 = image.copy(Bitmap.Config.ARGB_8888, true);

		this.<ImageView>findViewById(R.id.background).setImageBitmap(process(bmp32));
	}

	private native Bitmap process(Bitmap b);
}