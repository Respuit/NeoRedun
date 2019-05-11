/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepotions;

/**
 *
 * @author respuit
 */
public class DiskSpaceException extends Exception{
    public DiskSpaceException(){
        
    }
    public DiskSpaceException(String message){
        super(message);
    }
}
