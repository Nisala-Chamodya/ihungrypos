package lk.blacky.ihungrypos.controller;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.blacky.ihungrypos.util.Navigation;
import lk.blacky.ihungrypos.util.Routes;

import java.io.IOException;

public class ViewOrderFormController {

    public AnchorPane pane;

    public void backImgOnClickAction(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.VIEWALL,pane);
    }
}
