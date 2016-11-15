package com.example.appbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CadastroClientes extends Activity implements View.OnClickListener {
    private final static Clientes cliente = new Clientes();
    Button btnCTime;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_clientes);
        btnCTime = (Button) findViewById(R.id.button);
        btnCTime.setOnClickListener(this);
        text = (EditText) findViewById(R.id.editText);
    }

    public Clientes referencia(){
        return cliente;
    }
    @Override
    public void onClick(View view) {

        cliente.adicionar(text.getText().toString().trim());

        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
