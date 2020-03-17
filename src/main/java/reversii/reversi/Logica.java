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
    
    public void colocarFicha(int columna, int fila, int jugador){
            cuadricula [columna][fila] = jugador;
    }
    
    public int getNumFichasDarVuelta(int fila, int columna, int incCol, int incFil){
        int jugador = cuadricula[columna][fila];
        int contadorFichasVueltas = 0;
        int i = 1;
        try{
            while ((cuadricula[columna + (i * incCol)][fila + (i * incFil)] != jugador &&
                    cuadricula[columna + (i * incCol)][fila + (i * incFil)] != 0) ){
                contadorFichasVueltas ++ ;
                i++;
            }
            if (cuadricula[columna + (i * incCol)][fila + (i * incFil)] != jugador ){
                contadorFichasVueltas = 0;
            }
        } catch (Exception x){
        }
        
        return contadorFichasVueltas;
    }
    
    //Comprobamos el numero de fichas que hay que dar la vuelta y hacemos la animación
    //de dar la vuelta
    public boolean darVueltaXFichas(int numFichasVueltaHD, int numFichasVueltaHI, int numFichasVueltaVE, int numFichasVueltaVA,
                                    int numFichasVueltaDDA, int numFichasVueltaDDE, int numFichasVueltaDIA, int numFichasVueltaDIE){
        if(numFichasVueltaHD >= 1 || numFichasVueltaHI >= 1 || numFichasVueltaVE >= 1 || numFichasVueltaVA >= 1 ||
           numFichasVueltaDDA >= 1 || numFichasVueltaDDE >= 1 || numFichasVueltaDIA >= 1 || numFichasVueltaDIE >= 1) {
            return true;
        } else {
            return false;
        }
    }

            //Método para cambiar de color las fichas correspondientes y el jugador
    public void cambioColorFichasYAnimacion (double escalaFichas, int columna, int fila, int jugador){
        if(darVueltaXFichas() == true){
            
        }
    }
    
    public void comprobarFichasADarVuelta(int fila, int columna){
                    //Comprueba fichas en Horizontal hacia la Derecha
            numFichasVueltaHD = this.getNumFichasDarVuelta(fila, columna, 1, 0);
            System.out.println("Número de fichas a dar vuelta Horizontal Derecha: " + numFichasVueltaHD);
            //Comprueba fichas en Horizontal hacia la Izquierda
            numFichasVueltaHI = this.getNumFichasDarVuelta(fila, columna, -1, 0);
            System.out.println("Número de fichas a dar vuelta Horizontal Izquierda: " + numFichasVueltaHI);
            //Comprueba fichas en Vertical hacia Encima
            numFichasVueltaVE = this.getNumFichasDarVuelta(fila, columna, 0, -1);
            System.out.println("Número de fichas a dar vuelta Vertical Encima: " + numFichasVueltaVE);
            //Comprueba fichas en Vertical hacia Abajo
            numFichasVueltaVA = this.getNumFichasDarVuelta(fila, columna, 0, 1);
            System.out.println("Número de fichas a dar vuelta Vertical Abajo: " + numFichasVueltaVA);
            //Comprueba fichas en Diagonal hacia la Derecha Abajo, desde 0,0
            numFichasVueltaDDA = this.getNumFichasDarVuelta(fila, columna, 1, 1);
            System.out.println("Número de fichas a dar vuelta Diagonal derecha abajo: " + numFichasVueltaDDA);
            //Comprueba fichas en Diagonal hacia la Derecha Encima, desde 0,0
            numFichasVueltaDDE = this.getNumFichasDarVuelta(fila, columna, 1, -1);
            System.out.println("Número de fichas a dar vuelta Diagonal derecha arriba: " + numFichasVueltaDDE);
            //Comprueba fichas en Diagonal hacia la Izquierda Abajo, desde 0,0
            numFichasVueltaDIA = this.getNumFichasDarVuelta(fila, columna, -1, 1);
            System.out.println("Número de fichas a dar vuelta Diagonal izquierda abajo: " + numFichasVueltaDIA);
            //Comprueba fichas en Diagonal hacia la Izquierda Encima, desde 0,0
            numFichasVueltaDIE = this.getNumFichasDarVuelta(fila, columna, -1, -1);
            System.out.println("Número de fichas a dar vuelta Diagonal izquierda arriba: " + numFichasVueltaDIE);
    }

//    private void conseguirGiro(double escalaFichas){
//        if (escalaFichas >= -1){
//            escalaFichas --;
//        }
//    }

}