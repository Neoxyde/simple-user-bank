/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicabanco;

import java.io.IOException;

/**
 *
 * @author dam2
 */
public class Main 
{
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException 
    {
	GestorUsuarios userList = new GestorUsuarios();
	
	
	//Main view instantiated and set visible on controller
	Controller controller = new Controller(userList);
    } 
}
