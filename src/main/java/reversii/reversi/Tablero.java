
package reversii.reversi;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

/**
 *
 * @author noe
 */
public class Tablero extends Pane{
    static short margenLadosTablero=10;
    
    public Tablero(){
        for(int i=0; i<9; i++){
            Line line = new Line(Ficha.TAM_FICHA*i+margenLadosTablero, margenLadosTablero,
                    Ficha.TAM_FICHA*i+margenLadosTablero, (Ficha.TAM_FICHA)*8+margenLadosTablero);
            this.getChildren().add(line);
        }
        for(int i=0; i<9; i++){
            Line line = new Line(margenLadosTablero, Ficha.TAM_FICHA*i+margenLadosTablero,
                    (Ficha.TAM_FICHA)*8+margenLadosTablero, Ficha.TAM_FICHA*i+margenLadosTablero);
            this.getChildren().add(line);
        }
    }
}
