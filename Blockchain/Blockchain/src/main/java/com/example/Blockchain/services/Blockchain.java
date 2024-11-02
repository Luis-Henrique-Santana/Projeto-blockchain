package com.example.Blockchain.services;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> chain;

    public Blockchain(){
        chain = new ArrayList<>();
        chain.add(createGenesisBlock());
    }
    // gerador de bloco primario
    private Block createGenesisBlock(){
        return new Block(0, System.currentTimeMillis(), "BLOCO ZERO", "0");
    }
    //pega o ultimo bloco
    public Block getLastBlock (){
        return chain.get(chain.size()-1);
    }

    public void addBlock(Block newBlock){
        newBlock.setPreviousHash(getLastBlock().getHash());
        newBlock.setHash(newBlock.calculateHash());
        chain.add(newBlock);
    }

    public boolean isChainValid(){
        for(int i=1; i<chain.size(); i++){
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i-1);


            // verifica se tem alteração no hash
            if(currentBlock.getHash().equals(currentBlock.calculateHash()))
                return false;

            if(!currentBlock.getPreviousHash().equals(previousBlock.getHash()))
                return false;

        }

        return true;

    }

    public List<Block> getChain() {
        return chain;
    }

    public void setChain(List<Block> chain) {
        this.chain = chain;
    }

}
