package com.example.projetofinal_libras;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment1 extends Fragment {
    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment1, container, false);


        TextView textViewContent = view.findViewById(R.id.textViewContent);


        textViewContent.setText(
                "A modalidade gestual-visual-espacial da LIBRAS leva, muitas vezes, as pessoas a" +
                "pensarem que todos os sinais são um “desenho no ar” daquilo a que se referem." +
                "É claro que, em função da sua natureza linguística, a realização de um sinal pode" +
                "ser motivada pelas características do dado da realidade que representa, mas isso" +
                "não é uma regra." +
                "\n"+
                "A grande maioria dos sinais da LIBRAS é arbitrária, ou seja, não mantém relação" +
                "de semelhança alguma com seu referente. Assim, para ficar claro, vamos" +
                "conhecer alguns conceitos:\n" +
                "\n"+
                "Iconicidade – sinais icônicos são aqueles em que o gesto reproduz ou faz" +
                "alusão à imagem do seu referente.\n" +
                "Como exemplo, temos CASA, e TELEFONE.");

        return view;
    }
}
