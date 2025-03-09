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
    private Formation formation;
    private Participant participant;

    public InscriptionFormation( Formation formation, Participant participant) {

        this.formation = formation;
        this.participant = participant;
    }

    


    public Formation getFormation() {
        return formation;
    }

    public Participant getParticipant() {
        return participant;
    }

    

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }
    
    
    
}
