package activity;




import com.example.myapp.R;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;

//���������ṩһ���ڷ���ʱ�����Զ�����ıʼǹ��ܡ�
public class Mynote extends Activity{
	EditText editText;
	SharedPreferences notePref;
	Editor noteEditor;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		  setContentView(R.layout.note);
		  
	      editText =(EditText) findViewById(R.id.editext);
	      //��ȡSharedPreferences���󣬵�һ������Ϊ�ļ�����û���򴴽����ڶ���Ϊ����Ȩ�ޡ�
			notePref =getSharedPreferences("userInfo", MODE_PRIVATE);
	      //����edit�������һ������д�����ݵ�SharedPreferences.Editor��������
			noteEditor=notePref.edit();
	    	//����������Ӷ�ȡ���ַ���
	      String read =notePref.getString("note", "");
	      editText.setText(read);
	}
		@Override
			//�˳�ʱ��������
			protected void onDestroy() {
			super.onDestroy();
			String inputText = editText.getText().toString();
			save(inputText);
	}
		private void save(String inputText) {
			//��ȡ��������ݣ�����������
			String editor=editText.getText().toString().trim();
			noteEditor.putString("note", editor);
			noteEditor.commit();
		}
}	        