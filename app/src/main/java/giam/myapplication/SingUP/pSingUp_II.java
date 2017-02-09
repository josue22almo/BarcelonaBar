package giam.myapplication.SingUP;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import giam.myapplication.R;
import giam.myapplication.page_main;

public class pSingUp_II extends AppCompatActivity {
    private TextView    btn_next;
    private ImageView   btn_back;
    private EditText    mUser;
    private EditText    mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_sing_up_ii);

        btn_next            =   (TextView)findViewById(R.id.txt_sing_up_ii_next);
        btn_back            =   (ImageView)findViewById(R.id.img_sing_up_ii_back);
        mUser               =   (EditText)findViewById(R.id.edit_sing_up_name);
        mPassword           =   (EditText)findViewById(R.id.edit_sing_up_password);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //saveUserSeccion();
                showMainActivity();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void showMainActivity(){
        //Cerramos todas las actividades anteriores
        finishAffinity();

        //Creamos la actividad MAIN y la ejecutamos sin BACK
        Intent intent_main = new Intent(pSingUp_II.this, page_main.class);
        intent_main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent_main);
    }

    private void saveUserSeccion() {
        SharedPreferences prefs             =   getSharedPreferences(getString(R.string.app_preferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor     =   prefs.edit();
        editor.putString("keyUserName",mUser.getText().toString()).apply();
        editor.putString("keyUserPass", mPassword.getText().toString()).apply();
        editor.putString("keySeccion", "1").apply();
    }
}
