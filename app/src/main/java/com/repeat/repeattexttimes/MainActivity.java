package com.repeat.repeattexttimes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText text, inttext, et_output;
    Button btn, b_go;
    String edittext, final_text, texta="";
    private static int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);
        inttext = findViewById(R.id.Inttext);
        btn = findViewById(R.id.btn);
        b_go = findViewById(R.id.b_go);
        et_output = findViewById(R.id.et_output);

        b_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = text.getText().toString();
                String tempNumber = inttext.getText().toString();

                if (!tempNumber.equals("")){
                    int number = Integer.parseInt(tempNumber);

                    texta = "";
                    for (int i = 0; i < number; i++){
                        texta = texta + input + "\n";
                    }

                    et_output.setText(texta);

                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(text.getText()))
                {
                    text.setError("Enter text");
                }
                else if (TextUtils.isEmpty(inttext.getText()))
                {
                    inttext.setError("Please Enter REpeat Count");
                }
                else
                {
                    Intent shareintent = new Intent(Intent.ACTION_SEND);
                    shareintent.setType("text/plain");
                    edittext = text.getText().toString();
                    count = Integer.parseInt(inttext.getText().toString());
                    int i = 1;
                    final_text="";
                    while (count>=i){
                        count--;
                        final_text = final_text+"\n"+edittext;
                        shareintent.putExtra(Intent.EXTRA_TEXT,final_text);
                    }
                    startActivity(Intent.createChooser(shareintent,"share Via"));
                }
            }
        });

    }
}