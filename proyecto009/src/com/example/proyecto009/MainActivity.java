package com.example.proyecto009;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView; 
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	private Spinner spinner1;
	private EditText et1, et2;
	private TextView tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        tv3=(TextView)findViewById(R.id.tv3); 
        
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        String[]opciones={"sumar","restar","multiplicar","dividir"}; 
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void operar(View view) {
    	 String valor1=et1.getText().toString();
    	 String valor2=et2.getText().toString();
    	 int nro1=Integer.parseInt(valor1);
    	 int nro2=Integer.parseInt(valor2);
    	 String selec=spinner1.getSelectedItem().toString();
    	 if (selec.equals("sumar")) {
    		 int suma=nro1+nro2;
    		 String resu=String.valueOf(suma);
    		 tv3.setText(resu);
    	 } else
    		 if (selec.equals("restar")) {
    			 int resta=nro1-nro2;
    			 String resu=String.valueOf(resta);
    			 tv3.setText(resu);
    	 }
    	 else
    		 if (selec.equals("multiplicar")) {
    			 int multi=nro1*nro2;
    			 String resu=String.valueOf(multi);
    			 tv3.setText(resu);
    	 }
    	 else
    		 if (selec.equals("dividir")) {
    			 int divi=nro1/nro2;
    			 String resu=String.valueOf(divi);
    			 tv3.setText(resu);
    	 }
    } 
    
}
