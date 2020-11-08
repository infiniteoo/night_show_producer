/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerdemo;

/**
 *
 * @author troy
 */
public class LogElement {

    private String artistName;
    private String songTitle;
    private String introTime;
    private String outroTime;
    private String totalTime;
    private String fileName;

    public LogElement(String artist, String title, String intro, String outro, String total, String file) {
        this.artistName = artist;
        this.songTitle = title;
        this.introTime = intro;
        this.outroTime = outro;
        this.totalTime = total;
        this.fileName = file;

    }

    public String getArtistName() {
        return this.artistName;
    }

    public String getSongTitle() {
        return this.songTitle;
    }

    public String getIntroTime() {
        return this.introTime;
    }

    public String getTotalTime() {
        return this.totalTime;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getOutroTime() {
        return this.outroTime;
    }

}
