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
	//�Զ����FoodAdapter������ֻ�ܽ����Զ�����Food���������͡�
	public FoodAdapter(Context context, int textViewResourceId, List<Food> objects) {
		super(context, textViewResourceId, objects);
		resourceId =textViewResourceId;
	}
	@Override
	//��дgetView()������ָ������ʱ����ʾ���ݡ�
		public View getView(int position, View convertView, ViewGroup parent) {
		Food food = getItem(position); //��ȡListview�е�Food�������ڴ��ݲ�����
		View view;
		ViewHolder viewHolder;
		//�ж��Ƿ��Ѿ��л������ݡ�
		if (convertView == null) {
		//Ϊ�ؼ�View���ز��֣���LayoutInflater.from������������һ��LayoutInflater�����øö�����ɰ󶨲��֡�
		view= LayoutInflater.from(getContext()).inflate(resourceId, null);
		//����viewHolder���������ݻ���ؼ����󲢴��ݸ�view��
		viewHolder =new ViewHolder();
		viewHolder.foodImage =(ImageView) view.findViewById(R.id.food_image);
		viewHolder.foodName =(TextView) view.findViewById(R.id.food_name);
		view.setTag(viewHolder);
		} else {
			//ȡ��viewHodler
			view =convertView;
			viewHolder =(ViewHolder) view.getTag();
		}
		//����viewHolder��ȡ����
		viewHolder.foodImage.setImageResource(food.getImageId());
		viewHolder.foodName.setText(food.getName());
		return view;
	}
	  class ViewHolder{
		  ImageView foodImage;
		  TextView foodName;
	}
}
