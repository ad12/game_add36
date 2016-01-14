package add.makery.samplecode;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button b=new Button();
		b.setText("Hello World");
		b.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				if (b.getEffect()!=null) b.setEffect(null);
				else {b.setEffect(new DropShadow());}
			}
		});
		
		StackPane root = new StackPane();
        root.getChildren().add(b);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}
}
