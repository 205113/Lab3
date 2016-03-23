package it.polito.tdp.lab3.controller;

import java.util.*;

public class Corso {
	private String codice;
	private int crediti;
	private String nome;
	private int pd;
	private List<Studente>studenti;
	
	public Corso(String codice, int crediti, String nome, int pd) {
		this.codice = codice;
		this.crediti = crediti;
		this.nome = nome;
		this.pd = pd;
		studenti=new ArrayList<Studente>();
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public int getCrediti() {
		return crediti;
	}

	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPd() {
		return pd;
	}

	public void setPd(int pd) {
		this.pd = pd;
	}

	public List<Studente> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Studente> studenti) {
		this.studenti = studenti;
	}
	public boolean iscrivi(Studente s){
		if(this.studenti.contains(s))
			return false;
		else{this.studenti.add(s);
			return true;
		}
		
	}
}
