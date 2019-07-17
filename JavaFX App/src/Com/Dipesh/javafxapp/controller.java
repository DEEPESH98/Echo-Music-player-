package Com.Dipesh.javafxapp;

//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class controller implements Initializable {

	@FXML //FXML file ko connecte ker ta he ye
    public Label welcomeLabel;


    @FXML
	public ChoiceBox<String> choicebox;

	@FXML
	public TextField userinputfield;

	@FXML
	public Button convertbtn;

	private static final String C_TO_F_TEXT = "Celsius to Fahrenheit";
	private static final String F_TO_C_TEXT = "Fahrenheit to Celsius";

	private boolean isC_TO_F = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choicebox.getItems().add(C_TO_F_TEXT );//1.1 or 2 dono eke hi class se belong ker te he is liye aap jab bhii koi obj ya string jo dono me sane type ki hi honi chahiye ye.
		choicebox.getItems().add(F_TO_C_TEXT);//2.
        choicebox.setValue(C_TO_F_TEXT );//by defilte ye yehii dikhae ga .

		choicebox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			//System.out.println(newValue);
			if(newValue.equals(C_TO_F_TEXT)){// if user has selcted "C TO F".
				isC_TO_F = true;
			}
			else{
				isC_TO_F = false;
			}
		});


		//button ke action per kya hota he vo bata ta he
		convertbtn.setOnAction(event -> {
			//System.out.println("Button Clicked");
			convert();
		});
	}

	private void convert() {
			String input = userinputfield.getText();

			float enteredTemperature = 0.0f;
			try {
				enteredTemperature = Float.parseFloat(input);
			}catch (Exception e){
				warnUser();
				return;
				//no code executed....
			}
			float newtemperature = 0.0f;
			if(isC_TO_F){
				newtemperature = (enteredTemperature*9/5)+32;
			}else{
				System.out.println();
				newtemperature = (enteredTemperature - 32)*5/9;
			}
			
			display(newtemperature);
	}

	private void warnUser() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occurred");
		alert.setHeaderText("Invalid temperature Enterd");
		alert.setContentText("please enter a valid temperature");
		alert.show();
	}

	private void display(float newtemperature) {
		String unit = isC_TO_F? "F" : "C";
		System.out.println("The temprature is = " +newtemperature+unit );

		//ye alert message dikha ta he ki kktena temp he
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new temperature is: "+newtemperature +unit);
		alert.show();

	}
}
