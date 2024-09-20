package com.example.projetofinal_libras;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment1 extends Fragment {
    private static final String ARG_ITEM_ID = "item_id";
    private int itemId;

    public static Fragment1 newInstance(int itemId) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putInt(ARG_ITEM_ID, itemId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            itemId = getArguments().getInt(ARG_ITEM_ID);
        }
    }

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment1, container, false);

        TextView textViewContent = view.findViewById(R.id.textViewContent);

        SharedPreferences sharedPref = requireActivity().getSharedPreferences("ContentPrefs", requireContext().MODE_PRIVATE);

        int savedItemId = sharedPref.getInt("savedItemId", -1);

        if (savedItemId != -1) {
            itemId = savedItemId;
        }

        switch (itemId) {
            case 0:
                textViewContent.setText("Para cada sinal feito, uma ou as duas mãos podem assumir uma forma específica." +
                        "Muitas vezes, essa forma pode ser a mesma do alfabeto manual (de A até Z) ou dos números (de 0 até 9)," +
                        "embora haja algumas outras formas diferentes usadas. Alguns sinais usam a forma do número cinco," +
                        "outros do número quatro, outros da letra I, outras da letra C e assim por diante. Se você sempre" +
                        "identificar essas formas da mão, será mais fácil gravar os sinais por associação.\n" +
                        "\n" +
                        "O sinal pode ser feito pela mão dominante (direita para destros e esquerda para canhotos), ou pelas" +
                        "duas mãos. Alguns sinais podem ter a mesma configuração das mãos, mas serem produzidos em lugares" +
                        "diferentes do corpo ou espaço neutro.\n" +
                        "\n" +
                        "Por exemplo, os sinais APRENDER, SÁBADO e DESODORANTE-SPRAY têm a mesma configuração de mão e são" +
                        "realizados em pontos de articulação diferentes: testa, boca e axila, respectivamente.");
                break;
            case 1:
                textViewContent.setText("É o lugar onde a mão já configurada é posicionada. A mão pode tocar, bater ou ser" +
                        "posicionada em um ponto inicial da qual deslizará para outro ponto do corpo. Pode, ainda, ser" +
                        "posicionada em um espaço neutro à frente ou ao lado do corpo, seja na direita, na esquerda, em cima," +
                        "no meio ou embaixo.");
                break;
            case 2:
                textViewContent.setText("Explicação para Movimento");
                break;
            case 3:
                textViewContent.setText("Explicação para Orientação");
                break;
            case 4:
                textViewContent.setText("Explicação para Expressões Facial e Corporal");
                break;
            case 5:
                textViewContent.setText("Explicação para Iconicidade");
                break;
            case 6:
                textViewContent.setText("Explicação para Sistema de Classificação");
                break;
            case 7:
                textViewContent.setText("Explicação para Tempo Verba");
                break;
            default:
                textViewContent.setText("Conteúdo padrão");
                break;
        }

        return view;
    }

}
