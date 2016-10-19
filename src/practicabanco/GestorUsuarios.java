/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicabanco;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author dam2
 */
public class GestorUsuarios
{
		//Indexado por nombre
    private Map<String,Usuario> userList = new HashMap<>();
    
    private final Gson gson = new Gson();
    
    public GestorUsuarios()
    {
    }
    
    
    public void crearNuevoUsuario(String nombre, String apellidos, String dni,
            String email, String permisos, String userName, char[] password)
    {
        
        userList.put(userName, new Usuario(nombre, apellidos, dni, email,
                permisos, userName, password));        
    }
    
    public boolean isMapped(String key)
    {
	return userList.containsKey(key);
    }
    
    
    public Usuario buscarUsuario(String userName)
    {
        return userList.get(userName);
    }
    
    
    public int comprobarLogin(String userName, char[] password)
    {
	int token = 1;
	if (userList.containsKey(userName))
	{
	    char[] truePassword = userList.get(userName).getPassword();
	    if (password.length != truePassword.length)
	    {
		token = -2;
	    }
	    else
	    {
		if (!Arrays.equals(password, truePassword))
		{
		    token = -2;
		}
	    }
	    Arrays.fill(password, '0');	    
	}
	else
	{
	    token = -1;
	}
	return token;
    }
    
    
    /**
     * Modifica un usuario segun el userName.
     * <p>
     *  Devuelve un entero significativo del resultado de la operación.
     * </p>
     * @param userName El usuario      
     * @param campo
     * @param nuevoValor
     * @return 
     */
    public int modificarUsuario(String userName, String campo, String nuevoValor)
    {
        Usuario toModify = buscarUsuario(userName);
        
        int responseKey;
        
        //Comprobar que el usuario a modificar existe
        if (toModify == null)
        {
            return -2;
        }
        
        switch (campo)
        {
            case "nombre":
                toModify.setNombre(nuevoValor);
                responseKey = 1;
                break;
            case "apellidos":
                toModify.setApellidos(nuevoValor);
                responseKey = 1;
                break;
            case "dni":
                toModify.setDni(nuevoValor);
                responseKey = 1;
                break;
            case "email":
                toModify.setEmail(nuevoValor);
                responseKey = 1;
                break;
            case "permisos":
                toModify.setPermisos(nuevoValor);
                responseKey = 1;
                break;
            case "password":
                toModify.setPassword(nuevoValor.toCharArray());
                responseKey = 1;
                break;
            case "userName":
                if (buscarUsuario(nuevoValor) != null)
                {
                    responseKey = -1;
                }
                else
                {
                    toModify.setUserName(nuevoValor);
		    userList.remove(userName);
		    userList.put(nuevoValor, toModify);
                    responseKey = 1;
                }
		break;
            default:
                throw new AssertionError();
        }
        
        return responseKey;
    }
    
    
    
    public void serialize() throws IOException
    {
	try (FileWriter writer = new FileWriter
		    ("Data.json"))
	{
	    String json = this.gson.toJson(this.userList);
	    
	    writer.write(json);
	}	
    }
    
    public void read() throws FileNotFoundException
    {
        File file       = new File("Data.json");
        
        Scanner reader  = new Scanner(file);
        
	if (reader.hasNextLine())
	{
	    String json     = reader.nextLine();
        
	    Type stringUserType	= new TypeToken<Map<String,Usuario>>(){}.getType();

	    this.userList   = (Map<String,Usuario>) this.gson.fromJson(json, stringUserType);
	}
    }
}
