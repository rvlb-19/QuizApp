package com.rvlb.quizapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Renato on 27/7/16.
 */
public class PickThemeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_pick_theme, container, false);

        ArrayList<String> themes = new ArrayList<>();
        themes.add(getResources().getString(R.string.theme_option_default));
        themes.add(getResources().getString(R.string.theme_option_1));
        themes.add(getResources().getString(R.string.theme_option_2));
        themes.add(getResources().getString(R.string.theme_option_3));
        themes.add(getResources().getString(R.string.theme_option_4));
        themes.add(getResources().getString(R.string.theme_option_5));
        themes.add(getResources().getString(R.string.theme_option_6));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, themes);

        final Spinner spPickTheme = (Spinner) fragmentView.findViewById(R.id.spPickTheme);
        spPickTheme.setAdapter(adapter);

        Button btPickTheme = (Button) fragmentView.findViewById(R.id.btPickTheme);
        btPickTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = spPickTheme.getSelectedItemPosition();
                if(pos != 0) {
                    LoggedInActivity loggedInActivity = (LoggedInActivity) getActivity();
                    loggedInActivity.resetCorrectAnswers();
                    ArrayList<Question> questions = loggedInActivity.
                            getThemeQuestions(spPickTheme.getSelectedItem().toString());
                    if(questions.isEmpty())
                        Toast.makeText(getActivity(), R.string.no_questions_msg, Toast.LENGTH_LONG).show();
                    else {
                        ((AnswerQuestionFragment) getFragmentManager().
                                findFragmentById(R.id.fgAnswerQuestion)).updateFragment(questions);
                        loggedInActivity.switchLayout(R.id.llPickTheme, R.id.llAnswerQuestion);
                    }
                } else {
                    Toast.makeText(getActivity(), R.string.theme_option_default, Toast.LENGTH_LONG).show();
                }
            }
        });

        return fragmentView;
    }
}
