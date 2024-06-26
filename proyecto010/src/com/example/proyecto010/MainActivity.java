package com.example.proyecto010;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	private String[] lista = {"uno", "dos", "tres", "cuatro",
			"cinco", "seis", "siete", "ocho", "nueve", "diez"}; 
	private ListView lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        lv1=(ListView)findViewById(R.id.listView1);
        ArrayAdapter <String>adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista);
        lv1.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
