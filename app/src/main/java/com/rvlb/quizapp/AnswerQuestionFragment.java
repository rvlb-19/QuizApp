package com.rvlb.quizapp;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Renato on 27/7/16.
 */
public class AnswerQuestionFragment extends Fragment {

    private ArrayList<Question> questions;
    private TextView tvQuestionText;
    private ImageView ivQuestionImage;
    private RadioGroup rgQuestionOptions;
    private RadioButton rbOption1, rbOption2, rbOption3, rbOption4, rbOption5;

    private String correctAnswer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_answer_question, container, false);

        this.tvQuestionText = (TextView) fragmentView.findViewById(R.id.tvQuestionText);
        this.ivQuestionImage = (ImageView) fragmentView.findViewById(R.id.ivQuestionImage);

        this.rgQuestionOptions = (RadioGroup) fragmentView.findViewById(R.id.rgQuestionOptions);
        this.rbOption1 = (RadioButton) fragmentView.findViewById(R.id.rbOption1);
        this.rbOption2 = (RadioButton) fragmentView.findViewById(R.id.rbOption2);
        this.rbOption3 = (RadioButton) fragmentView.findViewById(R.id.rbOption3);
        this.rbOption4 = (RadioButton) fragmentView.findViewById(R.id.rbOption4);
        this.rbOption5 = (RadioButton) fragmentView.findViewById(R.id.rbOption5);

        Button btAnswer = (Button) fragmentView.findViewById(R.id.btAnswer);
        btAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rgQuestionOptions.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getActivity(), R.string.no_answer_selected_msg, Toast.LENGTH_LONG).show();
                } else {
                    RadioButton checkedButton = (RadioButton) fragmentView.
                            findViewById(rgQuestionOptions.getCheckedRadioButtonId());
                    if(checkedButton.getText().toString().equals(correctAnswer))
                        ((LoggedInActivity) getActivity()).increaseCorrectAnswers();
                    updateFragment(questions);
                }
            }
        });
        return fragmentView;
    }

    public void updateFragment(ArrayList<Question> questions) {
        if(!questions.isEmpty()) {
            Question q = questions.get(0);

            this.correctAnswer = q.getAnswer();

            if(q.getQuestionText().equals("")) this.tvQuestionText.setVisibility(View.GONE);
            else {
                this.tvQuestionText.setText(q.getQuestionText());
                this.tvQuestionText.setVisibility(View.VISIBLE);
            }

            if(!q.getHasImage()) this.ivQuestionImage.setVisibility(View.GONE);
            else {
                this.ivQuestionImage.setImageResource(q.getImageId());
                this.ivQuestionImage.setVisibility(View.VISIBLE);
            }

            q.shuffle();
            this.rbOption1.setText(q.getOption(0));
            this.rbOption2.setText(q.getOption(1));
            this.rbOption3.setText(q.getOption(2));
            this.rbOption4.setText(q.getOption(3));
            this.rbOption5.setText(q.getOption(4));

            this.rgQuestionOptions.clearCheck();

            questions.remove(0);

            this.questions = questions;

        } else {
            final LoggedInActivity loggedInActivity = (LoggedInActivity) getActivity();
            // Todas as questões selecionadas foram respondidas
            double result;
            if(loggedInActivity.getQntQuestions() == 0) result = 0;
            else result = (100.0*loggedInActivity.getCorrectAnswers())/loggedInActivity.getQntQuestions();
            String formattedResult = String.format(" %.2f", result);

            AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
            dialog.setTitle(getResources().getString(R.string.quiz_result_title));
            dialog.setMessage(getResources().getString(R.string.quiz_result_text) + formattedResult + "%");
            dialog.setNeutralButton(getResources().getString(R.string.label_ok),
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            loggedInActivity.resetCorrectAnswers();
                            loggedInActivity.switchLayout(R.id.llAnswerQuestion, R.id.llPickTheme);
                        }
                    });
            dialog.show();
        }
    }
}