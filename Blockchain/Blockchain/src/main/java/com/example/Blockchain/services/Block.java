package com.example.Blockchain.services;

import java.security.MessageDigest;
public class Block {

    private int index;
    private long timestamp;
    private String data;
    private String hash;
    private String previousHash;

    public Block (int index, long timestamp, String data, String previousHash){
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.previousHash = previousHash;
        this.hash = calculateHash();
    }

    private String applySHA256(String input){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA256");

            byte[] hashBytes = digest.digest(input.getBytes( "UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes){
                hexString.append(String.format("%02x",b));
            }
            return hexString.toString();
        }catch (Exception e){
            throw new RuntimeException(e);
        }


    }




    public String calculateHash(){
        String input = index + Long.toString(timestamp) + data + previousHash;
        return applySHA256(input);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }



}
