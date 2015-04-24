package com.myproject.mobistore;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class BrandList extends Activity {
	String p;
	Dbconn d=new Dbconn(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_gallery);
		Intent in=getIntent();
		p=in.getStringExtra("`customername`");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.brand_list, menu);
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
	
	public void opener(View view)
	{
		ImageButton ib=(ImageButton)view;
		String s=ib.getContentDescription().toString();
		Intent i=new Intent(getApplication(),BrandView.class);
		i.putExtra("brand",s);
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
            pDialog = new ProgressDialog(BrandList.this);
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
