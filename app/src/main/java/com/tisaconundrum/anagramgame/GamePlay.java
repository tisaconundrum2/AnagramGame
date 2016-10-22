package com.tisaconundrum.anagramgame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by tisaconundrum on 10/21/2016.
 */

public class GamePlay extends Activity implements View.OnClickListener {
    private RelativeLayout gamePlayLayout;
    private String DATA_FILE = "anagrams.txt";
    private ImageView tile1, tile2, tile3, tile4, tile5, tile6, tile7, submit_button;
    private String[] words;
    private int wordsfound = 0;
    private int totalwords = 0;
    boolean tile1_flag = false;
    boolean tile2_flag = false;
    boolean tile3_flag = false;
    boolean tile4_flag = false;

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
        tile1.setImageResource(R.mipmap.alpha_a);                                                       // adding the actual tile images to the board
        tile2.setImageResource(R.mipmap.alpha_p);                                                       // adding the actual tile images to the board
        tile3.setImageResource(R.mipmap.alpha_p);                                                       // adding the actual tile images to the board
        tile4.setImageResource(R.mipmap.alpha_s);                                                       // adding the actual tile images to the board
        try {
            tile1.setOnClickListener(this);                                                             // Listen out for any clicks
            tile2.setOnClickListener(this);                                                             // Listen out for any clicks
            tile3.setOnClickListener(this);                                                             // Listen out for any clicks
            tile4.setOnClickListener(this);                                                             // Listen out for any clicks
            tile5.setOnClickListener(this);                                                             // Listen out for any clicks
            tile6.setOnClickListener(this);                                                             // Listen out for any clicks
            tile7.setOnClickListener(this);                                                             // Listen out for any clicks
            submit_button.setOnClickListener(this);                                                             // Listen out for any clicks
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
    // Override the class that uses onClick
    public void onClick(View arg0) {                                                                    // start of onClick function
        TextView disp = (TextView) findViewById(R.id.tileOutput);                                       // get tileOutput so we can write to it
        Editable str = (Editable) disp.getText();                                                       // str will contain the text that is in it
        switch (arg0.getId()) {                                                                         // start of the switch
            case R.id.tile1:                                                                            // if our first case is tile1
                if (!tile1_flag) {                                                                      // and as long as tile1_flag is false
                    str = str.append('a');                                                              // add 'a' to the str variable
                    disp.setText(str);                                                                  // set the text so the user can see it
                    tile1.setColorFilter(Color.argb(150,200,200,200));
                    tile1_flag = true;                                                                  // set the flag to true, so the user doesn't try and click on it again
                    break;                                                                              // break out of this case
                } else {                                                                                // TODO we need to grey out the tile, so the user knows they clicked on that letter
                    break;                                                                              // TODO two ways to do that, either replace the image OR generate it procedurally
                }
            case R.id.tile2:
                if (!tile2_flag) {
                    str = str.append('p');
                    disp.setText(str);
                    tile2.setColorFilter(Color.argb(150,200,200,200));
                    tile2_flag = true;
                    break;
                } else {
                    break;
                }
            case R.id.tile3:
                if (!tile3_flag) {
                    str = str.append('p');
                    disp.setText(str);
                    tile3.setColorFilter(Color.argb(150,200,200,200));
                    tile3_flag = true;
                    break;
                } else {
                    break;
                }
            case R.id.tile4:
                if (!tile4_flag) {
                    str = str.append('s');
                    disp.setText(str);
                    tile4.setColorFilter(Color.argb(150,200,200,200));
                    tile4_flag = true;
                    break;
                } else {
                    break;
                }
            case R.id.submit_button:
                final TextView textViewNumTokens = (TextView) findViewById(R.id.words_matched);         // set the variable to hold the layout's location
                TextView input = (TextView) findViewById(R.id.tileOutput);                              // after the click pull the string from the tileOutput box
                String submission = input.getText().toString();                                         // convert the string, probably redundant, but gotta make sure
                for (int i = 0; i < words.length; i++) {                                                // going through each word that is in our list
                    if (words[i] != null) {                                                             // and as long as the list is not empty
                        if (words[i].equals(submission)) {                                              // check to see if the string is the same as the string that was typed
                            wordsfound += 1;                                                            // increment our wordsfound
                            textViewNumTokens.setText("Words matched " + wordsfound + "/" + totalwords);// update textViewNumTokens, and let the user know that they found a correct word
                            words[i] = null;                                                            // since we found a correct word, delete it from the list
                        }
                        tile1_flag = false;                                                             // set everything back to false
                        tile2_flag = false;                                                             // so that the user can use the buttons again
                        tile3_flag = false;
                        tile4_flag = false;
                        tile1.setColorFilter(null);
                        tile2.setColorFilter(null);
                        tile3.setColorFilter(null);
                        tile4.setColorFilter(null);
                        disp.setText("");                                                              // also clear the string text

                        if (wordsfound == totalwords) {                                                // TODO: have the user forwarded to the Game_over layout and display score, utilize intent here
                            Intent intent = new Intent(getApplicationContext(),GameOver.class);        // Set the Intent, and switch to GameOver.java
                            startActivity(intent);                                                     // Exit out of MainActivity and to GameActivity
                        }
                    }
                }
                input.setSelectAllOnFocus(true);
                break;
        }

    }
}