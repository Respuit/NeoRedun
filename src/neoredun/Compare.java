/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neoredun;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 *
 * @author respuit
 */
public class Compare {
    private Directory from;
    private Directory to;
    private ArrayList<String> fromList;
    private ArrayList<String> toList;
    private File fileFrom;
    private File fileTo;
    CopyPaste cp = new CopyPaste();
    DiskSpaceCheck diskCheck = new DiskSpaceCheck();
    
    
    public Compare(Directory f, Directory t){
        from = f;
        to = t;
        fromList = from.listContent();
        toList = to.listContent();
        
    }
//Complete path of the array.
    private void completePath(int i){
        fileFrom = new File(from.getPath() + fromList.get(i));
        fileTo = new File(to.getPath() + fromList.get(i));
    }   

//check if the copy folder has each file of the folder you want to copy.    
    public void compara(){
        if(diskCheck.enoughSpace(to.getPath(), from.getPath())) //If there is enought space in disk continiue
        {
            for(int i = 0; i < from.listContent().size(); i++){
                completePath(i);
                if(toList.contains(fromList.get(i)) && !fileFrom.isDirectory()){
                    checkDate(fileFrom, fileTo);
                }else{
                    completePath(i);
                    try{
                        cp.CopyFiles(fileFrom,fileTo);
                    }catch(Exception e){
                    
                    }
                }
            }
            fromFolderCheck();
        }
    }

//Only copy if you modified the file after the last copy.    
    private void checkDate(File f, File t){
        if(f.lastModified()>t.lastModified()){
             //System.out.println(t);
            try{
                cp.CopyFiles(f,t);
            }catch(Exception e){
                    
            }
         }
         
    }
//Check if something is removed from the directory you want to make a copy of, and still remain in the copy directory. I so delete said file.     
    private void fromFolderCheck(){
        for(int i = 0; i < to.listContent().size(); i++){
            if(!fromList.contains(toList.get(i))){
                System.out.println(toList.get(i));
                fileTo = new File(to.getPath() + toList.get(i));
                System.out.println(fileTo);
                cp.removeFiles(fileTo);
                
            }
        }
    }
}
