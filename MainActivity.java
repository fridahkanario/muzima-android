package com.example.fridah.uploadmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.net.URL;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
	//Inspections of elements made to ensure options menu clicked
        if (id == R.id.action_settings) {
            return true;
        }else if(id==R.id.item1){
        	//Execute POST and send data to server
            ProcessQueueuDataHandler.POST( new URL("server/url"),"newObs","oldObs", new Date());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
