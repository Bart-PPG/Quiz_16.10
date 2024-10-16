package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pytanie> listaPytan = new ArrayList<>();
    private TextView textView;
    private int aktualnePytanie;
    private Button buttonNastepne;
    private Button buttonTak;
    private Button buttonNie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wypelnijPytania();
        textView = findViewById(R.id.textViewTekstPytania);
        aktualnePytanie = 0;
        wstawPytanie(aktualnePytanie);

        buttonTak = findViewById(R.id.button);
        buttonTak.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sprawdzToPytanie(true);
                    }
                }
        );
        buttonNie = findViewById(R.id.button2);
        buttonNie.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                sprawdzToPytanie(false);
                            }
                        }
                );

        buttonNastepne = findViewById(R.id.button4);
        buttonNastepne.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        aktualnePytanie++;
                        if (aktualnePytanie == listaPytan.size()){
                            buttonNastepne.setVisibility((View.INVISIBLE));
                            buttonTak.setVisibility((View.INVISIBLE));
                            buttonNie.setVisibility((View.INVISIBLE));
                            int ile = podliczPunkty();
                        textView.setText("koniec quizu otrzymales " +String.valueOf(ile) +" punktow");
                        }
                        else{
                            wstawPytanie(aktualnePytanie);
                        }


                    }
                }
        );

    }
    private void  sprawdzToPytanie(boolean odpowiedzUzutkownika){
        if(listaPytan.get(aktualnePytanie).isPoprawna() == odpowiedzUzutkownika){
            listaPytan.get(aktualnePytanie).setUdzielonoPoprawnaOdpowiedz(true);
        }
    }
    private void wstawPytanie(int i){
        Pytanie pytanie = listaPytan.get(i);
        textView.setText(pytanie.getTresc());
    }



private  void wypelnijPytania(){
    listaPytan.add(new Pytanie("czy sekwoje moze miec 100 metrow wysokosci?","Sekwoje sa bardzo wyskoie",true));
    listaPytan.add(new Pytanie("czy najgrubsze drzewo ma obwod 10m","obwod najgrubszego pnia ma 44m",false));
    listaPytan.add(new Pytanie("Czy drzewa sa pochlaniaczem tlenu ?","zastanow sie czym jest fotosynteza",false));
}
private int podliczPunkty(){
        int ilePunktow = 0;
        for (Pytanie pytanie : listaPytan){
            if (pytanie.isUdzielonoPoprawnaOdpowiedz()){
                ilePunktow++;
            }
        }
        return ilePunktow;
    }

}