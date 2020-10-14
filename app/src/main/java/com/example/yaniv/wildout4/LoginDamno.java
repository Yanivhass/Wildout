package com.example.yaniv.wildout4;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginDamno extends android.app.Activity {
    EditText EmailEt, PasswordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_damno);
        EmailEt = (EditText)findViewById(R.id.email);
        PasswordEt = (EditText)findViewById(R.id.password);
        }


    public void OnLogin(View view) {
        String email = EmailEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String type = "login";
        BackgroundWorkerLogin backgroundWorker = new BackgroundWorkerLogin(this);
        backgroundWorker.execute(type,email,password);

    }


}