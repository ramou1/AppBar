package com.example.appbar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


public class MainActivity extends Activity {
    private DynamicGridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        gridView = (DynamicGridView) findViewById(R.id.dynamic_grid);
        gridView.setAdapter(new DynamicAdapter(this, Clientes.getInstance().getArray(), 3));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
    public void startSecondActivity(String bool){
        Intent intent = new Intent(this, CadastroClientes.class);
        intent.putExtra("Click",bool);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
