package com.mygdx.genexotrudnypacjent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

import com.mygdx.genexotrudnypacjent.model.UserData;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Radek on 13.07.2016.
 */
public class QuizQuestion1 extends AppCompatActivity {
    private UserData mUserData;

    @Bind(R.id.q1)
    RadioButton q1;

    @Bind(R.id.q2)
    RadioButton q2;

    @Bind(R.id.q3)
    RadioButton q3;

    @Bind(R.id.q4)
    RadioButton q4;

    @Bind(R.id.input)
    EditText input;

    @Bind(R.id.next)
    View next;

    @OnClick(R.id.next)
    void onNext(View view) {
        if(q4.isChecked()) {
            mUserData.setQuiz_odp1(q4.getText().toString() + " " + input.getText().toString());
        } else if(q3.isChecked()) {
                mUserData.setQuiz_odp1(q3.getText().toString());
        } else if(q2.isChecked()) {
            mUserData.setQuiz_odp1(q2.getText().toString());
        } else if(q1.isChecked()) {
            mUserData.setQuiz_odp1(q1.getText().toString());
        }

        gotoNext();
    }
    private void gotoNext() {
        Intent intent = new Intent(this, QuizQuestion2.class);
        intent.putExtra("user_data", mUserData);
        finish();
        startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.question1);

        ButterKnife.bind(this);

        if(getIntent()!=null) {
            mUserData = (UserData) getIntent().getSerializableExtra("user_data");
            //	Log.d("user data", mUserData.toString());
        }
        input.setEnabled(false);
        input.setAlpha(0.5f);
        updateDalej();
        q4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    select((RadioButton) buttonView);
                }


                if(isChecked) {
                    input.setEnabled(true);
                    input.setAlpha(1f);
                } else {
                    input.setEnabled(false);
                    input.setAlpha(0.5f);
                }
                updateDalej();
            }
        });

        CompoundButton.OnCheckedChangeListener updateListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    select((RadioButton) buttonView);
                }
                updateDalej();
            }
        };


        q1.setOnCheckedChangeListener(updateListener);
        q2.setOnCheckedChangeListener(updateListener);
        q3.setOnCheckedChangeListener(updateListener);

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateDalej();
            }
        });
    }

    void select(RadioButton checkBox) {
        if(checkBox!=q1)
        q1.setChecked(false);
        if(checkBox!=q2)
        q2.setChecked(false);
        if(checkBox!=q3)
        q3.setChecked(false);
        if(checkBox!=q4)
        q4.setChecked(false);
    }

    void updateDalej() {
        boolean isOk = false;
        if(q4.isChecked()) {
            isOk = !input.getText().toString().isEmpty();
        } else {
            isOk = q1.isChecked() || q2.isChecked() || q3.isChecked();
        }

        if(isOk) {
            next.setEnabled(true);
            next.setAlpha(1);
        } else {
            next.setEnabled(false);
            next.setAlpha(0.5f);
        }
    }
}
