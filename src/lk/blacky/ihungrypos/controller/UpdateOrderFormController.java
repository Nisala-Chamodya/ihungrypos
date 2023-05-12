package lk.blacky.ihungrypos.controller;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.ihungrypos.util.Navigation;
import lk.blacky.ihungrypos.util.Routes;

import java.io.IOException;

public class UpdateOrderFormController {
    public AnchorPane pane;

    public void btnCancelOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void btnUpdateOnClickAcction(ActionEvent actionEvent) {
    }

    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARDForm,pane);
    }
}
