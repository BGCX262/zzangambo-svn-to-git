package com.ge4.zzangambo;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class zzangamboResultActivity extends Activity {
    private int mGameResult = 0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        
        mGameResult = getIntent().getFlags();
        Log.d("playActivity", "game result : "+Integer.toString(mGameResult));
        
        if(mGameResult == zzangamboPlayActivity.PLAY_WIN)
        {
        	TextView tv = (TextView) findViewById(R.id.result_me_tv);
        	tv.setText("win");
        	
            tv = (TextView) findViewById(R.id.result_cpu_tv);
            tv.setText("lose");
            
        }
        else  if(mGameResult == zzangamboPlayActivity.PLAY_DRAW)
        {
        	TextView tv = (TextView) findViewById(R.id.result_me_tv);
        	tv.setText("draw");
        	
            tv = (TextView) findViewById(R.id.result_cpu_tv);
            tv.setText("draw");
        }
        else
        {
        	TextView tv = (TextView) findViewById(R.id.result_me_tv);
        	tv.setText("lose");
        	
            tv = (TextView) findViewById(R.id.result_cpu_tv);
            tv.setText("win");
        
        }
        
        Button retryBtn = (Button)findViewById(R.id.result_retry);
        
        retryBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        
        Button exitBtn = (Button)findViewById(R.id.result_exit);
        exitBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
				am.restartPackage(getPackageName());

			}
		});
    }
    
}
