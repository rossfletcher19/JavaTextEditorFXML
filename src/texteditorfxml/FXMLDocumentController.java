/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditorfxml;

import texteditorfxml.controllers.EffectsController;
import texteditorfxml.controllers.HeadingsController;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
/**
 *
 * @author rtbfl
 */
public class FXMLDocumentController {
    @FXML private HeadingsController fxmlheadingsController;
    @FXML private EffectsController fxmleffectsController;
    private Stage primaryStage;
    @FXML public TextArea textArea;
    @FXML private final TextArea textArea2 = new TextArea();
    String selectedText = new String();
    @FXML private GridPane gridpaneLeft;
    String documentsPath = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
    
    public String getSelectedTextfromTextArea(){
        return textArea.getSelectedText();
    }
    
    public void replaceSelectedText(String string){
        textArea.replaceSelection(string);
    }
    
    private void createOpeningFolder(){
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
    

    
    @FXML public void initialize() {
        fxmlheadingsController.init(this);
        fxmleffectsController.init(this);
        fxmlheadingsController.addHeadingsClasses();
        fxmleffectsController.addEffectsClasses();
        textArea.setWrapText(true);
        createOpeningFolder();
        Timer timer = new Timer();
        TimerTask task = new AutoSave();
        timer.schedule(task, 2000, 60000); 
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
