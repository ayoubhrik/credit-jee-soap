package model;

import java.io.Serializable;
import java.util.Date;


public class Credit implements Serializable{
	private static final long serialVersionUID = 1L;

	private int numcredit;

	private Date  datecredit;

	private double montant;

	private int duree;

	private double taux;

	private double annuite;

	private Date  dateprever;

	private String username;

	public int getNumcredit() {
		return numcredit;
	}
	public void setNumcredit(int numcredit) {
		this.numcredit = numcredit;
	}
	public Date getDatecredit() {
		return datecredit;
	}
	public void setDatecredit(Date datecredit) {
		this.datecredit = datecredit;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	public double getAnnuite() {
		return annuite;
	}
	public void setAnnuite(double annuite) {
		this.annuite = annuite;
	}
	public Date getDateprever() {
		return dateprever;
	}
	public void setDateprever(Date dateprever) {
		this.dateprever = dateprever;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Credit(int numcredit, Date datecredit, double montant, int duree, double taux, double annuite,
			Date dateprever, String username) {
		super();
		this.numcredit = numcredit;
		this.datecredit = datecredit;
		this.montant = montant;
		this.duree = duree;
		this.taux = taux;
		this.annuite = annuite;
		this.dateprever = dateprever;
		this.username = username;
	}
	public Credit(Date datecredit, double montant, int duree, double taux, double annuite,
			Date dateprever, String username) {
		this.datecredit = datecredit;
		this.montant = montant;
		this.duree = duree;
		this.taux = taux;
		this.annuite = annuite;
		this.dateprever = dateprever;
		this.username = username;
	}
	public Credit() {
		
	}
	@Override
	public String toString() {
		return "Credit [numcredit=" + numcredit + ", datecredit=" + datecredit + ", montant=" + montant + ", duree="
				+ duree + ", taux=" + taux + ", annuite=" + annuite + ", dateprever=" + dateprever + ", username="
				+ username + "]";
	}
	
	
}
