package giam.myapplication.SingIN;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import giam.myapplication.R;
import giam.myapplication.page_main;

public class pSingIN extends AppCompatActivity {
    private ImageView   btn_back;
    private TextView    btn_login;
    private TextView    mTextViewAuthError;
    private TextView    mTextViewPassRest;
    private EditText    mUser;
    private EditText    mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_sing_in);

        //Obtener referencia de los objectos
        btn_back                =   (ImageView)findViewById(R.id.img_back_sing_in);
        btn_login               =   (TextView)findViewById(R.id.txt_sing_in_login);

        mTextViewAuthError      =   (TextView)findViewById(R.id.txt_sing_in_auth_error);
        mTextViewPassRest       =   (TextView)findViewById(R.id.txt_sing_in_auth_error);

        mUser                   =   (EditText)findViewById(R.id.edit_sing_in_user);
        mPassword               =   (EditText)findViewById(R.id.edit_sing_in_password);

        //Campos invisible
        mTextViewAuthError.setVisibility(View.INVISIBLE);

        //Le damos focus al edit USUARIO o MAIL
        mUser.requestFocus();

        mUser.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    mPassword.performClick();
                    return true;
                }
                return false;
            }
        });

        mPassword.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    btn_login.performClick();
                    return true;
                }
                return false;
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emptyFields()){
                    if(verificateSeccion()) {
                       saveUserSeccion();
                        openMainPage();
                    }else{
                        showUserAuthError();
                    }
                }
            }
        });

        mTextViewPassRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Finalize current activity
                //finish();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Terminar la actividad
                finish();
            }
        });
    }

    private void openMainPage(){
        //Cerramos todas las actividades anteriores
        finishAffinity();

        //A la actividad anterior, sing_in_up, le decimos que se puede finalizar
        Intent intent_main = new Intent(pSingIN.this, page_main.class);
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

    private boolean verificateSeccion() {
        boolean error = true;

        //CONECT TO SERVER AND VERIFICATE IF USER EXIST

        return error;
    }

    private void showUserAuthError() {

        //Show textedit
        mTextViewAuthError.setVisibility(View.VISIBLE);

    }

    private boolean emptyFields() {
       if (TextUtils.isEmpty(mUser.getText().toString())) {
            mUser.setError(getString(R.string.error_not_empty_field));
            return false;
        }

        if (TextUtils.isEmpty(mPassword.getText().toString())) {
            mPassword.setError(getString(R.string.error_not_empty_field));
            return false;
        } /**/

        return true;
    }
}
