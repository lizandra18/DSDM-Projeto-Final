package com.example.projetofinal_libras;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConteudoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteudo_page);

        int conteudoPageId = getIntent().getIntExtra("id", 0);

        TextView textPageId = findViewById(R.id.textPageId);
        textPageId.setText("PAGE : " + conteudoPageId);
    }
}