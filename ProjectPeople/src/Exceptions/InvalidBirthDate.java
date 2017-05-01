/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author RA302
 */
public class InvalidBirthDate extends Exception{
        public InvalidBirthDate(){
            super("Fecha de nacimiento digitada invalida.");
        }
}
