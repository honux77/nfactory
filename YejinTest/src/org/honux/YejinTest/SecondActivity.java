package org.honux.YejinTest;

import android.support.v7.app.ActionBarActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActivity extends ActionBarActivity implements OnClickListener {
	
	private ProgressDialog mProgressDialog;   
	private TextView tv;
	private EditText et;
	  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        
 	   	//bind gui component
		tv = (TextView) findViewById(R.id.textView21);
		et = (EditText)findViewById(R.id.editText21);
        Button btnAsync = (Button) findViewById(R.id.buttonAsync);
        Button btn21 = (Button) findViewById(R.id.button21);
        btnAsync.setOnClickListener(this);
        btn21.setOnClickListener(this);
        
        //get intent & set et
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.SUA_MESSAGE);
        Log.v("+++++++++++++++++++++++++++++++++++++", message);
        et.setText(message);
        
        
        //set progress bar
        mProgressDialog = new ProgressDialog(this);
 	   	mProgressDialog.setIndeterminate(false);
 	   	mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
 	   	


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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


	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.buttonAsync:
			Log.v("*************************", "befure async call");			
			String message = et.getText().toString();					
	        new WebServiceTask().execute(message);
	        Log.v("***********************************", "After aysnc call");
			break;
		default:
	        Log.v("***********************************", "other button");

			return;
		}		
	}
	
	///////////////////////////////////////////////
	// inner class for handle async task
	////////////////////////////////////////////////
	class WebServiceTask extends AsyncTask<String, Void, String>{
		@Override
        protected void onPreExecute(){
            mProgressDialog.show();
        }
		
		@Override
		protected String doInBackground(String... params) {
			String result = "bg " + params[0];
			///////////////////////////////////////
			///////add some network job here//////
			///////////////////////////////////////
			int sleep = 10;
			for(int i = 0 ; i < sleep; i++){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
			Log.v("#######################", "I'm in async task");			
			return result;			
		}
		
		//result --> feed
		protected void onPostExecute(String feed) {
			mProgressDialog.dismiss();
			Log.v("XXXXXXXXXXXXXX", feed);			
			tv.setText(feed);
	    }

		
	}

}
