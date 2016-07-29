package com.rvlb.quizapp;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Renato on 27/7/16.
 */
public class Question {

    private String questionText, theme, answer;
    private int imageId;
    private boolean hasImage;
    private ArrayList<String> answerOptions;

    public Question(String theme, String questionText, boolean hasImage, int imageId, ArrayList<String> answerOptions) {
        this.theme = theme;
        this.questionText = questionText;
        this.hasImage = hasImage;
        this.imageId = imageId;
        this.answerOptions = answerOptions;
        this.answer = this.answerOptions.get(0);
    }

    public String getTheme() {
        return this.theme;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public boolean getHasImage() {
        return this.hasImage;
    }

    public int getImageId() {
        return this.imageId;
    }

    public String getOption(int index) {
        return this.answerOptions.get(index);
    }

    public String getAnswer() {
        return this.answer;
    }

    public void shuffle() {
        ArrayList<String> temp = new ArrayList<>();
        while(!this.answerOptions.isEmpty()) {
            int rand = Math.abs(new Random().nextInt()) % this.answerOptions.size();
            String s = this.answerOptions.get(rand);
            this.answerOptions.remove(rand);
            temp.add(s);
        }
        this.answerOptions = temp;
    }
}
