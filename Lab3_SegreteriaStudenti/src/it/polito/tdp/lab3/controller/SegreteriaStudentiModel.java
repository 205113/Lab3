package it.polito.tdp.lab3.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class SegreteriaStudentiModel {
	//private List<Studente>studenti;
	
	public String completa(String matricola){
		//completa nome e cognome data matricola
		String url="jdbc:mysql://localhost/iscritticorsi?user=root";
		try {String result="";
			Connection cn=DriverManager.getConnection(url);
			Statement st= cn.createStatement();
			ResultSet rs=st.executeQuery("SELECT nome,cognome FROM studente WHERE matricola=\""+matricola+"\"");
			if(rs.next()){
				result= rs.getString("nome")+"-"+rs.getString("cognome");
			}else{
				result= "Lo studente non esiste";
			}
			cn.close();
			rs.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	public String cercaCorsi(String matricola){
		//visualizza corsi della matricola
		return "";
	}
	public String cercaStudenti(String codice){
		//visualizza matricole del corso 
		return "";
	}
	public boolean iscritto(String matricola,String codice){
		//verifica se matricola iscritto a codice
		return false;
	}
	public void iscrivi(String matricola,String codice){
		//iscrive matricola a corso se non lo è già
	}
}
