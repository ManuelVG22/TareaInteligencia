/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciointeligencia;

import java.util.Stack;

/**
 *
 * @author Manuel Vásquez
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public final short OBSTACULO = -1;
    private short INICIO = -2;
    private static short OBJETIVO = -3;
    private int alto = 3;
    private int largo = 3;
    
    private short [][] laberinto;
    
    public NewMain() {
        System.out.println("Nuevo laberinto de tamaño " + alto + " por " + largo);
        
        laberinto = new short[largo + 2][alto + 2];
        
        for (int i = 0; i< largo + 2; i++) {
            for (int j = 0; j < alto + 2; j++) {
                laberinto[i][j] = 0;
            }
        }
        
        for (int i = 0; i < alto + 2; i++) {
            laberinto[0][i] = laberinto[largo + 1][i] = OBSTACULO;
        }
        
        for (int i = 0; i < largo + 2; i++) {
            laberinto[i][0] = laberinto[i][alto + 1] = OBSTACULO;
        }

        
        
        //Colocar obstaculos
        setValor(3, 2, OBSTACULO);
        setValor(2, 3, OBSTACULO);
        setValor(1, 2, OBSTACULO);
        
        //Especificar el estado inicial
        setValor(1, 1, (short)0);
        
        //Especifiar el estado objetivo
        setValor(largo - 1, alto - 1, OBJETIVO);
    }
    
    public short getValor(int x, int y) { 
        return laberinto[x + 1][y + 1]; 
    }
    
    public void setValor(int x, int y, short value) { 
        laberinto[x + 1][y + 1] = value; 
    }
    
    public int getLargo() { 
        return largo; 
    }
    
    public int getAlto() { 
        return alto; 
    }


public boolean buscarPosision(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            int posX = pos[0], posY = pos[1];

            if (getValor(posX, posY) == OBJETIVO) {
                System.out.println("Objetivo encontrado en: (" + posX + ", " + posY + ")");
                return true;
            }

            
            setValor(posX, posY, (short) -4);

            
            int[][] movimientos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] movimiento : movimientos) {
                int nuevoX = posX + movimiento[0];
                int nuevoY = posY + movimiento[1];
                if (getValor(nuevoX, nuevoY) == 0 || getValor(nuevoX, nuevoY) == OBJETIVO) {
                    stack.push(new int[]{nuevoX, nuevoY});
                }
            }
        }
        System.out.println("No se encontró el objetivo");
        return false;
    }
}
    

