package com.example.Blockchain.services;

public class Minerador {
    private int dificuldade;

    public Minerador(int dificuldade){
        this.dificuldade = dificuldade;
    }

    public void mineBlock(Block block){
        String target = new String(new char[dificuldade]).replace("\0", "0");
        while(!block.getHash().substring(0,dificuldade). equals(target)){
            block.setTimestamp(System.currentTimeMillis());
            block.setHash(block.calculateHash());
        }
        System.out.println("Bloco minerado: " + block.getHash());
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }
}
