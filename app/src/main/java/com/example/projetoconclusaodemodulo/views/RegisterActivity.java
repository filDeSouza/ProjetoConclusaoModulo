package com.example.projetoconclusaodemodulo.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projetoconclusaodemodulo.R;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout txtViewProfileName;
    private TextInputLayout txtViewProfileEmail;
    private TextInputLayout txtViewProfilePasword;
    private TextInputLayout txtViewProfileRepeatPassword;
    private Button buttonProfileRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();

        buttonProfileRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = txtViewProfileName.getEditText().getText().toString();
                String email = txtViewProfileEmail.getEditText().getText().toString();
                String senha = txtViewProfilePasword.getEditText().getText().toString();
                String senhaRepeat = txtViewProfileRepeatPassword.getEditText().getText().toString();

                if (nome.isEmpty()){
                    txtViewProfileName.setErrorEnabled(true);
                    txtViewProfileName.setError(getString(R.string.string_nome_invalido));
                }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    txtViewProfileEmail.setErrorEnabled(true);
                    txtViewProfileEmail.setError(getString(R.string.string_email_invalido));
                }
                else if (!validateSenha(senha)){
                    txtViewProfilePasword.setErrorEnabled(true);
                    txtViewProfilePasword.setError(getString(R.string.string_senha_invalida));
                }else if (senha != senhaRepeat){
                    txtViewProfileRepeatPassword.setErrorEnabled(true);
                    txtViewProfileRepeatPassword.setError(getString(R.string.string_senharepeat_invalido));
                }else {
                    startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                }
            }
        });

    }

    public void initViews(){

        txtViewProfileName = findViewById(R.id.textInputLayoutName);
        txtViewProfileEmail = findViewById(R.id.textInputLayoutEmail);
        txtViewProfilePasword = findViewById(R.id.textInputLayoutPassword);
        txtViewProfileRepeatPassword = findViewById(R.id.textInputLayoutPasswordRepeat);
        buttonProfileRegister = findViewById(R.id.buttonRegister);

    }

    public boolean validateSenha(String senha) {
        return senha.length() > 5;
    }

}
