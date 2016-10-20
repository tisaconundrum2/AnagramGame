package com.tisaconundrum.anagramgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by tisaconundrum on 10/17/2016.
 */

public class GamePlay extends AppCompatActivity {
    private String DATA_FILE = "anagrams.txt"
    private Integer totalwords = 0;
    private Integer wordsfound = 0;
    private String[] words;
    private TextView textViewNumTokens;
    private TextView textViewAnagramWord;
    private TextView textViewWordLabel;
    private TextView textViewUsernameTitle;
    private String username;
    private RelativeLayout gamePlayLayout;
    private Button alpha_a, alpha_b, alpha_c, alpha_d, alpha_e, alpha_f, alpha_g, alpha_h, alpha_i, alpha_j, alpha_k, alpha_l, alpha_m, alpha_n, alpha_o, alpha_p, alpha_q, alpha_r, alpha_s, alpha_t, alpha_u, alpha_v, alpha_w, alpha_x, alpha_y, alpha_z;
    private String[] alphaStrings = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private Button[] buttons;
    ImageView buttonSubmit = (ImageView) findViewById(R.id.submit_button);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_play);
        gamePlayLayout = (RelativeLayout) findViewById(R.id.game_play_layout);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        getInputFile(DATA_FILE);

    }

    public void initTiles() {
        for (int i = 0; i < 27; i++) {
            String buttonID = "alpha_" + alphaStrings[i];
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = ((Button) findViewById(resID));
            buttons[i].setOnClickListener((View.OnClickListener) this);
        }
    }

    private void getInputFile(String file) {
        try {                                                                                           // try the file and make sure it exists
            InputStreamReader inputs = new InputStreamReader(getAssets().open(file));                   // input the anagrams.txt file that will be in the src/main/assets directory
            BufferedReader br = new BufferedReader(inputs);                                             // Read the inputs in
            words = br.readLine().split(" ");                                                           // start counting how many words there. We can tell this by the spaces between each word
            textViewAnagramWord.setText(words[0]);                                                      // TODO, this sets the Anagram text, what we need to do is call a function to populate the tiles
            words[0] = null;                                                                            // delete the existence of the word, because we don't want to be reusing it
            totalwords = words.length - 1;                                                              // get our total word count by using the length function
            textViewNumTokens.setText(wordsfound + "/" + totalwords);                                   // in the xml file textViewNumTokens will now say something like 0/152
            //
        } catch (IOException e) {                                                                       //
            e.printStackTrace();                                                                        // output an error if we can't find the file
        }                                                                                               //
    }

    private void resetTiles() {
    }

    private void nextWorld() {
    }

    private void prevWord() {
    }

    private void submit() {
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View sub) {                                                             // click to submit the typed word
                TextView input = (TextView) findViewById(R.id.tileOutput);                              // after the click pull the string from editTextUserInput box
                String submission = input.getText().toString();                                         // convert the pulled string
                //
                for (int i = 0; i < words.length; i++) {                                                // going through each word that is in our list
                    if (words[i] != null) {                                                             // and as long as the list is not empty
                        if (words[i].equals(submission)) {                                              // check to see if the string is the same as the string that was typed
                            wordsfound += 1;                                                            // increment our wordsfound
                            textViewNumTokens.setText(wordsfound + "/" + totalwords);                   // update textViewNumTokens, and let the user know that they found a correct word
                            words[i] = null;                                                            // since we found a correct word, delete it from the list
                        }
                        if (wordsfound == totalwords) {                                                 // TODO: have the user fowarded to the Game_over layout and display score
                            //textViewUsernameTitle.setText("Great Job " + helpers.toTitleCase(username) + "!");
                            //textViewWordLabel.setText("");
                            //textViewAnagramWord.setText("You're the bestest!");
                            //input.setText("");
                        }
                    }
                }
                input.setSelectAllOnFocus(true);
            }
        });
    }


}