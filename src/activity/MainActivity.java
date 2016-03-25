package activity;


import com.example.myapp.R;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/*��������  1�����һ����¼���棬���Կ�ʼ��һ�ε�¼�˶�����
 * 		  2��������û�ƥ��ɹ�����ת���µĽ��棬Ĭ�ϵ�¼�ɹ����Զ����棬ƥ�䲻�ɹ���ʾ�������
 * */
 
public class MainActivity extends Activity implements OnClickListener{
	
	
	EditText userName,userPass;
	SharedPreferences pref;
	Editor editor;
	Button startButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  setContentView(R.layout.user_main);
	       
	        //��ʼ���ؼ�
	        userName =(EditText) findViewById(R.id.userName);
	        userName =(EditText) findViewById(R.id.userName);
	        userPass =(EditText) findViewById(R.id.userPass);
	        startButton =(Button) findViewById(R.id.start);
	        
	        startButton.setOnClickListener(this);
	        //��ȡSharedPreferences���󣬵�һ������Ϊ�ļ�����û���򴴽����ڶ���Ϊ����Ȩ�ޡ�
	        pref =getSharedPreferences("userInfo", MODE_MULTI_PROCESS);
	        if(!"".equals(pref)){
	        	//�ü�ֵ��ȡ���ļ�����û��������룬�����ı���
	        String editname =pref.getString("userName", "");
	        String editpass =pref.getString("userPass", "");
	        userName.setText(editname);
	        userPass.setText(editpass);
	        if("yonghuming".equals(editname)&&"yonghumima".equals(editpass)){
	        // Ĭ��Ҫ�Զ���½��
	       Intent intent = new Intent(MainActivity.this, sportActivity.class);
	       startActivity(intent);
	       finish();
	        }
	      }
	}      
	      //��������ؼ�����.
		 @Override
	        public void onClick(View v){
	        	switch(v.getId()){
	        	case R.id.start:
	        	String username =userName.getText().toString().trim();
	        	String userpass =userPass.getText().toString().trim();
	        	//�Ա��˻����룬�������¼�����洢������˻����ڹرյ�¼���档������󷢳���ʾ��
	        	if("yonghuming".equals(username)&&"yonghumima".equals(userpass)){
	    			Toast.makeText(MainActivity.this, "�����˶�����", Toast.LENGTH_SHORT).show();
	    			 //����edit�������һ������д�����ݵ�SharedPreferences.Editor����
	    	        editor=pref.edit();
	    			editor.putString("userName",username);
	    			editor.putString("userPass",userpass);
	    			editor.commit();
	    			Intent intent =new Intent(MainActivity.this,sportActivity.class);
	        		startActivity(intent);
	        		finish();
	        	}else{
	        		Toast.makeText(MainActivity.this, "�������", Toast.LENGTH_SHORT).show();
	        	}
	        	break;
	        	
	        	default:
	        		break;
	        	}
	    }
	}