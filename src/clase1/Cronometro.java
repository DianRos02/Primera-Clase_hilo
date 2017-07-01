/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase1;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author educacionit
 */
public class Cronometro implements Runnable {
 private JTextField  swText=null;
private JLabel swLabel=null;
private TextField fxText=null;
private Label fxLabel=null;
 private boolean correr=false;
 private int tiempo=0;


    public Cronometro(TextField fxTextField) {
        this.fxText = fxTextField;
    }

    public Cronometro(Label fxLabel) {
        this.fxLabel = fxLabel;
    }

    public Cronometro(JLabel swLabel) {
        this.swLabel = swLabel;
    }

    public Cronometro(JTextField swText) {
        this.swText = swText;
    }
    public void setText(String text){
        if(swText !=null) swText.setText(text);
        if(swLabel !=null) swLabel.setText(text);
        if(fxText !=null) fxText.setText(text);
        if(fxLabel !=null) fxLabel.setText(text);
    }

    @Override
    public void run() {
       
  
       while(true){
           if(correr) setText((++tiempo)+"");
           //LocalDateTime ldt=LocalDateTime.now();
           //setText(ldt.getHour()+":"+ldt.getMinute()+":"+ldt.getSecond());
           try {
               Thread.sleep(1000);
           } catch (InterruptedException ex) {
               Logger.getLogger(Hora.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
      
    }
    public void start(){
        correr=true;
    }
    public void pause(){
        correr=false;
    }
    public void reset(){
        tiempo=0;
        setText(tiempo+"");
    }
    }
    

