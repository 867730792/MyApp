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
/*��������  1�����һ�����������棬������ɵ�¼������˶�����
 * 		  2�������ɱ�����������fragment��ɣ���Ϊ�˶�����������������ġ�
 * 		  3����������fragment���ṩ��Ӧ�Ĺ��ܰ�ť������ִ�С�
 * 		  4�������ť��ת���µĽ��棬ִ����Ӧ�ķ�����
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
				Toast.makeText(sportActivity.this, "�ṩһ���ڷ���ʱ�����Զ�����ıʼǹ��ܡ�", Toast.LENGTH_SHORT).show();
				break;
			case R.id.set_time:
				Intent intent2 = new Intent(sportActivity.this,time.class);
				startActivity(intent2);
				Toast.makeText(sportActivity.this, "�ṩһ�����ڶ�ʱ֪ͨ�˶��Ĺ㲥", Toast.LENGTH_SHORT).show();
				break;
			case R.id.search:
				Intent intent3 = new Intent(sportActivity.this,Search.class);
				startActivity(intent3);
				Toast.makeText(sportActivity.this, "����ѡ��", Toast.LENGTH_SHORT).show();
				break;
				
			case R.id.ui2_button3:
				Intent intent4 = new Intent(sportActivity.this,FoodActivity.class);
				Toast.makeText(sportActivity.this, "��������", Toast.LENGTH_SHORT).show();
				startActivity(intent4);
				break;
			case R.id.ui2_button2:
				Intent intent5 = new Intent(sportActivity.this,ActionCenter.class);
				startActivity(intent5);
				Toast.makeText(sportActivity.this, "�˶�����", Toast.LENGTH_SHORT).show();
				break;
			case R.id.set:
				//����һ�����ɳ�������ʾ�Ի���
				Toast.makeText(sportActivity.this, "�˳�ѡ��", Toast.LENGTH_SHORT).show();
					AlertDialog.Builder dialog = new AlertDialog.Builder(sportActivity.this);
					dialog.setTitle("��ʾ");
					dialog.setMessage("��Ҫ�˳�������");
					dialog.setCancelable(false);
					dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							//������벢�˳���
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
	}			//�����ֻ�ȡSharedPreferences��������ݡ�
			 public void exit(){
				 SharedPreferences pref=getSharedPreferences("userInfo", MODE_MULTI_PROCESS);
				 Editor editor =pref.edit();
	        	 editor.clear();
	        	 editor.commit();
	        }
}		
