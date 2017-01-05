package com.kevin.tech.textinputdemo;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener {
    private TextInputLayout mTextInputUserName, mTextInputPassword;
    private EditText mUserName, mEmail;
    private TextInputEditText mPassword;
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextInputUserName = (TextInputLayout) findViewById(R.id.text_input_user_name);
        mTextInputPassword = (TextInputLayout) findViewById(R.id.text_input_password);
        mUserName = (EditText) findViewById(R.id.et_user_name);
        mEmail = (EditText) findViewById(R.id.et_email);
        mPassword = (TextInputEditText) findViewById(R.id.text_input_et_password);
        mLogin = (Button) findViewById(R.id.btn_login);

        mTextInputUserName.setCounterEnabled(true);
        mTextInputUserName.setCounterMaxLength(10);

        mPassword.addTextChangedListener(this);
        mLogin.setOnClickListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence sequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence sequence, int i, int i1, int i2) {
        mTextInputPassword.setErrorEnabled(false);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onClick(View view) {
        String passwordText = mPassword.getText().toString();
        if (!TextUtils.isEmpty(passwordText) && passwordText.length() < 6) {
            mTextInputPassword.setError(getString(R.string.password_error));
            mPassword.setError(getString(R.string.password_error));
           // mPassword.setError(getString(R.string.password_error),getDrawable(R.mipmap.ic_launcher));//Call requires API level 21
        }
    }
}
