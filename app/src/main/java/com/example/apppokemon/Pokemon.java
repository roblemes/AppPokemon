package com.example.apppokemon;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
   private String nome;
   private List<String> ataques;

   public Pokemon(){
        this.ataques = new ArrayList<>();
   }

    public Pokemon(String nome) {
        this.nome = nome;
        this.ataques = ataques;
    }

    public void addAtaque(String nome){
        this.ataques.add(nome);
    }

    public int totalAtaques(){
       return this.ataques.size();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getAtaques() {
        return ataques;
    }

    public void setAtaques(List<String> ataques) {
        this.ataques = ataques;
    }

    @Override
    public String toString() {
        return "Pokemon:\n" +
                "Nome:" + nome + '\n' +
                "Ataques disponiveis:\n" + totalAtaques() + "\n" +
                "Lista de ataques:\n" + ataques
                ;
    }
}
