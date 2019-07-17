package Com.Dipesh.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
//import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//import java.awt.*;
import java.util.Optional;

public class MyMain extends Application {// ye bydefolete jab hum app banate he tab ye apne aap hi baneti he class jo intiligi id ko app se connevte ker ta he.


	public static void main(String[] args){//(ye in tilligi ide bydefolte bana ta he . or ager aap bana na chaho to bhi correct he or nehii bana na chaho to bhi correcte he )
		System.out.println("main");
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("init");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {//start method is basicaly a part of of a application class.this is sub class of a MyMain class.
		System.out.println("Start");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));// THis is connect a tow file.
		VBox rootNode = loader.load();//rooot node me load ker te he .Vbox is a root node.

		MenuBar menuBar=createMenu();
		//rootNode.getChildren().addAll(menuBar);// ye pele ka he code.
		rootNode.getChildren().add(0,menuBar);//Lable welcome ko fix kera he
		//Scene scene = new Scene(rootNode, 300, 275);
		Scene scene = new Scene(rootNode);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.setResizable(false);
		primaryStage.show();

	}
	public MenuBar createMenu(){//This a MenuBar Method

        //File Menu
		Menu fileMenu = new Menu("File");//Make sure to selecte a menu for Menu(javafx.scene.control)
		MenuItem newMenwItem = new MenuItem("New");

		newMenwItem.setOnAction(event -> System.out.println("New Menu Item Clicked "));

		SeparatorMenuItem separatorMenuItem= new SeparatorMenuItem();//Line to divide ya seperet ker ta he  ase _______________.
		MenuItem quitMenuItem = new MenuItem("Quit");

		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});//this code is same
		/*quitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
				System.exit(0);
			}
		});*/
		fileMenu.getItems().addAll(newMenwItem,separatorMenuItem,quitMenuItem);


		//Help MEnu
		Menu helpMenu = new Menu("help");
        MenuItem  aboutApp = new MenuItem("About");

        aboutApp.setOnAction(event -> aboutApp());//lemda is used to code repet and repeet code.

        helpMenu.getItems().addAll(aboutApp);

		// Menu bar
		MenuBar menubar = new MenuBar();
		menubar.getMenus().addAll(fileMenu,helpMenu);

		return menubar;
	}

	private void aboutApp() {
		//TODO
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My first Desktop App");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("I am just a beginner but I will be pro and atart developing awseome games");


		ButtonType yesBtn= new ButtonType("yes");
		ButtonType noBtn = new ButtonType("No");

		alertDialog.getButtonTypes().setAll(yesBtn,noBtn);

		Optional<ButtonType>clickedBtn = alertDialog.showAndWait();//Option name class criated

		if(clickedBtn.isPresent() && clickedBtn.get() == yesBtn){
			System.out.println("yes btn clicked");
		}
		else{
			System.out.println("NO button clicked");
		}

	}

	@Override
	public void stop() throws Exception {
		System.out.println("Stop");
		super.stop();
	}
}
