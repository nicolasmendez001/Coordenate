package Exceptions;

public class ErrorBirthDate extends Exception { 
  
    public ErrorBirthDate(){
        super("Eror en la fecha de nacimiento, fecha invalida.");
    }
}
