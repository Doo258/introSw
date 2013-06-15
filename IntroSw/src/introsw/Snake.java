package org.upao.intro;

public class Snake {
    
    final int ARRIBA = 0;
    final int ABAJO = 1;
    final int DERECHA = 2;
    final int IZQUIERDA = 3;
            
    int inicioSnake;
    int longSnake;
    int manzanaX;
    int manzanaY;
    int ancho, alto;
    int[] snakeX;
    int[] snakeY;
    int direccion;
    
    
    
    Snake(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        snakeX = new int[ancho * alto];
        snakeY = new int[ancho * alto];
    }
    
    void inicializar() {
        inicioSnake = 0;
        longSnake = 4;
        
        // Cola de la serpiente
        snakeX[inicioSnake] = 1;
        snakeY[inicioSnake] = 1;
        snakeX[inicioSnake + 1] = 2;
        snakeY[inicioSnake + 1] = 1;
        snakeX[inicioSnake + 2] = 3;
        snakeY[inicioSnake + 2] = 1;
        // Cabeza de la serpiente
        snakeX[inicioSnake + 3] = 4;
        snakeY[inicioSnake + 3] = 1;
        // Direccion inicial
        direccion = DERECHA;
        generarManzana();
      
       
    }
    
    void mover() {
        int cabezaAnterior = inicioSnake + longSnake - 1;
        cabezaAnterior =cabezaAnterior %(ancho*alto);
        int cabeza = inicioSnake + longSnake;
        cabeza = cabeza %(ancho*alto);
        switch(direccion) {
            case DERECHA:
                snakeX[cabeza] = snakeX[cabezaAnterior] + 1;
                snakeY[cabeza] = snakeY[cabezaAnterior];
                break;
            case IZQUIERDA:
                snakeX[cabeza] = snakeX[cabezaAnterior] - 1;
                snakeY[cabeza] = snakeY[cabezaAnterior];
                break;
            case ARRIBA:
                snakeX[cabeza] = snakeX[cabezaAnterior];
                snakeY[cabeza] = snakeY[cabezaAnterior] - 1;
                break;
            case ABAJO:
                snakeX[cabeza] = snakeX[cabezaAnterior];
                snakeY[cabeza] = snakeY[cabezaAnterior] + 1;
                break;
        }
        if (snakeX[cabeza] >= ancho){
            snakeX[cabeza] =0;
        }else if (snakeX[cabeza]<0){
            snakeX[cabeza]=ancho -1;
        }
        {
        }
      if(snakeX[cabeza]==manzanaX && snakeY[cabeza]== manzanaY){
          longSnake++;
          generarManzana();
      }else{
            inicioSnake++;  
            inicioSnake= inicioSnake %(alto*ancho);
                    }
    }
    void verificarObstaculos(){
        int cabeza = inicioSnake +longSnake -1;
        cabeza = cabeza %(ancho *alto);
        for(int i = inicioSnake;i< inicioSnake +longSnake -1 ;i++){
            int pos = i %(alto*ancho);
            if(snakeX[cabeza] == snakeX[pos]&&
                    snakeY[cabeza] ==snakeX[pos]){
               
                break;
            }
      }
    }
    
     void generarManzana() {
         boolean valido =true;
         do{
        manzanaX = (int) (Math.random() * ancho);
        manzanaY = (int) (Math.random() * alto);
       for(int i = inicioSnake;i< inicioSnake + longSnake;i++){
          int pos =i %(ancho*alto);
           if(manzanaX ==snakeX[i]&&
                   manzanaY==snakeY[pos]){
               valido = false;
               break;
           }
       }
    }while(!valido);
  }      
    
    
    void irDerecha() {
        if(direccion != IZQUIERDA) {
            direccion = DERECHA;
        }
    }
    
    void irIzquierda() {
        if(direccion != DERECHA) {
            direccion = IZQUIERDA;
        }
    }
    
    void irArriba() {
        if(direccion != ABAJO) {
            direccion = ARRIBA;
        }
    }
    
    void irAbajo() {
        if(direccion != ARRIBA) {
            direccion = ABAJO;
        }
    }
}
