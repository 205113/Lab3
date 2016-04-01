package it.polito.tdp.lab3.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class SegreteriaStudentiModel {
	
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
		String risultato="";
		List<String>codici=new LinkedList<String>();
		String url="jdbc:mysql://localhost/iscritticorsi?user=root";
		try {
			Connection cn=DriverManager.getConnection(url);
			Statement st= cn.createStatement();
			ResultSet rs=st.executeQuery("SELECT codins FROM iscrizione WHERE matricola=\""+matricola+"\"");
			while(rs.next()){
				codici.add(rs.getString("codins"));
			}
			for(int i=0;i<codici.size();i++){
				rs=st.executeQuery("SELECT * FROM corso WHERE codins=\""+codici.get(i)+"\"");
				rs.next();
				risultato+=rs.getString("codins")+" "+rs.getInt("crediti")+" "+rs.getString("nome")+" "+rs.getInt("pd")+"\n";
			}
			rs.close();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return risultato;
	}
	public String cercaStudenti(String codice){
		//visualizza matricole del corso 
		String risultato="";
		List<Integer>codici=new LinkedList<Integer>();
		String url="jdbc:mysql://localhost/iscritticorsi?user=root";
		try {
			Connection cn=DriverManager.getConnection(url);
			Statement st= cn.createStatement();
			ResultSet rs=st.executeQuery("SELECT matricola FROM iscrizione WHERE codins=\""+codice+"\"");
			while(rs.next()){
				codici.add(rs.getInt("matricola"));
			}
			for(int i=0;i<codici.size();i++){
				rs=st.executeQuery("SELECT * FROM studente WHERE matricola=\""+codici.get(i)+"\"");
				rs.next();
				risultato+=rs.getInt("matricola")+" "+rs.getString("cognome")+" "+rs.getString("nome")+" "+rs.getString("CDS")+"\n";
			}
			rs.close();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return risultato;
	}
	public boolean iscritto(String matricola,String codice){
		String url="jdbc:mysql://localhost/iscritticorsi?user=root";
		try {boolean result;
			Connection cn=DriverManager.getConnection(url);
			Statement st= cn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM iscrizione WHERE matricola=\""+matricola+"\" AND codins=\""+codice+"\"");
			if(rs.next()){
				result= true;
			}else{
				result= false;
			}
			cn.close();
			rs.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public String iscrivi(String matricola,String codice){
		//iscrive matricola a corso se non lo è già
		if(this.iscritto(matricola, codice))
			return "lo studente è gia iscritto al corso";
		else{String url="jdbc:mysql://localhost/iscritticorsi?user=root";
			Connection cn;
			try {
				cn = DriverManager.getConnection(url);
				Statement st= cn.createStatement();
				st.executeUpdate("INSERT INTO `iscrizione` (`matricola`, `codins`) VALUES ("+matricola+", '"+codice+"')");
				return "Lo studente è stato iscritto";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return"errore nella creazione dell'iscrizione";
		}
			
	}
	public String corso(String nome){
		String codice="";
		String url="jdbc:mysql://localhost/iscritticorsi?user=root";
		try {
			Connection cn=DriverManager.getConnection(url);
			Statement st= cn.createStatement();
			ResultSet rs=st.executeQuery("SELECT codins FROM corso WHERE nome=\""+nome+"\"");
			if(rs.next()){
				codice= rs.getString("codins");
			}else{
				codice= "";
			}
			cn.close();
			rs.close();
			return codice;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return codice;
	}
    public List<String>Corsi(){
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
}
