package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pytanie> listaPytan = new ArrayList<>();
    private TextView textView;
    private int aktualnePytanie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wypelnijPytania();
        textView = findViewById(R.id.textViewTekstPytania);
        aktualnePytanie = 0;

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


}