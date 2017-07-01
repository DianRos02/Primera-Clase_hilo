
package clase1;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Hora implements Runnable{
private JTextField  swText=null;
private JLabel swLabel=null;
private TextField fxText=null;
private Label fxLabel=null;

    public Hora(TextField fxTextField) {
        this.fxText = fxTextField;
    }

    public Hora(Label fxLabel) {
        this.fxLabel = fxLabel;
    }

    public Hora(JLabel swLabel) {
        this.swLabel = swLabel;
    }

    public Hora(JTextField swText) {
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
           LocalDateTime ldt=LocalDateTime.now();
           setText(ldt.getHour()+":"+ldt.getMinute()+":"+ldt.getSecond());
           try {
               Thread.sleep(1000);
           } catch (InterruptedException ex) {
               Logger.getLogger(Hora.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
    
}
