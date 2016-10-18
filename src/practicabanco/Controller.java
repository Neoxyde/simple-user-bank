/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicabanco;

import interfaz.*;
import java.awt.Component;
import java.awt.Container;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author David
 */
public class Controller
{

    private GestorUsuarios userList;
    private MainView mainView;
    private RegisterView registerView;
    private AccessView accessView;
    private InfoView infoView;
    private ModifyView modifyView;

    public Controller()
    {
    }

    public Controller(GestorUsuarios userList)
    {
        this.userList = userList;
        this.mainView = new MainView(this);
        this.registerView = new RegisterView(this);
        this.accessView = new AccessView(this);
        this.infoView = new InfoView(this);
        this.modifyView = new ModifyView(this);

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
        clearContents(accessView);
        accessView.setVisible(true);
        accessView.setEnabled(true);
    }

    public void switchMainToRegister()
    {
        mainView.setVisible(false);
        mainView.setEnabled(false);
        clearContents(registerView);
        registerView.setVisible(true);
        registerView.setEnabled(true);
    }

    public void switchInfoToModify()
    {
        infoView.setVisible(false);
        infoView.setEnabled(false);
        clearContents(modifyView);
        modifyView.setVisible(true);
        modifyView.setEnabled(true);
    }

    public void cancelAccess()
    {
        accessView.setVisible(false);
        accessView.setEnabled(false);
        clearContents(mainView);
        mainView.setVisible(true);
        mainView.setEnabled(true);
    }

    public void cancelRegister()
    {
        registerView.setVisible(false);
        registerView.setEnabled(false);
        clearContents(mainView);
        mainView.setVisible(true);
        mainView.setEnabled(true);
    }

    public void cancelInfo()
    {
        infoView.setVisible(false);
        infoView.setEnabled(false);
        clearContents(mainView);
        mainView.setVisible(true);
        mainView.setEnabled(true);
    }

    public void cancelModify()
    {
        modifyView.setVisible(false);
        modifyView.setEnabled(false);
        clearContents(mainView);
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
                    access(user, accessView);
                    break;
                case -1:
                    JOptionPane.showMessageDialog(accessView, "El usuario no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(accessView, "La contraseña es incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } else
        {
            JOptionPane.showMessageDialog(accessView, "Por favor, rellene los campos", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
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
        } else
        {
            return false;
        }
    }

    public void access(String userName, JFrame view)
    {
        Usuario user = userList.buscarUsuario(userName);
        infoView.setLabelValues(user.getNombre(), user.getApellidos(),
                user.getEmail(), user.getDni(), user.getUserName(), new String(user.getPassword()));
        view.setVisible(false);
        view.setEnabled(false);
        infoView.setVisible(true);
        infoView.setEnabled(true);
    }

    public void signIn(RegisterView view)
    {
        int random = 1 + (int) (Math.random() * 5);
        String permisos = "";

        switch (random)
        {
            case 1:
                permisos = "Root";
                break;
            case 2:
                permisos = "Senior";
                break;
            case 3:
                permisos = "Junior";
                break;
            case 4:
                permisos = "System";
                break;
            case 5:
                permisos = "Admin";
                break;
            default:
                throw new AssertionError();
        }

        userList.crearNuevoUsuario(view.getTxtName().getText(), view.getTxtSurName().getText(),
                view.getTxtID().getText(), view.getTxtEmail().getText(), permisos,
                view.getTxtUserName().getText(), view.getPswd().getPassword());

        access(view.getTxtUserName().getText(), view);
    }

    public void modifyData(String name, String surname, String email, String id,
            String userName, String pswd)
    {
        infoView.setVisible(false);
        infoView.setEnabled(false);
        modifyView.setPreliminaryData(name, surname, email, id, userName, pswd);
        modifyView.setEnabled(true);
        modifyView.setVisible(true);
    }
    
    public void modifyUser(String lastUser, String name, String surname, String email, String id,
            String userName, String pswd)
    {
        if (name != null)
        {
            userList.modificarUsuario(lastUser, "nombre", name);
        }
        if (surname != null)
        {
            userList.modificarUsuario(lastUser, "apellidos", surname);
        }
        if (email != null)
        {
            userList.modificarUsuario(lastUser, "email", email);
        }
        if (id != null)
        {
            userList.modificarUsuario(lastUser, "dni", id);
        }
        if (userName != null)
        {
            userList.modificarUsuario(lastUser, "userName", userName);
        }
        if (pswd != null)
        {
            userList.modificarUsuario(lastUser, "password", pswd);
        }
        access(userName, modifyView);
    }

    public void clearContents(JFrame frame)
    {
        Container con = frame.getContentPane();
        for (Component c : con.getComponents())
        {
            if (c instanceof JTextField)
            {
                ((JTextField) c).setText("");
            }
        }
    }

}
