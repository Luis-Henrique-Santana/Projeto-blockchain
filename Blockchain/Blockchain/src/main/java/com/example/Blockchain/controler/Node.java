package com.example.Blockchain.controler;

import com.example.Blockchain.services.Block;
import com.example.Blockchain.services.Blockchain;
import com.example.Blockchain.services.Minerador;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/node")
public class Node {

    private Blockchain blockchain;

    public Node(){
        blockchain = new Blockchain();
    }

    @GetMapping("/isvalid")
    public String isValid(){

        return blockchain.isChainValid() ? "Block chain valida" : "Blockchain invalida";

    }

    @GetMapping("/blockchain")
    public List<Block> getBlockchain(){
        return blockchain.getChain();
    }

    @PostMapping("/addblock")
    public String addblock(@RequestBody String data){
    //pega bloco pra montar novo bloco
        Block newBlock = new Block(blockchain.getLastBlock().getIndex()+1,System.currentTimeMillis(),data, blockchain.getLastBlock().getHash());
        Minerador minerador = new Minerador(4);
        minerador.mineBlock(newBlock);
        blockchain.addBlock(newBlock);
        return "bloco minerado com sucesso";
    }
}
