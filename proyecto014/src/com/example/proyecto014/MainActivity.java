package com.example.proyecto014;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private EditText et1;
	private TextView tv2;
	private String clave = "abc123";
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    	et1=(EditText)findViewById(R.id.et1);
    	tv2=(TextView)findViewById(R.id.tv2); 
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void lanzar(View view) {
    	String claveIngresada=et1.getText().toString();
    	if (claveIngresada.equalsIgnoreCase(clave)){
      	 Intent i = new Intent(this, Bienvenido.class );
      	 startActivity(i);
    	}
    	else{
    		tv2.setText("Contraseña incorrecta");
    	}
      } 
    
}
