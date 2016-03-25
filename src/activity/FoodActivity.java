package activity;


import com.example.myapp.R;

import colorie.CalorieActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class FoodActivity extends Activity {
	Button bmiButton;
	Button foodButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui3_main);
		
		 bmiButton =(Button) findViewById(R.id.bmi_set);
		 foodButton=(Button) findViewById(R.id.food_set);
	
		bmiButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FoodActivity.this,BMI.class);
				startActivity(intent);
			}
		});
		foodButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FoodActivity.this,CalorieActivity.class);
				startActivity(intent);
			}
		});
	}
}
