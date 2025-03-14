/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

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
public class ParticipantService implements IDao<Participant> {

    private Connexion connexion;

    public ParticipantService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Participant o) {
        String req = "INSERT INTO participant (nom, prenom, email) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getEmail());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'ajout du participant: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Participant o) {
        String req = "DELETE FROM participant WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression du participant: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Participant o) {
        String req = "UPDATE participant SET nom = ?, prenom = ?, email = ? WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getEmail());
            ps.setInt(4, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour du participant: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public Participant findById(int id) {
        String req = "SELECT * FROM participant WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Participant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la recherche du participant: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Participant> findAll() {
        List<Participant> participants = new ArrayList<>();
        String req = "SELECT * FROM participant";
        try {
            Statement st = connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                participants.add(new Participant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email")));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des participants: " + ex.getMessage());
        }
        return participants;
    }
}
