/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditorfxml.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import texteditorfxml.FXMLDocumentController;

/**
 *
 * @author rtbfl
 */
public class EffectsController {
    @FXML private FXMLDocumentController fxmlDocC;
    String[] effects = {"*","_","??","-","+","^","~","{{","}}","bq. ","{quote}","{color:red}","{color}"};
    @FXML private Hyperlink strongLink;
    @FXML private Hyperlink emphasisLink;
    @FXML private Hyperlink citationLink;
    @FXML private Hyperlink deletedLink;
    @FXML private Hyperlink insertedLink;
    @FXML private Hyperlink superscriptLink;
    @FXML private Hyperlink subscriptLink;
    @FXML private Hyperlink monospacedLink;
    @FXML private Hyperlink blockquoteLink;
    @FXML private Hyperlink quoteLink;
    @FXML private Hyperlink colorLink;
    
    public void addEffectsClasses(){
    strongLink.getStyleClass().add("strongLink");
    emphasisLink.getStyleClass().add("emphasisLink");
    citationLink.getStyleClass().add("citationLink");
    deletedLink.getStyleClass().add("deletedLink");
    insertedLink.getStyleClass().add("insertedLink");
    superscriptLink.getStyleClass().add("superscriptLink");
    subscriptLink.getStyleClass().add("subscriptLink");
    monospacedLink.getStyleClass().add("monospacedLink");
    blockquoteLink.getStyleClass().add("blockquoteLink");
    quoteLink.getStyleClass().add("quoteLink");
    colorLink.getStyleClass().add("colorLink");
    }
    
    public void init(FXMLDocumentController fxmlDocumentController) {
        fxmlDocC = fxmlDocumentController;
    }
    
    @FXML 
    private void handleStrongLinkAction(ActionEvent event ) {
        String selectedText = fxmlDocC.getSelectedTextfromTextArea();
        String newText = (effects[0] + selectedText + effects[0]);
        fxmlDocC.replaceSelectedText(newText);
    }
    
    @FXML 
    private void handleEmphasisLinkAction(ActionEvent event ) {
        String selectedText = fxmlDocC.getSelectedTextfromTextArea();
        String newText = (effects[1] + selectedText + effects[1]);
        fxmlDocC.replaceSelectedText(newText);
    }
    
    @FXML 
    private void handleCitationLinkAction(ActionEvent event ) {
        String selectedText = fxmlDocC.getSelectedTextfromTextArea();
        String newText = (effects[2] + selectedText + effects[2]);
        fxmlDocC.replaceSelectedText(newText);
    }
    
    @FXML 
    private void handleDeletedLinkAction(ActionEvent event ) {
        String selectedText = fxmlDocC.getSelectedTextfromTextArea();
        String newText = (effects[3] + selectedText + effects[3]);
        fxmlDocC.replaceSelectedText(newText);
    }
    
    @FXML 
    private void handleInsertedLinkAction(ActionEvent event ) {
        String selectedText = fxmlDocC.getSelectedTextfromTextArea();
        String newText = (effects[4] + selectedText + effects[4]);
        fxmlDocC.replaceSelectedText(newText);
    }
    
    @FXML 
    private void handleSuperScriptLinkAction(ActionEvent event ) {
        String selectedText = fxmlDocC.getSelectedTextfromTextArea();
        String newText = (effects[5] + selectedText + effects[5]);
        fxmlDocC.replaceSelectedText(newText);
    }
    
    @FXML 
    private void handleSubscriptLinkAction(ActionEvent event ) {
        String selectedText = fxmlDocC.getSelectedTextfromTextArea();
        String newText = (effects[6] + selectedText + effects[6]);
        fxmlDocC.replaceSelectedText(newText);
    }
    
    @FXML 
    private void handleMonoSpaceLinkAction(ActionEvent event ) {
        String selectedText = fxmlDocC.getSelectedTextfromTextArea();
        String newText = (effects[7] + selectedText + effects[8]);
        fxmlDocC.replaceSelectedText(newText);
    }
    
    @FXML 
    private void handleBlockquoteLinkAction(ActionEvent event ) {
        String selectedText = fxmlDocC.getSelectedTextfromTextArea();
        String newText = (effects[9] + selectedText);
        fxmlDocC.replaceSelectedText(newText);
    }
    
    @FXML 
    private void handleQuoteLinkAction(ActionEvent event ) {
        String selectedText = fxmlDocC.getSelectedTextfromTextArea();
        String newText = (effects[10] + "\r\n" +  selectedText + "\r\n" + effects[10]);
        fxmlDocC.replaceSelectedText(newText);
    }
    
    @FXML 
    private void handleColorLinkAction(ActionEvent event ) {
        String selectedText = fxmlDocC.getSelectedTextfromTextArea();
        String newText = (effects[11] + "\r\n" +  selectedText + "\r\n" + effects[12]);
        fxmlDocC.replaceSelectedText(newText);
    }
    
    
    
}
