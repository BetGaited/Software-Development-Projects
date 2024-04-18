//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javafx.util.Duration;

public class Controller {

    @FXML
    private ImageView viewImages;

    Integer currentImageIndex = 0;

    public String[] imagePaths = {
        "images/sanji1.jpg",
        "images/sanji2.jpg",
        "images/sanji3.jpg",
        "images/sanji4.jpg",
        "images/sanji5.jpg"
    };
    
    //private Timeline timeline;

    @FXML
    public void initialize() {
        // timeline = new Timeline(new KeyFrame(Duration.seconds(2), event -> changePhoto()));
        // timeline.setCycleCount(Timeline.INDEFINITE);
        // timeline.play();
    }

    @FXML
    void skipButtonClicked(ActionEvent event) {
        //timeline.stop();
        changePhoto();
    }

    @FXML
    void changePhoto() {
        String image = imagePaths[currentImageIndex];
        Image image2 = new Image(image);
        
        viewImages.setImage(image2);
        if (currentImageIndex == 5) {
            currentImageIndex = 0;
        }
        else{
            currentImageIndex+=1;
        }

        //timeline.playFromStart();
    }
}