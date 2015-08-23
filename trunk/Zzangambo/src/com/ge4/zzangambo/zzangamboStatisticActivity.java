package com.ge4.zzangambo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class zzangamboStatisticActivity extends Activity{
	
	zzangamboStatistic mZzangData = new zzangamboStatistic();		// this data will be used in whole project 
    int index = 0;
    
     
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistic);
 
        mZzangData.load(this);
        
        display();

        // Button
        Button playButton = (Button)findViewById(R.id.Button_init);
        playButton.setOnClickListener(InitListener);        
        Button stateButton = (Button)findViewById(R.id.Button_main);
        stateButton.setOnClickListener(MainListener);    
        
	}

	private void display() {
		// Total
        TextView tv = (TextView)findViewById(R.id.TextTotalRound);
        tv.setText(Integer.toString(mZzangData.getTotalGames()));

        tv = (TextView)findViewById(R.id.TextTotalWin);
        tv.setText(Integer.toString(mZzangData.getTotalWin()));

        // scissor
        tv = (TextView)findViewById(R.id.TextScissorWin);
        tv.setText(Integer.toString(mZzangData.scissorWinCnt));
 
        tv = (TextView)findViewById(R.id.TextScissorLose);
        tv.setText(Integer.toString(mZzangData.scissorLoseCnt));

        // Rock
        tv = (TextView)findViewById(R.id.TextRockWin);
        tv.setText(Integer.toString(mZzangData.rockWinCnt));

        tv = (TextView)findViewById(R.id.TextRockLose);
        tv.setText(Integer.toString(mZzangData.rockLoseCnt));

        // Paper
        tv = (TextView)findViewById(R.id.TextPaperWin);
        tv.setText(Integer.toString(mZzangData.paperWinCnt));

        tv = (TextView)findViewById(R.id.TextPaperLose);
        tv.setText(Integer.toString(mZzangData.paperLoseCnt));
	}	
	
    private OnClickListener InitListener = new OnClickListener() {
        public void onClick(View v) {
            // Retrieve new text preferences.
//        	mZzangData.rockWinCnt = 0;
//        	mZzangData.paperWinCnt = 0;
//        	mZzangData.scissorWinCnt = 0;
//        	
//        	mZzangData.rockLoseCnt = 0;
//        	mZzangData.paperLoseCnt = 0;
//        	mZzangData.scissorLoseCnt = 0;
        	mZzangData.reset(zzangamboStatisticActivity.this);
        	display();
        	
        }
    };
    
    private OnClickListener MainListener = new OnClickListener() {
        public void onClick(View v) {
            // Retrieve new text preferences.
            finish();
        }
    };  	
}


class zzangamboStatistic{
	public final static int SCISSOR = 0;
	public final static int ROCK = 1;
	public final static int PAPER = 2;
	
	// key table
	public final static String ZGB_MAIN_KEY = "ZGB_MAIN_KEY";
	
	public final static String ROCK_WIN_KEY = "ROCK_WIN_KEY";
	public final static String PAPER_WIN_KEY = "PAPER_WIN_KEY";
	public final static String SCISSOR_WIN_KEY = "SCISSOR_WIN_KEY";
	public final static String ROCK_LOSE_KEY = "ROCK_LOSE_KEY";
	public final static String PAPER_LOSE_KEY = "PAPER_LOSE_KEY";
	public final static String SCISSOR_LOSE_KEY = "SCISSOR_LOSE_KEY";
	
	int rockWinCnt;
	int paperWinCnt;
	int scissorWinCnt;
	
	int rockLoseCnt;
	int paperLoseCnt;
	int scissorLoseCnt;
	
	int getTotalWin()
	{
		return rockWinCnt+paperWinCnt+scissorWinCnt;
	}
	
	int getTotalLose()
	{
		return rockLoseCnt+paperLoseCnt+scissorLoseCnt;
	}	
	int getTotalGames()
	{
		return getTotalWin() + getTotalLose();
	}
	
	boolean save(Activity myActivity)
	{
		
		SharedPreferences prefs = myActivity.getSharedPreferences(ZGB_MAIN_KEY, Activity.MODE_WORLD_READABLE | Activity.MODE_WORLD_WRITEABLE);
		SharedPreferences.Editor spe = prefs.edit();
		spe.putInt(ROCK_WIN_KEY, rockWinCnt);
		spe.putInt(PAPER_WIN_KEY, paperWinCnt);
		spe.putInt(SCISSOR_WIN_KEY, scissorWinCnt);
		spe.putInt(ROCK_LOSE_KEY, rockLoseCnt);
		spe.putInt(PAPER_LOSE_KEY, paperLoseCnt);
		spe.putInt(SCISSOR_LOSE_KEY, scissorLoseCnt);
		spe.commit();
		// TODO save persistence
		return true;
	}
	
	boolean load(Activity myActivity)
	{
		// TODO load frompersistence
		SharedPreferences prefs = myActivity.getSharedPreferences(ZGB_MAIN_KEY, Activity.MODE_WORLD_READABLE | Activity.MODE_WORLD_WRITEABLE);
		this.rockWinCnt = prefs.getInt(ROCK_WIN_KEY, 0);
		this.paperWinCnt = prefs.getInt(PAPER_WIN_KEY, 0);
		this.scissorWinCnt = prefs.getInt(SCISSOR_WIN_KEY, 0);
		this.rockLoseCnt = prefs.getInt(ROCK_LOSE_KEY, 0);
		this.paperLoseCnt = prefs.getInt(PAPER_LOSE_KEY, 0);
		this.scissorLoseCnt = prefs.getInt(SCISSOR_LOSE_KEY, 0);
		
		return true;
	}
	
	boolean reset(Activity myActivity)
	{
		this.rockWinCnt = 0;
		this.paperWinCnt = 0;
		this.scissorWinCnt = 0;
		this.rockLoseCnt = 0;
		this.paperLoseCnt = 0;
		this.scissorLoseCnt = 0;
		save(myActivity);
		
		// TODO save persistence
		return true;
	}
}