package com.example.gutierrezenzo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Factura extends Activity {
	private TextView tv3, tv5;

   	 	public void onCreate(Bundle b) {
	   		 super.onCreate(b);
	   		 setContentView(R.layout.factura);
	   		 
	         tv3=(TextView)findViewById(R.id.tv3);
	         tv5=(TextView)findViewById(R.id.tv5);
	         
	         Bundle bundle=getIntent().getExtras(); 
	         tv5.setText(bundle.getString("monto"));
	         
	         Bundle bundle2=getIntent().getExtras(); 
	         tv3.setText(bundle2.getString("tipo"));
	   	}
        
   	    public void retornar(View view) {
         	 Intent i = new Intent(this, MainActivity.class );
         	 startActivity(i);
         }
}
