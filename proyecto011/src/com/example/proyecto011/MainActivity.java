package com.example.proyecto011;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu; 
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private String[] paises = { "Argentina", "Chile", 
			"Paraguay", "Bolivia", "Peru", "Ecuador", "Brasil", "Colombia", "Venezuela", "Uruguay" };
			 private String[] habitantes = { "40000000", "17000000",
			"6500000", "10000000", "30000000", "14000000", "183000000", "44000000", "29000000", "3500000" };
			 private TextView tv1;
			 private ListView lv1; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tv1=(TextView)findViewById(R.id.tv1);
        lv1 =(ListView)findViewById(R.id.listView1); 
        ArrayAdapter <String> adapter = new
        		ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,paises);
        		 lv1.setAdapter(adapter);
        		 lv1.setOnItemClickListener(new OnItemClickListener() {
        			 @Override
        			 public void onItemClick(AdapterView<?> parent, View v,int posicion, long id) {
        				 tv1.setText("Población de "+ lv1.getItemAtPosition(posicion) + " es "+ habitantes[posicion]);
        		 }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
