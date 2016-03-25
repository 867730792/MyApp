package activity;


import android.app.Activity;
import com.example.myapp.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
//提供一个点击发送通知的功能。
public class time extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.time);
	Button time =(Button) findViewById(R.id.send_time);
	
		time.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//获取NotificationManager 的对象
				NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
				//创建一个 Notification 对象
				Notification notification = new Notification(R.drawable.ic_launcher, "锻炼提示", System.currentTimeMillis());
				notification.setLatestEventInfo(time.this, "到锻炼的时间了","每天运动，美好心情！", null);
				//显示通知
				manager.notify(1, notification);
			}
		});
	
	}
	
}
