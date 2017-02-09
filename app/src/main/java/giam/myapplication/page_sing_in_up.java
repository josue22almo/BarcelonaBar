package giam.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import giam.myapplication.SingIN.pSingIN;
import giam.myapplication.SingUP.pSingUp_I;

public class page_sing_in_up extends AppCompatActivity {
    private TextView btn_login;
    private TextView btn_sinUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_sing_in_up);

        // REFERENCES UI
        btn_login = (TextView)findViewById(R.id.btn_sing_in);
        btn_sinUp = (TextView)findViewById(R.id.btn_sing_up);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funShowPageSingIN();
            }
        });

        btn_sinUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funShowPageSingUP();
            }
        });
    }

    private void funShowPageSingUP(){
        //Lanzamos la actividad para iniciar seccion
        Intent intent = new Intent(page_sing_in_up.this, pSingUp_I.class);
        startActivity(intent);
    }

    private void funShowPageSingIN(){
        //Lanzamos la actividad para registrarse
        //Toast.makeText(this, "funShowPageSingUP", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(page_sing_in_up.this, pSingIN.class);
        startActivity(intent);
    }

}
