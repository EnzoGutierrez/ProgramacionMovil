package com.example.proyecto015;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class Actividad2 extends Activity {

	private WebView webView1; 
	
	@Override
	 public void onCreate(Bundle b) {
	 super.onCreate(b);
	 setContentView(R.layout.actividad2);
	 webView1=(WebView)findViewById(R.id.webView1);

	 Bundle bundle=getIntent().getExtras();
	 webView1.loadUrl("http://"+bundle.getString("direccion"));
	}
	
	public void finalizar(View view) {
		 finish();
		 } 
}
