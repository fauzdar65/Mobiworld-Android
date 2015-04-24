package com.myproject.mobistore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class PhoneView extends ListActivity {
	
	String pid;
	Dbconn d;
    HashMap<String,String> h;
	ArrayList<HashMap<String,String> > a;
	TextView header;
	ImageView image;
	
	String p;
	public static final String MyPreferences="mypref";
	public static final String user="username";
	public static final String pass="password";
	
	SharedPreferences sharedpreferences;
	
	private String url_all="http://moboworld.esy.es/json1.php";
	private String url_a="http://moboworld.esy.es/json2.php";
	List<NameValuePair> params1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_productview);
		Button b1=(Button)findViewById(R.id.button1);
		Button b2=(Button)findViewById(R.id.button2);
		b1.setVisibility(View.VISIBLE);
		b2.setVisibility(View.VISIBLE);
		
		
		
		Intent i=getIntent();
		pid=i.getStringExtra("PID");
		
		sharedpreferences=getSharedPreferences(MyPreferences,Context.MODE_PRIVATE);
		p=sharedpreferences.getString(user, null);
		
		params1=new ArrayList<NameValuePair>();
		
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
			
			
			ListAdapter adapter = new SimpleAdapter( PhoneView.this,a, R.layout.single_order_row, new String[] { "left","right"}, new int[] {R.id.model, R.id.dop});

            setListAdapter(adapter);   
		}
		
	}
	
	public void buyer(View view)
	{
		url_a="http://moboworld.esy.es/json2.php";
		
		new LoadAllProducts().execute();
	}
	
	public void carter(View view)
	{
		url_a="http://moboworld.esy.es/json3.php";
		
		new LoadAllProducts().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.phone_view, menu);
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
	
class LoadAllProducts extends AsyncTask<String, String, String> {
    	
    	JSONParser jParser = new JSONParser();
    	private ProgressDialog pDialog;
    	
        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            
            pDialog = new ProgressDialog(PhoneView.this);
            pDialog.setMessage("Processing Request..Please wait...");
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
            params1.add(new BasicNameValuePair("user", p));
            params1.add(new BasicNameValuePair("pid", pid));
            jParser.makeHttpRequest(url_a, "POST", params1);
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
           params1.clear();

        }

    }
}
