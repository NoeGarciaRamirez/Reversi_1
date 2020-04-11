package reversii.reversi;


/**
 *
 * @author noe
 */
public class Logica {
    static int [][] cuadricula = new int[8][8];
    int numFichasVueltaHD;
    int numFichasVueltaHI;
    int numFichasVueltaVE;
    int numFichasVueltaVA;
    int numFichasVueltaDDA;
    int numFichasVueltaDDE;
    int numFichasVueltaDIA;
    int numFichasVueltaDIE;
    int contadorFichasVueltas = 0;
    Tablero tablero;
    
    //Detectar fin de partida y qué jugador gana. No es necesario deshabilitar el "Colocar ficha" ya que
    //se comprueba si se puede colocar ficha, y no se puede reajustar la ventana
    
    public void comprobarFinDePartida() {
        int NumFichasJugadorBlanco = 0;
        int NumFichasJugadorNegro = 0;
        
        for(int c=0; c<8; c++) {
            for(int f=0; f<8; f++){
                if (cuadricula[c][f] == 1){
                    NumFichasJugadorBlanco++;
                }
                if (cuadricula[c][f] == -1){
                    NumFichasJugadorNegro++;
                }
            }
        } 
        /*Cuando se rellenan los 64 espacios del tablero (8 X 8)se comprueba qué jugador tiene más
        puntos, y se muestra un mensaje indicando quién gana. O si hay empate.*/
        if (NumFichasJugadorBlanco + NumFichasJugadorNegro == 64) {
            
            if (NumFichasJugadorBlanco > NumFichasJugadorNegro) {
                System.out.println("¡Gana el jugador 1 (Blanco)!");
            }
            if (NumFichasJugadorBlanco < NumFichasJugadorNegro) {
                System.out.println("¡Gana el jugador 2 (Negro)!");
            }
            if (NumFichasJugadorBlanco == NumFichasJugadorNegro) {
                System.out.println("Se ha acabado la partida con un empate");
            }
            
            tablero.reiniciarPartida();
            
        }
    }
    


    public Logica() {
        for(int c=0; c<8; c++) {
            for(int f=0; f<8; f++){
                cuadricula[c][f] = 0;//Crear una matriz de 8X8, y rellenarla de 0
            }
        }
    }

    public void mostrarConsola() {
        for(int c=0; c<8; c++) {
            for(int f=0; f<8; f++){
                System.out.print(cuadricula[f][c] + "\t");//Mostrar en consola la matriz con tabulador
            }
            System.out.println();
        }
    }

    public void colocarFichaL(int columna, int fila, int jugador){
            cuadricula [columna][fila] = jugador;
    }
    
    //Se comprueba a cuántas fichas hay que darle la vuelta, desde donde se pone la ficha en las 8 direcciones
    public int getNumFichasDarVuelta(int fila, int columna, int incCol, int incFil){
        int jugador = cuadricula[columna][fila];
        int i = 1;
        try{
            while ( (cuadricula[columna + (i * incCol)][fila + (i * incFil)] != jugador
                    &&
                    cuadricula[columna + (i * incCol)][fila + (i * incFil)] != 0) ){
                contadorFichasVueltas ++ ;
                i++;
            }
            if (cuadricula[columna + (i * incCol)][fila + (i * incFil)] != jugador ){
                contadorFichasVueltas = 0;
            }
            //que no cuente +1 a contador si sale de tablero
//            if (columna >= 8 || fila >= 8 || columna <= 0 || fila <= 0){
//                contadorFichasVueltas = 0;
//            }
        } catch (Exception x){}
        
        return contadorFichasVueltas;//Retorna una variable para saber el número de posiciones en la matriz y en pantalla que hay que cambiar
    }
    
    //Si se da la vuelta a alguna ficha, se hace en la matriz
    public void cambiarJugadorEnMatriz(int columna, int fila, int jugador, int contadorFichasVueltas, int incCol, int incFil){
        if(numFichasVueltaHD >= 1 || numFichasVueltaHI >= 1 || numFichasVueltaVE >= 1 || numFichasVueltaVA >= 1 ||
           numFichasVueltaDDA >= 1 || numFichasVueltaDDE >= 1 || numFichasVueltaDIA >= 1 || numFichasVueltaDIE >= 1) {
            for(int i=1; i<(contadorFichasVueltas+1); i++){
                cuadricula[columna + (i * incCol)][fila + (i * incFil)] = jugador;
            }
        }
    }
    
    
    
    
    
    // PARTE QUE HACE QUE SE CAMBIEN LAS FICHAS EN PANTALLA
    
    
//    public void cambiarJugadorEnPantalla (int columna, int fila, int jugador, int contadorFichasVueltas, int incCol, int incFil){
//        if(numFichasVueltaHD >= 1 || numFichasVueltaHI >= 1 || numFichasVueltaVE >= 1 || numFichasVueltaVA >= 1 ||
//           numFichasVueltaDDA >= 1 || numFichasVueltaDDE >= 1 || numFichasVueltaDIA >= 1 || numFichasVueltaDIE >= 1) {
//            for(int i=1; i<(contadorFichasVueltas+1); i++){
//            
//            Ficha ficha = new Ficha(jugador);
//            ficha.setLayoutX((columna * Ficha.TAM_FICHA + Ficha.TAM_FICHA * 0.5) + contadorFichasVueltas * (columna * Ficha.TAM_FICHA + Ficha.TAM_FICHA * 0.5));
//            ficha.setLayoutY((fila * Ficha.TAM_FICHA + Ficha.TAM_FICHA * 0.5) + contadorFichasVueltas * (fila * Ficha.TAM_FICHA + Ficha.TAM_FICHA * 0.5));
//            tablero.getChildren().add(ficha);// Esta línea es la que da error, a la hora de ponerlo en pantalla.
//            }
//        }
//    }

    public void comprobarFichasADarVuelta(int fila, int columna, int jugador){
        //Comprueba fichas en Horizontal hacia la Derecha
        numFichasVueltaHD = this.getNumFichasDarVuelta(fila, columna, 1, 0);
        System.out.println("Número de fichas a dar vuelta Horizontal Derecha: " + numFichasVueltaHD);
        if (numFichasVueltaHD > 0) {
            cambiarJugadorEnMatriz(columna, fila, jugador, contadorFichasVueltas, 1, 0);
            
            //cambiarJugadorEnPantalla(columna, fila, jugador, contadorFichasVueltas, 1, 0);
        }

        //Comprueba fichas en Horizontal hacia la Izquierda
        numFichasVueltaHI = this.getNumFichasDarVuelta(fila, columna, -1, 0);
        System.out.println("Número de fichas a dar vuelta Horizontal Izquierda: " + numFichasVueltaHI);
        if (numFichasVueltaHI > 0) {
            cambiarJugadorEnMatriz(columna, fila, jugador, contadorFichasVueltas, -1, 0);
            
            //cambiarJugadorEnPantalla(columna, fila, jugador, contadorFichasVueltas, 1, 0);
        }

        //Comprueba fichas en Vertical hacia Encima
        numFichasVueltaVE = this.getNumFichasDarVuelta(fila, columna, 0, -1);
        System.out.println("Número de fichas a dar vuelta Vertical Encima: " + numFichasVueltaVE);
        if (numFichasVueltaVE > 0) {
            cambiarJugadorEnMatriz(columna, fila, jugador, contadorFichasVueltas, 0, -1);
        }

        //Comprueba fichas en Vertical hacia Abajo
        numFichasVueltaVA = this.getNumFichasDarVuelta(fila, columna, 0, 1);
        System.out.println("Número de fichas a dar vuelta Vertical Abajo: " + numFichasVueltaVA);
        if (numFichasVueltaVA > 0) {
            cambiarJugadorEnMatriz(columna, fila, jugador, contadorFichasVueltas, 0, 1);
        }

        //Comprueba fichas en Diagonal hacia la Derecha Abajo, desde 0,0
        numFichasVueltaDDA = this.getNumFichasDarVuelta(fila, columna, 1, 1);
        System.out.println("Número de fichas a dar vuelta Diagonal derecha abajo: " + numFichasVueltaDDA);
        if (numFichasVueltaDDA > 0) {
            cambiarJugadorEnMatriz(columna, fila, jugador, contadorFichasVueltas, 1, 1);
        }

        //Comprueba fichas en Diagonal hacia la Derecha Encima, desde 0,0
        numFichasVueltaDDE = this.getNumFichasDarVuelta(fila, columna, 1, -1);
        System.out.println("Número de fichas a dar vuelta Diagonal derecha arriba: " + numFichasVueltaDDE);
        if (numFichasVueltaDDE > 0) {
            cambiarJugadorEnMatriz(columna, fila, jugador, contadorFichasVueltas, 1, -1);
        }

        //Comprueba fichas en Diagonal hacia la Izquierda Abajo, desde 0,0
        numFichasVueltaDIA = this.getNumFichasDarVuelta(fila, columna, -1, 1);
        System.out.println("Número de fichas a dar vuelta Diagonal izquierda abajo: " + numFichasVueltaDIA);
        if (numFichasVueltaDIA > 0) {
            cambiarJugadorEnMatriz(columna, fila, jugador, contadorFichasVueltas, -1, 1);
        }

        //Comprueba fichas en Diagonal hacia la Izquierda Encima, desde 0,0
        numFichasVueltaDIE = this.getNumFichasDarVuelta(fila, columna, -1, -1);
        System.out.println("Número de fichas a dar vuelta Diagonal izquierda arriba: " + numFichasVueltaDIE);
        if (numFichasVueltaDIE > 0) {
            cambiarJugadorEnMatriz(columna, fila, jugador, contadorFichasVueltas, -1, -1);
        }
    }

    
    
    
    
    
    
    
    
    // HACER EL GIRO DE LA FICHA
    
//    private void conseguirGiro(double escalaFichas){
//        if (escalaFichas >= -1){
//            escalaFichas --;
//        }
//    }

}