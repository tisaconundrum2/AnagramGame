package com.tisaconundrum.anagramgame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ImageProperties {
    public boolean titleFlag;
    public String appendLetter;

    ImageProperties(boolean titleFlag, String appendLetter) {
        this.titleFlag = titleFlag;
        this.appendLetter = appendLetter;
    }

    public void setFlag(boolean titleFlag) {
        this.titleFlag = titleFlag;
    }


}

public class GamePlay1 extends Activity implements View.OnClickListener {
    private RelativeLayout gamePlayLayout;
    private String DATA_FILE = "anagrams2.txt";
    private ImageView tile1, tile2, tile3, tile4, tile5, tile6, tile7, submit_button;
    private String[] words;
    private int wordsfound = 0;
    private int totalwords = 0;

    boolean shake_flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);                                                             // tell the Dalvik VM to run your code in addition to the existing code in the onCreate() of the parent class.
        setContentView(R.layout.game_play);                                                             // set xml file of focus
        gamePlayLayout = (RelativeLayout) findViewById(R.id.game_play_layout);                          // get xml file's android:id. I'll be honest, I'm not sure why this needs to be here
        View decorView = getWindow().getDecorView();                                                    // Retrieve the current decor view
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);                                // Make our game full screen, so we don't have to worry about the top bar
        initTiles();                                                                                    // initialize all our tiles, and get them prepped to be worked with
        getInputFile(DATA_FILE);                                                                        // we need our dictionary of words to match against.


    }

    private void initTiles() {
        tile1 = (ImageView) findViewById(R.id.tile1);                                                   // TODO replicate how this is working in a more automated way
        tile2 = (ImageView) findViewById(R.id.tile2);                                                   // getting tiles int place
        tile3 = (ImageView) findViewById(R.id.tile3);                                                   // getting tiles int place
        tile4 = (ImageView) findViewById(R.id.tile4);                                                   // getting tiles int place
        tile5 = (ImageView) findViewById(R.id.tile5);                                                   // getting tiles int place
        tile6 = (ImageView) findViewById(R.id.tile6);                                                   // getting tiles int place
        tile7 = (ImageView) findViewById(R.id.tile7);                                                   // adding the actual tile images to the board
        submit_button = (ImageView) findViewById(R.id.submit_button);
        tile1.setImageResource(R.mipmap.alpha_l);                                                       // adding the actual tile images to the board
        tile2.setImageResource(R.mipmap.alpha_e);                                                       // adding the actual tile images to the board
        tile3.setImageResource(R.mipmap.alpha_a);                                                       // adding the actual tile images to the board
        tile4.setImageResource(R.mipmap.alpha_s);                                                       // adding the actual tile images to the board
        tile5.setImageResource(R.mipmap.alpha_t);                                                       // adding the actual tile images to the board
        falsifyLetters();
        submit_button.setTag(new ImageProperties(true, "submit"));

        try {
            tile1.setOnClickListener(this);                                                             // Listen out for any clicks
            tile2.setOnClickListener(this);                                                             // Listen out for any clicks
            tile3.setOnClickListener(this);                                                             // Listen out for any clicks
            tile4.setOnClickListener(this);                                                             // Listen out for any clicks
            tile5.setOnClickListener(this);                                                             // Listen out for any clicks
            tile6.setOnClickListener(this);                                                             // Listen out for any clicks
            tile7.setOnClickListener(this);                                                             // Listen out for any clicks
            submit_button.setOnClickListener(this);                                                     // Listen out for any clicks
        } catch (Exception ignored) {                                                                   // ignore exceotions that may be thrown

        }

    }

    private void getInputFile(String file) {
        TextView textViewNumTokens = (TextView) findViewById(R.id.words_matched);
        try {                                                                                           // try the file and make sure it exists
            InputStreamReader inputs = new InputStreamReader(getAssets().open(file));                   // input the anagrams.txt file that will be in the src/main/assets directory
            BufferedReader br = new BufferedReader(inputs);                                             // Read the inputs in
            words = br.readLine().split(" ");                                                           // start counting how many words there. We can tell this by the spaces between each word
            //textViewAnagramWord.setText(words[0]);                                                    // TODO, this sets the Anagram text, what we need to do is call a function to populate the tiles when this is ran (Line 84)
            //WE ALREADY PREPOPULATED THE BOARD WITH THE WORD APPS
            //So just use apps as the main word from the dictionary.
            words[0] = null;                                                                            // delete the existence of the word, because we don't want to be reusing it
            totalwords = words.length - 1;                                                              // get our total word count by using the length function
            textViewNumTokens.setText("Words matched " + wordsfound + "/" + totalwords);                // in the xml file textViewNumTokens will now say something like "Words matched 0/152"
            //
        } catch (IOException e) {                                                                       //
            e.printStackTrace();                                                                        // output an error if we can't find the file
        }                                                                                               //
    }

    @Override
    public void onClick(View arg0) {
        TextView disp = (TextView) findViewById(R.id.tileOutput);
        Editable str = (Editable) disp.getText();


        ImageView imageView = (ImageView) arg0;
        ImageProperties imageProperties = (ImageProperties) arg0.getTag();
        if (!imageProperties.titleFlag) {                                                           // if the flag
            str = str.append(imageProperties.appendLetter);                                         //
            disp.setText(str);                                                                      //
            imageView.setColorFilter(Color.argb(150, 200, 200, 200));                               //
            imageProperties.setFlag(true);                                                       //
        }
        if (imageProperties.appendLetter == "submit") {
            final TextView textViewNumTokens = (TextView) findViewById(R.id.words_matched);         // set the variable to hold the layout's location
            TextView input = (TextView) findViewById(R.id.tileOutput);                              // after the click pull the string from the tileOutput box
            String submission = input.getText().toString();                                         // convert the string, probably redundant, but gotta make sure
            for (int i = 0; i < words.length; i++) {                                                // going through each word that is in our list
                if (words[i] != null) {                                                             // and as long as the list is not empty
                    if (words[i].equals(submission)) {                                              // check to see if the string is the same as the string that was typed
                        wordsfound += 1;                                                            // increment our wordsfound
                        textViewNumTokens.setText("Words matched " + wordsfound + "/" + totalwords);// update textViewNumTokens, and let the user know that they found a correct word
                        words[i] = null;                                                            // since we found a correct word, delete it from the list
                        shake_flag = true;
                    }
                    falsifyLetters();
                    nullifyLetters();
                    disp.setText("");                                                              // also clear the string text

                    if (wordsfound == totalwords) {                                                // TODO: have the user forwarded to the Game_over layout and display score, utilize intent here
                        Intent intent = new Intent(getApplication(), GameOver.class);              // Set the Intent, and switch to GameOver.java
                        startActivity(intent);                                                     // Exit out of MainActivity and to GameActivity
                    }
                }
            }
            if (!shake_flag) {
                shake();                                                                           // if they get it right, don't shake, otherwise shake
            }
            shake_flag = false;                                                                    // reset the flag, so we shake again
            input.setSelectAllOnFocus(true);
        }
    }

    private void shake() {
        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        shake.setDuration(GameSettings.SHAKE_DURATION);
        gamePlayLayout = (RelativeLayout) findViewById(R.id.game_play_layout);
        gamePlayLayout.startAnimation(shake);
    }

    private void onRightArrowPressed() {
                                                                                                    //TODO: utilize intent to go forward to next level
    }

    private void onLeftArrowPressed() {
                                                                                                    // TODO: make left arrow visible
                                                                                                    // TODO: utilize intent to go to previous level
    }

    @Override
    public void onBackPressed() {
    }

    public void falsifyLetters(){
        tile1.setTag(new ImageProperties(false, "l"));
        tile2.setTag(new ImageProperties(false, "e"));
        tile3.setTag(new ImageProperties(false, "a"));
        tile4.setTag(new ImageProperties(false, "s"));
        tile5.setTag(new ImageProperties(false, "t"));
        tile6.setTag(new ImageProperties(false, null));
        tile7.setTag(new ImageProperties(false, null));
    }

    public void nullifyLetters(){
        tile1.setColorFilter(null);
        tile2.setColorFilter(null);
        tile3.setColorFilter(null);
        tile4.setColorFilter(null);
        tile5.setColorFilter(null);
        tile6.setColorFilter(null);
        tile7.setColorFilter(null);
    }
}