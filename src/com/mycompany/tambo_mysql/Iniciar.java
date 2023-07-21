
package com.mycompany.tambo_mysql;

public class Iniciar {
    public static void main(String[]args){
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);//Centra el formulario
    }
}
