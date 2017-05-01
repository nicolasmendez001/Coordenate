/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author DiegoNicolas
 */
public class IdNotFoundException extends Exception{
	public IdNotFoundException(){
		
		super("Id no encontrada.");
	}
}
