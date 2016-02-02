package com.example.temperatureconverterapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	final String LOG_TAG = "MainScreen";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final EditText et = (EditText)findViewById(R.id.editText);
        int number;
        
        /*if(et1.getText().length()==0){
        Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_LONG).show();
		return;
        }*/
        final TextView result = (TextView) findViewById(R.id.result);
        
        
        Button toCelcius = (Button) findViewById(R.id.ConverttoCelcius);
        toCelcius.setOnClickListener(new OnClickListener() {
        	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Log.e(LOG_TAG, "Inside Celcius");
				try{
					if(et.getText().length()==0){
					      Toast.makeText(MainActivity.this, "Please enter a valid number", Toast.LENGTH_LONG).show();
							return;
					        }
					
				double number = Double.parseDouble(String.valueOf(et.getText()));
				Double answer = (number-32)*5/9;
				result.setText(answer.toString()+ "Degree C");
				
			}catch (Exception e) {
                Log.e(LOG_TAG, "Failed to Convert to Celcius", e);
				
			}
			}

		});
        
        Button toFahrenheit = (Button) findViewById(R.id.ConverttoFahrenheit);
        toFahrenheit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Log.e(LOG_TAG, "Inside Fahrenheit");
				try{
					if(et.getText().length()==0){
					      Toast.makeText(MainActivity.this, "Please enter a valid number", Toast.LENGTH_LONG).show();
							return;
					        }
					double number = Double.parseDouble(String.valueOf(et.getText()));
					Double answer = (number*9)/5+32;
					result.setText(answer.toString()+ "Degree F");
				}catch (Exception e) {
	                Log.e(LOG_TAG, "Failed to convert to Fahrenheit", e);
					
				}
				}
			
		});
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
}
