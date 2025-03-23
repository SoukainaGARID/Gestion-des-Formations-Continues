/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import connexion.Connexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author GIGA STORE
 */
public class graphe2 extends javax.swing.JInternalFrame {
           private DefaultCategoryDataset dataset;
           private Connexion connexion;
    /**
     * Creates new form graphe2
     */
    public graphe2() {
        initComponents();
        connexion = Connexion.getInstance();
        this.setTitle("Nombre de participants par formation ");
        
        dataset = new DefaultCategoryDataset();
        load();
        JFreeChart barChart = ChartFactory.createBarChart(
                "participants par formation",
                "formations",
                "Nombre de participants",
                dataset
        );
        
          CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        // Appliquer une couleur dégradée aux barres
        renderer.setSeriesPaint(0, new java.awt.Color(0, 128, 255));  // Bleu pour la première série
        renderer.setSeriesPaint(1, new java.awt.Color(255, 165, 0));  // Orange pour la deuxième série

        // Optionnel : définir la couleur de fond de la grille
        plot.setBackgroundPaint(new java.awt.Color(255, 255, 255));  // Blanc pour le fond du graphique

        ChartPanel chartPanel = new ChartPanel(barChart);
         chartPanel.setPreferredSize(new java.awt.Dimension(800, 600)); // Taille du graphique
        setContentPane(chartPanel);
        
    }
private void load() {
    // Requête SQL pour récupérer le nombre de participants par formation
    String req = "SELECT f.intitule, COUNT(i.participant_id) AS participants_count "
               + "FROM inscriptionFormation i "
               + "JOIN formation f ON i.formation_id = f.id "
               + "GROUP BY f.intitule";

    try (PreparedStatement ps = connexion.getCn().prepareStatement(req);
         ResultSet rs = ps.executeQuery()) {

        dataset.clear();  // Efface les anciennes données

        // Parcours des résultats et ajout au dataset
        while (rs.next()) {
            String formationName = rs.getString("intitule");  // Nom de la formation
            int participantsCount = rs.getInt("participants_count");  // Nombre de participants

            // Ajout des données au dataset avec "Participants" comme série et le nom de la formation comme catégorie
            dataset.addValue(participantsCount, "Participants", formationName);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erreur de connexion à la base de données !");
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chartPanel = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setVisible(true);

        javax.swing.GroupLayout chartPanelLayout = new javax.swing.GroupLayout(chartPanel);
        chartPanel.setLayout(chartPanelLayout);
        chartPanelLayout.setHorizontalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 857, Short.MAX_VALUE)
        );
        chartPanelLayout.setVerticalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chartPanel;
    // End of variables declaration//GEN-END:variables
}
