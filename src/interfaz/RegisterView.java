/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import practicabanco.Controller;

/**
 *
 * @author David
 */
public class RegisterView extends javax.swing.JFrame
{
    
    private Controller controller;
    boolean[] fields = new boolean[6];

    /**
     * Creates new form RegisterWindow
     */
    public RegisterView()
    {
	initComponents();
    }

    public RegisterView(Controller controller)
    {
	initComponents();
	this.controller = controller;
	this.lblEmail.setText("");
	this.lblID.setText("");
	this.lblName.setText("");
	this.lblPass1.setText("");
	this.lblPass2.setText("");
	this.lblSurname.setText("");
	this.lblUsername.setText("");

	this.txtID.getDocument().addDocumentListener(new FieldsValidator("txtID"));
	this.txtSurName.getDocument().addDocumentListener(new FieldsValidator("txtSurname"));
	this.txtName.getDocument().addDocumentListener(new FieldsValidator("txtName"));
	this.txtUserName.getDocument().addDocumentListener(new FieldsValidator("txtUsername"));
	this.pswd.getDocument().addDocumentListener(new FieldsValidator("pswd"));
	this.txtEmail.getDocument().addDocumentListener(new FieldsValidator("txtEmail"));

	for (int i = 0; i < fields.length; i++)
	{
	    fields[i] = true;
	}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        txtName = new javax.swing.JTextField();
        txtSurName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtUserName = new javax.swing.JTextField();
        pswd = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSend = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        lblSurname = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPass1 = new javax.swing.JLabel();
        lblPass2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DataTron - Register");

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellidos");

        jLabel3.setText("Correo electrónico");

        jLabel4.setText("DNI");

        jLabel5.setText("Nombre de Usuario");

        jLabel6.setText("Contraseña");

        btnSend.setText("Enviar");
        btnSend.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSendActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCancelActionPerformed(evt);
            }
        });

        lblName.setText("jLabel7");

        lblSurname.setText("jLabel8");

        lblEmail.setText("jLabel9");

        lblID.setText("jLabel10");

        lblUsername.setText("jLabel11");

        lblPass1.setText("jLabel12");

        lblPass2.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(btnSend)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancel)
                .addGap(102, 102, 102))
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName)
                            .addComponent(txtSurName)
                            .addComponent(txtEmail)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(pswd))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPass2)
                    .addComponent(lblName)
                    .addComponent(lblSurname)
                    .addComponent(lblEmail)
                    .addComponent(lblID)
                    .addComponent(lblUsername)
                    .addComponent(lblPass1))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblName))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSurName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSurname)))
                            .addComponent(jLabel2))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(lblEmail))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblID)))
                    .addComponent(jLabel4))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(lblUsername))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPass1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPass2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSend)
                    .addComponent(btnCancel))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCancelActionPerformed
    {//GEN-HEADEREND:event_btnCancelActionPerformed
	controller.cancelRegister();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSendActionPerformed
    {//GEN-HEADEREND:event_btnSendActionPerformed
	controller.signIn(this);
    }//GEN-LAST:event_btnSendActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
	/* Set the Nimbus look and feel */
	//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	 */
	try
	{
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
	    {
		if ("Nimbus".equals(info.getName()))
		{
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException ex)
	{
	    java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex)
	{
	    java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex)
	{
	    java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex)
	{
	    java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable()
	{
	    public void run()
	    {
		new RegisterView().setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPass1;
    private javax.swing.JLabel lblPass2;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField pswd;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSurName;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables

    class FieldsValidator implements DocumentListener
    {

	//TODO method that checks if fields are OK and enables or disables button,
	//instead of searching for it in every validation method.
	String name;

	public FieldsValidator(String name)
	{
	    this.name = name;
	}

	@Override
	public void insertUpdate(DocumentEvent e)
	{
	    checkToValidate();
	}

	@Override
	public void removeUpdate(DocumentEvent e)
	{
	    checkToValidate();
	}

	@Override
	public void changedUpdate(DocumentEvent e)
	{
	    checkToValidate();
	}

	private void checkToValidate()
	{
	    switch (this.name)
	    {
		case "txtName":
		    validateName();
		    break;
		case "txtSurname":
		    validateSurname();
		    break;
		case "txtEmail":
		    validateEmail();
		    break;
		case "txtID":
		    validateID();
		    break;
		case "txtUsername":
		    validateUsername();
		    break;
		case "pswd":
		    validatePswrd();
		default:
		    break;
	    }
	}

	private void validateEmail()
	{
	    Pattern pattern = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}");
	    Matcher matcher = pattern.matcher(txtEmail.getText().toUpperCase());

	    if (!matcher.matches())
	    {
		lblEmail.setText("Formato inválido.");
		fields[0] = false;
	    } else
	    {
		lblEmail.setText("");
		fields[0] = true;
	    }
	    checkValidations();
	}

	private void validateUsername()
	{
	    String userName = txtUserName.getText();

	    if (controller.isValidText(userName))
	    {
		if (controller.checkUserExistence(userName))
		{
		    lblUsername.setText("El usuario ya existe.");
		    fields[1] = false;
		} else
		{
		    lblUsername.setText("");
		    fields[1] = true;
		}
	    }
	    checkValidations();
	}

	private void validatePswrd()
	{
	    char[] pass = pswd.getPassword();

	    if (pass.length <= 6)
	    {
		lblPass1.setText("La contraseña debe tener al");
		lblPass2.setText("menos siete caracteres.");
		fields[2] = false;
	    } else
	    {
		lblPass1.setText("");
		lblPass2.setText("");
		fields[2] = true;
	    }
	    checkValidations();
	}

	private void validateID()
	{
	    Pattern pattern = Pattern.compile("(\\d{1,8})([A-Z])");
	    Matcher matcher = pattern.matcher(txtID.getText().toUpperCase());

	    if (!matcher.matches())
	    {
		lblID.setText("Formato inválido.");
		fields[3] = false;
	    } else
	    {
		lblID.setText("");
		fields[3] = true;
	    }
	    checkValidations();
	}

	private void validateName()
	{
	    String name = txtName.getText();
	    if (controller.isValidText(name))
	    {
		if (!validateCapitalLetter(name))
		{
		    lblName.setText("Respete a la RAE.");
		    fields[4] = false;
		} else
		{
		    lblName.setText("");
		    fields[4] = true;
		}
	    }
	    checkValidations();
	}

	private void validateSurname()
	{
	    String surname = txtSurName.getText();
	    if (controller.isValidText(surname))
	    {
		if (!validateCapitalLetter(surname))
		{
		    lblSurname.setText("Respete a la RAE.");
		    fields[5] = false;
		} else
		{
		    lblSurname.setText("");
		    fields[5] = true;
		}
	    }
	    checkValidations();
	}

	private boolean validateCapitalLetter(String phrase)
	{
	    return phrase.equals(capitalizeString(phrase));
	}

	private String capitalizeString(String string)
	{
	    char[] chars = string.toLowerCase().toCharArray();
	    boolean found = false;
	    for (int i = 0; i < chars.length; i++)
	    {
		if (!found && Character.isLetter(chars[i]))
		{
		    chars[i] = Character.toUpperCase(chars[i]);
		    found = true;
		} else if (Character.isWhitespace(chars[i]))
		{ // You can add other chars here
		    found = false;
		}
	    }
	    return String.valueOf(chars);
	}

	private void checkValidations()
	{
	    boolean flag = true;
	    int i = 0;
	    while (flag && i < fields.length)
	    {
		if (!fields[i])
		{
		    flag = false;
		}
		i++;
	    }
	    btnSend.setEnabled(flag);
	}
    }
    //<editor-fold defaultstate="collapse" desc="Getters and setters">
    public JPasswordField getPswd()
    {
	return pswd;
    }

    public void setPswd(JPasswordField pswd)
    {
	this.pswd = pswd;
    }

    public JTextField getTxtEmail()
    {
	return txtEmail;
    }

    public void setTxtEmail(JTextField txtEmail)
    {
	this.txtEmail = txtEmail;
    }

    public JTextField getTxtID()
    {
	return txtID;
    }

    public void setTxtID(JTextField txtID)
    {
	this.txtID = txtID;
    }

    public JTextField getTxtName()
    {
	return txtName;
    }

    public void setTxtName(JTextField txtName)
    {
	this.txtName = txtName;
    }

    public JTextField getTxtSurName()
    {
	return txtSurName;
    }

    public void setTxtSurName(JTextField txtSurName)
    {
	this.txtSurName = txtSurName;
    }

    public JTextField getTxtUserName()
    {
	return txtUserName;
    }

    public void setTxtUserName(JTextField txtUserName)
    {
	this.txtUserName = txtUserName;
    }
    //</editor-fold>
    
}
