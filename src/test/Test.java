/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import beans.Formation;
import beans.InscriptionFormation;
import beans.Participant;
import services.FormationService;
import services.InscriptionFormationService;
import services.ParticipantService;

/**
 *
 * @author GIGA STORE
 */
public class Test {
    public static void main(String[] args) {
        FormationService formationService = new FormationService();
        ParticipantService participantService = new ParticipantService();
        InscriptionFormationService inscriptionService = new InscriptionFormationService();

       
        Formation formation = new Formation("Java", 30, 500.0);
        formationService.create(formation);

        
        Participant participant = new Participant("Soukaina", "Garid", "soukainagrd@example.com");
        participantService.create(participant);

       
        InscriptionFormation inscription = new InscriptionFormation(formation, participant);
        inscriptionService.create(inscription);

 
        System.out.println("Formations:");
        for (Formation f : formationService.findAll()) {
            System.out.println(f.getIntitule());
        }

      
        System.out.println("\nParticipants:");
        for (Participant p : participantService.findAll()) {
            System.out.println(p.getNom());
        }

        
       

     
        inscriptionService.delete(inscription);

     
        System.out.println("\nInscriptions after deletion:");
        for (InscriptionFormation i : inscriptionService.findAll()) {
            System.out.println(i.getParticipant().getNom() + " is registered for " + i.getFormation().getIntitule());
        }

       
        
    }
}