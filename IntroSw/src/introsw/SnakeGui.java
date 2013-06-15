package org.upao.intro;

import javax.swing.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SnakeGui extends JFrame {

    Snake snake;
    SnakePanel panel;
    boolean gameOver = false, pausa = false;

    public static void main(String[] args) {
        new SnakeGui().ejecutar();
    }

    void ejecutar() {
        snake = new Snake(30, 20);
        panel = new SnakePanel(snake, 20);
        this.setTitle("Snake INSO");
        this.getContentPane().add(panel);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                switch (e.getKeyChar()) {
                    case 'w':
                        snake.irArriba();
                        break;
                    case 'a':
                        snake.irIzquierda();
                        break;
                    case 's':
                        snake.irAbajo();
                        break;
                    case 'd':
                        snake.irDerecha();
                        break;
                    case 'q':
                        gameOver = true;
                        break;
                    case 'p':
                        pausa = !pausa;
                        break;
                }
            }
        });
        iniciarJuego();
    }

    void iniciarJuego() {
        snake.inicializar();
        while (!gameOver) {
            try {
                while (pausa) {
                    Thread.sleep(10);
                }
                Thread.sleep(150);
            } catch (InterruptedException ex) {
            }
            snake.mover();
            panel.repaint();
        }
    }
}
