package com.example.appbar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class CadastroClientes extends Activity  {
    Button btnOk, btnCancel, btnAdd;
    private TextView text;
    String value = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        this.value = intent.getStringExtra("Click").toString();
        setContentView(R.layout.cadastro_clientes);

        //-------------------------------ADICIONAR CLIENTE----------------------------------------
        btnOk = (Button) findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                if (!text.getText().toString().trim().isEmpty()) {
                    if (value.equals("false")){
                        Clientes.getInstance().adicionar(text.getText().toString().trim());
                    } else {
                        Clientes.getInstance().editar(text.getText().toString().trim(), value);
                    }
                    finish();
                    Intent intent = new Intent(CadastroClientes.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(CadastroClientes.this,"Campo nome está vazio!!! ",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });

        //-----------------------------ADICIONAR ELEMENTO---------------------------------------
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                TableLayout tl = (TableLayout) findViewById(R.id.table);
                TableRow tr_head = new TableRow(CadastroClientes.this); //criou
                tr_head.setId(R.id.row);
                tr_head.setBackgroundColor(Color.BLUE);
                tr_head.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));

                //---------------------------ADICIONANDO SPINNER-------------------------------
                final Spinner produto = new Spinner(CadastroClientes.this);
                ArrayAdapter<String> adapter;
                List<String> list;
                list = new ArrayList<String>();
                list.add("Coca-Cola");
                list.add("Cerveja");
                list.add("Item 3");
                list.add("Item 4");
                list.add("Item 5");
                //produto.setOnItemClickListener();

                adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, list);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                produto.setAdapter(adapter);
                tr_head.addView(produto);

                //---------------------------ADICIONANDO EDITTEXT-----------------------------
               /* EditText qtd = new EditText(CadastroClientes.this);
                tr_head.addView(produto);*/

                tl.addView(tr_head, new TableLayout.LayoutParams(
                        LayoutParams.FILL_PARENT,
                        LayoutParams.WRAP_CONTENT));

                produto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {
                        String imc_met=produto.getSelectedItem().toString();
                        System.out.println(imc_met);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        // TODO Auto-generated method stub

                    }
                });

//        ----------------------------------CODIGO ANTIGO NOIS NAO TEM VERSIONAMENTO----------------------------------------


//                TableLayout tl = (TableLayout) findViewById(R.id.table);
//                TableRow tr_head = new TableRow(CadastroClientes.this); //criou
//                tr_head.setId(R.id.row);
//                tr_head.setBackgroundColor(Color.BLUE);
//                tr_head.setLayoutParams(new LayoutParams(
//                        LayoutParams.FILL_PARENT,
//                        LayoutParams.WRAP_CONTENT));
//
//                TextView label_date = new TextView(CadastroClientes.this);
//                label_date.setId(R.id.txtColA);
//                label_date.setText("DATE");
//                label_date.setTextColor(Color.WHITE);
//                label_date.setPadding(5, 5, 5, 5);
//                tr_head.addView(label_date);
//
//                tl.addView(tr_head, new TableLayout.LayoutParams(
//                        LayoutParams.FILL_PARENT,
//                        LayoutParams.WRAP_CONTENT));

// -------------------------------------------------------FIM DO CODIGO ANTIGO-------------------------------------------
            }
        });


        this.text = (EditText) findViewById(R.id.editText);//t aai kkkkk pera

        if (!value.equals("false")){
            text.setText(value);
        }

        //-----------------------------CANCELAR INSERÇÃO---------------------------------------
        btnCancel = (Button) findViewById(R.id.btnCancelar);
        btnCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(CadastroClientes.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
