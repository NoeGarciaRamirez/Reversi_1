
package reversii.reversi;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author noe
 */
public class Ficha extends Group {
    double escalaFichas = 1;
    Group grupoFicha = new Group();
    static final short TAM_FICHA = 40;
    
        //Método constructor
    public Ficha(int jugador){//Creación de la ficha
        Circle circle1 = new Circle();
        circle1.setRadius(TAM_FICHA/2);
        circle1.setFill(Color.BLACK);
        this.getChildren().add(circle1);
        
        Circle circle2 = new Circle();
        circle2.setRadius(TAM_FICHA * 0.48);
        this.getChildren().add(circle2);
        
        
        if(jugador==1){
            circle2.setFill(Color.rgb(230, 230, 230));//Blanco, jugador 1
        } else {
            circle2.setFill(Color.rgb(0, 0, 0));//Negro, jugador 2
        }
        //Para la animación de las fichas que se dan la vuelta
        
        this.setScaleX(escalaFichas);
    }

}
