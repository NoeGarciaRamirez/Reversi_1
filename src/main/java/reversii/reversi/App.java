package reversii.reversi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    
    static final short TAM_TABLERO = (Ficha.TAM_FICHA)*8;
    
    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        var scene = new Scene(root, TAM_TABLERO, TAM_TABLERO);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
        
        Tablero tablero = new Tablero();
        root.getChildren().add(tablero);
        
        
        Ficha ficha = new Ficha(1);
        
        Ficha ficha2 = new Ficha(-1);
        

    }

    public static void main(String[] args) {
        launch();
    }

}