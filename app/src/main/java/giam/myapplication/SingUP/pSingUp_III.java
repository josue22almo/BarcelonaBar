package giam.myapplication.SingUP;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import giam.myapplication.R;
import giam.myapplication.page_main;

public class pSingUp_III extends AppCompatActivity {
    private TextView    btn_sing_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_sing_up_iii);

        btn_sing_in             =   (TextView)findViewById(R.id.txt_sing_up_iii_sing_up);

        btn_sing_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(pSingUp_III.this, page_main.class);
                startActivity(intent);
            }
        });
    }
}
