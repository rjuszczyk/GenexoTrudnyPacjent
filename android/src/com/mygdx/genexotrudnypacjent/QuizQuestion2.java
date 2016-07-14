package com.mygdx.genexotrudnypacjent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
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
public class QuizQuestion2 extends AppCompatActivity {
    private UserData mUserData;

    @Bind(R.id.q1)
    RadioButton q1;

    @Bind(R.id.q2)
    RadioButton q2;

    @Bind(R.id.q3)
    RadioButton q3;

    @Bind(R.id.q5)
    RadioButton q5;

    @Bind(R.id.q6)
    RadioButton q6;

    @Bind(R.id.q4)
    RadioButton q4;

    void select(RadioButton checkBox) {
        if(checkBox!=q1)
            q1.setChecked(false);
        if(checkBox!=q2)
            q2.setChecked(false);
        if(checkBox!=q3)
            q3.setChecked(false);
        if(checkBox!=q4)
            q4.setChecked(false);
        if(checkBox!=q5)
            q5.setChecked(false);
        if(checkBox!=q6)
            q6.setChecked(false);
    }


    @Bind(R.id.input)
    EditText input;

    @Bind(R.id.input2)
    EditText input2;

    @Bind(R.id.input3)
    EditText input3;

    @Bind(R.id.next)
    View next;

    @OnClick(R.id.next)
    void onNext(View view) {
        if(q4.isChecked()) {
            mUserData.setQuiz_odp2(q4.getText().toString() + " " + input.getText().toString());
        } else  if(q2.isChecked()) {
            mUserData.setQuiz_odp2(q2.getText().toString() + " " + input2.getText().toString());
        } else  if(q3.isChecked()) {
            mUserData.setQuiz_odp2(q3.getText().toString() + " " + input3.getText().toString());
        } else if(q5.isChecked()) {
                mUserData.setQuiz_odp2(q5.getText().toString());
        } else if(q6.isChecked()) {
            mUserData.setQuiz_odp2(q6.getText().toString());
        } else if(q1.isChecked()) {
            mUserData.setQuiz_odp2(q1.getText().toString());
        }

        mUserData.setQuiz_odp3("test3");
        gotoNext();
    }
    private void gotoNext() {
        Intent intent = new Intent(this, QuizQuestion3.class);
        intent.putExtra("user_data", mUserData);
        finish();
        startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.question2);

        ButterKnife.bind(this);

        if(getIntent()!=null) {
            mUserData = (UserData) getIntent().getSerializableExtra("user_data");
            //	Log.d("user data", mUserData.toString());
        }
        input.setEnabled(false);
        input.setAlpha(0.5f);
        input2.setEnabled(false);
        input2.setAlpha(0.5f);
        input3.setEnabled(false);
        input3.setAlpha(0.5f);
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

        q2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    select((RadioButton) buttonView);
                }

                if(isChecked) {
                    input2.setEnabled(true);
                    input2.setAlpha(1f);
                } else {
                    input2.setEnabled(false);
                    input2.setAlpha(0.5f);
                }
                updateDalej();
            }
        });
        q3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    select((RadioButton) buttonView);
                }

                if(isChecked) {
                    input3.setEnabled(true);
                    input3.setAlpha(1f);
                } else {
                    input3.setEnabled(false);
                    input3.setAlpha(0.5f);
                }
                updateDalej();
            }
        });

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
        q5.setOnCheckedChangeListener(updateListener);
        q6.setOnCheckedChangeListener(updateListener);

        TextWatcher updateDalejWatcher = new TextWatcher() {
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
        };

        input.addTextChangedListener(updateDalejWatcher);
        input2.addTextChangedListener(updateDalejWatcher);
        input3.addTextChangedListener(updateDalejWatcher);
    }


    void updateDalej() {
        boolean isOk = false;
        if(q4.isChecked()) {
            isOk = !input.getText().toString().isEmpty();
        } else if(q2.isChecked()) {
            isOk = !input2.getText().toString().isEmpty();
        } else if(q3.isChecked()) {
            isOk = !input3.getText().toString().isEmpty();
        } else {
                isOk = q1.isChecked() || q5.isChecked() || q6.isChecked();            
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
