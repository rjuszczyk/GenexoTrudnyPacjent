package com.mygdx.genexotrudnypacjent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
public class QuizQuestion3 extends AppCompatActivity {
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

        mUserData.setQuiz_odp2("test2");
        mUserData.setQuiz_odp3("test3");
        gotoNext();
    }
    private void gotoNext() {
        Intent intent = new Intent(this, SendingDataActivity.class);
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
                updateDalej();
            }
        };
        q1.setOnCheckedChangeListener(updateListener);
        q2.setOnCheckedChangeListener(updateListener);
        q3.setOnCheckedChangeListener(updateListener);
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
