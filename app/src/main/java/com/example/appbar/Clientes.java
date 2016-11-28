package com.example.appbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Clientes {

    private static Clientes uniqueInstance;
    private ArrayList<String> clientes;

    private Clientes(){
        this.clientes = new ArrayList<>();
        clientes.add(" "); //Botaõ de Adicionar Novo Cliente
    }

    public static synchronized Clientes getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Clientes();
        }
        return uniqueInstance;
    }

    public void adicionar(String cliente){
        this.clientes.add(clientes.size()-1,cliente);
    }

    public void editar(String cliente, String index) {
        this.clientes.set(this.clientes.indexOf(index),cliente);
    }
    public ArrayList<String> getArray(){
        return clientes;
    }


}
