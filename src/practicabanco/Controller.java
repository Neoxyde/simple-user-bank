/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicabanco;
import interfaz.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class Controller
{
    private GestorUsuarios userList;
    private JFrame mainView;
    private JFrame registerView;
    private JFrame accessView;
    

    public Controller()
    {	
    }

    public Controller(GestorUsuarios userList)
    {
	this.userList	= userList;
	this.mainView	= new MainView(this);
	this.registerView   = new RegisterView(this);
	this.accessView	= new AccessView(this);
	
	this.mainView.setEnabled(true);
	this.mainView.setVisible(true);
	
	//TODO: Better exception handling. Specifically a FATAL 404 ERROR window.
	try
	{
	    this.userList.read();
	} catch (FileNotFoundException ex)
	{
	    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    public void switcMainToAccess()
    {
	mainView.setVisible(false);
	mainView.setEnabled(false);
	accessView.setVisible(true);
	accessView.setEnabled(true);
    }
    
    public void switchMainToRegister()
    {
	mainView.setVisible(false);
	mainView.setEnabled(false);
	registerView.setVisible(true);
	registerView.setEnabled(true);
    }
    
    public void cancelAccess()
    {
	accessView.setVisible(false);
	accessView.setEnabled(false);
	mainView.setVisible(true);
	mainView.setEnabled(true);
    }
    
    public void cancelRegister()
    {
	registerView.setVisible(false);
	registerView.setEnabled(false);
	mainView.setVisible(true);
	mainView.setEnabled(true);
    }
    
    public void exit(JFrame window)
    {
	try
	{
	    userList.serialize();
	} catch (IOException e)
	{
	    JOptionPane.showMessageDialog(window, "No se pudieron guardar los datos modificados", "Error", JOptionPane.ERROR_MESSAGE);
	}	
    }
    
    public void validateAccess(String user, char[] password)
    {
	if (isValidText(user))
	{
	    int token = userList.comprobarLogin(user, password);
	    switch (token)
	    {
		//TODO Create user data view when login is correct and link case to it.
	    	case 1:
		    System.out.println("A");
		    break;
	    	case -1:
		    JOptionPane.showMessageDialog
			(accessView, "El usuario no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
		    break;
	    	default:
		    JOptionPane.showMessageDialog
			(accessView, "La contraseña es incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
		    break;
	    }
	}
	else
	{
	    JOptionPane.showMessageDialog
		(accessView, "Por favor, rellene los campos", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
	}
    }
    
    //This method serves as a link between the views listeners and the isMapped method in model. For model-view separation purposes.
    public boolean checkUserExistence(String userName)
    {
	return userList.isMapped(userName);
    }
    
    public boolean isValidText(String text)
    {
	if (text != null)
	{
	    return !text.trim().isEmpty();
	}
	else
	{
	    return false;
	}
    }
    
    //TODO handle the result of validation
    public void validatePswd(char[] pswd)
    {
	boolean flag = true;
	if (pswd.length < 6)
	{
	    flag = false;
	}
    }
    
    public void validateName(String name)
    {
	
    }
    
    public void validateSurname(String surname)
    {
	
    }
    
    public void validateID(String id)
    {
	
    }
    
    public void validateEmail(String email)
    {
	
    }
    
    
}
