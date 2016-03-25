package activity;



import com.example.myapp.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class ActionCenter extends Activity implements OnClickListener{
	ImageView imageView;
	Button chest,leg,back,shoulder;
	protected void onCreate(Bundle savedInstanceState) {
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	super.onCreate(savedInstanceState);
	setContentView(R.layout.ui2_main);
	chest =(Button) findViewById(R.id.chest);
	leg =(Button) findViewById(R.id.leg);
	back =(Button) findViewById(R.id.back);
	shoulder =(Button) findViewById(R.id.shoulder);
	imageView=(ImageView) findViewById(R.id.sportimg);
	
	chest.setOnClickListener(this);
	leg.setOnClickListener(this);
	back.setOnClickListener(this);
	shoulder.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.chest:
			 imageView.setImageResource(R.drawable.chest);
			break;
		case R.id.leg:
			 imageView.setImageResource(R.drawable.leg);
			break;
		case R.id.back:
			 imageView.setImageResource(R.drawable.back);
			break;
		case R.id.shoulder:
			 imageView.setImageResource(R.drawable.shoulder);
			break;

		default:
			break;
		}
		
	}
    
 }
