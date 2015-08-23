package com.ge4.zzangambo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class zzangamboMainActivity extends Activity 
{
	zzangamboStatistic mZzangData = new zzangamboStatistic();		// this data will be used in whole project 
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button playButton = (Button)findViewById(R.id.ButtonPlay);
        playButton.setOnClickListener(playListener);        
        Button stateButton = (Button)findViewById(R.id.ButtonState);
        stateButton.setOnClickListener(stateListener);    
    
    }
    
    private OnClickListener playListener = new OnClickListener() {
        public void onClick(View v) {
            // Retrieve new text preferences.
            Intent intent = new Intent(zzangamboMainActivity.this, zzangamboPlayActivity.class);
            startActivity(intent);
        }
    };
    
    private OnClickListener stateListener = new OnClickListener() {
        public void onClick(View v) {
            // Retrieve new text preferences.
            Intent intent = new Intent(zzangamboMainActivity.this, zzangamboStatisticActivity.class);
            startActivity(intent);
        }
    };    
}