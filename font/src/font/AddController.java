/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package font;

import backend.*;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.events.JFXDialogEvent;
import database.*;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author ITokkyZ
 */
public class AddController {
    
       
    @FXML
    private TextField TextFieldID;

    @FXML
    private TextField TextFieldName;

    @FXML
    private TextField TextFieldPrice;

    @FXML
    private TextField TextFieldAmount;

    @FXML
    private DatePicker  TextFieldArrivelDate;

    @FXML
    private DatePicker TextFieldEXP;

    @FXML
    private TextField TextFieldFactory;

    @FXML
    private TextField TextFieldProfit;

    ObservableList<String> typeList = FXCollections.observableArrayList("Food","Drink","Alcohol","Book");
    ObservableList<String> subFoodList = FXCollections.observableArrayList("Weight","Quantity");
    ObservableList<String> subBookList = FXCollections.observableArrayList("Cartoon","Magazine","Fiction");
    ObservableList<String> dummy = FXCollections.observableArrayList();
     
     @FXML
     private ComboBox typeBox; 
     @FXML
     private ComboBox subTypeBox;
     
    @FXML
    private StackPane confirmStackPane;
    
    @FXML
    	private JFXDialog confirm = null;
    @FXML
        private JFXDialogLayout content = new JFXDialogLayout();
    
    @FXML
    private Label newType;

    @FXML
    private Label newSubType;

    @FXML
    private Label newId;

    @FXML
    private Label newName;

    @FXML
    private Label newArrivalDate;

    @FXML
    private Label newEXP;

    @FXML
    private Label newPrice;

    @FXML
    private Label newAmount;

    @FXML
    private Label newProfit;

    @FXML
    private Label newFactory;
    @FXML
    private Label newTotalPrice;
        
	Object newItems;
       
    @FXML
    private void AddToObect(ActionEvent event) throws IOException {
              
        
        ConnectDB newDB = new ConnectDB();
        if(typeBox.getValue().equals("Alcohol")){
           
             Alcohol newAlcohol= new Alcohol(Long.parseLong(TextFieldID.getText()),
                TextFieldName.getText(),TextFieldEXP.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                     TextFieldArrivelDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                TextFieldFactory.getText(),Double.parseDouble(TextFieldAmount.getText()),
                Double.parseDouble(TextFieldPrice.getText()),
                Double.parseDouble(TextFieldProfit.getText()));
             
                newType.setText((String) typeBox.getValue());
                newSubType.setText((String) subTypeBox.getValue());
                newId.setText(String.valueOf(newAlcohol.getId()));
                newName.setText(newAlcohol.getName());
                newEXP.setText(newAlcohol.getEXP());
                newArrivalDate.setText(newAlcohol.getArrivalDate());
                newPrice.setText(String.valueOf(newAlcohol.getPrice()));
                newAmount.setText(String.valueOf(newAlcohol.getAmount()));
                newProfit.setText(String.valueOf(newAlcohol.getProfit()));
                newTotalPrice.setText(String.valueOf(newAlcohol.getTotalPrice()));
                newFactory.setText(String.valueOf(newAlcohol.getFactory()));
                newItems = newAlcohol;
                
                confirmStackPane.setVisible(true);
                    
     
         }
        else if(typeBox.getValue().equals("Drink")){
     
            Drinks newDrinks = new Drinks(Long.parseLong(TextFieldID.getText()),
                    TextFieldName.getText(),TextFieldEXP.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                    ,TextFieldArrivelDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                    TextFieldFactory.getText(),Double.parseDouble(TextFieldAmount.getText()),
                    Double.parseDouble(TextFieldPrice.getText()),
                    Double.parseDouble(TextFieldProfit.getText()));
                    
                    newType.setText((String) typeBox.getValue());
                    newSubType.setText((String) subTypeBox.getValue());
                    newId.setText(String.valueOf(newDrinks.getId()));
                    newName.setText(newDrinks.getName());
                    newArrivalDate.setText(newDrinks.getArrivalDate());
                    newEXP.setText(newDrinks.getEXP());
                    newPrice.setText(String.valueOf(newDrinks.getPrice()));
                    newAmount.setText(String.valueOf(newDrinks.getAmount()));
                    newProfit.setText(String.valueOf(newDrinks.getProfit()));
                    newTotalPrice.setText(String.valueOf(newDrinks.getTotalPrice()));
                    newFactory.setText(String.valueOf(newDrinks.getFactory()));
                    newItems = newDrinks;
                
                    confirmStackPane.setVisible(true);
         }
        else if(typeBox.getValue().equals("Food")){
            if(subTypeBox.getValue().equals("Weight")){
                   Weight newWeight = new Weight(Long.parseLong(TextFieldID.getText()),
                        TextFieldName.getText(),TextFieldEXP.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                           ,TextFieldArrivelDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        TextFieldFactory.getText(),Double.parseDouble(TextFieldAmount.getText()),
                        Double.parseDouble(TextFieldPrice.getText()),
                        Double.parseDouble(TextFieldProfit.getText()));
                            
                        newType.setText((String) typeBox.getValue());
                        newSubType.setText((String) subTypeBox.getValue());
                        newId.setText(String.valueOf(newWeight.getId()));
                        newName.setText(newWeight.getName());
                        newArrivalDate.setText(newWeight.getArrivalDate());
                        newEXP.setText(newWeight.getEXP());
                        newPrice.setText(String.valueOf(newWeight.getPrice()));
                        newAmount.setText(String.valueOf(newWeight.getAmount()));
                        newProfit.setText(String.valueOf(newWeight.getProfit()));
                        newTotalPrice.setText(String.valueOf(newWeight.getTotalPrice()));
                        newFactory.setText(String.valueOf(newWeight.getFactory()));
                        newItems = newWeight;    
                   
                        confirmStackPane.setVisible(true);
             }
            else if(subTypeBox.getValue().equals("Quantity")){
                    
                    Quantity newQuantity = new Quantity(Long.parseLong(TextFieldID.getText()),
                        TextFieldName.getText(),TextFieldEXP.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                            ,TextFieldArrivelDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        TextFieldFactory.getText(),Double.parseDouble(TextFieldAmount.getText()),
                        Double.parseDouble(TextFieldPrice.getText()),
                        Double.parseDouble(TextFieldProfit.getText()));
                            
                        newType.setText((String) typeBox.getValue());
                        newSubType.setText((String) subTypeBox.getValue());
                        newId.setText(String.valueOf(newQuantity.getId()));
                        newName.setText(newQuantity.getName());
                        newArrivalDate.setText(newQuantity.getArrivalDate());
                        newEXP.setText(newQuantity.getEXP());
                        newPrice.setText(String.valueOf(newQuantity.getPrice()));
                        newAmount.setText(String.valueOf(newQuantity.getAmount()));
                        newProfit.setText(String.valueOf(newQuantity.getProfit()));
                        newTotalPrice.setText(String.valueOf(newQuantity.getTotalPrice()));
                        newFactory.setText(String.valueOf(newQuantity.getFactory()));
                        newItems = newQuantity;    
                    
                        confirmStackPane.setVisible(true);
            }
            
             
         }
        else if(typeBox.getValue().equals("Book")){
            if(subTypeBox.getValue().equals("Cartoon")){
                    Cartoon newCartoon = new Cartoon(Long.parseLong(TextFieldID.getText()),
                        TextFieldName.getText(),TextFieldEXP.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                            ,TextFieldArrivelDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        TextFieldFactory.getText(),Double.parseDouble(TextFieldAmount.getText()),
                        Double.parseDouble(TextFieldPrice.getText()),
                        Double.parseDouble(TextFieldProfit.getText()));
                        
                        newType.setText((String) typeBox.getValue());
                        newSubType.setText((String) subTypeBox.getValue());
                        newId.setText(String.valueOf(newCartoon.getId()));
                        newName.setText(newCartoon.getName());
                        newArrivalDate.setText(newCartoon.getArrivalDate());
                        newEXP.setText(newCartoon.getEXP());
                        newPrice.setText(String.valueOf(newCartoon.getPrice()));
                        newAmount.setText(String.valueOf(newCartoon.getAmount()));
                        newProfit.setText(String.valueOf(newCartoon.getProfit()));
                        newTotalPrice.setText(String.valueOf(newCartoon.getTotalPrice()));
                        newFactory.setText(String.valueOf(newCartoon.getFactory()));
                        newItems = newCartoon;    
                    
                        confirmStackPane.setVisible(true);
             }
            else if(subTypeBox.getValue().equals("Magazine")){
                    Magazine newMagazine = new Magazine(Long.parseLong(TextFieldID.getText()),
                        TextFieldName.getText(),TextFieldEXP.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                            ,TextFieldArrivelDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        TextFieldFactory.getText(),Double.parseDouble(TextFieldAmount.getText()),
                        Double.parseDouble(TextFieldPrice.getText()),
                        Double.parseDouble(TextFieldProfit.getText()));
                        
                        newType.setText((String) typeBox.getValue());
                        newSubType.setText((String) subTypeBox.getValue());
                        newId.setText(String.valueOf(newMagazine.getId()));
                        newName.setText(newMagazine.getName());
                        newArrivalDate.setText(newMagazine.getArrivalDate());
                        newEXP.setText(newMagazine.getEXP());
                        newPrice.setText(String.valueOf(newMagazine.getPrice()));
                        newAmount.setText(String.valueOf(newMagazine.getAmount()));
                        newProfit.setText(String.valueOf(newMagazine.getProfit()));
                        newTotalPrice.setText(String.valueOf(newMagazine.getTotalPrice()));
                        newFactory.setText(String.valueOf(newMagazine.getFactory()));
                        newItems = newMagazine;  
                        
                        confirmStackPane.setVisible(true);
             }
            else if(subTypeBox.getValue().equals("Fiction")){
                    Fiction newFiction = new Fiction(Long.parseLong(TextFieldID.getText()),
                        TextFieldName.getText(),TextFieldEXP.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                            ,TextFieldArrivelDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        TextFieldFactory.getText(),Double.parseDouble(TextFieldAmount.getText()),
                        Double.parseDouble(TextFieldPrice.getText()),
                        Double.parseDouble(TextFieldProfit.getText()));
                    
                        newType.setText((String) typeBox.getValue());
                        newSubType.setText((String) subTypeBox.getValue());
                        newId.setText(String.valueOf(newFiction.getId()));
                        newName.setText(newFiction.getName());
                        newArrivalDate.setText(newFiction.getArrivalDate());
                        newEXP.setText(newFiction.getEXP());
                        newPrice.setText(String.valueOf(newFiction.getPrice()));
                        newAmount.setText(String.valueOf(newFiction.getAmount()));
                        newProfit.setText(String.valueOf(newFiction.getProfit()));
                        newTotalPrice.setText(String.valueOf(newFiction.getTotalPrice()));
                        newFactory.setText(String.valueOf(newFiction.getFactory()));
                        newItems = newFiction;  
                    
                        confirmStackPane.setVisible(true);
             }
             
         }
        
       
        
        
    }
    
     @FXML
    private void AddBackMenu(ActionEvent event) throws IOException {
        Parent addPage = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene addPage_scene = new Scene(addPage);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(addPage_scene);
        stage.setResizable(false);
        stage.show();
    }
    
    
   @FXML
    public void initialize(){
         typeBox.setValue("");
         typeBox.setItems(typeList);
         subTypeBox.setValue("");
         subTypeBox.setItems(dummy);
         
         
    }
    @FXML
private void typeChoice(){
         if(typeBox.getValue().equals("Alcohol")){
            subTypeBox.setItems(dummy);
         }
         else if(typeBox.getValue().equals("Drink")){
            subTypeBox.setItems(dummy);
         }
         else if(typeBox.getValue().equals("Food")){
            subTypeBox.setValue("Weight");
            subTypeBox.setItems(subFoodList);
         }
         else if(typeBox.getValue().equals("Book")){
            subTypeBox.setValue("Cartoon");
            subTypeBox.setItems(subBookList);
         }
             
     }

    @FXML
private  void ConfirmAdd(ActionEvent event) throws IOException, InterruptedException {
        ConnectDB newDB = new ConnectDB();
        newDB.AddObjectToDB(newItems);
        content.setHeading(new Text ("Confirm"));
        content.setBody(new Text("Complete"));
        
        if (confirm == null) {
		confirm = new JFXDialog(confirmStackPane,content, JFXDialog.DialogTransition.CENTER);
      	}
        
         confirm.show();
          confirm.setOnDialogClosed(new EventHandler<JFXDialogEvent>(){
          @Override
          public void handle(JFXDialogEvent arg0) {
            Parent addPage = null;
              try {
                  addPage = FXMLLoader.load(getClass().getResource("add.fxml"));
              } catch (IOException ex) {
                  Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
              }
            Scene addPage_scene = new Scene(addPage);
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(addPage_scene);
            stage.setResizable(false);
            stage.show();
            
          }
 
      });
         content.setOnMouseClicked(new EventHandler<MouseEvent>(){
          @Override
          public void handle(MouseEvent arg0) {
            Parent addPage = null;
              try {
                  addPage = FXMLLoader.load(getClass().getResource("add.fxml"));
              } catch (IOException ex) {
                  Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
              }
            Scene addPage_scene = new Scene(addPage);
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(addPage_scene);
            stage.setResizable(false);
            stage.show();
            
          }
 
      });
        
    }
     @FXML
private    void ReloadPageAdd(ActionEvent event) throws IOException {
   
        Parent addPage = FXMLLoader.load(getClass().getResource("add.fxml"));
        Scene addPage_scene = new Scene(addPage);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(addPage_scene);
        stage.setResizable(false);
        stage.show();
    } 
}