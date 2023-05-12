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

import java.io.IOException;

import static lk.blacky.ihungrypos.util.Validator.isCustomerTelephoneNoMatcher;

public class PlaceOrderFormController {
    public JFXTextField txtCustID;
    public JFXTextField txtName;
    public JFXTextField txtQTY;
    public JFXTextField txtPrice;
    public AnchorPane pane;
    public Label lblOid;

    public void initialize(){
        setOrderId();
    }

    private void setOrderId() {
        if (DataBase.orderArray.length<1) {
            lblOid.setText("B-0001");
            return;
        }
        String tempId = DataBase.orderArray[DataBase.orderArray.length - 1].getOrderId();
        String array[] = tempId.split("-");
        int tempNum = Integer.parseInt(array[1]);
        int Id = tempNum + 1;
        lblOid.setText("B-000" + Id);
    }


    public void btnPlaceOrder(ActionEvent actionEvent) {
      /*check Customer*/
        if (isCustomerTelephoneNoMatcher(txtCustID.getText())){
            /*Vaiable Declaration*/
            String custId=txtCustID.getText();
            String custName=txtName.getText();
            Customer c1=new Customer(custId,custName);
            boolean isSaved = DataBase.customerIncrement(c1)!=null;
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Saved").show();
                txtCustID.clear();
                txtName.clear();
                System.out.println("Customer "+ c1);


            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Try Again").show();
            }


        }else{
            new Alert(Alert.AlertType.ERROR, "start without “0”\n" +
                    "or phone number has more than 10 numbers Pleace Ceck").show();
            txtCustID.setStyle("-jfx-unfocus-color : red");
        }



        /*Order Section*/
        String oId=lblOid.getText();
        int burgerQTY=Integer.parseInt(txtQTY.getText());
        double price=Double.parseDouble(txtPrice.getText());
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

    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARDForm,pane);
    }
}
