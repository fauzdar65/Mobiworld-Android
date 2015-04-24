package com.myproject.mobistore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONArray;
import org.json.JSONException;
import org.apache.http.NameValuePair;

import com.myproject.mobistore.MainActivity.LoadAllProducts;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.AsyncTask;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;


@SuppressLint("InlinedApi")
public class LoggedScreen extends Activity {
	String p;
	public static final String MyPreferences="mypref";
	public static final String user="username";
	public static final String pass="password";
	
	SharedPreferences sharedpreferences;
	
	TextView t;
	
	Dbconn d=new Dbconn(this);
	ProgressDialog pd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first_activity);
		Intent in=getIntent();
		
		p=in.getStringExtra("`customername`");
		
		t=(TextView)findViewById(R.id.afail);
		 t.setText("Welcome "+p);
        // Sync with online site
       
		
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.logged_screen, menu);
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
	
	public void lout(View view)
	{
		Intent i=new Intent(getApplication(),MainActivity.class);
		sharedpreferences=getSharedPreferences(MyPreferences,Context.MODE_PRIVATE);
		sharedpreferences.edit().clear().commit();
		
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
		i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(i);
	}
	
	public void viewOrder(View view)
	{
		Intent i=new Intent(getApplication(),OrdersList.class);
		i.putExtra("uid",p);
		startActivity(i);	
	}
	
	public void viewBrands(View view)
	{
		
		pd = new ProgressDialog(LoggedScreen.this);
        pd.setMessage("Loading ...");
        pd.setIndeterminate(false);
        pd.setCancelable(false);
        pd.show();
        new Thread(new Runnable() {
        	  @Override
        	  public void run()
        	  {
        	    // do the thing that takes a long time
        		  Intent i=new Intent(getApplication(),BrandList.class);
        			i.putExtra("uid",p);
        		  startActivity(i);	
        	    runOnUiThread(new Runnable() {
        	      @Override
        	      public void run()
        	      {
        	        pd.dismiss();
        	      }
        	    });
        	  }
        	}).start();
		
		
		
	}
	
	public void showCart(View view)
	{
		Intent i=new Intent(getApplication(),CartList.class);
		i.putExtra("uid",p);
		startActivity(i);	
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
	            pDialog = new ProgressDialog(LoggedScreen.this);
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
	            	int s=0;
	                if(json!=null)s=json.getInt("success");
	               
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
