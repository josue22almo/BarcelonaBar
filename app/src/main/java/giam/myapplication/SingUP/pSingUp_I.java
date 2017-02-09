package giam.myapplication.SingUP;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import giam.myapplication.R;

public class pSingUp_I extends AppCompatActivity {
    private TextView    btn_next;
    private ImageView   btn_back;
    private EditText    pName;
    private EditText    pBirthDate;
    private EditText    pMail;
    private EditText    pPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_sing_up_i);

        // Asignamos las instancias
        btn_next    =   (TextView)findViewById(R.id.txt_sing_up_i_next);
        btn_back    =   (ImageView)findViewById(R.id.img_back_sing_up_i);
        pName       =   (EditText)findViewById(R.id.edit_sing_up_name);
        pBirthDate  =   (EditText)findViewById(R.id.edit_sing_up_birthdate);
        pMail       =   (EditText)findViewById(R.id.edit_sing_up_mail);
        pPassword   =   (EditText)findViewById(R.id.edit_sing_in_password);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSingUpII();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void    showSingUpII(){
        Intent intent = new Intent(pSingUp_I.this, pSingUp_II.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == 1) {
            // Nos aseguramos que el resultado es positivo
            if (resultCode == RESULT_OK) {
                // Se ha registrado correctamente.
                // Le decimos a la actividad anterior que se cierre. sing_in_up
                Intent returnIntent = new Intent();
                returnIntent.putExtra("boolOk",RESULT_OK);
                setResult(RESULT_OK,returnIntent);

                // Cerramos la actividad actual
                finish();
            }
        }
    }
}
