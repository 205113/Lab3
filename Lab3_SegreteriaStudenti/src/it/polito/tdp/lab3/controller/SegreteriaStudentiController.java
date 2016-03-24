package it.polito.tdp.lab3.controller;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {
	private SegreteriaStudentiModel model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblCorso;

    @FXML
    private ComboBox<String> corsi;

    @FXML
    private Label lblStudente;

    @FXML
    private TextField matricola;

    @FXML
    private Button completa;
    
    @FXML
    private TextField nome;

    @FXML
    private TextField cognome;

    @FXML
    private Button cerca;

    @FXML
    private Button iscrivi;

    @FXML
    private TextArea risultato;

    @FXML
    private Button cancella;
    public void setModel( SegreteriaStudentiModel model ) {
    	this.model = model ;
    }
    @FXML
    void doCancella(ActionEvent event) {
    	risultato.clear();
    	matricola.clear();
    	nome.clear();
    	cognome.clear();
    }


    @FXML
    void doCompleta(ActionEvent event) {
 
    	    String s=model.completa(matricola.getText());
    	    String[]studente=s.split("-");
    	    if(studente.length==2){
    	    	//completa
    	    	nome.setText(studente[0]);
    	    	cognome.setText(studente[1]);
    	    }
    	    else{
    	    	risultato.setText(s);
    	    }
    }
    @FXML
    void doCerca(ActionEvent event) {

    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	if(false){//condizione errata, sarebbe per capire se ha scelto un corso
    		risultato.setText("Non hai selezionato alcun corso");
    	}
    	else{
    		String codice=model.corso("Diritto commerciale");//errato,dovrebbe essere elemento del menu
    		if(codice.compareTo("")==0)
    			risultato.setText("il corso non esiste");
    		else
    			risultato.setText(model.iscrivi(matricola.getText(), codice));
    	}
    }
    /*private List<String>Corsi(){
    	List<String>corsi=new ArrayList<String>();
    	corsi.add("Nessun corso");
    	//carico corsi da DB
    	return corsi;
    }*/

    @FXML
    void initialize() {
        assert lblCorso != null : "fx:id=\"lblCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert corsi != null : "fx:id=\"corsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert lblStudente != null : "fx:id=\"lblStudente\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert matricola != null : "fx:id=\"matricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert completa != null : "fx:id=\"completa\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert nome != null : "fx:id=\"nome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert cognome != null : "fx:id=\"cognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert cerca != null : "fx:id=\"cerca\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert iscrivi != null : "fx:id=\"iscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert risultato != null : "fx:id=\"risultato\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert cancella != null : "fx:id=\"cancella\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        nome.setEditable(false);
        cognome.setEditable(false);
        
        //corsi.getItems().addAll(((ObservableList<String>) Corsi()));
    }
}