package com.leojr.languagedemo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.leojr.languagedemo.Helper.LanguageHelper;
import com.leojr.languagedemo.common.CommonVls;


public class MainActivity extends AppCompatActivity {

    private Button btnChangeLanguage;
    private TextView tvLanguage;
    private Button btnNewActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChangeLanguage = (Button) findViewById(R.id.btn_change_language);
        tvLanguage = (TextView) findViewById(R.id.tv_language);
        btnNewActivity = (Button) findViewById(R.id.btn_start_new_test);

        tvLanguage.setText(getString(R.string.test_language));
        btnChangeLanguage.setText(getString(R.string.btn_change_language));
        btnNewActivity.setTag(getString(R.string.btn_start_new_activity));

        btnChangeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lang = LanguageHelper.getLanguage(MainActivity.this);
                if (lang.equals(CommonVls.ENGLISH)){
                    updateViews(CommonVls.VIETNAMESE);
                }else {
                    updateViews(CommonVls.ENGLISH);
                }

            }
        });
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MainActivity.this, TestLanguageActivity.class);
                startActivity(mIntent);
                finish();
            }
        });
    }

    private void updateViews(String languageCode) {
        Context context = LanguageHelper.setLocale(this,languageCode);
        Resources resources = context.getResources();

        tvLanguage.setText(resources.getString(R.string.test_language));
        btnChangeLanguage.setText(resources.getString(R.string.btn_change_language));
        btnNewActivity.setText(resources.getString(R.string.btn_start_new_activity));
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LanguageHelper.onAttach(newBase));
    }
}
