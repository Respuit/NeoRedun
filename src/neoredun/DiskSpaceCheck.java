/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neoredun;


import java.awt.FlowLayout;
import java.io.File;
import javax.swing.JFrame;

/**
 *
 * @author respuit
 */
public class DiskSpaceCheck {
    
    
    public boolean enoughSpace(File disk, File dir){
        if(spaceOnDisk(disk) >= dirSize(dir)){
            return true;
        }else{
            System.out.println("espacio insuficiente");
            
        //Display a panel with the error. Need an Jframe to display     
            NotSpaceDisk nsd = new NotSpaceDisk();    
            JFrame frame = new JFrame();
            frame.setSize(512, 100); 
            frame.setLocationRelativeTo(null);
            frame.add(nsd);
            frame.setVisible(true);
            return false;
        }
    }
//Space free on the disk you are going to make a copy.    
    private float spaceOnDisk(File f){
        long freeSpace = f.getFreeSpace();
        return freeSpace;
    }

//Space needed.    
    public static float dirSize(File directory) {
        float size = 0;
        for (File file : directory.listFiles()) {
        if (file.isFile())
            size += file.length();
        else
            size += dirSize(file);
    }
    return size;
}
}
