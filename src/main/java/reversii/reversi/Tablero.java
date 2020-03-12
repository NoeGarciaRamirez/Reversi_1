
package reversii.reversi;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import static javafx.scene.paint.Color.RED;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import static javafx.util.Duration.seconds;
import static reversii.reversi.App.TAM_TABLERO;
import static reversii.reversi.App.errorFicha;

/**
 *
 * @author noe
 */
public class Tablero extends Pane{//Meter que se pase tu turno si tardas mas de 10 s

    int turno = 1;//El primer turno es del jugador Blanco
    Logica logica;
    Timeline timeline;
    App app;

    public Tablero(){
        //Label que muestra en pantalla que no puedes colocar la ficha en ese sitio
        Label errorFicha = new Label();
        errorFicha.relocate(TAM_TABLERO/2 - 50, TAM_TABLERO/2 - 50);
        errorFicha.setTextFill(RED);
        errorFicha.setVisible(false);
//        root.getChildren().add(errorFicha);
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

            logica.mostrarConsola();

//            timeline = new Timeline(
//                new KeyFrame(Duration.seconds(3), e -> {
//                    errorFicha.setVisible(true);
//                })
//            );
//            timeline.stop();
        });
    }

    public void colocarFicha(int columna, int fila, int jugador) {
        //Comprueba si hay una ficha donde haces click
        if (Logica.cuadricula [columna][fila] == 1 || Logica.cuadricula [columna][fila] == -1){
            System.out.println("No puedes colocar la ficha aquí");
            timeline.play();
        } else {
            //Coloca la ficha correspondiente, dependiendo del jugador
            Ficha ficha = new Ficha(jugador);
            ficha.setLayoutX(columna * Ficha.TAM_FICHA + Ficha.TAM_FICHA * 0.5);
            ficha.setLayoutY(fila * Ficha.TAM_FICHA + Ficha.TAM_FICHA * 0.5);
            this.getChildren().add(ficha);
            logica.colocarFicha(columna, fila, jugador);
            
            //Comprobar la cantidad de fichas a las que se le dan la vuelta alrededor de la
            //ficha que acabamos de colocar
            
            //Comprueba fichas en Horizontal hacia la Derecha
            int numFichasVueltaHD = logica.getNumFichasDarVuelta(fila, columna, 1, 0);
            System.out.println("Número de fichas a dar vuelta Horizontal Derecha: " + numFichasVueltaHD);
            //Comprueba fichas en Horizontal hacia la Izquierda
            int numFichasVueltaHI = logica.getNumFichasDarVuelta(fila, columna, -1, 0);
            System.out.println("Número de fichas a dar vuelta Horizontal Izquierda: " + numFichasVueltaHI);
            //Comprueba fichas en Vertical hacia Encima
            int numFichasVueltaVE = logica.getNumFichasDarVuelta(fila, columna, 0, -1);
            System.out.println("Número de fichas a dar vuelta Vertical Encima: " + numFichasVueltaVE);
            //Comprueba fichas en Vertical hacia Abajo
            int numFichasVueltaVA = logica.getNumFichasDarVuelta(fila, columna, 0, 1);
            System.out.println("Número de fichas a dar vuelta Vertical Abajo: " + numFichasVueltaVA);
            //Comprueba fichas en Diagonal hacia la Derecha Abajo, desde 0,0
            int numFichasVueltaDDA = logica.getNumFichasDarVuelta(fila, columna, 1, 1);
            System.out.println("Número de fichas a dar vuelta Diagonal derecha abajo: " + numFichasVueltaDDA);
            //Comprueba fichas en Diagonal hacia la Derecha Encima, desde 0,0
            int numFichasVueltaDDE = logica.getNumFichasDarVuelta(fila, columna, 1, -1);
            System.out.println("Número de fichas a dar vuelta Diagonal derecha arriba: " + numFichasVueltaDDE);
            //Comprueba fichas en Diagonal hacia la Izquierda Abajo, desde 0,0
            int numFichasVueltaDIA = logica.getNumFichasDarVuelta(fila, columna, -1, 1);
            System.out.println("Número de fichas a dar vuelta Diagonal izquierda abajo: " + numFichasVueltaDIA);
            //Comprueba fichas en Diagonal hacia la Izquierda Encima, desde 0,0
            int numFichasVueltaDIE = logica.getNumFichasDarVuelta(fila, columna, -1, -1);
            System.out.println("Número de fichas a dar vuelta Diagonal izquierda arriba: " + numFichasVueltaDIE);
            
            turno *= -1;
        }
    }
}