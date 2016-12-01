package com.example.appbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private DynamicGridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView = (DynamicGridView) findViewById(R.id.dynamic_grid);
        gridView.setAdapter(new DynamicAdapter(this, Clientes.getInstance().getArray(), 3));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getAdapter().getItem(position).toString() == " ") {
                    startSecondActivity("false");
                }

                else{
                    startSecondActivity(parent.getAdapter().getItem(position).toString());
                }
            }
        });
    }
    //    public void startSecondActivity(){
//        Intent intent = new Intent(this, CadastroClientes.class);
//        intent.putExtra("Click","false");
//       startActivity(intent);
//       finish();
//    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void startSecondActivity(String a){
        Intent intent = new Intent(MainActivity.this, CadastroClientes.class);
        intent.putExtra("Click",a);
        startActivity(intent);
        finishAfterTransition();
        // finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
