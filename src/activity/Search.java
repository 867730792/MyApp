package activity;


import android.app.Activity;

import com.example.myapp.R;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
//��APP�������ṩһ��������������ҳ��
public class Search extends Activity{
	WebView webView;
	ProgressDialog progressDialog;
	 protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
		 setContentView(R.layout.web_view);
		webView =(WebView) findViewById(R.id.webview);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
		webView.getSettings().setUseWideViewPort(true);
		webView.getSettings().setAppCacheEnabled(true);
		webView.getSettings().setDomStorageEnabled(true);
		webView.getSettings().setLoadWithOverviewMode(true);
		
		progressDialog =new ProgressDialog(Search.this);
		progressDialog.setTitle("��ҳ������");
		progressDialog.setMessage("Loading...");
		progressDialog.setCancelable(true);
		progressDialog.show();
		
		webView.setWebViewClient(new WebViewClient() {
			@Override
			// ���ݴ���Ĳ��������µ���ҳ����WebView�д���ҳ��
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url); 
			return true; 
			}
		});
			webView.loadUrl("http://www.baidu.com");
	}
}
