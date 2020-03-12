package reversii.reversi;

/**
 *
 * @author noe
 */
public class Logica {
    static int [][] cuadricula = new int[8][8];
    
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
    public boolean darVueltaXFichas(int numFichasVueltaHD, int numFichasVueltaVD, int numFichasVueltaDD, int numFichasVueltaDI){
        if(numFichasVueltaHD >= 1 || numFichasVueltaVD >= 1 || numFichasVueltaDD >= 1 || numFichasVueltaDI >= 1) {
            return true;
        } else {
            return false;
        }
    }



//    private void conseguirGiro(double escalaFichas){
//        if (escalaFichas >= -1){
//            escalaFichas --;
//        }
//    }
}