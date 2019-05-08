/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neoredun;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 *
 * @author respuit
 */
public class CopyPaste {
    private Path fromP;
    private Path toP;
    
    
//Just copy a file (REPLACE_EXISTING so there is no need to verify each file manually)    
    public void CopyFiles(File f, File t) throws IOException{
        fromP = f.toPath();
        toP =t.toPath();
        Files.copy(fromP, toP, REPLACE_EXISTING);
    }
//Delete passed file.    
    public void removeFiles(File f){
        f.delete();
    }
}
