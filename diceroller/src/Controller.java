import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Button Button;

    @FXML
    private ImageView DiceRollerImage;

    @FXML
    private Label NumberLabel;

    Random random = new Random();

    @FXML
    private Text Text;

    @FXML
    void OnButtonClick(ActionEvent event) {
        int Result = random.nextInt(1, 7);
        NumberLabel.setText(Integer.toString(Result));
        switch (Result) {
            case 1:
            DiceRollerImage.setImage((new Image("cara1.png")));
            break;

            case 2:
            DiceRollerImage.setImage((new Image("cara2.png")));
            break;

            case 3:
            DiceRollerImage.setImage((new Image("cara3.png")));
            break;

            case 4:
            DiceRollerImage.setImage((new Image("cara4.png")));
            break;

            case 5:
            DiceRollerImage.setImage((new Image("cara5.png")));
            break;

            case 6:
            DiceRollerImage.setImage((new Image("cara6.png")));
            break;

            default:
            break;
        }
    }

}