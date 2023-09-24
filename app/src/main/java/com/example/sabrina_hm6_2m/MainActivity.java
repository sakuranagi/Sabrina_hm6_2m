package com.example.sabrina_hm6_2m;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView login = findViewById(R.id.login);
        TextView text = findViewById(R.id.text);
        TextView text2 = findViewById(R.id.text2);
        TextView text3 = findViewById(R.id.text3);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        Button button = findViewById(R.id.button);
        TextView text_forgot_password = findViewById(R.id.text_forgot_password);
        TextView text_click_here = findViewById(R.id.text_click_here);
        button.setEnabled(false);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    button.setBackgroundColor(getResources().getColor(R.color.orange));
                    button.setEnabled(true);
                } else {
                    button.setBackgroundColor(getResources().getColor(R.color.grey));
                    button.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();


                if (emailText.equals("admin") && passwordText.equals("admin")) {
                    Toast.makeText(MainActivity.this, "Вы успешно зарегестрировались", Toast.LENGTH_SHORT).show();
                    text.setVisibility(View.VISIBLE);
                    login.setVisibility(View.GONE);
                    text2.setVisibility(View.GONE);
                    text3.setVisibility(View.GONE);
                    email.setVisibility(View.GONE);
                    password.setVisibility(View.GONE);
                    button.setVisibility(View.GONE);
                    text_forgot_password.setVisibility(View.GONE);
                    text_click_here.setVisibility(View.GONE);
                } else {
                    Toast.makeText(MainActivity.this, "Неправельный логин или пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    }
}

