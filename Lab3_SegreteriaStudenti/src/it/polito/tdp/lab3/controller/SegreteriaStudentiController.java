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

    @FXML
    void doCancella(ActionEvent event) {
    	risultato.clear();
    	matricola.clear();
    	nome.clear();
    	cognome.clear();
    }

    @FXML
    void doCerca(ActionEvent event) {

    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }
    private List<String>Corsi(){
    	List<String>corsi=new LinkedList<String>();
    	corsi.add("Nessun corso");
    	//carico corsi da DB
    	return null;
    }

    @FXML
    void initialize() {
        assert lblCorso != null : "fx:id=\"lblCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert corsi != null : "fx:id=\"corsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert lblStudente != null : "fx:id=\"lblStudente\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert matricola != null : "fx:id=\"matricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
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