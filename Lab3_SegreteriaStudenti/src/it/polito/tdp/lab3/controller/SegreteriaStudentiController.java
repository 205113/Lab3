package it.polito.tdp.lab3.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

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
    	if((corsi.getValue()==null)&&(matricola.getText().compareTo("")==0))
    		risultato.setText("dati mancanti");
    	else { 
    		if((corsi.getValue()!=null)&&(matricola.getText().compareTo("")!=0)){
    			boolean iscritto=model.iscritto(matricola.getText(), model.corso(corsi.getValue()));
    			if(iscritto)
    				risultato.setText("Lo studente è iscritto al corso");
    			else
    				risultato.setText("Lo studente non è iscritto al corso");
    		}else{
    			if(corsi.getValue()==null){
    				risultato.setText(model.cercaCorsi(matricola.getText()));
    			}else{
    				risultato.setText(model.cercaStudenti(model.corso(corsi.getValue())));
    			}
    		}
    		
    	}
    	
    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	if(corsi.getValue()==null){
    		risultato.setText("Non hai selezionato alcun corso");
    	}
    	else{
    		String codice=model.corso(corsi.getValue());
    		if(codice.compareTo("")==0)
    			risultato.setText("il corso non esiste");
    		else
    			risultato.setText(model.iscrivi(matricola.getText(), codice));
    	}
    }
    private List<String>Corsi(){
    	List<String>corsi=new ArrayList<String>();
    	//corsi.add("Nessun corso");
    	//carico corsi da DB
		String url="jdbc:mysql://localhost/iscritticorsi?user=root";
		try {
			Connection cn=DriverManager.getConnection(url);
			Statement st= cn.createStatement();
			ResultSet rs=st.executeQuery("SELECT nome FROM corso ");
			while(rs.next()){
				corsi.add( rs.getString("nome"));
			}
			cn.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return corsi;
    }


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
        corsi.getItems().addAll(( Corsi()));
    }
}