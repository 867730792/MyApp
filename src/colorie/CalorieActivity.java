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

//调用准备好的adapter，ArrayList，完成ListView的创建。
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
        //点击事件
        listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
				food =FoodList.get(position);
				Toast.makeText(CalorieActivity.this, food.getName(), Toast.LENGTH_SHORT).show();
			}
		});
    }
    private void initFood() {
		 //用数组保存需要传入的两个自定义参数的原始数据。
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

