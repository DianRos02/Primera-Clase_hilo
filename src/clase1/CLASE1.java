/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author educacionit
 */
public class CLASE1 {

    /**
     * @param args the command line arguments
     * 
     */
    
    /*
    Curso : Java Advanced 15 horas
    Profe: Carlos Rios  carlos.rios@educacionit.com
    */
    //1-CARGAR FILE1 disco1 10s
    //2-cargar file2 disco2 10s
    //3-abrir formulario   1s
    // la etapa más lenta es el disco duro
    //lo más rapido es dentro del ordenador
    
    public static void main(String[] args) throws Exception {
       /* int suma=0;
        for(int a=1;a<=1000000000;a++){
            suma+=a;
        }
        
            System.out.println(suma);
            for(int a=1;a<=1000000;a++){
                System.out.println(a);
            }*/
       
       //cantidad de nucleos del procesador
        System.out.println("nucleos:" + Runtime.getRuntime().availableProcessors());
        //Clase Interna
        class Hilo extends Thread{ // clase que permite ejecutar en un hilo, 
          private String descripcion;

            public Hilo(String descripcion) {
                this.descripcion = descripcion;
            }
          //el metodo start va ejecutar en un hilo
            @Override
            //public void start(){ // metodo que ejecuta en un hilo distinto
            public void run(){
                for(int a=1;a<=10;a++){
                    System.out.println(descripcion +":"+a);
                    dormir(500);
                    //this.yield();
                    //System.out.println("--" + this.getState());
                }
            }

            private void dormir(int ms) {
                try {
                    Thread.sleep(ms); // sleep lanza exception
                } catch (InterruptedException ex) {
                    Logger.getLogger(CLASE1.class.getName()).log(Level.SEVERE, null, ex);
                    //soup(ex);
                }
            }
        }//end class
        
        Hilo hilo1=new Hilo("hilo 1");
        Hilo hilo2=new Hilo("hilo 2");
        //System.out.println(hilo1.getClass().getName());
        //System.out.println(hilo1.getState());
        //System.out.println(hilo1.isAlive());
        
        /*ciclo de vida de un hilo
         new  runnable   bocked                 terminated
               start ()  time walting. sleep()  muerte natural
                          waiting     . wait    asesinato.stop
     
        */
        hilo1.setPriority(Thread.MAX_PRIORITY);
        hilo2.setPriority(Thread.MIN_PRIORITY);
        hilo1.setPriority(2);// java tiene de 1 a 10 prioridades  
        
        
        //el metodo start no ejecuta en un hilo aparte
        // el método run invoca al metodo start() en un hilo aparte
        hilo1.start(); //cuando bajamos el sleep varia el orden de ejecucion entre cada hilo
        hilo2.start(); //la apertura tarda
        //hilo1.run();
        //hilo2.run();
        new Hilo ("hilo 3").start(); //agregar un nuevo hilo, 
        
        //hilo1.start(); no se puede startear 2 veces 1 hilo.
        System.out.println("--fin del programa.--");
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.err.println("ocurrio un error!!");// err está desincronizado del hilo principal del sistema
        
        Thread.sleep(1000);
        
        System.out.println(hilo1.getState());
        System.out.println(hilo1.isAlive());
        }//end main
    }// end class
    

