package colorie;

import java.util.List;

import com.example.myapp.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodAdapter extends ArrayAdapter<Food> {
	private int resourceId;
	//自定义的FoodAdapter适配器只能接受自定义类Food的数据类型。
	public FoodAdapter(Context context, int textViewResourceId, List<Food> objects) {
		super(context, textViewResourceId, objects);
		resourceId =textViewResourceId;
	}
	@Override
	//重写getView()方法，指定滑动时的显示内容。
		public View getView(int position, View convertView, ViewGroup parent) {
		Food food = getItem(position); //获取Listview中的Food对象用于传递参数。
		View view;
		ViewHolder viewHolder;
		//判断是否已经有缓存数据。
		if (convertView == null) {
		//为控件View加载布局，用LayoutInflater.from（）代表构建出一个LayoutInflater对象，用该对象完成绑定布局。
		view= LayoutInflater.from(getContext()).inflate(resourceId, null);
		//创建viewHolder对象存放数据缓存控件对象并传递给view。
		viewHolder =new ViewHolder();
		viewHolder.foodImage =(ImageView) view.findViewById(R.id.food_image);
		viewHolder.foodName =(TextView) view.findViewById(R.id.food_name);
		view.setTag(viewHolder);
		} else {
			//取出viewHodler
			view =convertView;
			viewHolder =(ViewHolder) view.getTag();
		}
		//利用viewHolder获取数据
		viewHolder.foodImage.setImageResource(food.getImageId());
		viewHolder.foodName.setText(food.getName());
		return view;
	}
	  class ViewHolder{
		  ImageView foodImage;
		  TextView foodName;
	}
}
