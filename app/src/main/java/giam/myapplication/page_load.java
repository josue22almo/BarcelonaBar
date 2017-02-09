package giam.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

public class page_load extends Activity {

    private LinearLayout layout_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_load);
       // SharedPreferences prefs = getSharedPreferences(getString(R.string.app_preferences), Context.MODE_PRIVATE);

        // Asignamos las instancias
        layout_main = (LinearLayout)findViewById(R.id.layout_page_firts);

        layout_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //funShowPageIni();
            }
        });

        //restartValues();

        //SI SE HA INICIADO SECCIÓN, MOSTRAR LA PAGINA PRINCIPAL
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                SharedPreferences prefs = getSharedPreferences(getString(R.string.app_preferences), Context.MODE_PRIVATE);
                switch (prefs.getString("keySeccion","0")) {
                    case "1": //Seccion iniciada
                        Intent intent_main = new Intent(page_load.this, page_main.class);
                        intent_main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent_main);
                        finish();
                        break;
                    case "0": //Seccion no iniciada
                        Intent intent_sing_in_ip = new Intent(page_load.this, page_sing_in_up.class);
                        intent_sing_in_ip.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent_sing_in_ip);
                        finish();
                        break;
                }
            }
        }, 500); //time in millis
    }


    public void restartValues(){
        SharedPreferences prefs = getSharedPreferences(getString(R.string.app_preferences), Context.MODE_PRIVATE);
        prefs.edit().remove("keySeccion").apply();
        prefs.edit().remove("keyUserName").apply();
        prefs.edit().remove("keyUserPass").apply();
    }
}
