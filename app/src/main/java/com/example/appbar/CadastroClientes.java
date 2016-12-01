package com.example.appbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CadastroClientes extends Activity  {
    Button btnOk, btnCancel, btnAdd;
    private TextView text;
    String value = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent.getStringExtra("Click") == null){
            this.value = " ";
        }else {
            this.value = intent.getStringExtra("Click").toString();
        }
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
                    //de nadakkk
                }
            }
        });

        //-----------------------------ADICIONAR ELEMENTO---------------------------------------
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(CadastroClientes.this,Produtos.class);
                startActivity(intent);
                finish();
            }});
//
//                TableLayout tl = (TableLayout) findViewById(R.id.table);
//                TableRow tr_head = new TableRow(CadastroClientes.this); //criou
//                tr_head.setId(R.id.row);
//                tr_head.setBackgroundColor(Color.rgb(47,127,67));
//                tr_head.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
//

//                //-----------------------IR PARA A TELA DE PRODUTOS----------------------------
//                Intent intent = new Intent(CadastroClientes.this,Produtos.class);
//                startActivity(intent);
//
//                //---------------------------ADICIONANDO SPINNER-------------------------------
//                final Spinner produto = new Spinner(CadastroClientes.this);
//                ArrayAdapter<String> adapter;
//                List<String> list;
//                list = new ArrayList<String>();
//                list.add("Escolha...");
//                list.add("");
//                //produto.setOnItemClickListener();
//
//                adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,
//                        (List<String>)Itens.getInstance().getItens());
//                //pera
//                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                produto.setAdapter(adapter);
//
//                //---------------------------ADICIONANDO EDITTEXT-----------------------------
//                EditText qtd = new EditText(CadastroClientes.this);
//                qtd.setGravity(Gravity.CENTER);
//                qtd.setHint("0");
//                qtd.setText("4");
//                qtd.setInputType(InputType.TYPE_CLASS_NUMBER);
//
//                //---------------------------ADICIONANDO TEXTVIEW-----------------------------
//                TextView preco = new TextView(CadastroClientes.this);
//                preco.setGravity(Gravity.CENTER);
//                preco.setHint("R$ 0,00");
//                preco.setText("R$ "+2.5*Integer.valueOf(qtd.getText().toString()));
//
//                tr_head.addView(produto);
//                tr_head.addView(qtd);
//                tr_head.addView(preco);
//
//                tl.addView(tr_head, new TableLayout.LayoutParams(
//                        LayoutParams.FILL_PARENT,
//                        LayoutParams.WRAP_CONTENT));
//
//                produto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//                    @Override
//                    public void onItemSelected(AdapterView<?> arg0, View arg1,
//                                               int arg2, long arg3) {
//
//                        String imc_met=produto.getSelectedItem().toString();
//                        //oiaa to ficando preocupado, ta muito ruim kk
//                        //ruim nada, ta sim, cheio de gambiarras e outra, nao conseguimos conecta com o firebase,
//                        //pra qe serve isso?. de onde surgiu isso? ass
//
//                    }
//
//                    @Override
//                    public void onNothingSelected(AdapterView<?> arg0) {
//                        // TODO Auto-generated method stub
//
//                    }
//                });
//
////        ----------------------------------CODIGO ANTIGO NOIS NAO TEM VERSIONAMENTO----------------------------------------
//
//
////                TableLayout tl = (TableLayout) findViewById(R.id.table);
////                TableRow tr_head = new TableRow(CadastroClientes.this); //criou
////                tr_head.setId(R.id.row);
////                tr_head.setBackgroundColor(Color.BLUE);
////                tr_head.setLayoutParams(new LayoutParams(
////                        LayoutParams.FILL_PARENT,
////                        LayoutParams.WRAP_CONTENT));
////
////                TextView label_date = new TextView(CadastroClientes.this);
////                label_date.setId(R.id.txtColA);
////                label_date.setText("DATE");
////                label_date.setTextColor(Color.WHITE);
////                label_date.setPadding(5, 5, 5, 5);
////                tr_head.addView(label_date);
////
////                tl.addView(tr_head, new TableLayout.LayoutParams(
////                        LayoutParams.FILL_PARENT,
////                        LayoutParams.WRAP_CONTENT));
//
//// -------------------------------------------------------FIM DO CODIGO ANTIGO-------------------------------------------
//            }
//        });


        this.text = (EditText) findViewById(R.id.editText);

        if (!value.equals("false")){
            text.setText(value);
        }

        //-----------------------------CANCELAR INSERÇÃO---------------------------------------
        btnCancel = (Button) findViewById(R.id.btnCancela);
        btnCancel.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroClientes.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
