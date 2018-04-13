/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

/**
 *
 * @author 2115082
 */
import java.io.*; 
import java.net.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
public class URLReader extends Thread{ 
    
    public static void main(String[] args){
        for(int i=0;i<20;i++){
            Thread hilo = new URLReader();
            hilo.start();
        }    
    }
    
    @Override
    public void run(){
        try{
            System.out.println("PATH = '/'");
            response("/");
            System.out.println("PATH = '/hello'");
            response("/hello");            
            System.out.println("PATH = '/db'");
            response("/db");                        
        } catch(MalformedURLException e){
            Logger.getLogger(URLReader.class.getName()).log(Level.SEVERE, null, e);
            
        }
    
    }
    
    public void response(String tipo) throws MalformedURLException{
        URL result = new URL("https://aremp.herokuapp.com"+tipo);
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(result.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }            
    }
}
