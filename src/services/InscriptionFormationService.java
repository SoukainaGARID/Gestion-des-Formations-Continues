/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.Formation;
import beans.InscriptionFormation;
import beans.Participant;
import dao.IDao;
import connexion.Connexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GIGA STORE
 */
public class InscriptionFormationService implements IDao<InscriptionFormation> {

    private Connexion connexion;
    private FormationService formationService;
    private ParticipantService participantService;

    public InscriptionFormationService() {
        connexion = Connexion.getInstance();
        formationService = new FormationService();
        participantService = new ParticipantService();
    }

    @Override
    public boolean create(InscriptionFormation o) {
        String req = "INSERT INTO inscriptionFormation (formation_id, participant_id) VALUES (?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getFormation().getId());
            ps.setInt(2, o.getParticipant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(InscriptionFormation o) {
        String req = "DELETE FROM inscriptionFormation WHERE formation_id = ? AND participant_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getFormation().getId());
            ps.setInt(2, o.getParticipant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(InscriptionFormation o) {
        // Cette méthode n'est pas applicable car InscriptionFormation n'a pas d'attribut a modifier

        return false;
    }

    @Override
    public InscriptionFormation findById(int id) {
        // Cette méthode n'est pas applicable car InscriptionFormation n'a pas d'ID unique.

        return null;
    }

    @Override
    public List<InscriptionFormation> findAll() {
        List<InscriptionFormation> inscriptions = new ArrayList<>();
        String req = "SELECT * FROM inscriptionFormation";
        try {
            Statement st = connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Formation formation = formationService.findById(rs.getInt("formation_id"));
                Participant participant = participantService.findById(rs.getInt("participant_id"));
                inscriptions.add(new InscriptionFormation(formation, participant));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return inscriptions;
    }
}
