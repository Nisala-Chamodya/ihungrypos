package lk.blacky.ihungrypos.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import lk.blacky.ihungrypos.db.DataBase;
import lk.blacky.ihungrypos.model.Customer;
import lk.blacky.ihungrypos.model.Order;
import lk.blacky.ihungrypos.util.Navigation;
import lk.blacky.ihungrypos.util.Routes;

import static lk.blacky.ihungrypos.util.Validator.*;

import java.io.IOException;

public class ManageCustomerFormController {

    public AnchorPane pane;
    public JFXTextField txtCustomerId;
    public JFXTextField txtCustName;
    public JFXTextField txtQTY;
    public JFXTextField txtPrice;
    public JFXTextField txtOid;
    public Label lblOId;

    public void initialize(){
        setOrderId();
    }

    private void setOrderId() {
        System.out.println(DataBase.orderArray.length);
        if (DataBase.orderArray.length<1) {
            lblOId.setText("B-0001");
            return;
        }
        String tempId = DataBase.orderArray[DataBase.orderArray.length - 1].getOrderId();
        String array[] = tempId.split("-");
        int tempNum = Integer.parseInt(array[1]);
        int Id = tempNum + 1;
        lblOId.setText("B-000" + Id);
    }


    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARDForm,pane);
    }


    public void btnAddOnClickAction(ActionEvent actionEvent) {
        if (isCustomerTelephoneNoMatcher(txtCustomerId.getText())){
            /*Vaiable Declaration*/
            String custId=txtCustomerId.getText();
            String custName=txtCustName.getText();
            Customer c1=new Customer(custId,custName);
            boolean isSaved = DataBase.customerIncrement(c1)!=null;
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Saved").show();
                txtCustomerId.clear();
                txtCustName.clear();
                System.out.println("Customer "+ c1);
              

            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Try Again").show();
            }


        }else{
            new Alert(Alert.AlertType.ERROR, "start without “0”\n" +
                    "or phone number has more than 10 numbers Pleace Ceck").show();
            txtCustomerId.setStyle("-jfx-unfocus-color : red");
        }
    }

    public void btnPlaceOrder(ActionEvent actionEvent) {
        String oId=lblOId.getText();
        int burgerQTY=Integer.parseInt(txtQTY.getText());
        double price=Double.parseDouble(txtPrice.getText());
        System.out.println(oId);
        Order order1=new Order(oId,burgerQTY,price);

        boolean isSaved = DataBase.orderIncrement(order1)!=null;
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "Order Placed Successfully").show();

            txtPrice.clear();
            txtQTY.clear();
            System.out.println("Order "+order1);

        }else {
            new Alert(Alert.AlertType.CONFIRMATION, "Try Again").show();
        }

    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
