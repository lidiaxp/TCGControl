package com.example.lidiaxp.tcgcontrol;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class campo extends AppCompatActivity {
    private CountDownTimer countDownTimer;
    private boolean timerHasStarted = false;
    private final long startTime = 5 * 500;
    private final long interval = 1 * 1000;
    private AlertDialog alerta;
    private AlertDialog alertaa;
    private TextView round;
    private TextView hp1;
    private TextView hp2;
    private TextView hp3;
    private TextView hp4;
    private TextView hp5;
    private TextView hp6;
    private ImageButton moeda;
    private ImageButton dormir1;
    private ImageButton fogo1;
    private ImageButton paralisado1;
    private ImageButton confuso1;
    private ImageButton veneno1;
    private ImageButton fechar2;
    private ImageButton dormir2;
    private ImageButton fogo2;
    private ImageButton paralisado2;
    private ImageButton confuso2;
    private ImageButton veneno2;
    private ImageButton fechar3;
    private ImageButton dormir3;
    private ImageButton fogo3;
    private ImageButton paralisado3;
    private ImageButton confuso3;
    private ImageButton veneno3;
    private ImageButton fechar4;
    private ImageButton dormir4;
    private ImageButton fogo4;
    private ImageButton paralisado4;
    private ImageButton confuso4;
    private ImageButton veneno4;
    private ImageButton fechar5;
    private ImageButton dormir5;
    private ImageButton fogo5;
    private ImageButton paralisado5;
    private ImageButton confuso5;
    private ImageButton veneno5;
    private ImageButton fechar6;
    private ImageButton dormir6;
    private ImageButton fogo6;
    private ImageButton paralisado6;
    private ImageButton confuso6;
    private ImageButton veneno6;

    private int vida[] = {0,0,0,0,0,0,0,0,0,0,0,0};
    private int Sparalisado[] = {0,0,0,0,0,0,0,0,0,0,0,0};
    private int Squeimado[] = {0,0,0,0,0,0,0,0,0,0,0,0};
    private int Sadormceido[] = {0,0,0,0,0,0,0,0,0,0,0,0};
    private int Sconfuso[] = {0,0,0,0,0,0,0,0,0,0,0,0};
    private int Senvenenado[] = {0,0,0,0,0,0,0,0,0,0,0,0};
    private int Dqueimado = 20;
    private int Dconfuso = 30;
    private int Denvenenado[] = {0,0,0,0,0,0,0,0,0,0,0,0};

    private int clicado = 0;
    private int rounds = 1;
    private ImageView lose;
    private SharedPreferences save;
    private SharedPreferences.Editor editor;
    private RelativeLayout campo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campo);

        //----------------salvando-----------------------
        save = getSharedPreferences("save", Context.MODE_PRIVATE);
        for(int i = 0; i < 12; i++){
            vida[i] = save.getInt("vida" + i, 0);
            Sparalisado[i] = save.getInt("Sparalisado" + i, 0);
            Squeimado[i] = save.getInt("Squeimado" + i, 0);
            Sadormceido[i] = save.getInt("Sadormceido" + i, 0);
            Sconfuso[i] = save.getInt("Sconfuso" + i, 0);
            Senvenenado[i] = save.getInt("Senvenenado" + i, 0);
            Denvenenado[i] = save.getInt("Denvenenado" + i, 0);
        }
        rounds = save.getInt("roundy", 1);
        clicado = save.getInt("clicado", 0);

        //----------------contadores----------------------
        countDownTimer = new MyCountDownTimer(startTime, interval);

        //--------definindo variaveis---------------------
        lose = (ImageView) findViewById(R.id.lose);
        moeda = (ImageButton) findViewById(R.id.moeda);
        round = (TextView) findViewById(R.id.round);
        hp1 = (TextView) findViewById(R.id.hp1);
        hp2 = (TextView) findViewById(R.id.hp2);
        hp3 = (TextView) findViewById(R.id.hp3);
        hp4 = (TextView) findViewById(R.id.hp4);
        hp5 = (TextView) findViewById(R.id.hp5);
        hp6 = (TextView) findViewById(R.id.hp6);
        campo = (RelativeLayout) findViewById(R.id.oi);
        lose = (ImageView) findViewById(R.id.lose);
        dormir1 = (ImageButton) findViewById(R.id.dormir1);
        fogo1 = (ImageButton) findViewById(R.id.fogo1);
        paralisado1 = (ImageButton) findViewById(R.id.paralisado1);
        confuso1 = (ImageButton) findViewById(R.id.confuso1);
        veneno1 = (ImageButton) findViewById(R.id.veneno1);
        fechar2 = (ImageButton) findViewById(R.id.fechar2);
        dormir2 = (ImageButton) findViewById(R.id.dormir2);
        fogo2 = (ImageButton) findViewById(R.id.fogo2);
        paralisado2 = (ImageButton) findViewById(R.id.paralisado2);
        confuso2 = (ImageButton) findViewById(R.id.confuso2);
        veneno2 = (ImageButton) findViewById(R.id.veneno2);
        fechar3 = (ImageButton) findViewById(R.id.fechar3);
        dormir3 = (ImageButton) findViewById(R.id.dormir3);
        fogo3 = (ImageButton) findViewById(R.id.fogo3);
        paralisado3 = (ImageButton) findViewById(R.id.paralisado3);
        confuso3 = (ImageButton) findViewById(R.id.confuso3);
        veneno3 = (ImageButton) findViewById(R.id.veneno3);
        fechar4 = (ImageButton) findViewById(R.id.fechar4);
        dormir4 = (ImageButton) findViewById(R.id.dormir4);
        fogo4 = (ImageButton) findViewById(R.id.fogo4);
        paralisado4 = (ImageButton) findViewById(R.id.paralisado4);
        confuso4 = (ImageButton) findViewById(R.id.confuso4);
        veneno4 = (ImageButton) findViewById(R.id.veneno4);
        fechar5 = (ImageButton) findViewById(R.id.fechar5);
        dormir5 = (ImageButton) findViewById(R.id.dormir5);
        fogo5 = (ImageButton) findViewById(R.id.fogo5);
        paralisado5 = (ImageButton) findViewById(R.id.paralisado5);
        confuso5 = (ImageButton) findViewById(R.id.confuso5);
        veneno5 = (ImageButton) findViewById(R.id.veneno5);
        fechar6 = (ImageButton) findViewById(R.id.fechar6);
        dormir6 = (ImageButton) findViewById(R.id.dormir6);
        fogo6 = (ImageButton) findViewById(R.id.fogo6);
        paralisado6 = (ImageButton) findViewById(R.id.paralisado6);
        confuso6 = (ImageButton) findViewById(R.id.confuso6);
        veneno6 = (ImageButton) findViewById(R.id.veneno6);

        //--------------posiçao da tela--------------
        turn();

        //-------------iniciando-------------------
        lose.setVisibility(View.GONE);

        //---------------setando o do save---------------
        if(rounds%2==1 || rounds == 1){
            interfaceCondicoes();
            texto(0);
            round.setText("Round " + rounds);
        }else{
            interfaceCondicoes();
            texto(6);
            round.setText("Round " + rounds);
        }
    }

    public void cima1(View v){
     if(rounds % 2 == 1){
         vida[0] += 10;
         hp1.setText(vida[0] + "HP");
     }else{
         vida[6] += 10;
         hp1.setText(vida[6] + "HP");
     }
    }

    public void baixo1(View v){
        if(rounds % 2 == 1){
            if(vida[0] > 5){
                vida[0] -= 10;
                hp1.setText(vida[0] + "HP");
            }else{
                morreu(0, v);
            }
        }else{
            if(vida[6] > 5){
                vida[6] -= 10;
                hp1.setText(vida[6] + "HP");
            }else{
                morreu(6, v);
            }
        }
    }

    public void cima2(View v){
        if(rounds % 2 == 1){
            if(vida[0] > 0){
                vida[1] += 10;
                hp2.setText(vida[1] + "HP");
            }else{
                Toast.makeText(campo.this, "Você precisa de um Pokémon  principal", Toast.LENGTH_SHORT).show();
            }
        }else{
            if(vida[0] > 0){
                vida[7] += 10;
                hp2.setText(vida[7] + "HP");
            }else{
                Toast.makeText(campo.this, "Você precisa de um Pokémon  principal", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void baixo2(View v){
        if(rounds % 2 == 1){
            if(vida[1] > 5){
                vida[1] -= 10;
                hp2.setText(vida[1] + "HP");
            }else{
                morreu(1, v);
            }
        }else{
            if(vida[7] > 5){
                vida[7] -= 10;
                hp2.setText(vida[7] + "HP");
            }else{
                morreu(7, v);
            }
        }
    }

    public void cima3(View v){
        if(rounds % 2 == 1){
            if(vida[0] > 0){
                vida[2] += 10;
                hp3.setText(vida[2] + "HP");
            }else{
                Toast.makeText(campo.this, "Você precisa de um Pokémon  principal", Toast.LENGTH_SHORT).show();
            }
        }else{
            if(vida[0] > 0){
                vida[8] += 10;
                hp3.setText(vida[8] + "HP");
            }else{
                Toast.makeText(campo.this, "Você precisa de um Pokémon  principal", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void baixo3(View v){
        if(rounds % 2 == 1){
            if(vida[2] > 5){
                vida[2] -= 10;
                hp3.setText(vida[2] + "HP");
            }else{
                morreu(2, v);
            }
        }else{
            if(vida[8] > 5){
                vida[8] -= 10;
                hp3.setText(vida[8] + "HP");
            }else{
                morreu(8, v);
            }
        }
    }

    public void cima4(View v){
        if(rounds % 2 == 1){
            if(vida[0] > 0){
                vida[3] += 10;
                hp4.setText(vida[3] + "HP");
            }else{
                Toast.makeText(campo.this, "Você precisa de um Pokémon  principal", Toast.LENGTH_SHORT).show();
            }
        }else{
            if(vida[0] > 0){
                vida[9] += 10;
                hp4.setText(vida[9] + "HP");
            }else{
                Toast.makeText(campo.this, "Você precisa de um Pokémon  principal", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void baixo4(View v){
        if(rounds % 2 == 1){
            if(vida[3] > 5){
                vida[3] -= 10;
                hp4.setText(vida[3] + "HP");
            }else{
                morreu(3, v);
            }
        }else{
            if(vida[9] > 5){
                vida[9] -= 10;
                hp4.setText(vida[9] + "HP");
            }else{
                morreu(9, v);
            }
        }
    }

    public void cima5(View v){
        if(rounds % 2 == 1){
            if(vida[0] > 0){
                vida[4] += 10;
                hp5.setText(vida[4] + "HP");
            }else{
                Toast.makeText(campo.this, "Você precisa de um Pokémon  principal", Toast.LENGTH_SHORT).show();
            }
        }else{
            if(vida[0] > 0){
                vida[10] += 10;
                hp5.setText(vida[10] + "HP");
            }else{
                Toast.makeText(campo.this, "Você precisa de um Pokémon  principal", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void baixo5(View v){
        if(rounds % 2 == 1){
            if(vida[4] > 5){
                vida[4] -= 10;
                hp5.setText(vida[4] + "HP");
            }else{
                morreu(4, v);
            }
        }else{
            if(vida[10] > 5){
                vida[10] -= 10;
                hp5.setText(vida[10] + "HP");
            }else{
                morreu(10, v);
            }
        }
    }

    public void cima6(View v){
        if(rounds % 2 == 1){
            if(vida[0] > 0){
                vida[5] += 10;
                hp6.setText(vida[5] + "HP");
            }else{
                Toast.makeText(campo.this, "Você precisa de um Pokémon  principal", Toast.LENGTH_SHORT).show();
            }
        }else{
            if(vida[0] > 0){
                vida[11] += 10;
                hp6.setText(vida[11] + "HP");
            }else{
                Toast.makeText(campo.this, "Você precisa de um Pokémon  principal", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void baixo6(View v){
        if(rounds % 2 == 1){
            if(vida[5] > 5){
                vida[5] -= 10;
                hp6.setText(vida[5] + "HP");
            }else{
                morreu(5, v);
            }
        }else{
            if(vida[11] > 5){
                vida[11] -= 10;
                hp6.setText(vida[11] + "HP");
            }else{
                morreu(11, v);
            }
        }
    }

    public void dormir1(View v){
        if(rounds%2==1){
            dormir(0);
        }else{
           dormir(6);
        }
    } // n pode recuar + moeda

    public void veneno1(final View v){
        if(rounds%2==1){
            veneno(0);
            for(int i = 0; i < Senvenenado[0]/10; i++){
                baixo1(v);
            }
        }else{
            veneno(6);
            for(int i = 0; i < Senvenenado[6]/10; i++){
                baixo6(v);
            }
        }
    }  // dano

    public void fogo1(View v){
        if(rounds%2==1){
            fogo(0);
        }else{
            fogo(6);
        }
    } // moeda + dano

    public void paralisado1(View v){
        if(rounds%2==1){
            paralisado(0);
        }else{
            paralisado(6);
        }
    } // n pode recuar + so dura um turno

    public void confuso1(View v){
        if(rounds%2==1){
           confuso(0);
        }else{
            confuso(6);
        }
    } //moeda antes d atacar

    public void dormir2(View v){
        if(rounds%2==1){//    n pode recuar + moeda
            dormir(1);
        }else{
            dormir(7);
        }
    }

    public void veneno2(View v){
        if(rounds%2==1){
            veneno(1);
            for(int i = 0; i < Senvenenado[1]/10; i++){
                baixo2(v);
            }
        }else{
            veneno(7);
            for(int i = 0; i < Senvenenado[7]/10; i++){
                baixo2(v);
            }
        }
    }

    public void fogo2(View v){
        if(rounds%2==1){
            fogo(1);
        }else{
            fogo(7);
        }
    }

    public void paralisado2(View v){
        if(rounds%2==1){
            paralisado(1);
        }else{
            paralisado(7);
        }
    }

    public void confuso2(View v){
        if(rounds%2==1){
            confuso(1);
        }else{
            confuso(7);
        }
    }

    public void dormir3(View v){
        if(rounds%2==1){//    n pode recuar + moeda
            dormir(2);
        }else{
            dormir(8);
        }
    }

    public void veneno3(View v){
        if(rounds%2==1){
            veneno(2);
            for(int i = 0; i < Senvenenado[2]/10; i++){
                baixo3(v);
            }
        }else{
            veneno(2);
            for(int i = 0; i < Senvenenado[8]/10; i++){
                baixo3(v);
            }
        }
    }

    public void fogo3(View v){
        if(rounds%2==1){
            fogo(2);
        }else{
            fogo(8);
        }
    }

    public void paralisado3(View v){
        if(rounds%2==1){
            paralisado(2);
        }else{
            paralisado(8);
        }
    }

    public void confuso3(View v){
        if(rounds%2==1){
            confuso(2);
        }else{
            confuso(8);
        }
    }

    public void dormir4(View v){
        if(rounds%2==1){//    n pode recuar + moeda
            dormir(3);
        }else{
            dormir(9);
        }
    }

    public void veneno4(View v){
        if(rounds%2==1){
            veneno(3);
            for(int i = 0; i < Senvenenado[3]/10; i++){
                baixo4(v);
            }
        }else{
            veneno(9);
            for(int i = 0; i < Senvenenado[9]/10; i++){
                baixo4(v);
            }
        }
    }

    public void fogo4(View v){
        if(rounds%2==1){
            fogo(3);
        }else{
            fogo(9);
        }
    }

    public void paralisado4(View v){
        if(rounds%2==1){
            paralisado(3);
        }else{
            paralisado(9);
        }
    }

    public void confuso4(View v){
        if(rounds%2==1){
            confuso(3);
        }else{
            confuso(9);
        }
    }

    public void dormir5(View v){
        if(rounds%2==1){//    n pode recuar + moeda
            dormir(4);
        }else{
            dormir(10);
        }
    }

    public void veneno5(View v){
        if(rounds%2==1){
            veneno(4);
            for(int i = 0; i < Senvenenado[4]/10; i++){
                baixo5(v);
            }
        }else{
            veneno(10);
            for(int i = 0; i < Senvenenado[10]/10; i++){
                baixo5(v);
            }
        }
    }

    public void fogo5(View v){
        if(rounds%2==1){
            fogo(4);
        }else{
            fogo(10);
        }
    }

    public void paralisado5(View v){
        if(rounds%2==1){
            paralisado(4);
        }else{
            paralisado(10);
        }
    }

    public void confuso5(View v){
        if(rounds%2==1){
            confuso(4);
        }else{
            confuso(10);
        }
    }

    public void dormir6(View v){
        if(rounds%2==1){//    n pode recuar + moeda
            dormir(5);
        }else{
            dormir(11);
        }
    }

    public void veneno6(View v){
        if(rounds%2==1){
            veneno(5);
            for(int i = 0; i < Senvenenado[5]/10; i++){
                baixo6(v);
            }
        }else{
            veneno(11);
            for(int i = 0; i < Senvenenado[11]/10; i++){
                baixo6(v);
            }
        }
    }

    public void fogo6(View v){
        if(rounds%2==1){
            fogo(5);
        }else{
            fogo(11);
        }
    }

    public void paralisado6(View v){
        if(rounds%2==1){
            paralisado(5);
        }else{
            paralisado(11);
        }
    }

    public void confuso6(View v){
        if(rounds%2==1){
            confuso(5);
        }else{
            confuso(11);
        }
    }

    public void dormir(int pokemon){
        if(vida[pokemon] > 0){
            Sconfuso[pokemon] = 0;
            Sparalisado[pokemon] = 0;
            Sadormceido[pokemon] = Sadormceido[pokemon] == 0? 1 : 0;
            interfaceCondicoes();
        }else{
            Toast.makeText(campo.this, "Não tem pokémon neste campo", Toast.LENGTH_SHORT).show();
        }
    }

    public void veneno (final int pokemon){
        if (vida[pokemon] > 0) {
            Senvenenado[pokemon] = Senvenenado[pokemon] == 0 ? 1 : 0;
            if(Senvenenado[pokemon] == 1){
                ArrayList<String> itens = new ArrayList<String>();
                itens.add("10");
                itens.add("20");
                itens.add("30");
                ArrayAdapter adapter = new ArrayAdapter(campo.this, R.layout.item_alerta, itens);
                AlertDialog.Builder builder = new AlertDialog.Builder(campo.this);
                builder.setTitle("De quanto é esse envenenamento?");
                builder.setSingleChoiceItems(adapter, 0, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        if (arg1 == 2) {
                            Denvenenado[pokemon] = 30;
                        } else if (arg1 == 1) {
                            Denvenenado[pokemon] = 20;
                        } else {
                            Denvenenado[pokemon] = 10;
                        }
                        alerta.dismiss();
                    }
                });
                alerta = builder.create();
                alerta.show();
            }
            interfaceCondicoes();
        } else {
            Toast.makeText(campo.this, "Não tem pokémon neste campo", Toast.LENGTH_SHORT).show();
        }
    }

    public void fogo(int pokemon){
        if(vida[pokemon] > 0){
            Squeimado[pokemon] = Squeimado[pokemon] == 0 ? 1 : 0;
            interfaceCondicoes();
        }else{
            Toast.makeText(campo.this, "Não tem pokémon neste campo", Toast.LENGTH_SHORT).show();
        }
    }

    public void paralisado(int pokemon){
        if(vida[pokemon] > 0){
            Sconfuso[pokemon] = 0;
            Sadormceido[pokemon] = 0;
            Sparalisado[pokemon] = Sparalisado[pokemon] == 0? 1 : 0;
            interfaceCondicoes();
        }else{
            Toast.makeText(campo.this, "Não tem pokémon neste campo", Toast.LENGTH_SHORT).show();
        }
    }

    public void confuso(int pokemon){
        if(vida[pokemon] > 0){
            Sparalisado[pokemon] = 0;
            Sadormceido[pokemon] = 0;
            Sconfuso[pokemon] = Sconfuso[pokemon] == 0? 1 : 0;
            interfaceCondicoes();
        }else{
            Toast.makeText(campo.this, "Não tem pokémon neste campo", Toast.LENGTH_SHORT).show();
        }
    }

    public void reinicie(){
        for (int i = 0; i < 12; i++) {
            zerarVariaveis(i);
        }

        rounds = 1;
        round.setText("Round " + rounds);

        clicado = 0;

        hp1.setText(vida[0] + " HP");
        hp2.setText(vida[1] + " HP");
        hp3.setText(vida[2] + " HP");
        hp4.setText(vida[3] + " HP");
        hp5.setText(vida[4] + " HP");
        hp6.setText(vida[5] + " HP");

        interfaceCondicoes();

        campo.setRotation(0);

    }

    public void reiniciar(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(campo.this);
        builder.setMessage("Você tem certeza que deseja reiniciar essa partida?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                reinicie();
                lose.setVisibility(View.INVISIBLE);
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                alerta.dismiss();
            }
        });
        alerta = builder.create();
        alerta.show();
    }

    public void vez(final View v){
        int aux = turn() == 1? 0 : 6;
        int aux2 = turn() == 1? 6 : 0;
        int dano = 0;
        int dano2 = 0;

        if(Senvenenado[aux] == 1){
            dano += Denvenenado[aux] * 2;
        }

        if(Senvenenado[aux2] == 1){
            dano2 += Denvenenado[aux] * 2;
        }

        if(Squeimado[aux] == 1){
            if(!moedin()){ //cara
                dano += Dqueimado;
            }
        }

        if(Squeimado[aux2] == 1){
            if(!moedin()){ //cara
                dano2 += Dqueimado;
            }
        }

        if(Sadormceido[aux] == 1){
            if(moedin()){
                Sadormceido[aux] = 0;
                interfaceCondicoes();
            }
        }

        if(Sadormceido[aux2] == 1){
            if(moedin()){
                Sadormceido[aux2] = 0;
                interfaceCondicoes();
            }
        }

        Sparalisado[aux] = Sparalisado[aux] == 1 ? 0 : 0;
        interfaceCondicoes();

        /*if(Sconfuso[aux] == 1){
            if(!moedin()){
                dano += Dconfuso;
            }
        }*/

        vida[aux] -= dano;
        vida[aux2] -= dano2;
        texto(aux);

        rounds += 1;
        round.setText("Round " + rounds);
        aux = aux == 0 ? 6 : 0;
        texto(aux);
        turn();

        //---------------checando vida-------------
        if(vida[0] <= 0 && rounds > 3){
            campo.setRotation(0);
            lose.setVisibility(View.VISIBLE);
            reinicie();
        }else if (vida[6] <= 0 && rounds > 3){
            campo.setRotation(180);
            lose.setVisibility(View.VISIBLE);
            reinicie();
        }

        interfaceCondicoes();
    }

    public int turn(){
        if (rounds % 2 == 1) {//1 jogador
            campo.setRotation(0);
        } else {//2 jogador
            campo.setRotation(180);
        }
        return rounds % 2;
    }

    public void principalMorreu(final int pokemon, final View v){
        ArrayList<String> itens = new ArrayList<String>();
        itens.add("Não tenho mais Pokémon");
        itens.add("1");
        itens.add("2");
        itens.add("3");
        itens.add("4");
        itens.add("5");
        ArrayAdapter adapter = new ArrayAdapter(campo.this, R.layout.item_alerta, itens);
        AlertDialog.Builder builder = new AlertDialog.Builder(campo.this);
        builder.setTitle("Você tem algum pokémon para substituí-lo?");
        builder.setSingleChoiceItems(adapter, 0, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                if (arg1 == 0) {
                    lose.setVisibility(View.VISIBLE);
                    reinicie();
                } else if (arg1 == 1) {
                    change(pokemon, pokemon + 1);
                } else if (arg1 == 2){
                    change(pokemon, pokemon + 2);
                } else if (arg1 == 3){
                    change(pokemon, pokemon + 3);
                }else if (arg1 == 4){
                    change(pokemon, pokemon + 4);
                }else if (arg1 == 5){
                    change(pokemon, pokemon + 5);
                }
                alerta.dismiss();
            }
        });
        alerta = builder.create();
        alerta.show();
    }

    public void change(int p1, int p2){
        if(Sadormceido[p1] == 1 || Sparalisado[p1] == 1){
            Toast.makeText(campo.this, "Ação inválida, Pokémon sob condição especial", Toast.LENGTH_SHORT).show();
        }else if(vida[p2] <= 0){
            Toast.makeText(campo.this, "Precisa trocar por um Pokémon vivo", Toast.LENGTH_SHORT).show();
        }else{
            int aux = vida[p1];

            vida[p1] = vida[p2];
            Sadormceido[p1] = Sadormceido[p2];
            Squeimado[p1] = Sadormceido[p2];
            Senvenenado[p1] = Senvenenado[p2];
            Sconfuso[p1] = Sconfuso[p2];
            Sparalisado[p1] = Sparalisado[p2];
            Denvenenado[p1] = Denvenenado[p2];

            vida[p2] = aux;
            Sadormceido[p2] = 0;
            Squeimado[p2] = 0;
            Senvenenado[p2] = 0;
            Sconfuso[p2] = 0;
            Sparalisado[p2] = 0;
            Denvenenado[p2] = 0;

            interfaceCondicoes();
            if(p1 < 6){
                texto(0);
            }else {
                texto(6);
            }
        }
    }

    public void trocar(View v){
        final int aux = rounds%2 == 1? 0 : 6;
        ArrayList<String> itens = new ArrayList<String>();
        itens.add("1");
        itens.add("2");
        itens.add("3");
        itens.add("4");
        itens.add("5");
        ArrayAdapter adapter = new ArrayAdapter(campo.this, R.layout.item_alerta, itens);
        AlertDialog.Builder builder = new AlertDialog.Builder(campo.this);
        builder.setTitle("Deseja mudar para qual Pokémon?");
        builder.setSingleChoiceItems(adapter, 0, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                if (arg1 == 0) {
                    change(aux, aux + 1);
                } else if (arg1 == 1){
                    change(aux, aux + 2);
                } else if (arg1 == 2){
                    change(aux, aux + 3);
                }else if (arg1 == 3){
                    change(aux, aux + 4);
                }else if (arg1 == 4){
                    change(aux, aux + 5);
                }
                alerta.dismiss();
            }
        });
        alerta = builder.create();
        alerta.show();
    }

    public void morreu1(View v){
        if(rounds%2 == 1){
            morreu(0, v);
        } else{
            morreu(6, v);
        }
    }

    public void morreu2(View v){
        if(rounds%2 == 1){
            morreu(1, v);
        } else{
            morreu(7, v);
        }
    }

    public void morreu3(View v){
        if(rounds%2 == 1){
            morreu(2, v);
        } else{
            morreu(8, v);
        }
    }

    public void morreu4(View v){
        if(rounds%2 == 1){
            morreu(3, v);
        } else{
            morreu(9, v);
        }
    }

    public void morreu5(View v){
        if(rounds%2 == 1){
            morreu(4, v);
        } else{
            morreu(10, v);
        }
    }

    public void morreu6(View v){
        if(rounds%2 == 1){
            morreu(5, v);
        } else{
            morreu(11, v);
        }
    }

    public void morreu(int pokemon, View v){
        zerarVariaveis(pokemon);
        if(pokemon == 0 || pokemon == 6){
            principalMorreu(pokemon, v);
        }
    }

    public void zerarVariaveis(int pokemon){
        vida[pokemon] = 0;
        Senvenenado[pokemon] = 0;
        Sadormceido[pokemon] = 0;
        Sparalisado[pokemon] = 0;
        Sconfuso[pokemon] = 0;
        Squeimado[pokemon] = 0;
        Denvenenado[pokemon] = 0;

        if(pokemon < 6){
            texto(0);
        }else {
            texto(6);
        }
    }

    public void moeda(View v){
        moedin();
    }

    private boolean moedin() {
        Random rnd = new Random();
        boolean numero = rnd.nextBoolean();
        if(clicado == 0){
            if (numero) {//cara
                moeda.setBackgroundResource(R.drawable.pika);
                clicado = 1;
            } else {//coroa
                moeda.setBackgroundResource(R.drawable.pikachu);
                clicado = 1;
            }
            if (!timerHasStarted) {
                countDownTimer.start();
                timerHasStarted = true;
            } else {
                countDownTimer.cancel();
            }
        }
        return numero;
    }

    public void SalvarPraSair() {
        editor = save.edit();
        for(int i = 0; i < 12; i++){
            editor.putInt("vida" + i, vida[i]);
            editor.putInt("Sparalisado" + i, Sparalisado[i]);
            editor.putInt("Squeimado" + i, Squeimado[i]);
            editor.putInt("Sadormceido" + i, Sadormceido[i]);
            editor.putInt("Sconfuso" + i, Sconfuso[i]);
            editor.putInt("Senvenenado" + i, Senvenenado[i]);
            editor.putInt("Denvenenado" + i, Denvenenado[i]);
        }
        editor.putInt("clicado", clicado);
        editor.putInt("roundy", rounds);
        editor.commit();
    }

    public void texto(int t){
        hp1.setText(vida[t] + "HP");
        hp2.setText(vida[t + 1] + "HP");
        hp3.setText(vida[t + 2] + "HP");
        hp4.setText(vida[t + 3] + "HP");
        hp5.setText(vida[t + 4] + "HP");
        hp6.setText(vida[t + 5] + "HP");
    }

    @Override
    public void onPause() {
        super.onPause();
        SalvarPraSair();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        SalvarPraSair();
    }

    @Override
    public void onStop(){
        super.onStop();
        SalvarPraSair();
    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(campo.this);
        builder.setMessage("Você tem certeza que deseja sair?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                alerta.dismiss();
            }
        });
        alerta = builder.create();
        alerta.show();
    }

    private void interfaceCondicoes() {
        if(rounds%2==1){
            if (Sadormceido[0] == 0) {
                dormir1.setBackgroundResource(R.drawable.sleep);
            } else {
                dormir1.setBackgroundResource(R.drawable.dormiti);
            }
            if (Squeimado[0] == 0) {
                fogo1.setBackgroundResource(R.drawable.fogoo);
            } else {
                fogo1.setBackgroundResource(R.drawable.fired);
            }
            if (Sparalisado[0] == 0) {
                paralisado1.setBackgroundResource(R.drawable.pessoaa);
            } else {
                paralisado1.setBackgroundResource(R.drawable.paralisiti);
            }
            if (Sconfuso[0] == 0) {
                confuso1.setBackgroundResource(R.drawable.confuso);
            } else {
                confuso1.setBackgroundResource(R.drawable.confused);
            }
            if (Senvenenado[0] == 0) {
                veneno1.setBackgroundResource(R.drawable.veneno);
            } else {
                veneno1.setBackgroundResource(R.drawable.envenenati);
            }

            if (Sadormceido[1] == 0) {
                dormir2.setBackgroundResource(R.drawable.sleep);
            } else {
                dormir2.setBackgroundResource(R.drawable.dormiti);
            }
            if (Squeimado[1] == 0) {
                fogo2.setBackgroundResource(R.drawable.fogoo);
            } else {
                fogo2.setBackgroundResource(R.drawable.fired);
            }
            if (Sparalisado[1] == 0) {
                paralisado2.setBackgroundResource(R.drawable.pessoaa);
            } else {
                paralisado2.setBackgroundResource(R.drawable.paralisiti);
            }
            if (Sconfuso[1] == 0) {
                confuso2.setBackgroundResource(R.drawable.confuso);
            } else {
                confuso2.setBackgroundResource(R.drawable.confused);
            }
            if (Senvenenado[1] == 0) {
                veneno2.setBackgroundResource(R.drawable.veneno);
            } else {
                veneno2.setBackgroundResource(R.drawable.envenenati);
            }

            if (Sadormceido[2] == 0) {
                dormir3.setBackgroundResource(R.drawable.sleep);
            } else {
                dormir3.setBackgroundResource(R.drawable.dormiti);
            }
            if (Squeimado[2] == 0) {
                fogo3.setBackgroundResource(R.drawable.fogoo);
            } else {
                fogo3.setBackgroundResource(R.drawable.fired);
            }
            if (Sparalisado[2] == 0) {
                paralisado3.setBackgroundResource(R.drawable.pessoaa);
            } else {
                paralisado3.setBackgroundResource(R.drawable.paralisiti);
            }
            if (Sconfuso[2] == 0) {
                confuso3.setBackgroundResource(R.drawable.confuso);
            } else {
                confuso3.setBackgroundResource(R.drawable.confused);
            }
            if (Senvenenado[2] == 0) {
                veneno3.setBackgroundResource(R.drawable.veneno);
            } else {
                veneno3.setBackgroundResource(R.drawable.envenenati);
            }

            if (Sadormceido[3] == 0) {
                dormir4.setBackgroundResource(R.drawable.sleep);
            } else {
                dormir4.setBackgroundResource(R.drawable.dormiti);
            }
            if (Squeimado[3] == 0) {
                fogo4.setBackgroundResource(R.drawable.fogoo);
            } else {
                fogo4.setBackgroundResource(R.drawable.fired);
            }
            if (Sparalisado[3] == 0) {
                paralisado4.setBackgroundResource(R.drawable.pessoaa);
            } else {
                paralisado4.setBackgroundResource(R.drawable.paralisiti);
            }
            if (Sconfuso[3] == 0) {
                confuso4.setBackgroundResource(R.drawable.confuso);
            } else {
                confuso4.setBackgroundResource(R.drawable.confused);
            }
            if (Senvenenado[3] == 0) {
                veneno4.setBackgroundResource(R.drawable.veneno);
            } else {
                veneno4.setBackgroundResource(R.drawable.envenenati);
            }

            if (Sadormceido[4] == 0) {
                dormir5.setBackgroundResource(R.drawable.sleep);
            } else {
                dormir5.setBackgroundResource(R.drawable.dormiti);
            }
            if (Squeimado[4] == 0) {
                fogo5.setBackgroundResource(R.drawable.fogoo);
            } else {
                fogo5.setBackgroundResource(R.drawable.fired);
            }
            if (Sparalisado[4] == 0) {
                paralisado5.setBackgroundResource(R.drawable.pessoaa);
            } else {
                paralisado5.setBackgroundResource(R.drawable.paralisiti);
            }
            if (Sconfuso[4] == 0) {
                confuso5.setBackgroundResource(R.drawable.confuso);
            } else {
                confuso5.setBackgroundResource(R.drawable.confused);
            }
            if (Senvenenado[4] == 0) {
                veneno5.setBackgroundResource(R.drawable.veneno);
            } else {
                veneno5.setBackgroundResource(R.drawable.envenenati);
            }

            if (Sadormceido[5] == 0) {
                dormir6.setBackgroundResource(R.drawable.sleep);
            } else {
                dormir6.setBackgroundResource(R.drawable.dormiti);
            }
            if (Squeimado[5] == 0) {
                fogo6.setBackgroundResource(R.drawable.fogoo);
            } else {
                fogo6.setBackgroundResource(R.drawable.fired);
            }
            if (Sparalisado[5] == 0) {
                paralisado6.setBackgroundResource(R.drawable.pessoaa);
            } else {
                paralisado6.setBackgroundResource(R.drawable.paralisiti);
            }
            if (Sconfuso[5] == 0) {
                confuso6.setBackgroundResource(R.drawable.confuso);
            } else {
                confuso6.setBackgroundResource(R.drawable.confused);
            }
            if (Senvenenado[5] == 0) {
                veneno6.setBackgroundResource(R.drawable.veneno);
            } else {
                veneno6.setBackgroundResource(R.drawable.envenenati);
            }
        }else{
            if (Sadormceido[6] == 0) {
                dormir1.setBackgroundResource(R.drawable.sleep);
            } else {
                dormir1.setBackgroundResource(R.drawable.dormiti);
            }
            if (Squeimado[6] == 0) {
                fogo1.setBackgroundResource(R.drawable.fogoo);
            } else {
                fogo1.setBackgroundResource(R.drawable.fired);
            }
            if (Sparalisado[6] == 0) {
                paralisado1.setBackgroundResource(R.drawable.pessoaa);
            } else {
                paralisado1.setBackgroundResource(R.drawable.paralisiti);
            }
            if (Sconfuso[6] == 0) {
                confuso1.setBackgroundResource(R.drawable.confuso);
            } else {
                confuso1.setBackgroundResource(R.drawable.confused);
            }
            if (Senvenenado[6] == 0) {
                veneno1.setBackgroundResource(R.drawable.veneno);
                Denvenenado[6] = 0;
            } else {
                veneno1.setBackgroundResource(R.drawable.envenenati);
            }

            if (Sadormceido[7] == 0) {
                dormir2.setBackgroundResource(R.drawable.sleep);
            } else {
                dormir2.setBackgroundResource(R.drawable.dormiti);
            }
            if (Squeimado[7] == 0) {
                fogo2.setBackgroundResource(R.drawable.fogoo);
            } else {
                fogo2.setBackgroundResource(R.drawable.fired);
            }
            if (Sparalisado[7] == 0) {
                paralisado2.setBackgroundResource(R.drawable.pessoaa);
            } else {
                paralisado2.setBackgroundResource(R.drawable.paralisiti);
            }
            if (Sconfuso[7] == 0) {
                confuso2.setBackgroundResource(R.drawable.confuso);
            } else {
                confuso2.setBackgroundResource(R.drawable.confused);
            }
            if (Senvenenado[7] == 0) {
                veneno2.setBackgroundResource(R.drawable.veneno);
            } else {
                veneno2.setBackgroundResource(R.drawable.envenenati);
            }

            if (Sadormceido[8] == 0) {
                dormir3.setBackgroundResource(R.drawable.sleep);
            } else {
                dormir3.setBackgroundResource(R.drawable.dormiti);
            }
            if (Squeimado[8] == 0) {
                fogo3.setBackgroundResource(R.drawable.fogoo);
            } else {
                fogo3.setBackgroundResource(R.drawable.fired);
            }
            if (Sparalisado[8] == 0) {
                paralisado3.setBackgroundResource(R.drawable.pessoaa);
            } else {
                paralisado3.setBackgroundResource(R.drawable.paralisiti);
            }
            if (Sconfuso[8] == 0) {
                confuso3.setBackgroundResource(R.drawable.confuso);
            } else {
                confuso3.setBackgroundResource(R.drawable.confused);
            }
            if (Senvenenado[8] == 0) {
                veneno3.setBackgroundResource(R.drawable.veneno);
            } else {
                veneno3.setBackgroundResource(R.drawable.envenenati);
            }

            if (Sadormceido[9] == 0) {
                dormir4.setBackgroundResource(R.drawable.sleep);
            } else {
                dormir4.setBackgroundResource(R.drawable.dormiti);
            }
            if (Squeimado[9] == 0) {
                fogo4.setBackgroundResource(R.drawable.fogoo);
            } else {
                fogo4.setBackgroundResource(R.drawable.fired);
            }
            if (Sparalisado[9] == 0) {
                paralisado4.setBackgroundResource(R.drawable.pessoaa);
            } else {
                paralisado4.setBackgroundResource(R.drawable.paralisiti);
            }
            if (Sconfuso[9] == 0) {
                confuso4.setBackgroundResource(R.drawable.confuso);
            } else {
                confuso4.setBackgroundResource(R.drawable.confused);
            }
            if (Senvenenado[9] == 0) {
                veneno4.setBackgroundResource(R.drawable.veneno);
            } else {
                veneno4.setBackgroundResource(R.drawable.envenenati);
            }

            if (Sadormceido[10] == 0) {
                dormir5.setBackgroundResource(R.drawable.sleep);
            } else {
                dormir5.setBackgroundResource(R.drawable.dormiti);
            }
            if (Squeimado[10] == 0) {
                fogo5.setBackgroundResource(R.drawable.fogoo);
            } else {
                fogo5.setBackgroundResource(R.drawable.fired);
            }
            if (Sparalisado[10] == 0) {
                paralisado5.setBackgroundResource(R.drawable.pessoaa);
            } else {
                paralisado5.setBackgroundResource(R.drawable.paralisiti);
            }
            if (Sconfuso[10] == 0) {
                confuso5.setBackgroundResource(R.drawable.confuso);
            } else {
                confuso5.setBackgroundResource(R.drawable.confused);
            }
            if (Senvenenado[10] == 0) {
                veneno5.setBackgroundResource(R.drawable.veneno);
            } else {
                veneno5.setBackgroundResource(R.drawable.envenenati);
            }

            if (Sadormceido[11] == 0) {
                dormir6.setBackgroundResource(R.drawable.sleep);
            } else {
                dormir6.setBackgroundResource(R.drawable.dormiti);
            }
            if (Squeimado[11] == 0) {
                fogo6.setBackgroundResource(R.drawable.fogoo);
            } else {
                fogo6.setBackgroundResource(R.drawable.fired);
            }
            if (Sparalisado[11] == 0) {
                paralisado6.setBackgroundResource(R.drawable.pessoaa);
            } else {
                paralisado6.setBackgroundResource(R.drawable.paralisiti);
            }
            if (Sconfuso[11] == 0) {
                confuso6.setBackgroundResource(R.drawable.confuso);
            } else {
                confuso6.setBackgroundResource(R.drawable.confused);
            }
            if (Senvenenado[11] == 0) {
                veneno6.setBackgroundResource(R.drawable.veneno);
            } else {
                veneno6.setBackgroundResource(R.drawable.envenenati);
            }
        }
    }

    public class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {
            moeda.setBackgroundResource(R.drawable.moeda);
            clicado = 0;
            timerHasStarted = false;
        }

        @Override
        public void onTick(long millisUntilFinished) {

        }

    }
}
