package com.example.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.*;
import android.widget.AdapterView.AdapterContextMenuInfo;



public class MainActivity extends Activity {

	
List<Map<String, String>> planetsList = new ArrayList<Map<String,String>>();
SimpleAdapter simpleAdpt;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        initList();
        ListView lv = (ListView) findViewById(R.id.listView);
        
simpleAdpt = new SimpleAdapter(this, planetsList, android.R.layout.simple_list_item_1, new String[] {"planet"}, new int[] 
		{android.R.id.text1});
		
	lv.setAdapter(simpleAdpt);
	lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		
		 
public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
		  
		 
	 // We know the View is a TextView so we can cast it
TextView clickedView = (TextView) view;
Toast.makeText(MainActivity.this,"Item with id ["+id+"] - Position ["+position+"] - Planet ["+clickedView.getText()+"]", Toast.LENGTH_SHORT).show();
	 
}
});
	registerForContextMenu(lv); }
	
			private void initList() {
			
			 planetsList.add(createPlanet("planet", "Mercury"));
			 planetsList.add(createPlanet("planet", "Venus"));
			 planetsList.add(createPlanet("planet", "Mars"));
			 planetsList.add(createPlanet("planet", "Jupiter"));
		     planetsList.add(createPlanet("planet", "Saturn"));
			 planetsList.add(createPlanet("planet", "Uranus"));
			 planetsList.add(createPlanet("planet", "Neptune"));
			
			 }
			
			
		 private HashMap<String, String> createPlanet(String key, String name) {
			 HashMap<String, String> planet = new HashMap<String, String>();
			 planet.put(key, name);
			
			 return planet;
		 }		 
		 
				
  @Override
  public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
  super.onCreateContextMenu(menu, v, menuInfo);
  AdapterContextMenuInfo aInfo = (AdapterContextMenuInfo) menuInfo;
		 
	// We know that each row in the adapter is a Map
	HashMap map = (HashMap) simpleAdpt.getItem(aInfo.position);
		 
	 menu.setHeaderTitle("Options for "  + map.get("planet")); 
	 menu.add(1, 1, 1, "Details");
	 menu.add(1, 2, 2, "Delete");
		 
		  }

		 @Override
		 public boolean onContextItemSelected(MenuItem item) {
		 int itemId = item.getItemId();
		 // Implements our logic
		 Toast.makeText(this, "Item id ["+itemId+"]", Toast.LENGTH_SHORT).show();
		 return true;
		 }
		
}
	

