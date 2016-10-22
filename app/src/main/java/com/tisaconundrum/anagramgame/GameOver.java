package com.tisaconundrum.anagramgame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by tisaconundrum on 10/17/2016.
 */

public class GameOver extends AppCompatActivity{
    private RelativeLayout gameOverLayout;
    private TextView titleLeft;
    private TextView titleMiddle;
    private TextView titleRight;
    private Animation compileAnimation;
    private ImageView homebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        gameOverLayout = (RelativeLayout) findViewById(R.id.game_over_layout);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        if(getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        titleAnimate();
        homebutton();
    }

    private void homebutton() {
        {
            homebutton = (ImageView) findViewById(R.id.home_button);
            homebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Intent settingsIntent = new Intent(GameOver.this, MainMenu.class);
                                settingsIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION); //this checks that all animations are done before moving foward
                                startActivity(settingsIntent);
                            } catch (Exception e){
                                System.err.println(e.getMessage());
                            }
                        }
                    }, GameSettings.START_NEW_ACTIVITY_DURATION);

                }
            });
        }

    }

    private void titleAnimate(){
        titleLeft = (TextView) findViewById(R.id.anagram_left);
        titleMiddle = (TextView) findViewById(R.id.title_game_over);
        titleRight = (TextView) findViewById(R.id.anagram_right);

        compileAnimation = AnimationUtils.loadAnimation(GameOver.this, R.anim.back_anim_for_title_left);
        compileAnimation.setDuration(GameSettings.ANIMATION_HIDE_TITLE_DURATION);
        compileAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        titleLeft.startAnimation(compileAnimation);

        compileAnimation = AnimationUtils.loadAnimation(GameOver.this, R.anim.back_anim_for_title_right);
        compileAnimation.setDuration(GameSettings.ANIMATION_HIDE_TITLE_DURATION);
        compileAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        titleRight.startAnimation(compileAnimation);

        compileAnimation = AnimationUtils.loadAnimation(GameOver.this, R.anim.back_anim_for_title_middle);
        compileAnimation.setDuration(GameSettings.ANIMATION_HIDE_TITLE_DURATION);
        compileAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        titleMiddle.startAnimation(compileAnimation);
    }
}