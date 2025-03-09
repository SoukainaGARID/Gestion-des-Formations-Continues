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
public class InscriptionFormation {
    private int id;
    private Formation formation;
    private Participant participant;

    public InscriptionFormation(int id, Formation formation, Participant participant) {
        this.id = id;
        this.formation = formation;
        this.participant = participant;
    }

    public InscriptionFormation(Formation formation, Participant participant) {
        this.formation = formation;
        this.participant = participant;
    }

    public int getId() {
        return id;
    }

    public Formation getFormation() {
        return formation;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
    
    
    
}
