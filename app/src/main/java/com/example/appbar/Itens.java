package com.example.appbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 30/11/16.
 */

public class Itens {


    private static Itens uniqueInstance;
    private HashMap produtos;

    private Itens(){

        FirebaseDatabase.getInstance().getReference().child("Mercadorias").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                produtos = (HashMap) dataSnapshot.getValue();
                System.out.println(produtos==null);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        // this.itens = new ArrayList<String>();
        // this.itens.add("Skol");
        // this.itens.add("Antartica");
        // this.itens.add("Brahma");
        // this.itens.add("Peixe");
        // this.itens.add("Salame");
        // this.itens.add("Batata Frita");
        // this.itens.add("Coca-Cola");
        //  this.itens.add("Kuat");

        // this.iten = new HashMap<String,String>();
//        itens.put("Cerveja","Skol");
//        itens.put("Cerveja","Antartica");
//        itens.put("Cerveja","Brahma");
//        itens.put("Porcao","Peixe");
//        itens.put("Porcao","Salame");
//        itens.put("Porcao","Batata Frita");
//        itens.put("Refrigerante lata","Coca-Cola");
//        itens.put("Refrigerante lata","Kuat");
//        itens.put("Refrigerante lata","Pepsi");
//        itens.put("Refrigerante 2L","Coca-Cola");
//        itens.put("Refrigerante 2L","Pepsi");
//        itens.put("Refrigerante 2L","Fanta Uva");

        //itens.put("Bala","Juquinha"); agora vamos fazer outra activity ok?:O ok vamos fazer salvar primeiro,
        //bem, me explica o que voce fez la

    }

    public static synchronized Itens getInstance(){
        if(uniqueInstance == null) {
            System.out.print("Iniciando");
            uniqueInstance = new Itens();
        }
        return uniqueInstance;
    }


    public HashMap getProdutos(String child){
        if (produtos == null){
            return null;
        }else {
            return (HashMap) produtos.get(child);
        }
    }
}
