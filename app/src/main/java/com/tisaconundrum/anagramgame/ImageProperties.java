package com.tisaconundrum.anagramgame;

/**
 * Created by tisaconundrum on 10/22/2016.
 */
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
