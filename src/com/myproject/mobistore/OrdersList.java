package com.myproject.mobistore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class OrdersList extends ListActivity {
    String uid;
    Dbconn d=new Dbconn(this);
    ArrayList<HashMap<String,String> > od= new ArrayList<HashMap<String,String> >();
    private ProgressDialog pDialog=null;	
   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_orders_list);
		Intent i=getIntent();
		uid=i.getStringExtra("uid");
	    od=d.getOrders(uid);
	    //TextView t=(TextView)findViewById(R.id.textView1);
	    //if(od.size()>0)t.setText(od.get(1).get("DOP"));
	   
	    if(od.size()>0)
	    {
	    	ListView ld=getListView();
	    	ld.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					TextView t=(TextView) arg1.findViewById(R.id.pid);
					Intent i=new Intent(getApplication(),Productview.class);
					i.putExtra("PID", t.getText().toString() );
					startActivity(i);
				}});
	    	
	    	 ListAdapter adapter = new SimpleAdapter( OrdersList.this,od, R.layout.single_order_row, new String[] { "Model","DOP","PID"}, new int[] {R.id.model, R.id.dop,R.id.pid});
	    	             
	    	             
	                setListAdapter(adapter);
	    	
	    }


	}
	
	public void onPause(){
    	super.onPause();
    	
    	if(pDialog!=null)
    	{
    		pDialog.dismiss();
    	}
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.orders_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			
			new LoadAllProducts().execute();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	class LoadAllProducts extends AsyncTask<String, String, String> {
    	
    	JSONParser jParser = new JSONParser();
    	
    	private String url_all = "http://moboworld.esy.es/json1.php";
        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(OrdersList.this);
            pDialog.setMessage("Loading products. Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        /**
         * getting All products from url
         * */
        protected String doInBackground(String... args) {
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            // getting JSON string from URL
            JSONObject json = jParser.makeHttpRequest(url_all, "GET", params);

            // Check your log cat for JSON reponse
            //Log.d("All Products: ", json.toString());

            try {
                // Checking for SUCCESS TAG
                int s=json.getInt("success");
                if(s==1)
                {
                d.replacedb(json);
                
                }
                } 
             catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        
        protected void onPostExecute(String file_url) {
            
            
            
           
            
            new Thread(new Runnable() {
          	  @Override
          	  public void run()
          	  {
          	    // do the thing that takes a long time
          		  Intent i=getIntent();
          			i.putExtra("uid",uid);
          			finish();  
          		  startActivity(i);	
          	    runOnUiThread(new Runnable() {
          	      @Override
          	      public void run()
          	      {
          	    	pDialog.dismiss();
          	      }
          	    });
          	  }
          	}).start();
            
                     
           
        }

    }
}
