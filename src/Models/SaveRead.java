/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author respuit
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author respuit
 */
public class SaveRead {
    
    FileOutputStream saveFile;
    ObjectOutputStream save;
    FileInputStream saveFileRead;
    ObjectInputStream saveRead;

    public SaveRead()  {
        
        
    }

//Save variable in a .sav. It save it in orther so you always need to pass all the parameters (hence the getters).      
    public void saveVariables(String from, String to ){
        try{
        saveFile = new FileOutputStream("save.sav");
        save = new ObjectOutputStream(saveFile);
        save.writeObject(from);
        save.writeObject(to);
        }catch(Exception e){
            System.out.println("nono");
        }
    }
  
//read all the variables from the .sav at once.    
    public void readVariables(){
        String auxA; // First variable in this case the path from where you are going to copy. 
        String auxB; // Seccond variable, path where you are going to copy. 
        try{
            saveFileRead = new FileInputStream("save.sav");
            saveRead = new ObjectInputStream(saveFileRead);
            auxA = (String) saveRead.readObject();
            auxB = (String) saveRead.readObject();
            System.out.println(auxA);
            System.out.println(auxB);
        }catch(Exception e){
            System.out.println("nonono");
        }
        
    }

    
//Always needs to read all the content of the file.
//Add the temporary variables needed to get to the dessired one.   
//Get from path from .sav.    
    public String getA(){ 
         String auxA = "";
         String auxB;
        try{
            saveFileRead = new FileInputStream("save.sav");
            saveRead = new ObjectInputStream(saveFileRead);
            auxA = (String) saveRead.readObject();
            auxB = (String) saveRead.readObject();
        }catch(Exception e){
        
        }
        return auxA;
    }
//Get to path from .sav.    
    public String getB(){
         String auxA;
         String auxB = "";
        try{
            saveFileRead = new FileInputStream("save.sav");
            saveRead = new ObjectInputStream(saveFileRead);
            auxA = (String) saveRead.readObject();
            auxB = (String) saveRead.readObject();
        }catch(Exception e){
        
        }
        return auxB;
    }
    
    /*public File getFile(){
        File f;
        return new File(saveFile.toString());
    }*/
}
