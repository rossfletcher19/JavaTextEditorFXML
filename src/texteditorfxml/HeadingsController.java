/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditorfxml;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;

/**
 *
 * @author rtbfl
 */
public class HeadingsController {
    @FXML private FXMLDocumentController fxmlDocC;
    String[] headings = {"h1. ","h2. ","h3. ","h4. ","h5. ","h6. "};
    @FXML public Hyperlink h1Link;
    @FXML public Hyperlink h2Link;
    @FXML public Hyperlink h3Link;
    @FXML public Hyperlink h4Link;
    @FXML public Hyperlink h5Link;
    @FXML public Hyperlink h6Link;
    
    @FXML
    private void handleH1LinkAction(ActionEvent event) {
        String selectedText = fxmlDocC.getSelectedTextfromTextArea();
        String newText = (headings[0] + selectedText);
        fxmlDocC.replaceSelectedText(newText);

    }
    
    @FXML 
    private void handleH2LinkAction(ActionEvent event ) {
        String selectedText = fxmlDocC.getSelectedTextfromTextArea();
        String newText = (headings[1] + selectedText);
        fxmlDocC.replaceSelectedText(newText);
    }
    
    @FXML 
    private void handleH3LinkAction(ActionEvent event ) {
        String selectedText = fxmlDocC.getSelectedTextfromTextArea();
        String newText = (headings[2] + selectedText);
        fxmlDocC.replaceSelectedText(newText);
    }
    
    @FXML 
    private void handleH4LinkAction(ActionEvent event ) {
        String selectedText = fxmlDocC.getSelectedTextfromTextArea();
        String newText = (headings[3] + selectedText);
        fxmlDocC.replaceSelectedText(newText);
    }
    
    @FXML 
    private void handleH5LinkAction(ActionEvent event ) {
        String selectedText = fxmlDocC.getSelectedTextfromTextArea();
        String newText = (headings[4] + selectedText);
        fxmlDocC.replaceSelectedText(newText);
    }
    
    @FXML 
    private void handleH6LinkAction(ActionEvent event ) {
         String selectedText = fxmlDocC.getSelectedTextfromTextArea();
        String newText = (headings[5] + selectedText);
        fxmlDocC.replaceSelectedText(newText);
    }
    
    public void addHeadingsClasses(){
        h1Link.getStyleClass().add("h1Link");
        h2Link.getStyleClass().add("h2Link");
        h3Link.getStyleClass().add("h3Link");
        h4Link.getStyleClass().add("h4Link");
        h5Link.getStyleClass().add("h5Link");
        h6Link.getStyleClass().add("h6Link");
    }
    
    public void init(FXMLDocumentController fxmlDocumentController) {
        fxmlDocC = fxmlDocumentController;
    }

}
