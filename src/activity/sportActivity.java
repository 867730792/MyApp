package activity;



import android.app.Activity;
import com.example.myapp.R;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
/*代码需求：  1，获得一个操作主界面，用以完成登录后进入运动程序。
 * 		  2，界面由标题栏和三个fragment组成，分为运动程序的三个功能中心。
 * 		  3，标题栏和fragment中提供相应的功能按钮，用以执行。
 * 		  4，点击按钮跳转到新的界面，执行相应的方法。
 * */
public class sportActivity extends Activity implements OnClickListener{
	Button buttonnote,buttontime,fButton,ui2;
	ImageButton search, set;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.sport_main);
		Button buttonnote =(Button) findViewById(R.id.note);
		Button buttontime =(Button) findViewById(R.id.set_time);
		Button ui2 =(Button) findViewById(R.id.ui2_button2);
		ImageButton search =(ImageButton) findViewById(R.id.search);
		ImageButton set =(ImageButton) findViewById(R.id.set);
		
		fButton =(Button) findViewById(R.id.ui2_button3);
		
		fButton.setOnClickListener(this);
		buttonnote.setOnClickListener(this);
		buttontime.setOnClickListener(this);
		search.setOnClickListener(this);
		set.setOnClickListener(this);
		ui2.setOnClickListener(this);
	}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.note:
				Intent intent1 = new Intent(sportActivity.this,Mynote.class);
				startActivity(intent1);
				Toast.makeText(sportActivity.this, "提供一个在返回时可以自动保存的笔记功能。", Toast.LENGTH_SHORT).show();
				break;
			case R.id.set_time:
				Intent intent2 = new Intent(sportActivity.this,time.class);
				startActivity(intent2);
				Toast.makeText(sportActivity.this, "提供一个用于定时通知运动的广播", Toast.LENGTH_SHORT).show();
				break;
			case R.id.search:
				Intent intent3 = new Intent(sportActivity.this,Search.class);
				startActivity(intent3);
				Toast.makeText(sportActivity.this, "搜索选项", Toast.LENGTH_SHORT).show();
				break;
				
			case R.id.ui2_button3:
				Intent intent4 = new Intent(sportActivity.this,FoodActivity.class);
				Toast.makeText(sportActivity.this, "健康管理", Toast.LENGTH_SHORT).show();
				startActivity(intent4);
				break;
			case R.id.ui2_button2:
				Intent intent5 = new Intent(sportActivity.this,ActionCenter.class);
				startActivity(intent5);
				Toast.makeText(sportActivity.this, "运动中心", Toast.LENGTH_SHORT).show();
				break;
			case R.id.set:
				//弹出一个不可撤销的提示对话框
				Toast.makeText(sportActivity.this, "退出选项", Toast.LENGTH_SHORT).show();
					AlertDialog.Builder dialog = new AlertDialog.Builder(sportActivity.this);
					dialog.setTitle("提示");
					dialog.setMessage("你要退出程序吗？");
					dialog.setCancelable(false);
					dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							//清除密码并退出。
							exit();
							 finish();
						}
					});
						dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							
						}
					});
						dialog.show();
						break;
			
				default:
				break;	
		}
	}			//用名字获取SharedPreferences，清除数据。
			 public void exit(){
				 SharedPreferences pref=getSharedPreferences("userInfo", MODE_MULTI_PROCESS);
				 Editor editor =pref.edit();
	        	 editor.clear();
	        	 editor.commit();
	        }
}		
