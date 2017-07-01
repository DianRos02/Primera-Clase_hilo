/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase1;

/**
 *
 * @author educacionit
 */
public class Parte2 {
    public static void main(String[] args) {
        System.out.println("Interface Runnable");
        
        class Hilo implements Runnable{
            private String descripcion;

            public Hilo(String descripcion) {
                this.descripcion = descripcion;
            }
            

            @Override
            public void run() {
                for (int a=1;a<=10;a++){
                    System.out.println( descripcion +":"+a);
                    dormir(500);
                }
                
                }
            private void dormir(int ms){
                try{
                    Thread.sleep(ms);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            
        }//end class
        Hilo hilo1=new Hilo("hilo 1");
        Hilo hilo2=new Hilo("hilo 2");
        
        Thread tHilo1=new Thread(hilo1);
        Thread tHilo2=new Thread(hilo2);
        
        tHilo1.start();
        tHilo2.start();
        
        new Thread (new Hilo("hilo 3")).start();
                
    }
    
}
