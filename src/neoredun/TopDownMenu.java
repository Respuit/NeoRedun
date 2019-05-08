/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neoredun;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

/**
 *
 * @author respuit
 */
public class TopDownMenu {
    SaveRead sr = new SaveRead();
    JFileChooser f = new JFileChooser();
    File fileNV = new File("Directory not valid");
    File fget;
    
    public File topDown(int getab){
        try{
            String a = UIManager.getSystemLookAndFeelClassName();
            System.out.println(a);
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
            
        }       
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        f.showSaveDialog(null);
        if(f.getSelectedFile()==null){
            if(getab == 0){
               if(sr.getA().equals("")){
                   return fileNV;
               }
               return fget = new File(sr.getA());
            }else{
                if(sr.getB().equals("")){
                    return fileNV;
                }
                return fget = new File(sr.getB());
           }
        }
        return f.getSelectedFile();
    }
}
