package it.polito.gestionecontabilitàdirezionale.Controller;


import it.polito.contabilitàdirezionale.model.ReportValoriTecnici;
import javafx.scene.control.TableCell;
import javafx.scene.paint.Color;

public class ChangeCell extends TableCell<ReportValoriTecnici, Float>{
	
  	protected void updateItem(Float item, boolean empty) {
        super.updateItem(item, empty);

        if (item == null || empty) {
            setText(null);
            setStyle("");
        } else {
        	if(item.doubleValue()>= 0.25){
        		setText(item.toString());
        		
                setTextFill(Color.RED);		
        	}
        	
        	else{
        		setText(item.toString());
        		setTextFill(Color.BLACK);	
        	}
        }
    }

}


