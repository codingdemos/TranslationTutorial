package com.codingdemos.translationtutorial;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    Spinner mLanguage;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLanguage = (Spinner) findViewById(R.id.spLanguage);
        mTextView = (TextView) findViewById(R.id.textView);
        mAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.language_option));
        mLanguage.setAdapter(mAdapter);

        if (LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("en")) {
            mLanguage.setSelection(mAdapter.getPosition("English"));
        } else if (LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("in")) {
            mLanguage.setSelection(mAdapter.getPosition("Indonesian"));
        } else {
            mLanguage.setSelection(mAdapter.getPosition("Spanish"));
        }

        mLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Context context;
                Resources resources;
                switch (i) {
                    case 0:
                        context = LocaleHelper.setLocale(MainActivity.this, "en");
                        resources = context.getResources();
                        mTextView.setText(resources.getString(R.string.text_translation));
                        break;
                    case 1:
                        context = LocaleHelper.setLocale(MainActivity.this, "in");
                        resources = context.getResources();
                        mTextView.setText(resources.getString(R.string.text_translation));
                        break;
                    case 2:
                        context = LocaleHelper.setLocale(MainActivity.this, "es");
                        resources = context.getResources();
                        mTextView.setText(resources.getString(R.string.text_translation));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase));
    }
}
