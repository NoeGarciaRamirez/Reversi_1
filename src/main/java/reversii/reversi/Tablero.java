
package reversii.reversi;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

/**
 *
 * @author noe
 */
public class Tablero extends Pane{//Meter que se pase tu turno si tardas mas de 10 s
    
    int turno = 1;//El primer turno es del jugador Blanco
    Logica logica;
    
    public Tablero(){
        logica = new Logica();
        
        for(int i=0; i<9; i++){//Líneas verticales
            Line line = new Line(Ficha.TAM_FICHA*i, 0,
                    Ficha.TAM_FICHA*i, (Ficha.TAM_FICHA)*8);
            this.getChildren().add(line);
        }
        for(int i=0; i<9; i++){//Líneas horizontales
            Line line = new Line(0, Ficha.TAM_FICHA*i,
                    (Ficha.TAM_FICHA)*8, Ficha.TAM_FICHA*i);
            this.getChildren().add(line);
        }
        
        //Las 4 fichas del principio de la partida, que están siempre
        colocarFicha(3, 3, 1);//Blancas
        colocarFicha(4, 4, 1);
        colocarFicha(4, 3, -1);//Negras
        colocarFicha(3, 4, -1);
        
        this.setOnMouseClicked((MouseEvent mouseEvent) -> {
            System.out.println("Mouse clicked X : Y -> "+
                    mouseEvent.getX() + ", " + mouseEvent.getY());
            
            int clickX = (int) mouseEvent.getX();
            int columna = clickX / Ficha.TAM_FICHA;
            System.out.println("Columna " + columna);
            
            int clickY = (int) mouseEvent.getY();
            int fila = clickY / Ficha.TAM_FICHA;
            System.out.println("Fila " + fila);
            
            colocarFicha(columna, fila, turno);
            turno *= -1;
            
            logica.mostrarConsola();
            
        });
    }
    
    private void colocarFicha(int columna, int fila, int jugador) {
//        if ((columna != ) && (fila != )){
//            System.out.println("No puedes colocar la ficha aquí");
//        } else {
        Ficha ficha = new Ficha(jugador);
        ficha.setLayoutX(columna * Ficha.TAM_FICHA + Ficha.TAM_FICHA * 0.5);
        ficha.setLayoutY(fila * Ficha.TAM_FICHA + Ficha.TAM_FICHA * 0.5);
        this.getChildren().add(ficha);
        logica.colocarFicha(columna, fila, jugador);
        }
    }
    
    
//    private void conseguirGiro(double escalaFichas){
//        escalaFichas --;
//        this.setScaleX(1);
//    }


