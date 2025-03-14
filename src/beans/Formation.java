/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author GIGA STORE
 */
public class Formation {

    private int id;
    private String intitule;
    private int duree;
    private double cout;

    public Formation(int id, String intitule, int duree, double cout) {
        this.id = id;
        this.intitule = intitule;
        this.duree = duree;
        this.cout = cout;
    }

    public Formation(String intitule, int duree, double cout) {
        this.intitule = intitule;
        this.duree = duree;
        this.cout = cout;
    }

    public int getId() {
        return id;
    }

    public String getIntitule() {
        return intitule;
    }

    public int getDuree() {
        return duree;
    }

    public double getCout() {
        return cout;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

}
