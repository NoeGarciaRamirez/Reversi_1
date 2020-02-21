
package reversii.reversi;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

/**
 *
 * @author noe
 */
public class Tablero extends Pane{
    
    public Tablero(){
        for(int i=0; i<9; i++){
            Line line = new Line(Ficha.TAM_FICHA*i, i,
                    Ficha.TAM_FICHA*i, (Ficha.TAM_FICHA)*8);
            this.getChildren().add(line);
        }
        for(int i=0; i<9; i++){
            Line line = new Line(i, Ficha.TAM_FICHA*i,
                    (Ficha.TAM_FICHA)*8, Ficha.TAM_FICHA*i);
            this.getChildren().add(line);
        }
        this.setOnMouseClicked((MouseEvent mouseEvent) -> {
            System.out.println("Mouse clicked X : Y -> "+
                    mouseEvent.getX() + ", " + mouseEvent.getY());
            int clickX = (int) mouseEvent.getX();
            int columna = clickX / Ficha.TAM_FICHA;
            System.out.println("Columna " + columna);
            colocarFicha(columna, 2);
        });
    }
    
    private void colocarFicha(int columna, int jugador) {
        Ficha ficha = new Ficha(jugador);
        ficha.setLayoutX(columna * Ficha.TAM_FICHA + Ficha.TAM_FICHA * 0.5);
        ficha.setLayoutY(Ficha.TAM_FICHA/2);
        this.getChildren().add(ficha);
    }
}
