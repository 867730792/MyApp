package activity;




import com.example.myapp.R;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;

//代码需求，提供一个在返回时可以自动保存的笔记功能。
public class Mynote extends Activity{
	EditText editText;
	SharedPreferences notePref;
	Editor noteEditor;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		  setContentView(R.layout.note);
		  
	      editText =(EditText) findViewById(R.id.editext);
	      //获取SharedPreferences对象，第一个参数为文件名，没有则创建，第二个为访问权限。
			notePref =getSharedPreferences("userInfo", MODE_PRIVATE);
	      //调用edit方法获得一个可以写入数据的SharedPreferences.Editor容器对象。
			noteEditor=notePref.edit();
	    	//往容器中添加读取的字符串
	      String read =notePref.getString("note", "");
	      editText.setText(read);
	}
		@Override
			//退出时保存数据
			protected void onDestroy() {
			super.onDestroy();
			String inputText = editText.getText().toString();
			save(inputText);
	}
		private void save(String inputText) {
			//获取输入的数据，存入容器。
			String editor=editText.getText().toString().trim();
			noteEditor.putString("note", editor);
			noteEditor.commit();
		}
}	        