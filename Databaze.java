/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.evidence_pojistenych;

/**
 *
 * @author Vlad Voronkov
 */

class Databaze {
  private final String jmeno;
  private final String prijmeni;
  private final int telCislo;
  private final int vek;

  
/**
* Konstruktor
*/
    public Databaze(String jmeno, String prijmeni, int telCislo, int vek) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.telCislo = telCislo;
        this.vek = vek;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public int getTelCislo() {
        return telCislo;
    }

    public int getVek() {
        return vek;
    }

    @Override
    public String toString() {
        return jmeno + prijmeni + telCislo + vek;
    }
    
  
}