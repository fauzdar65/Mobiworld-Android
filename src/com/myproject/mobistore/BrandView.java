package com.myproject.mobistore;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class BrandView extends ListActivity {
	
	String bname;
	Dbconn d;
    ArrayList<HashMap<String,String>> bl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_brand_view);
		Intent i=getIntent();
		
		bname=i.getStringExtra("brand");
		d=new Dbconn(this);
		bl=d.getBrand(bname);
		
		if(bl.size()>0)
	    {
	    	ListView ld=getListView();
	    	ld.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					TextView t=(TextView) arg1.findViewById(R.id.pid);
					Intent i=new Intent(getApplication(),PhoneView.class);
					i.putExtra("PID", t.getText().toString() );
					startActivity(i);
				}});
	    	
	    	 ListAdapter adapter = new SimpleAdapter( BrandView.this,bl, R.layout.single_order_row, new String[] { "Model","PID"}, new int[] {R.id.model,R.id.pid});
	    	             
	    	             
	                setListAdapter(adapter);
	    	
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.brand_view, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
