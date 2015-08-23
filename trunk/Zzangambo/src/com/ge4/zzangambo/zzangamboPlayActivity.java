package com.ge4.zzangambo;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class zzangamboPlayActivity extends Activity {
	
	// constant for play
	public final static int ROCK = 0;
	public final static int PAPER = 1;
	public final static int SCISSOR = 2;

	
	// constant for Result activity
	public final static String PLAY_RESULT_KEY = "ZZANG_PLAY_RESULT";
	public final static int PLAY_LOSE = 0;
	public final static int PLAY_WIN = 1;
	public final static int PLAY_DRAW = 2;

	
	zzangamboStatistic mZzangData = new zzangamboStatistic();		// this data will be used in whole project 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);

        // Watch for button clicks.
        ImageButton goButtonScissor = (ImageButton)findViewById(R.id.ImageButtonScissor);
        goButtonScissor.setOnClickListener(mGoListenerScissor);

        ImageButton goButtonRock = (ImageButton)findViewById(R.id.ImageButtonRock);
        goButtonRock.setOnClickListener(mGoListenerRock);
        
        ImageButton goButtonPaper = (ImageButton)findViewById(R.id.ImageButtonPaper);
        goButtonPaper.setOnClickListener(mGoListenerPaper);
        
        mZzangData.load(this);
    }

    private OnClickListener mGoListenerScissor = new OnClickListener()
    {
    	int game_result = 0;// lozi123
    	
        public void onClick(View v)
        {
        	Intent intent = new Intent();
        	Random random = new Random();
        	int mSelect = (int) random.nextInt(3);
        	
        	switch(mSelect)
        	{
        		case zzangamboStatistic.SCISSOR :
        			Toast.makeText(zzangamboPlayActivity.this, "draw!!!", Toast.LENGTH_SHORT).show();
        			break;
        			
        		case zzangamboStatistic.ROCK :
        			game_result = PLAY_LOSE;// lozi123
        			mZzangData.scissorLoseCnt++;
        			mZzangData.save(zzangamboPlayActivity.this);
        			
        			intent.setClass(zzangamboPlayActivity.this, zzangamboResultActivity.class);
        			intent.setFlags(game_result);		// lozi123
                    startActivity(intent);
        			break;
        			
        		case zzangamboStatistic.PAPER :
        			game_result = PLAY_WIN;// lozi123
        			mZzangData.scissorWinCnt++;
        			mZzangData.save(zzangamboPlayActivity.this);
        			intent.setClass(zzangamboPlayActivity.this, zzangamboResultActivity.class);
        			intent.setFlags(game_result);		// lozi123
                    startActivity(intent);
        			break;
        		
        		default :
        			break;
        	}
        }
    };

    private OnClickListener mGoListenerRock = new OnClickListener()
    {
    	int game_result = 0;
    	
        public void onClick(View v)
        {
        	Intent intent = new Intent();
        	Random random = new Random();
        	int mSelect = (int) random.nextInt(3); 
        	
        	switch(mSelect)
        	{
        		case zzangamboStatistic.SCISSOR :
        			game_result = PLAY_WIN;
        			mZzangData.rockWinCnt++;
        			mZzangData.save(zzangamboPlayActivity.this);
        			intent.setClass(zzangamboPlayActivity.this, zzangamboResultActivity.class);
        			intent.setFlags(game_result);
                    startActivity(intent);
        			break;
        			
        		case zzangamboStatistic.ROCK :
        			Toast.makeText(zzangamboPlayActivity.this, "draw!!!", Toast.LENGTH_SHORT).show();
        			break;
        			
        		case zzangamboStatistic.PAPER :
        			game_result = PLAY_LOSE;
        			mZzangData.rockLoseCnt++;
        			mZzangData.save(zzangamboPlayActivity.this);
        			intent.setClass(zzangamboPlayActivity.this, zzangamboResultActivity.class);
        			intent.setFlags(game_result);
                    startActivity(intent);
        			break;
        			
        		default :
        			break;
        	}
        }
    };
    
    private OnClickListener mGoListenerPaper = new OnClickListener()
    {
    	int game_result = 0;
    	
        public void onClick(View v)
        {
        	Intent intent = new Intent();
        	Random random = new Random();
        	int mSelect = (int) random.nextInt(3);
        	
        	switch(mSelect)
        	{
        		case zzangamboStatistic.SCISSOR :
        			game_result = PLAY_LOSE;

        			mZzangData.paperLoseCnt++;
        			mZzangData.save(zzangamboPlayActivity.this);
        			intent.setClass(zzangamboPlayActivity.this, zzangamboResultActivity.class);
        			intent.setFlags(game_result);
                    startActivity(intent);
        			break;
        			
        		case zzangamboStatistic.ROCK :
        			game_result = PLAY_WIN;
        			mZzangData.paperWinCnt++;
        			mZzangData.save(zzangamboPlayActivity.this);
        			intent.setClass(zzangamboPlayActivity.this, zzangamboResultActivity.class);
        			intent.setFlags(game_result);
                    startActivity(intent);
        			break;
        			
        		case zzangamboStatistic.PAPER :
        			Toast.makeText(zzangamboPlayActivity.this, "draw!!!", Toast.LENGTH_SHORT).show();
        			break;
        			
        		default :
        			break;  			
        	}
        }
    };
}

