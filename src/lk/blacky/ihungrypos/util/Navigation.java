package lk.blacky.ihungrypos.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();
        switch (route) {
            case DASHBOARDForm:
                window.setTitle("DashBord Form");
                initUI("DashBoardForm.fxml");
                break;
            case MANAGECUSTOMER:
                window.setTitle("Manage Customer Form");
                initUI("ManageCustomerForm.fxml");
                break;
            case PLACEORDER:
                window.setTitle("Place Order Form");
                initUI("PlaceOrderForm.fxml");
                break;
            case UPDATEORDER:
                window.setTitle("Update Order Form");
                initUI("updateOrderForm.fxml");
                break;
            case VIEWALL:
                window.setTitle("View All Details");
                initUI("ViewAllDetailsForm.fxml");
                break;
            case VIEWORDER:
                window.setTitle("View Order");
                initUI("ViewOrderForm.fxml");
                break;




        }
    }

    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/blacky/ihungrypos/view/"+location)));

    }

}
