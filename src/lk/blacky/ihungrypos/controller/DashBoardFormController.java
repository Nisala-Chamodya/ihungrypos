package lk.blacky.ihungrypos.controller;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.ihungrypos.util.Navigation;
import lk.blacky.ihungrypos.util.Routes;

import java.io.IOException;

public class DashBoardFormController {
    public AnchorPane pane;

    public void manageCustomerOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.MANAGECUSTOMER,pane);
    }

    public void btnPlaceOrderOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.PLACEORDER,pane);
    }

    public void btnUpdateOrderOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.UPDATEORDER,pane);
    }

    public void btnViewAllOnAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.VIEWALL,pane);
    }

    public void btnShutdownOnClickAction(MouseEvent mouseEvent) {
        System.exit(0);
    }
}
