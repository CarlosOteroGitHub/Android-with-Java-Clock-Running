package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/*

AUTHOR: ING. CARLOS OTERO RAMÍREZ.

 */
public class MainActivity extends AppCompatActivity {

    int segundos=0, minutos=0, horas=0;

    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Reloj");

        textView1 = findViewById(R.id.AM1_id1);
        hilo.start();
    }

    Thread hilo = new Thread() {
        public void run(){
            try{
                while(true){
                    Thread.sleep(1000);
                    segundos++;
                    if(segundos>59){
                        minutos++;
                        segundos=0;
                    }
                    if(minutos>59){
                        horas++;
                        minutos=0;
                    }
                    textView1.setText(horas + " : " + minutos + " : " + segundos);
                }
            } catch(InterruptedException e){
                textView1.setText("Error: " + e.getMessage());
            }
        }
    };
}