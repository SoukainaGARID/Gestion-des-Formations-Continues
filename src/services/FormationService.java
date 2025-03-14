/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.Formation;
import dao.IDao;
import connexion.Connexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GIGA STORE
 */
public class FormationService implements IDao<Formation> {

    private Connexion connexion;

    public FormationService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Formation o) {
        String req = "INSERT INTO formation (intitule, duree, cout) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getIntitule());
            ps.setInt(2, o.getDuree());
            ps.setDouble(3, o.getCout());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Formation o) {
        String req = "DELETE FROM formation WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Formation o) {
        String req = "UPDATE formation SET intitule = ?, duree = ?, cout = ? WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getIntitule());
            ps.setInt(2, o.getDuree());
            ps.setDouble(3, o.getCout());
            ps.setInt(4, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Formation findById(int id) {
        String req = "SELECT * FROM formation WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Formation(rs.getInt("id"), rs.getString("intitule"), rs.getInt("duree"), rs.getDouble("cout"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Formation> findAll() {
        List<Formation> formations = new ArrayList<>();
        String req = "SELECT * FROM formation";
        try {
            Statement st = connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                formations.add(new Formation(rs.getInt("id"), rs.getString("intitule"), rs.getInt("duree"), rs.getDouble("cout")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return formations;
    }

}
