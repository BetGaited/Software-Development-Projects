import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Button MinusSign;

    @FXML
    private Label Number;

    @FXML
    private Button PlusSign;

    @FXML
    void MinusSign(ActionEvent event) {
        int num = Integer.parseInt(Number.getText());
        Number.setText(Integer.toString(num - 1));
    }

    @FXML
    void PlusSign(ActionEvent event) {
        int num = Integer.parseInt(Number.getText());
        Number.setText(Integer.toString(num + 1));
    }

}
