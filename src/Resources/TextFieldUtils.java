/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resources;

import javax.swing.JTextField;

public class TextFieldUtils {
    public static void setupClearTextOnFirstClick(JTextField textField) {
        if (textField.getToolTipText().equals(textField.getText())) {
            textField.setText("");
        }
    }
    public static void setupClearTextOnFirstClickOff(JTextField textField) {
        if(textField.getText().equals("")){
                textField.setText(textField.getToolTipText());
            }
    }

}



