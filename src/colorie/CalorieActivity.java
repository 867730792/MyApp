package colorie;


import java.util.ArrayList;
import java.util.List;

import com.example.myapp.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

//����׼���õ�adapter��ArrayList�����ListView�Ĵ�����
public class CalorieActivity extends Activity{
	private List<Food>FoodList;
	private BaseAdapter adapter;
	private ListView listView;
	private Food food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);
        FoodList =new ArrayList<Food>();
        adapter =new FoodAdapter(CalorieActivity.this, R.layout.food_list, FoodList);
        initFood();
        //����¼�
        listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
				food =FoodList.get(position);
				Toast.makeText(CalorieActivity.this, food.getName(), Toast.LENGTH_SHORT).show();
			}
		});
    }
    private void initFood() {
		 //�����鱣����Ҫ����������Զ��������ԭʼ���ݡ�
		 int[] imageId ={R.drawable.apple,R.drawable.cabbage,R.drawable.chicken,
		R.drawable.pork,R.drawable.potato,R.drawable.apple,R.drawable.cabbage,R.drawable.chicken,
		R.drawable.pork,R.drawable.potato,R.drawable.apple,R.drawable.cabbage,R.drawable.chicken,
		R.drawable.pork,R.drawable.potato,R.drawable.apple};
		 String[] name =getResources().getStringArray(R.array.food);
		 
		 for (int i =0;i<imageId.length;i++){
			 Food foodset = new Food(name[i],imageId[i]);
			 FoodList.add(foodset);
		 }
	        listView =(ListView) findViewById(R.id.list_view);
	        listView.setAdapter(adapter);
	}	
}

