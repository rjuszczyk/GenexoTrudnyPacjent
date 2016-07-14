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
public class QuizQuestion3 extends AppCompatActivity {
    private UserData mUserData;



    @Bind(R.id.input)
    EditText input;

    @Bind(R.id.next)
    View next;

    @OnClick(R.id.next)
    void onNext(View view) {
        mUserData.setQuiz_odp3(input.getText().toString());
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

        setContentView(R.layout.question3);

        ButterKnife.bind(this);

        if(getIntent()!=null) {
            mUserData = (UserData) getIntent().getSerializableExtra("user_data");
            //	Log.d("user data", mUserData.toString());
        }

        updateDalej();
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateDalej();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    void updateDalej() {
        boolean isOk = false;
        if(input.getText().length()>5) {
            isOk = true;
        } else {
            isOk = false;
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
