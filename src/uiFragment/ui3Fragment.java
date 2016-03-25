package uiFragment;


import android.os.Bundle;
import com.example.myapp.R;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;





public class ui3Fragment extends Fragment {

   @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	   View view = inflater.inflate(R.layout.ui3_main,container, false);
   		return view;
   }
}
