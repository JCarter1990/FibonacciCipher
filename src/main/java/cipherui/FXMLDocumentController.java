/*
 * Copyright (C) 2018 JCarter
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package cipherui;

import ciphercore.Cipher;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author JCarter
 */
public class FXMLDocumentController implements Initializable
{
    @FXML
    private TextField inputString;
    @FXML
    private TextField cipherKey;
    @FXML
    private TextArea displayString;
    
    Alert stringAlert = new Alert(AlertType.WARNING,"You must input a string.");
    Alert keyAlert = new Alert(AlertType.WARNING, "You must input a key.");
    
    @FXML
    private void handleEncryption(ActionEvent event)
    {
        if(inputString.getText().equals(""))
        {
            stringAlert.showAndWait();
        }
        else if(cipherKey.getText().equals(""))
        {
            keyAlert.showAndWait();
        }
        else
        {
            displayString.clear();
            displayString.setText(Cipher.encrypt(inputString.getText(),
                                        Integer.parseInt(cipherKey.getText())));
        }
    }
    
    @FXML
    private void handleDecryption(ActionEvent event)
    {
        if(inputString.getText().equals(""))
        {
            stringAlert.showAndWait();
        }
        else if(cipherKey.getText().equals(""))
        {
            keyAlert.showAndWait();
        }
        else
        {
            displayString.clear();
            displayString.setText(Cipher.decrypt(inputString.getText(),
                                        Integer.parseInt(cipherKey.getText())));
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        displayString.setEditable(false);
    }    
    
}
