//package com.tisaconundrum.anagramgame;
//
//import android.app.Activity;
//import android.graphics.Color;
//import android.os.Bundle;
//import android.text.Editable;
//import android.view.View;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//class ImageProperties{
//    public boolean titleFlag;
//    public String appendLetter;
//
//    ImageProperties(boolean titleFlag, String appendLetter){
//        this.titleFlag = titleFlag;
//        this.appendLetter = appendLetter;
//    }
//}
//
//public class GamePlay2 extends Activity implements View.OnClickListener {
//    private RelativeLayout gamePlayLayout;
//    private String DATA_FILE = "anagrams2.txt";
//    private ImageView tile1, tile2, tile3, tile4, tile5, tile6, tile7, submit_button;
//    private String[] words;
//    private int wordsfound = 0;
//    private int totalwords = 0;
//
//    boolean shake_flag = false;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);                                                             // tell the Dalvik VM to run your code in addition to the existing code in the onCreate() of the parent class.
//        setContentView(R.layout.game_play);                                                             // set xml file of focus
//        gamePlayLayout = (RelativeLayout) findViewById(R.id.game_play_layout);                          // get xml file's android:id. I'll be honest, I'm not sure why this needs to be here
//        View decorView = getWindow().getDecorView();                                                    // Retrieve the current decor view
//        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);                                // Make our game full screen, so we don't have to worry about the top bar
//        initTiles();                                                                                    // initialize all our tiles, and get them prepped to be worked with
//        getInputFile(DATA_FILE);                                                                        // we need our dictionary of words to match against.
//
//
//    }
//
//    private void initTiles() {
//        tile1 = (ImageView) findViewById(R.id.tile1);                                                   // TODO replicate how this is working in a more automated way
//        tile2 = (ImageView) findViewById(R.id.tile2);                                                   // getting tiles int place
//        tile3 = (ImageView) findViewById(R.id.tile3);                                                   // getting tiles int place
//        tile4 = (ImageView) findViewById(R.id.tile4);                                                   // getting tiles int place
//        tile5 = (ImageView) findViewById(R.id.tile5);                                                   // getting tiles int place
//        tile6 = (ImageView) findViewById(R.id.tile6);                                                   // getting tiles int place
//        tile7 = (ImageView) findViewById(R.id.tile7);                                                   // adding the actual tile images to the board
//        submit_button = (ImageView) findViewById(R.id.submit_button);
//        tile1.setImageResource(R.mipmap.alpha_l);                                                       // adding the actual tile images to the board
//        tile2.setImageResource(R.mipmap.alpha_e);                                                       // adding the actual tile images to the board
//        tile3.setImageResource(R.mipmap.alpha_a);                                                       // adding the actual tile images to the board
//        tile4.setImageResource(R.mipmap.alpha_s);                                                       // adding the actual tile images to the board
//        tile4.setImageResource(R.mipmap.alpha_t);                                                       // adding the actual tile images to the board
//
//        try {
//            tile1.setOnClickListener(this);                                                             // Listen out for any clicks
//            tile2.setOnClickListener(this);                                                             // Listen out for any clicks
//            tile3.setOnClickListener(this);                                                             // Listen out for any clicks
//            tile4.setOnClickListener(this);                                                             // Listen out for any clicks
//            tile5.setOnClickListener(this);                                                             // Listen out for any clicks
//            tile6.setOnClickListener(this);                                                             // Listen out for any clicks
//            tile7.setOnClickListener(this);                                                             // Listen out for any clicks
//            submit_button.setOnClickListener(this);                                                     // Listen out for any clicks
//        } catch (Exception ignored) {                                                                   // ignore exceotions that may be thrown
//
//        }
//    }
//
//    private void getInputFile(String file) {
//        TextView textViewNumTokens = (TextView) findViewById(R.id.words_matched);
//        try {                                                                                           // try the file and make sure it exists
//            InputStreamReader inputs = new InputStreamReader(getAssets().open(file));                   // input the anagrams.txt file that will be in the src/main/assets directory
//            BufferedReader br = new BufferedReader(inputs);                                             // Read the inputs in
//            words = br.readLine().split(" ");                                                           // start counting how many words there. We can tell this by the spaces between each word
//            //textViewAnagramWord.setText(words[0]);                                                    // TODO, this sets the Anagram text, what we need to do is call a function to populate the tiles when this is ran (Line 84)
//            //WE ALREADY PREPOPULATED THE BOARD WITH THE WORD APPS
//            //So just use apps as the main word from the dictionary.
//            words[0] = null;                                                                            // delete the existence of the word, because we don't want to be reusing it
//            totalwords = words.length - 1;                                                              // get our total word count by using the length function
//            textViewNumTokens.setText("Words matched " + wordsfound + "/" + totalwords);                // in the xml file textViewNumTokens will now say something like "Words matched 0/152"
//            //
//        } catch (IOException e) {                                                                       //
//            e.printStackTrace();                                                                        // output an error if we can't find the file
//        }                                                                                               //
//    }
//
//    @Override
//    public void onClick(View arg0) {
//        TextView disp = (TextView) findViewById(R.id.tileOutput);
//        Editable str = (Editable) disp.getText();
//        ImageView tile1 = (ImageView) findViewById(R.id.tile1);
//        ImageView tile2 = (ImageView) findViewById(R.id.tile2);
//        ImageView tile3 = (ImageView) findViewById(R.id.tile3);
//        ImageView tile4 = (ImageView) findViewById(R.id.tile4);
//        ImageView tile5 = (ImageView) findViewById(R.id.tile5);
//        ImageView tile6 = (ImageView) findViewById(R.id.tile6);
//        ImageView tile7 = (ImageView) findViewById(R.id.tile7);
//        tile1.setTag(new ImageProperties(false, "l"));
//        tile2.setTag(new ImageProperties(false, "e"));
//        tile3.setTag(new ImageProperties(false, "a"));
//        tile4.setTag(new ImageProperties(false, "s"));
//        tile5.setTag(new ImageProperties(false, "t"));
//        tile6.setTag(new ImageProperties(false, null));
//        tile7.setTag(new ImageProperties(false, null));
//
//        ImageView imageView = (ImageView) arg0;
//        ImageProperties imageProperties = (ImageProperties) arg0.getTag();
//        if (!imageProperties.titleFlag) {
//            str = str.append(imageProperties.appendLetter);
//            disp.setText(str);
//            imageView.setColorFilter(Color.argb(150, 200, 200, 200));
//            imageProperties.titleFlag = true;
//        }
//    }
//
//    private void shake() {
//        Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
//        shake.setDuration(GameSettings.SHAKE_DURATION);
//        gamePlayLayout = (RelativeLayout) findViewById(R.id.game_play_layout);
//        gamePlayLayout.startAnimation(shake);
//    }
//
//    private void onRightArrowPressed() {
//    }
//
//    private void onLeftArrowPressed() {
//    }
//
//    @Override
//    public void onBackPressed() {
//    }
//
//}
