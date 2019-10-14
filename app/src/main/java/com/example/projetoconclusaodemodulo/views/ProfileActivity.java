package com.example.projetoconclusaodemodulo.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projetoconclusaodemodulo.R;
import com.google.android.material.textfield.TextInputLayout;

public class ProfileActivity extends AppCompatActivity {

    private TextInputLayout txtViewProfileName;
    private TextInputLayout txtViewProfileEmail;
    private TextInputLayout txtViewProfilePasword;
    private TextInputLayout txtViewProfileRepeatPassword;
    private Button buttonProfileRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViews();

        buttonProfileRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, HomeActivity.class));
            }
        });

    }

    public void initViews(){

        txtViewProfileName = findViewById(R.id.textInputLayoutProfileName);
        txtViewProfileEmail = findViewById(R.id.textInputLayoutProfileEmail);
        txtViewProfilePasword = findViewById(R.id.textInputLayoutProfilePassword);
        txtViewProfileRepeatPassword = findViewById(R.id.textInputLayoutProfilePasswordRepeat);
        buttonProfileRegister = findViewById(R.id.buttonProfileRegister);

    }

}
