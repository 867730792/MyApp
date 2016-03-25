package activity;


import com.example.myapp.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/*代码需求：1，获得一个拥有数字小键盘的界面用以输入具体数值。
 * 					2，通过输入的数值计算出相应的身体质量指数BMI，在范围内弹出提示，健康，较轻，较重。
 */
public class BMI extends Activity implements OnClickListener{
	EditText ediwidth,ediheight,bmishow;
	TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.bmi);
		Button bmisum =(Button) findViewById(R.id.bmi_button);
		ediwidth =(EditText) findViewById(R.id.bmi_width);
		ediheight =(EditText) findViewById(R.id.bmi_height);
		bmishow =(EditText) findViewById(R.id.bmi_show);
		
		Button number1 =(Button) findViewById(R.id.number1);
		Button number2 =(Button) findViewById(R.id.number2);
		Button number3 =(Button) findViewById(R.id.number3);
		Button number4 =(Button) findViewById(R.id.number4);
		Button number5 =(Button) findViewById(R.id.number5);
		Button number6 =(Button) findViewById(R.id.number6);
		Button number7 =(Button) findViewById(R.id.number7);
		Button number8 =(Button) findViewById(R.id.number8);
		Button number9 =(Button) findViewById(R.id.number9);
		Button number0 =(Button) findViewById(R.id.number0);
		Button clear =(Button) findViewById(R.id.clear);
		number1.setOnClickListener(this);
		number2.setOnClickListener(this);
		number3.setOnClickListener(this);
		number4.setOnClickListener(this);
		number5.setOnClickListener(this);
		number6.setOnClickListener(this);
		number7.setOnClickListener(this);
		number8.setOnClickListener(this);
		number9.setOnClickListener(this);
		number0.setOnClickListener(this);
		bmisum.setOnClickListener(this);
		clear.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		//用两个字符串来保存获取按钮输入的值。
		String show1 =ediwidth.getText().toString();
		
		String show2 =ediheight.getText().toString();
		switch (v.getId()) {
		case R.id.clear:	
			ediwidth.setText("");
			ediheight.setText("");
			bmishow.setText("");
			break;
		case R.id.number1:
		case R.id.number2:
		case R.id.number3:
		case R.id.number4:
		case R.id.number5:
		case R.id.number6:
		case R.id.number7:
		case R.id.number8:
		case R.id.number9:
		case R.id.number0:
			if(ediwidth.hasFocus()) {
				//获得焦点  
	        	ediwidth.setText(show1+((Button)v).getText());
	        }else{
	        	//失去焦点  
	        	ediheight.setText(show2+((Button)v).getText());
	        }  
			break;
			
		case R.id.bmi_button:
			//计算方法。
			if (!"".equals(show1)&&!"".equals(show2)) {
				double a1 = Double.parseDouble(show1.trim());
				double a2 = Double.parseDouble(show2.trim());
				double c =a2/100;
				double sum = (a1/(c*c));
				if(a2>230||a2<50||a1>200||a1<20||sum<13||sum>50){
					Toast.makeText(BMI.this, "请输入正确的数值", Toast.LENGTH_SHORT).show();
					break;
				}
				if(sum<23&&sum>18){
					Toast.makeText(BMI.this, "你的体重很标准，请继续保持", Toast.LENGTH_SHORT).show();
				}
				if(sum<18&&sum>13){
					Toast.makeText(BMI.this, "你的体重较低，请增加营养", Toast.LENGTH_SHORT).show();
				}
				if(sum>23&&sum<50){
					Toast.makeText(BMI.this, "你的体重较高，请增加锻炼", Toast.LENGTH_SHORT).show();
				}
				String BMI=String.valueOf(sum); 
				bmishow.setText(BMI);
				}
		default:
			break;
		}
		
	}
}
	


