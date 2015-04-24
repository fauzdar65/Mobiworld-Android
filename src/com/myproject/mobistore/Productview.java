package com.myproject.mobistore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Productview extends ListActivity {
	
	

	String pid;
	Dbconn d;
    HashMap<String,String> h;
	ArrayList<HashMap<String,String> > a;
	TextView header;
	ImageView image;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_productview);
		Intent i=getIntent();
		pid=i.getStringExtra("PID");
		
		
		d=new Dbconn(this);
		h=d.phoneDetails(pid);
		
		h.remove("PID");
		h.remove("Description");
		
		header=(TextView)findViewById(R.id.test);
		image=(ImageView)findViewById(R.id.imageView1);
		
		int j = getResources().getIdentifier(pid, "drawable", getPackageName());
		
		image.setImageResource(j);
		if(h.size()>0)
		{	
		header.setText(h.remove("Companyname").toString()+" "+h.remove("Modelname").toString());
		a=new ArrayList<HashMap<String,String> >();
		
		Iterator<HashMap.Entry<String, String>> iterator = h.entrySet().iterator();
		 while(iterator.hasNext()){
		  HashMap.Entry<String, String> entry = iterator.next();
		   HashMap<String,String> temp=new HashMap<String,String>();
		   temp.put("left", entry.getKey());
		   temp.put("right", entry.getValue());
		   if(temp.get("right").length()>0)a.add(temp);
		   iterator.remove(); // right way to remove entries from Map, 
		                      // avoids ConcurrentModificationException
		 }
		 
		}
		
		if(a.size()>0)
		{
			
			
			ListAdapter adapter = new SimpleAdapter( Productview.this,a, R.layout.single_order_row, new String[] { "left","right"}, new int[] {R.id.model, R.id.dop});
            
            
            setListAdapter(adapter);   
            
        
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.productview, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			new LoadAllProducts().execute();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	class LoadAllProducts extends AsyncTask<String, String, String> {
    	
    	JSONParser jParser = new JSONParser();
    	private ProgressDialog pDialog;
    	private String url_all = "http://moboworld.esy.es/json1.php";
        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Productview.this);
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
            
            pDialog.dismiss();
           

        }

    }
	
}
