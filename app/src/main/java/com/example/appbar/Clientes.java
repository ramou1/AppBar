package com.example.appbar;

import java.util.ArrayList;


public class Clientes {
    private ArrayList<String> clientes;

    public Clientes(){
        this.clientes = new ArrayList<>();
        clientes.add(" "); //Botaõ de Adicionar Novo Cliente
    }

    public void adicionar(String cliente){
        this.clientes.add(clientes.size()-1,cliente);
    }

    public ArrayList<String> getArray(){
        return clientes;
    }
}
