package com.example.appbar;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Produtos extends Activity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    Button btnCancelar;

    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    HashMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);
        if (Itens.getInstance() == null || Itens.getInstance().getProdutos("Bebidas") == null) {
            Toast.makeText(Produtos.this, "Os dados nao foram carregados ainda, espere mais alguns segundos!!!",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Produtos.this, CadastroClientes.class);
            startActivity(intent);
            finish();
        } else {
            loadDataView();
            this.map = Itens.getInstance().getProdutos("Categorias");

        }

        btnCancelar = (Button) findViewById(R.id.btnCancela);
        btnCancelar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(Produtos.this,CadastroClientes.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void loadDataView(){
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        // Adding child data
        listDataHeader.add("Cervejas");
        listDataHeader.add("Refrigerantes");
        listDataHeader.add("Porções");

        // Adding child data
        List<String> cerveja = new ArrayList<String>();
        cerveja.add("Antarctica");
        cerveja.add("Skol");
        cerveja.add("Brahma");
        cerveja.add("Devassa");
        cerveja.add("Desesperados");

        List<String> refri = new ArrayList<String>();
        refri.add("Coca-Cola");
        refri.add("Pepsi");
        refri.add("Guaraná");
        refri.add("Soda");
        refri.add("Fanta Uva");
        refri.add("H2OH!");

        List<String> porcoes = new ArrayList<String>();
        porcoes.add("Peixe");
        porcoes.add("Batata Frita");
        porcoes.add("Mandioca");
        porcoes.add("The Canyons");
        porcoes.add("Europa Report");

        listDataChild.put(listDataHeader.get(0), cerveja); // Header, Child data
        listDataChild.put(listDataHeader.get(1), refri);
        listDataChild.put(listDataHeader.get(2), porcoes);


    }
}

