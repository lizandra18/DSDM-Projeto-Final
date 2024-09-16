package com.example.projetofinal_libras;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<RecyclerViewList> itemList = new ArrayList<>();
    androidx.recyclerview.widget.RecyclerView conteudos_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conteudos_list = findViewById(R.id.conteudos_list);
        conteudos_list.setHasFixedSize(true);
        conteudos_list.setLayoutManager(new GridLayoutManager(this, 2));

        itemList = new ArrayList<RecyclerViewList>();


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

}