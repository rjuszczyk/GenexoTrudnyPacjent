package com.mygdx.genexotrudnypacjent.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.mygdx.genexotrudnypacjent.R;
import com.mygdx.genexotrudnypacjent.adapter.StanowiskoRecyclerViewAdaoter;
import com.mygdx.genexotrudnypacjent.adapter.StoresRecyclerViewAdapter;
import com.mygdx.genexotrudnypacjent.database.DatabaseHelper;
import com.mygdx.genexotrudnypacjent.model.Row;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Radek on 14.07.2016.
 */
public class ChooseStanowiskoDialog extends BaseDialog implements StanowiskoRecyclerViewAdaoter.OnItemClickListener {
    public static String TAG = "ChooseStanowiskoDialogpublic";

    private StanowiskoRecyclerViewAdaoter mStoresRecyclerViewAdapter;

    private RecyclerView mRecyclerView;
    private EditText mSearchView;
    private View mProgressContainer;

    public static ChooseElementDialog createInstance()
    {
        ChooseElementDialog choosePositionDialog = new ChooseElementDialog();
        Bundle bundle = new Bundle();
        return choosePositionDialog;
    }



    public void onRowSelected(String row) {
    }

    protected boolean isTwoLines() {
        return false;
    }

    public ChooseStanowiskoDialog()
    {
        super();



        setStyle(STYLE_NO_TITLE, 0);
    }

    @Override
    public int getLayoutId() {

        return R.layout.dialog_choose_element;
    }

    @Override
    public void initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {




        mRecyclerView = (RecyclerView) mContentView.findViewById(R.id.recycler_view);
        mProgressContainer = mContentView.findViewById(R.id.progress_contianer);
        mSearchView = (EditText) mContentView.findViewById(R.id.search_text);


        mSearchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                query(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        setupList();
    }

    private void hideKeyboard()
    {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity()
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        inputMethodManager.hideSoftInputFromWindow(mSearchView.getApplicationWindowToken(),
                0);
    }

    public void query(CharSequence newText) {
        if (newText.length() > 1) {
            mStoresRecyclerViewAdapter.filter(newText.toString());
            return ;
        }
    }


    boolean storesLoaded = false;
    private void setupList() {
        long time = System.currentTimeMillis();
        if (mRecyclerView != null) {

            LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            mRecyclerView.setLayoutManager(manager);

            mStoresRecyclerViewAdapter = new StanowiskoRecyclerViewAdaoter() {

                @Override
                public String getTextFromRow(String row) {
                    return row;
                }

                public boolean isTwoLinesAdapter() {
                    return isTwoLines();
                }
            };

            mStoresRecyclerViewAdapter.setOnItemClickListener(this);
            mRecyclerView.setAdapter(mStoresRecyclerViewAdapter);

            final Handler handler = new Handler();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final List<String> stores = Arrays.asList("kierownik apteki",
                            "personel farmaceutyczny",
                            "kierownik apteki/personel farmaceutyczny");
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            mStoresRecyclerViewAdapter.setStores(stores);
                            storesLoaded = true;
                            mProgressContainer.setVisibility(View.GONE);
                        }
                    });
                }
            }).start();
        }
        Log.d("loading choose dialog", "took = " + (System.currentTimeMillis() - time));
    }

    @Override
    public void onItemClick(View view, String store) {
        onRowSelected(store);
        dismiss();
    }
}
