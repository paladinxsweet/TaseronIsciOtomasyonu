package application;

import java.sql.Date;

public class Kisi {	

private String ad;
private String soyad;
private Date tarih;
private String telefon;
private String adres;
private String firma;
private String mevki;
private int ucret;
private int calisma_suresi;
private String sigorta;
private String bulundugu_proje;
public Kisi(String ad, String soyad, Date tarih, String telefon, String adres, String firma, String mevki,
		int ucret, int calisma_suresi, String sigorta, String bulundugu_proje) {
	super();
	this.ad = ad;
	this.soyad = soyad;
	this.tarih = tarih;
	this.telefon = telefon;
	this.adres = adres;
	this.firma = firma;
	this.mevki = mevki;
	this.ucret = ucret;
	this.calisma_suresi = calisma_suresi;
	this.sigorta = sigorta;
	this.bulundugu_proje = bulundugu_proje;
}
public Kisi() {
	// TODO Auto-generated constructor stub
}
public String getAd() {
	
	return ad;
}
public void setAd(String ad) {
	this.ad=ad;
}
public String getSoyad() {
	return soyad;
}
public void setSoyad(String soyad) {
	this.soyad = soyad;
}
public Date getTarih() {
	return tarih;
}
public void setTarih(Date tarih) {
	this.tarih = tarih;
}
public String getTelefon() {
	return telefon;
}
public void setTelefon(String telefon) {
	this.telefon = telefon;
}
public String getAdres() {
	return adres;
}
public void setAdres(String adres) {
	this.adres = adres;
}
public String getFirma() {
	return firma;
}
public void setFirma(String firma) {
	this.firma = firma;
}
public String getMevki() {
	return mevki;
}
public void setMevki(String mevki) {
	this.mevki = mevki;
}
public int getUcret() {
	return ucret;
}
public void setUcret(int ucret) {
	this.ucret = ucret;
}
public int getCalisma_suresi() {
	return calisma_suresi;
}
public void setCalisma_suresi(int calisma_suresi) {
	this.calisma_suresi = calisma_suresi;
}
public String getSigorta() {
	return sigorta;
}
public void setSigorta(String sigorta) {
	this.sigorta = sigorta;
}
public String getBulundugu_proje() {
	return bulundugu_proje;
}
public void setBulundugu_proje(String bulundugu_proje) {
	this.bulundugu_proje = bulundugu_proje;
}

}
