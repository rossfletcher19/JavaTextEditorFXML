/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditorfxml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JFileChooser;

/**
 *
 * @author rtbfl
 */
public class FXMLDocumentController implements Initializable {
    private Stage primaryStage;
    @FXML private TextArea textArea;
    @FXML private final TextArea textArea2 = new TextArea();
    String selectedText = new String();
    @FXML private GridPane gridpaneLeft;
    String documentsPath = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
    String[] headings = {"h1. ","h2. ","h3. ","h4. ","h5. ","h6. "};
    @FXML private Hyperlink h1Link;
    @FXML private Hyperlink h2Link;
    @FXML private Hyperlink h3Link;
    @FXML private Hyperlink h4Link;
    @FXML private Hyperlink h5Link;
    @FXML private Hyperlink h6Link;
    
    
    
    @FXML 
    private void handleH1LinkAction(ActionEvent event ) {
        this.selectedText = this.textArea.getSelectedText();
        textArea.replaceSelection(headings[0] + selectedText);
    }
    
    @FXML 
    private void handleH2LinkAction(ActionEvent event ) {
        this.selectedText = this.textArea.getSelectedText();
        textArea.replaceSelection(headings[1] + selectedText); 
    }
    
        @FXML 
    private void handleH3LinkAction(ActionEvent event ) {
        this.selectedText = this.textArea.getSelectedText();
        textArea.replaceSelection(headings[2] + selectedText); 
    }
    
        @FXML 
    private void handleH4LinkAction(ActionEvent event ) {
        this.selectedText = this.textArea.getSelectedText();
        textArea.replaceSelection(headings[3] + selectedText); 
    }
    
        @FXML 
    private void handleH5LinkAction(ActionEvent event ) {
        this.selectedText = this.textArea.getSelectedText();
        textArea.replaceSelection(headings[4] + selectedText); 
    }
    
        @FXML 
    private void handleH6LinkAction(ActionEvent event ) {
        this.selectedText = this.textArea.getSelectedText();
        textArea.replaceSelection(headings[5] + selectedText); 
    }
    
    private void createOpeningFile(File file){
        
        
    }
    
    private void createOpeningFolder(){
//        String documentsPath = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
        Path path = Paths.get(documentsPath + "\\jc");

        if (Files.exists(path)) {
                System.out.println("folder already created.");
        } else {
        new File(documentsPath + "\\jc").mkdir();
        }
    }
    
    
    @FXML
    private void saveFile(ActionEvent event){
        
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(primaryStage);

        if(file != null){

            Save(textArea.getText().replaceAll("\n", System.getProperty("line.separator")), file);
        } 
    }
    
    
    private void Save(String content, File file){
        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class
                .getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void addClasses(){
    gridpaneLeft.getStyleClass().add("gridPaneLeft");
    h1Link.getStyleClass().add("h1Link");
    h2Link.getStyleClass().add("h2Link");
    h3Link.getStyleClass().add("h3Link");
    h4Link.getStyleClass().add("h4Link");
    h5Link.getStyleClass().add("h5Link");
    h6Link.getStyleClass().add("h6Link");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textArea.setWrapText(true);
        createOpeningFolder();
        addClasses();
        Timer timer = new Timer();
        TimerTask task = new AutoSave();
        timer.schedule(task, 2000, 5000); 

    }
    
    
    class AutoSave extends TimerTask {
        
        @Override
        public void run() { 
                
            if(textArea2.getText().equals(textArea.getText())){
                // do nothing
            } else {
                // autosave file with first line of TextArea as Filename
                String[] firstLineFileName = textArea.getText().split("\\n");
                File file = new File(String.format(documentsPath + "\\jc\\%s.txt", firstLineFileName[0]));
                Save(textArea.getText().replaceAll("\n", System.getProperty("line.separator")), file);
                textArea2.setText(textArea.getText());
            
            }
                
      
        } 
    
    }
    
}
