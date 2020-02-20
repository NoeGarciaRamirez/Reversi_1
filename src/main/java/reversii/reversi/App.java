package reversii.reversi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    
    static final short TAM_TABLERO = (Ficha.TAM_FICHA)*8+20;
    
    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        var scene = new Scene(root, TAM_TABLERO, TAM_TABLERO);
        stage.setScene(scene);
        stage.show();
        
        Tablero tablero = new Tablero();
        root.getChildren().add(tablero);
        
        Ficha ficha = new Ficha(1);
        tablero.getChildren().add(ficha);
        
        Ficha ficha2 = new Ficha(2);
        ficha2.setLayoutX(30);
        ficha2.setLayoutY(30);
        

    }

    public static void main(String[] args) {
        launch();
    }

}