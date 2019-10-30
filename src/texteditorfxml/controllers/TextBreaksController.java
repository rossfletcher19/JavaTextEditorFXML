/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditorfxml.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import texteditorfxml.FXMLDocumentController;

/**
 * FXML Controller class
 *
 * @author rtbfl
 */
public class TextBreaksController {
    @FXML private FXMLDocumentController fxmlDocC;
    String[] textBreaks = {"(empty line)","\\","----","---","--"};
    @FXML public Hyperlink emptyLineAboveLink;
    @FXML public Hyperlink emptyLineBelowLink;
    
    
    public void addTextBreaksClasses(){
        emptyLineAboveLink.getStyleClass().add("emptyLineAboveLink");
        emptyLineBelowLink.getStyleClass().add("emptyLineBelowLink");
        
    }
    
    public void init(FXMLDocumentController fxmlDocumentController) {
        fxmlDocC = fxmlDocumentController;
    }
    
    @FXML
    private void handleEmptyLineAboveAction(ActionEvent event) {
        String selectedText = fxmlDocC.getSelectedTextfromTextArea();
        String newText = (textBreaks[0] + "\n" + selectedText);
        fxmlDocC.replaceSelectedText(newText);
    }
    
    @FXML
    private void handleEmptyLineBelowAction(ActionEvent event) {
        String selectedText = fxmlDocC.getSelectedTextfromTextArea();
        String newText = ( selectedText + "\n" + textBreaks[0]);
        fxmlDocC.replaceSelectedText(newText);
    }
   
    
}
