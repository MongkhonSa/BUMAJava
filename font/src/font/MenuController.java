/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package font;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author ITokkyZ
 */
public class MenuController implements Initializable {
    
    @FXML
    private void ButtomAdd(ActionEvent event) throws IOException {
        Parent addPage = FXMLLoader.load(getClass().getResource("add.fxml"));
        Scene addPage_scene = new Scene(addPage);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(addPage_scene);
        stage.setResizable(false);
        stage.show();
       
    }
   @FXML
    private void ButtomDetails(ActionEvent event) throws IOException {
        Parent detailPage = FXMLLoader.load(getClass().getResource("detail.fxml"));
        Scene detailPage_scene = new Scene(detailPage);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(detailPage_scene);
        stage.setResizable(false);
        stage.show();
}
      @FXML
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
