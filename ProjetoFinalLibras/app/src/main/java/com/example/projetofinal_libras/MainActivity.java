package com.example.projetofinal_libras;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textNome;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    String usuarioID;
    ArrayList<RecyclerViewList> itemList = new ArrayList<>();
    androidx.recyclerview.widget.RecyclerView conteudos_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conteudos_list = findViewById(R.id.conteudos_list);
        textNome = findViewById(R.id.textNome);
        conteudos_list.setHasFixedSize(true);
        conteudos_list.setLayoutManager(new GridLayoutManager(this, 2));

        itemList = new ArrayList<>();

        itemList.add(new RecyclerViewList(R.drawable.configuracao, "Configuração de Mão"));
        itemList.add(new RecyclerViewList(R.drawable.ponto, "Ponto de Articulação"));
        itemList.add(new RecyclerViewList(R.drawable.movimento, "Movimento"));
        itemList.add(new RecyclerViewList(R.drawable.orientacao, "Orientação"));
        itemList.add(new RecyclerViewList(R.drawable.expressao, "Expressões Facial e Corporal"));
        itemList.add(new RecyclerViewList(R.drawable.iconicidade, "Iconicidade"));
        itemList.add(new RecyclerViewList(R.drawable.sistema, "Sistema de Classificação"));
        itemList.add(new RecyclerViewList(R.drawable.tempo, "Tempo Verbal"));

        ItemAdapter conteudoAdapter = new ItemAdapter(itemList, this);
        conteudos_list.setAdapter(conteudoAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        String userId = usuarioID;
        DatabaseReference userRef = database.child("users").child(userId).child("name");
        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    textNome.setText("Olá, " + dataSnapshot.getValue(String.class) + "!");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                textNome.setText("Olá, usuário!");
            }
        });
    }
}
