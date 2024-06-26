package com.example.gutierrezenzop2;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle; 
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Factura extends Activity {
	private TextView tv3, tv5, tv7, tv9;

	
   	 	public void onCreate(Bundle b) {
	   		 super.onCreate(b);
	   		 setContentView(R.layout.factura);
	   		 
	         tv3=(TextView)findViewById(R.id.tv3);
	         tv5=(TextView)findViewById(R.id.tv5);
	         tv7=(TextView)findViewById(R.id.tv7);
	         tv9=(TextView)findViewById(R.id.tv9);
	         
	         Bundle bundle=getIntent().getExtras(); 
	         tv3.setText(bundle.getString("nombre"));
	         tv5.setText(bundle.getString("telefono"));
	         tv7.setText(bundle.getString("dias"));
	         tv9.setText(bundle.getString("monto"));
	   	}
        
   	    public void retornar(View view) {
         	 Intent i = new Intent(this, MainActivity.class );
         	 startActivity(i);
         }
}
