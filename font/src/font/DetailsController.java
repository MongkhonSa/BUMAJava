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
import database.ConnectDB;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author ITokkyZ
 */
public class DetailsController implements Initializable  {
    
    ObservableList<String> typeList = FXCollections.observableArrayList("Food","Drink","Alcohol","Book");
    ObservableList<String> subFoodList = FXCollections.observableArrayList("Weight","Quantity");
    ObservableList<String> subBookList = FXCollections.observableArrayList("Cartoon","Magazine","Fiction");
    ObservableList<String> dummy = FXCollections.observableArrayList();
     Object newItems = null;
     Items items2;
     @FXML
     private ComboBox typeBox; 
     @FXML
     private ComboBox subTypeBox;
     @FXML
    private TableView<Items> tableView;
    @FXML
    private TableColumn<Items,String> idColumn;

    @FXML
    private TableColumn<Items,String> nameColumn;

    @FXML
    private TableColumn<Items,String> arrivalDateColumn;

    @FXML
    private TableColumn<Items,String> EXPColumn;

    @FXML
    private TableColumn<Items,String> factoryColumn;

    @FXML
    private TableColumn<Items,String> amountColumn;

    @FXML
    private TableColumn<Items,String> priceColumn;

    @FXML
    private TableColumn<Items,String> profitColumn;

    @FXML
    private TableColumn<Items,String> totalpriceColumn;
     @FXML
    private StackPane confirmStackPane;
     @FXML
    private StackPane confirmStackPane2;
     @FXML
    private StackPane EditStackPane;
      @FXML
    private TextField TextFieldID;

    @FXML
    private TextField TextFieldName;

    @FXML
    private TextField TextFieldPrice;

    @FXML
    private TextField TextFieldAmount;

    @FXML
    private TextField TextFieldFactory;

    @FXML
    private TextField TextFieldProfit;
    

    @FXML
    private ComboBox typeBox1;

    @FXML
    private ComboBox subTypeBox1;

    @FXML
    private DatePicker TextFieldArrivalDate;

    @FXML
    private DatePicker TextFieldEXP;

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
    @FXML
    void DeleteItem(ActionEvent event) {
        confirm = null;
       ObservableList<Items> selectedRows,allItems;
       allItems = tableView.getItems();
       selectedRows=tableView.getSelectionModel().getSelectedItems();
       
       for(Items items:selectedRows){
           newType.setText((String) typeBox.getValue());
            newSubType.setText((String) subTypeBox.getValue());
            newId.setText(String.valueOf(items.getId()));
            newName.setText(items.getName());
            newArrivalDate.setText(items.getArrivalDate());
            newEXP.setText(items.getEXP());
            newPrice.setText(String.valueOf(items.getPrice()));
            newAmount.setText(String.valueOf(items.getAmount()));
            newProfit.setText(String.valueOf(items.getProfit()));
            newTotalPrice.setText(String.valueOf(items.getTotalPrice()));
            newFactory.setText(String.valueOf(items.getFactory()));
       }
       if(!selectedRows.isEmpty()){
            confirmStackPane.setVisible(true);
       }
    }

    @FXML
    void CancelDelete(ActionEvent event) {
        confirmStackPane.setVisible(false);
    }

    @FXML
    void ConfirmDelete(ActionEvent event) {
        ConnectDB newConnectDB = new ConnectDB();
        
        ObservableList<Items> selectedRows,allItems;
       allItems = tableView.getItems();
       selectedRows=tableView.getSelectionModel().getSelectedItems();
       
       for(Items items:selectedRows){             
           newConnectDB.DeleteObjectDB(items,typeBox.getValue(),subTypeBox.getValue());

       }
        content.setHeading(new Text ("Confirm"));
        content.setBody(new Text("Complete"));
        
        if (confirm == null) {
		confirm = new JFXDialog(confirmStackPane,content, JFXDialog.DialogTransition.CENTER);
      	}
        confirm.show();
         
         
         confirm.setOnDialogClosed(new EventHandler<JFXDialogEvent>(){
          @Override
          public void handle(JFXDialogEvent arg0) {
            confirmStackPane.setVisible(false);
          
         }
 
      });
        
       
        allItems.removeAll(selectedRows);
      
         
   
            
           
           
    }
   
   
    
    @FXML
    void EditItems(ActionEvent event) throws IOException, ParseException {
        ObservableList<Items> selectedRows,allItems;
       allItems = tableView.getItems();
       selectedRows=tableView.getSelectionModel().getSelectedItems();
      
       for(Items items:selectedRows){             
       TextFieldID.setText(String.valueOf(items.getId()));
       TextFieldName.setText(String.valueOf(items.getName()));
       TextFieldPrice.setText(String.valueOf(items.getPrice()));
       TextFieldFactory.setText(String.valueOf(items.getFactory()));
       TextFieldAmount.setText(String.valueOf(items.getAmount()));
       TextFieldProfit.setText(String.valueOf(items.getProfit()));
       LocalDate newEXP = LocalDate.parse(items.getEXP(), DateTimeFormatter.ofPattern("dd-MM-yyyy")) ;
       TextFieldEXP.setValue(newEXP);
       LocalDate newArrivalDate = LocalDate.parse(items.getArrivalDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")) ;
       TextFieldArrivalDate.setValue(newArrivalDate);
       
       }
     
        if(!selectedRows.isEmpty()){
            typeBox1.setValue(typeBox.getValue());
            subTypeBox1.setValue(subTypeBox.getValue());
            EditStackPane.setVisible(true);
       }
        
    }
       @FXML
    void cancelEditButton(ActionEvent event) {
        EditStackPane.setVisible(false);
    }
       @FXML
    void EditButton(ActionEvent event) {
       
       ConnectDB  newConnectDB=new ConnectDB(); 
       ObservableList<Items> selectedRows,allItems;
       allItems = tableView.getItems();
       selectedRows=tableView.getSelectionModel().getSelectedItems();
        for(Items items:selectedRows){  
        if(typeBox.getValue().equals(typeBox1.getValue().toString())&&subTypeBox.getValue().equals(subTypeBox1.getValue().toString())){
        
        newConnectDB.editDB(items,typeBox1.getValue(),subTypeBox1.getValue(),Long.parseLong(TextFieldID.getText()),
                        TextFieldName.getText(),TextFieldEXP.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                            ,TextFieldArrivalDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        TextFieldFactory.getText(),Double.parseDouble(TextFieldAmount.getText()),
                        Double.parseDouble(TextFieldPrice.getText()),
                        Double.parseDouble(TextFieldProfit.getText()));
                        newType.setText((String) typeBox.getValue() +" to "+typeBox1.getValue());
                        newSubType.setText((String) subTypeBox.getValue()+" to "+subTypeBox1.getValue());
                        newId.setText(String.valueOf(items.getId())+" to "+TextFieldID.getText());
                        newName.setText(items.getName()+" to "+TextFieldName.getText());
                        newArrivalDate.setText(items.getArrivalDate()+" to "+TextFieldArrivalDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                        newEXP.setText(items.getEXP()+" to "+TextFieldEXP.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                        newPrice.setText(String.valueOf(items.getPrice())+" to "+Double.parseDouble(TextFieldPrice.getText()));
                        newAmount.setText(String.valueOf(items.getAmount())+" to "+Double.parseDouble(TextFieldAmount.getText()));
                        newProfit.setText(String.valueOf(items.getProfit())+" to "+Double.parseDouble(TextFieldProfit.getText()));
                        newTotalPrice.setText(String.valueOf(items.getTotalPrice())+" to "+((Double.parseDouble(TextFieldPrice.getText())+Double.parseDouble(TextFieldProfit.getText()))*(1+Items.getVAT())) );
                        newFactory.setText(String.valueOf(items.getFactory())+" to1 "+TextFieldFactory.getText());
                        newItems = items;  
                    
                        confirmStackPane2.setVisible(true);
        }
        else{          
                items2 = items;
    
                        newType.setText( typeBox.getValue().toString() +" to ");
                        newSubType.setText(subTypeBox.getValue().toString()+" to ");
                        newId.setText(String.valueOf(items.getId())+" to ");
                        newName.setText(items.getName()+" to ");
                        newArrivalDate.setText(items.getArrivalDate()+" to ");
                        newEXP.setText(items.getEXP()+" to ");
                        newPrice.setText(String.valueOf(items.getPrice())+" to ");
                        newAmount.setText(String.valueOf(items.getAmount())+" to ");
                        newProfit.setText(String.valueOf(items.getProfit())+" to ");
                        newTotalPrice.setText(String.valueOf(items.getTotalPrice())+" to " );
                        newFactory.setText(String.valueOf(items.getFactory())+" to ");
                if(typeBox1.getValue().equals("Alcohol")){
           
             Alcohol newAlcohol= new Alcohol(Long.parseLong(TextFieldID.getText()),
                TextFieldName.getText(),TextFieldEXP.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                     TextFieldArrivalDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                TextFieldFactory.getText(),Double.parseDouble(TextFieldAmount.getText()),
                Double.parseDouble(TextFieldPrice.getText()),
                Double.parseDouble(TextFieldProfit.getText()));
                
                newType.setText( (String)newType.getText()+ typeBox1.getValue());
                newSubType.setText((String)newSubType.getText());
                newId.setText(newId.getText()+String.valueOf(newAlcohol.getId()));
                newName.setText(newName.getText()+newAlcohol.getName());
                newEXP.setText(newEXP.getText()+newAlcohol.getEXP());
                newArrivalDate.setText(newArrivalDate.getText()+newAlcohol.getArrivalDate());
                newPrice.setText(newPrice.getText()+String.valueOf(newAlcohol.getPrice()));
                newAmount.setText(newAmount.getText()+String.valueOf(newAlcohol.getAmount()));
                newProfit.setText(newProfit.getText()+String.valueOf(newAlcohol.getProfit()));
                newTotalPrice.setText(newTotalPrice.getText()+String.valueOf(newAlcohol.getTotalPrice()));
                newFactory.setText(newFactory.getText()+String.valueOf(newAlcohol.getFactory()));
                newItems = newAlcohol;
                
                confirmStackPane2.setVisible(true);
                    
     
         }
        else if(typeBox1.getValue().equals("Drink")){
     
            Drinks newDrinks = new Drinks(Long.parseLong(TextFieldID.getText()),
                    TextFieldName.getText(),TextFieldEXP.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                    ,TextFieldArrivalDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                    TextFieldFactory.getText(),Double.parseDouble(TextFieldAmount.getText()),
                    Double.parseDouble(TextFieldPrice.getText()),
                    Double.parseDouble(TextFieldProfit.getText()));
                    
                newType.setText( (String)newType.getText()+ typeBox1.getValue());
                newSubType.setText((String)newSubType.getText());
                newId.setText(newId.getText()+String.valueOf(newDrinks.getId()));
                newName.setText(newName.getText()+newDrinks.getName());
                newEXP.setText(newEXP.getText()+newDrinks.getEXP());
                newArrivalDate.setText(newArrivalDate.getText()+newDrinks.getArrivalDate());
                newPrice.setText(newPrice.getText()+String.valueOf(newDrinks.getPrice()));
                newAmount.setText(newAmount.getText()+String.valueOf(newDrinks.getAmount()));
                newProfit.setText(newProfit.getText()+String.valueOf(newDrinks.getProfit()));
                newTotalPrice.setText(newTotalPrice.getText()+String.valueOf(newDrinks.getTotalPrice()));
                newFactory.setText(newFactory.getText()+String.valueOf(newDrinks.getFactory()));
                newItems = newDrinks;
                
                    confirmStackPane2.setVisible(true);
         }
        else if(typeBox1.getValue().equals("Food")){
            if(subTypeBox1.getValue().equals("Weight")){
                Weight newWeight = new Weight(Long.parseLong(TextFieldID.getText()),
                        TextFieldName.getText(),TextFieldEXP.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                           ,TextFieldArrivalDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        TextFieldFactory.getText(),Double.parseDouble(TextFieldAmount.getText()),
                        Double.parseDouble(TextFieldPrice.getText()),
                        Double.parseDouble(TextFieldProfit.getText()));
                            
                newType.setText( (String)newType.getText()+ typeBox1.getValue());
                newSubType.setText((String)newSubType.getText()+ subTypeBox1.getValue().toString());
                newId.setText(newId.getText()+String.valueOf(newWeight.getId()));
                newName.setText(newName.getText()+newWeight.getName());
                newEXP.setText(newEXP.getText()+newWeight.getEXP());
                newArrivalDate.setText(newArrivalDate.getText()+newWeight.getArrivalDate());
                newPrice.setText(newPrice.getText()+String.valueOf(newWeight.getPrice()));
                newAmount.setText(newAmount.getText()+String.valueOf(newWeight.getAmount()));
                newProfit.setText(newProfit.getText()+String.valueOf(newWeight.getProfit()));
                newTotalPrice.setText(newTotalPrice.getText()+String.valueOf(newWeight.getTotalPrice()));
                newFactory.setText(newFactory.getText()+String.valueOf(newWeight.getFactory()));
                newItems = newWeight;   
                   
                        confirmStackPane2.setVisible(true);
             }
            else if(subTypeBox1.getValue().equals("Quantity")){
                    
                Quantity newQuantity = new Quantity(Long.parseLong(TextFieldID.getText()),
                        TextFieldName.getText(),TextFieldEXP.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                            ,TextFieldArrivalDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        TextFieldFactory.getText(),Double.parseDouble(TextFieldAmount.getText()),
                        Double.parseDouble(TextFieldPrice.getText()),
                        Double.parseDouble(TextFieldProfit.getText()));
                            
                newType.setText( (String)newType.getText()+ typeBox1.getValue());
                newSubType.setText((String)newSubType.getText()+ subTypeBox1.getValue().toString());
                newId.setText(newId.getText()+String.valueOf(newQuantity.getId()));
                newName.setText(newName.getText()+newQuantity.getName());
                newEXP.setText(newEXP.getText()+newQuantity.getEXP());
                newArrivalDate.setText(newArrivalDate.getText()+newQuantity.getArrivalDate());
                newPrice.setText(newPrice.getText()+String.valueOf(newQuantity.getPrice()));
                newAmount.setText(newAmount.getText()+String.valueOf(newQuantity.getAmount()));
                newProfit.setText(newProfit.getText()+String.valueOf(newQuantity.getProfit()));
                newTotalPrice.setText(newTotalPrice.getText()+String.valueOf(newQuantity.getTotalPrice()));
                newFactory.setText(newFactory.getText()+String.valueOf(newQuantity.getFactory()));
                newItems = newQuantity;       
                    
                        confirmStackPane2.setVisible(true);
            }
            
             
         }
        else if(typeBox1.getValue().equals("Book")){
            if(subTypeBox1.getValue().equals("Cartoon")){
                Cartoon newCartoon = new Cartoon(Long.parseLong(TextFieldID.getText()),
                        TextFieldName.getText(),TextFieldEXP.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                            ,TextFieldArrivalDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        TextFieldFactory.getText(),Double.parseDouble(TextFieldAmount.getText()),
                        Double.parseDouble(TextFieldPrice.getText()),
                        Double.parseDouble(TextFieldProfit.getText()));
                        
                newType.setText( (String)newType.getText()+ typeBox1.getValue());
                newSubType.setText((String)newSubType.getText()+ subTypeBox1.getValue().toString());
                newId.setText(newId.getText()+String.valueOf(newCartoon.getId()));
                newName.setText(newName.getText()+newCartoon.getName());
                newEXP.setText(newEXP.getText()+newCartoon.getEXP());
                newArrivalDate.setText(newArrivalDate.getText()+newCartoon.getArrivalDate());
                newPrice.setText(newPrice.getText()+String.valueOf(newCartoon.getPrice()));
                newAmount.setText(newAmount.getText()+String.valueOf(newCartoon.getAmount()));
                newProfit.setText(newProfit.getText()+String.valueOf(newCartoon.getProfit()));
                newTotalPrice.setText(newTotalPrice.getText()+String.valueOf(newCartoon.getTotalPrice()));
                newFactory.setText(newFactory.getText()+String.valueOf(newCartoon.getFactory()));
                newItems = newCartoon;    
                    
                        confirmStackPane2.setVisible(true);
             }
            else if(subTypeBox1.getValue().equals("Magazine")){
                    Magazine newMagazine = new Magazine(Long.parseLong(TextFieldID.getText()),
                        TextFieldName.getText(),TextFieldEXP.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                            ,TextFieldArrivalDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        TextFieldFactory.getText(),Double.parseDouble(TextFieldAmount.getText()),
                        Double.parseDouble(TextFieldPrice.getText()),
                        Double.parseDouble(TextFieldProfit.getText()));
                        
                newType.setText( (String)newType.getText()+ typeBox1.getValue());
                newSubType.setText((String)newSubType.getText()+ subTypeBox1.getValue().toString());
                newId.setText(newId.getText()+String.valueOf(newMagazine.getId()));
                newName.setText(newName.getText()+newMagazine.getName());
                newEXP.setText(newEXP.getText()+newMagazine.getEXP());
                newArrivalDate.setText(newArrivalDate.getText()+newMagazine.getArrivalDate());
                newPrice.setText(newPrice.getText()+String.valueOf(newMagazine.getPrice()));
                newAmount.setText(newAmount.getText()+String.valueOf(newMagazine.getAmount()));
                newProfit.setText(newProfit.getText()+String.valueOf(newMagazine.getProfit()));
                newTotalPrice.setText(newTotalPrice.getText()+String.valueOf(newMagazine.getTotalPrice()));
                newFactory.setText(newFactory.getText()+String.valueOf(newMagazine.getFactory()));
                newItems = newMagazine;  
                        
                        confirmStackPane2.setVisible(true);
             }
            else if(subTypeBox1.getValue().equals("Fiction")){
                    Fiction newFiction = new Fiction(Long.parseLong(TextFieldID.getText()),
                        TextFieldName.getText(),TextFieldEXP.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                            ,TextFieldArrivalDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                        TextFieldFactory.getText(),Double.parseDouble(TextFieldAmount.getText()),
                        Double.parseDouble(TextFieldPrice.getText()),
                        Double.parseDouble(TextFieldProfit.getText()));
                    
                newType.setText( (String)newType.getText()+ typeBox1.getValue());
                newSubType.setText((String)newSubType.getText()+ subTypeBox1.getValue().toString());
                newId.setText(newId.getText()+String.valueOf(newFiction.getId()));
                newName.setText(newName.getText()+newFiction.getName());
                newEXP.setText(newEXP.getText()+newFiction.getEXP());
                newArrivalDate.setText(newArrivalDate.getText()+newFiction.getArrivalDate());
                newPrice.setText(newPrice.getText()+String.valueOf(newFiction.getPrice()));
                newAmount.setText(newAmount.getText()+String.valueOf(newFiction.getAmount()));
                newProfit.setText(newProfit.getText()+String.valueOf(newFiction.getProfit()));
                newTotalPrice.setText(newTotalPrice.getText()+String.valueOf(newFiction.getTotalPrice()));
                newFactory.setText(newFactory.getText()+String.valueOf(newFiction.getFactory()));
                newItems = newFiction;  
                    
                        confirmStackPane2.setVisible(true);
             }
             
         }
                   
        }
        
        }
        
        EditStackPane.setVisible(false); // close edit page
        // refresh table
       
    }
     @FXML
   public void typeChoice(){
           ConnectDB  newConnectDB=new ConnectDB(); 
         if(typeBox.getValue().equals("Alcohol")){
            
            subTypeBox.setItems(dummy);
            tableView.setItems(newConnectDB.showTableDB(typeBox.getValue()));
         }
         else if(typeBox.getValue().equals("Drink")){
           
            subTypeBox.setItems(dummy);
             tableView.setItems(newConnectDB.showTableDB(typeBox.getValue()));
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
   public void typeChoice1(){ 
         if(typeBox1.getValue().equals("Alcohol")){
            subTypeBox1.setItems(dummy);
            
         }
         else if(typeBox1.getValue().equals("Drink")){
            subTypeBox1.setItems(dummy);
             
         }
         else if(typeBox1.getValue().equals("Food")){
             subTypeBox1.setValue("Weight");
             subTypeBox1.setItems(subFoodList);
             
            
         }
         else if(typeBox1.getValue().equals("Book")){
             subTypeBox1.setValue("Cartoon");
             subTypeBox1.setItems(subBookList);
             
         }
             
     }
      @FXML
    void ConfirmEdit(ActionEvent event) {
        if(newItems !=null&&items2!=null){
        ConnectDB newConnectDB = new ConnectDB();
        newConnectDB.DeleteObjectDB(items2,typeBox.getValue().toString(),subTypeBox.getValue().toString());
        newConnectDB.AddObjectToDB(newItems);
        }
        
        typeBox.setValue("");
        subTypeBox.setValue("");
        confirmStackPane2.setVisible(false);
        typeBox.setValue(typeBox1.getValue());
        subTypeBox.setValue(subTypeBox1.getValue());
    }
      @FXML
    void CancelEdit(ActionEvent event) {
        confirmStackPane2.setVisible(false);
    }

         @FXML
    void SubTypeChoice(ActionEvent event)throws IOException  {
        ConnectDB  newConnectDB=new ConnectDB(); 
         if(subTypeBox.getValue().equals("Weight")){
            tableView.setItems(newConnectDB.showTableDB(subTypeBox.getValue()));
         }
         else if (subTypeBox.getValue().equals("Quantity")){
            tableView.setItems(newConnectDB.showTableDB(subTypeBox.getValue()));
         }
         else if (subTypeBox.getValue().equals("Cartoon")){
            tableView.setItems(newConnectDB.showTableDB(subTypeBox.getValue()));
         }
         else if (subTypeBox.getValue().equals("Magazine")){
            tableView.setItems(newConnectDB.showTableDB(subTypeBox.getValue()));
         }
         else if (subTypeBox.getValue().equals("Fiction")){
            tableView.setItems(newConnectDB.showTableDB(subTypeBox.getValue()));
         }
         else tableView.setItems(newConnectDB.showTableDB(typeBox.getValue()));
         
            
        
         
    }
     
     @FXML
    void DetailBackToMenu(ActionEvent event) throws IOException {
        Parent detailPage = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene detailPage_scene = new Scene(detailPage);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(detailPage_scene);
        stage.setResizable(false);
        stage.show();
    }
 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ConnectDB newConnectDB = new ConnectDB();
        idColumn.setCellValueFactory(new PropertyValueFactory<Items, String>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Items, String>("name"));
        arrivalDateColumn.setCellValueFactory(new PropertyValueFactory<Items, String>("ArrivalDate"));
        EXPColumn.setCellValueFactory(new PropertyValueFactory<Items, String>("EXP"));
        factoryColumn.setCellValueFactory(new PropertyValueFactory<Items, String>("factory"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<Items, String>("amount"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Items, String>("price"));
        profitColumn.setCellValueFactory(new PropertyValueFactory<Items, String>("profit"));
        totalpriceColumn.setCellValueFactory(new PropertyValueFactory<Items, String>("totalPrice"));
        typeBox.setValue("");
        tableView.setItems(newConnectDB.showTableDB(typeBox.getValue()));
        typeBox.setItems(typeList);
        subTypeBox.setValue("");
        subTypeBox.setItems(dummy);
  
        typeBox1.setItems(typeList);
        subTypeBox1.setItems(dummy);
        // select row in table
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        
        
         
    }

   
}