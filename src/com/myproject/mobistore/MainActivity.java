package com.myproject.mobistore;



import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;


import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
	
	int sto=0;
	EditText u,p;
	String s1,s2;
	Button b;
	Dbconn d=new Dbconn(this);
	TextView t;
	private ProgressDialog pDialog=null;	
	List<NameValuePair> params1 = new ArrayList<NameValuePair>();
	private String url_2 = "http://moboworld.esy.es/json4.php";
	
	public static final String MyPreferences="mypref";
	public static final String user="username";
	public static final String pass="password";
	
	SharedPreferences sharedpreferences;
	
	AlertDialog.Builder builder1;
	@Override
	protected void onResume() 
	{
		
	      sharedpreferences=getSharedPreferences(MyPreferences,Context.MODE_PRIVATE);
	      if (sharedpreferences.contains(user))
	      {
	      if(sharedpreferences.contains(pass)){
	         Intent i = new Intent(this,LoggedScreen.class);
	         i.putExtra("`customername`",sharedpreferences.getString(user, null));
	         startActivity(i);
	      }
	      }
	      super.onResume();
	   }
	
	

	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.activity_main);
        u=(EditText)findViewById(R.id.disptext);
        p=(EditText)findViewById(R.id.editText2);
        t=(TextView)findViewById(R.id.afail);
        
    }
    
    
    
    public void authenticator(View view)
    {
    	s1=u.getText().toString();
    	s2=p.getText().toString();
    	
    	if(s1.length()>0 && s2.length()>0)
    	{
    		String out=d.loginToDB(s1, s2);
    	   
    		if(out=="Login Failed")
    		{
    			t.setText("Authentication Failed");
    		}
    	 	else
    		{
    	 		Editor editor = sharedpreferences.edit();
    	 		editor.putString(user,s1);
    	 		editor.putString(pass,s2);
    	 		editor.commit();
    	 		new LoadAllProducts().execute();
    		
    		}
    	}
    }
    
    public void onPause(){
    	super.onPause();
    	
    	if(pDialog!=null)
    	{
    		pDialog.dismiss();
    	}
    }
    
    public void popper(View view)
    {
    	
    	


    	builder1 = new AlertDialog.Builder(this);

    	// Setting OK Button
    	builder1.setPositiveButton("Close", new DialogInterface.OnClickListener() {
    	        public void onClick(DialogInterface dialog, int which) {
    	        // Write your code here to execute after dialog closed
    	        dialog.dismiss();
    	        }
    	});


    	
    	LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.form_popup,null);
    	// Setting Dialog Title
    	final EditText e1,e2,e3,e44,e5,e6,e7;
    	final RadioButton r1;
    	
    	e1=(EditText)layout.findViewById(R.id.editText1);
    	e2=(EditText)layout.findViewById(R.id.editText2);
    	e3=(EditText)layout.findViewById(R.id.editText3);
    	e44=(EditText)layout.findViewById(R.id.editText4);
    	e5=(EditText)layout.findViewById(R.id.editText5);
    	e6=(EditText)layout.findViewById(R.id.editText6);
    	e7=(EditText)layout.findViewById(R.id.editText7);
    	
    	r1=(RadioButton)layout.findViewById(R.id.male);
    	
    	
    	
    	
    	
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setTitle("Sign up");
    	builder.setView(layout);
        builder.setPositiveButton("Sign up", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            	String gender;
            	if(r1.isChecked())gender="male";
            	else gender="female";
            	
            	params1.add(new BasicNameValuePair("name", e1.getText().toString()));
            	params1.add(new BasicNameValuePair("gender", gender));
            	params1.add(new BasicNameValuePair("age",e2.getText().toString()));
            	params1.add(new BasicNameValuePair("add", e3.getText().toString()));
            	params1.add(new BasicNameValuePair("mob", e44.getText().toString()));
            	params1.add(new BasicNameValuePair("email", e5.getText().toString()));
            	params1.add(new BasicNameValuePair("user", e6.getText().toString()));
            	params1.add(new BasicNameValuePair("pass", e7.getText().toString()));
                
            	dialog.dismiss();
            	new signon().execute();
       
            	
            	
                //save info where you want it
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
// Setting Dialog Message


dialog.show();


// Showing Alert Message

    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       //getMenuInflater().inflate(R.menu.main, menu);
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
    	
    	private String url_all = "http://moboworld.esy.es/json1.php";
        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
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
            JSONObject json=null;
            try
            {
             json = jParser.makeHttpRequest(url_all, "GET", params);
            }
            catch(Exception e){
            	e.printStackTrace();
            }
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
            Intent i=new Intent(getApplication(),LoggedScreen.class);
    		i.putExtra("`customername`",s1);
    		startActivity(i);

        }

    }
    
class signon extends AsyncTask<String, String, String> {
    	
    	JSONParser jParser = new JSONParser();
    	private String url_all = "http://moboworld.esy.es/json1.php";
    	List<NameValuePair> params = new ArrayList<NameValuePair>();
        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Processing..Please wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        /**
         * getting All products from url
         * */
        protected String doInBackground(String... args) {
           
            JSONObject json=null,json1=null;
            try
            {
             json1 = jParser.makeHttpRequest(url_2, "POST", params1);
             json = jParser.makeHttpRequest(url_all, "GET", params);
            }
            catch(Exception e){
            	e.printStackTrace();
            }
            // Check your log cat for JSON reponse
            //Log.d("All Products: ", json.toString());

            try {
                // Checking for SUCCESS TAG
            	sto=0;
                if(json1!=null && json!=null)sto=json1.getInt("success");
                
                if(sto==1)
                {
                d.replacedb(json);	
                }
                
                if(sto==1)
            	{
            		builder1.setMessage("Account Created!");
            	}
            	else if(sto==2)
            	{
            		builder1.setMessage("Username already Exists!");
            	}
            	else
            	{
            		builder1.setMessage("Connection Error");
            	}
                
                } 
             catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        
        protected void onPostExecute(String file_url) {
            
            pDialog.dismiss();
            
            AlertDialog a=builder1.create();
        	a.show();

        }

    }
}



