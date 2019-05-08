/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neoredun;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.*;

/**
 *
 * @author respuit
 */
public class Directory {
    private File filePath;
    private ArrayList<File> files;
    

    
    
//If wanted the entire path declare files as: ArrayList<File>....(filePath.listFiles).
    public Directory(String path){
        filePath = new File(path);
        files = new ArrayList<>();
        try{
            this.listFiles(filePath);
        }catch(NullPointerException e){
           // System.out.println("Introduce un directorio valido por favor"); //Create a windowd to alert the user.
        }
        
        
    }
       
//Fill array recursively with file folders and sub folders.     
    public void listFiles(File dir){
        File[] filesL = dir.listFiles();
        for (int i = 0; i <filesL.length; i++){
            if(dirCheck(filesL[i])){
                files.add(filesL[i]);
                listFiles(filesL[i]);
            }else{
                files.add(filesL[i]);
              }
        }
    }
   
//Check if is a directory (separate for potencial use).
   private boolean dirCheck(File file){
       if(file.isDirectory()){
           return true;
       }else{
           return false;
       }
   }
   
//Separate in lines the elements of the list for easy read. * Means that the filePath is excluded for easy of use. 
   private String listArrayNextLine(){
       String aux = ("");
       for(File f : files){
           aux = aux.replace(filePath.toString(), "");//*
           aux+=f + "\n" + "\t\t";           
       }
       return aux;
   }
//Return array with just the end os th path (excluding filePath)   
   public ArrayList<String> listContent(){
       ArrayList<String> auxA = new ArrayList<>();
       String aux = ("");
       for(File f: files){
           aux= f.toString().replace(filePath.toString(), "");
           auxA.add(aux);
       }
       return auxA;
   }
   
   
    
//Getters.    
    public File getPath(){
        return filePath;
    }
    
    public ArrayList<File> getFiles(){
        return files;
    }
//Setters.    
    public void setPath(String newPath){
        filePath = new File(newPath);
    }
    
    public String toString(){
        return "Path:           " + filePath +
                "\n\t\t------------------------------------------"+
                "\nFiles inside:   " + listArrayNextLine();
    }
    
}
