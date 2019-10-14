package com.example.projetoconclusaodemodulo.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.example.projetoconclusaodemodulo.R;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputLogin;
    private TextInputLayout textInputPassword;
    private Button butaoLogin;
    private Button butaoRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initViews();

        butaoLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String email = textInputLogin.getEditText().getText().toString();
                String senha = textInputPassword.getEditText().getText().toString();

                if (Patterns.EMAIL_ADDRESS.matcher(email).matches() && !senha.isEmpty()){
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    textInputLogin.setErrorEnabled(true);
                    textInputLogin.setError(getString(R.string.string_email_invalido));
                }else if (!validateSenha(senha)){
                    textInputPassword.setErrorEnabled(true);
                    textInputPassword.setError(getString(R.string.string_senha_invalida));
                }


            }
        });

        butaoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

    }

    private void initViews() {

        textInputLogin = findViewById(R.id.textInputLayoutEmail);
        textInputPassword = findViewById(R.id.textInputLayoutPassword);
        butaoLogin = findViewById(R.id.buttonLogin);
        butaoRegister = findViewById(R.id.buttonRegister);

    }

    public boolean validateSenha(String senha) {
        return senha.length() > 5;
    }

}
