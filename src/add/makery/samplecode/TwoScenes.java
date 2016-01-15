package add.makery.samplecode;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TwoScenes extends Application {

    private static final Color color = Color.web("#464646");
    Button button3 = new Button("Decline");
    DropShadow shadow = new DropShadow();
    Label label = new Label();


    public static void main(String[] args) {
        launch(args);
    }
    public Button createButton(String name){
    	Button b=new Button(name);
    	b.setPrefSize(80, 20);
    	return b;
    }
    public HBox createHBox(String color) {
        HBox hbox = new HBox();
        
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: "+color+";");

        return hbox;
    }
    
    @Override
    public void start(Stage stage) {
    	stage.setMaxWidth(Double.MAX_VALUE);
    	stage.setMaxHeight(Double.MAX_VALUE);
    	stage.setWidth(500);
    	stage.setHeight(500);
    	BorderPane root=new BorderPane();
        Scene scene=new Scene(root);
        HBox hbox=createHBox("f345f4");
        Button play=createButton("PLAY");
        Button cancel=createButton("CANCEL");
        
        play.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				BorderPane root=new BorderPane();
				Scene s=new Scene(root);
				Scene previous=scene;
				Button b=new Button("change scene");
				b.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent event) {
						stage.setScene(previous);
					}
		        	
		        });
				HBox hb=createHBox("d34d23");
				hb.getChildren().add(b);
				hb.setAlignment(Pos.CENTER);
				root.setBottom(hb);
				stage.setScene(s);
			}
        	
        });
        hbox.getChildren().addAll(play,cancel);
        hbox.setAlignment(Pos.CENTER);
        root.setBottom(hbox);
        
        stage.setScene(scene);
        stage.show();
    }
}