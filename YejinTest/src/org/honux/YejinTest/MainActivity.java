package org.honux.YejinTest;



import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity implements OnClickListener {
    public final static String SUA_MESSAGE = "SUA MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(this);
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
    	int id = v.getId();
    	Log.v("++++++++++++++++++++++++++++++++", "ID" + id);
    	Intent i = new Intent(this, SecondActivity.class);
    	EditText et = (EditText)findViewById(R.id.editText1);
    	String str = et.getText().toString();
    	Log.v("+++++++++++++++++++++++++++++++++++", str);
    	i.putExtra(SUA_MESSAGE, str);
    	startActivity(i);
    }
}
