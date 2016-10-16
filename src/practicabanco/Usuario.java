/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicabanco;

/**
 * Usar un hashmap
 *
 * @author dam2
 */
public class Usuario
{

    private String nombre;
    private String apellidos;
    private String dni;
    private String email;
    private String permisos;
    private String userName;
    private char[] password;

    public Usuario()
    {
    }

    public Usuario(String nombre, String apellidos, String dni, String email,
            String permisos, String userName, char[] password)
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.permisos = permisos;
        this.userName = userName;
        this.password = password;
    }

    //Password
    public char[] getPassword()
    {
        return password;
    }

    public void setPassword(char[] password)
    {
        this.password = password;
    }

    //Nombre
    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    //Apellidos
    public String getApellidos()
    {
        return apellidos;
    }

    public void setApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }

    //Dni
    public String getDni()
    {
        return dni;
    }

    public void setDni(String dni)
    {
        this.dni = dni;
    }

    //Email
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    //Permisos
    public String getPermisos()
    {
        return permisos;
    }

    public void setPermisos(String permisos)
    {
        this.permisos = permisos;
    }

    //Usuario
    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

}
