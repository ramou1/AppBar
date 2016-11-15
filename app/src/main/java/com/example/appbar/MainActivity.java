package com.example.appbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;



public class MainActivity extends Activity {

    private DynamicGridView gridView;
    private CadastroClientes cd = new CadastroClientes();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        gridView = (DynamicGridView) findViewById(R.id.dynamic_grid);
        gridView.setAdapter(new DynamicAdapter(this, cd.referencia().getArray(), 3));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (parent.getAdapter().getItem(position).toString() == " ") {
//                    cliente.adicionar("Cliente 2");
//
//                    Intent intent = getIntent();
//                    finish();
//                    startActivity(getIntent());
//                }
//                else{
//                    startSecondActivity();
//                }

                if (parent.getAdapter().getItem(position).toString() == " ") {
                    startSecondActivity();
                }
                else{
                    // startSecondActivity();
                }
            }
        });
    }
    public void startSecondActivity(){
       Intent intent = new Intent(this, CadastroClientes.class);
       startActivity(intent);
       finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
