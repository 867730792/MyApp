package activity;


import android.app.Activity;
import com.example.myapp.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
//�ṩһ���������֪ͨ�Ĺ��ܡ�
public class time extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.time);
	Button time =(Button) findViewById(R.id.send_time);
	
		time.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//��ȡNotificationManager �Ķ���
				NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
				//����һ�� Notification ����
				Notification notification = new Notification(R.drawable.ic_launcher, "������ʾ", System.currentTimeMillis());
				notification.setLatestEventInfo(time.this, "��������ʱ����","ÿ���˶����������飡", null);
				//��ʾ֪ͨ
				manager.notify(1, notification);
			}
		});
	
	}
	
}
