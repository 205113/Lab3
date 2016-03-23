package it.polito.tdp.lab3.controller;

public class Studente {
	private String matricola;
	private String nome;
	private String cognome;
	private String cds;
	
	public Studente(String matricola, String nome, String cognome,String cds) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.cds=cds;
	}
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getCds() {
		return cds;
	}
	public void setCds(String cds) {
		this.cds = cds;
	}
	public boolean equals(Studente altro){
		if((this.matricola).compareTo(altro.getMatricola())==0)
				return true;
		else
			return false;
	}
	
}
