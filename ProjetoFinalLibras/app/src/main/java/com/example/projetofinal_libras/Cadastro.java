package com.example.projetofinal_libras;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Cadastro extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText cadastrarEmail, cadastrarSenha;
    private Button cadastrarButton;
    private TextView redirecionaLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);

        auth = FirebaseAuth.getInstance();
        cadastrarEmail = findViewById(R.id.cadastrar_email);
        cadastrarSenha = findViewById(R.id.cadastrar_senha);
        cadastrarButton = findViewById(R.id.cadastrar_button);
        redirecionaLogin = findViewById(R.id.redireciona_login);

        cadastrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = cadastrarEmail.getText().toString().trim();
                String senha = cadastrarSenha.getText().toString().trim();

                if (usuario.isEmpty()){
                    cadastrarEmail.setError("Informe um email");
                }
                if (senha.isEmpty()){
                    cadastrarSenha.setError("Informe uma senha");
                }else {
                    auth.createUserWithEmailAndPassword(usuario, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Cadastro.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Cadastro.this, Login.class));
                            } else {
                                Toast.makeText(Cadastro.this, "Falha ao tentar cadastrar novo usuário", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        redirecionaLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Cadastro.this, Login.class));
            }
        });
    }
}