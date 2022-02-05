import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFrame extends JFrame{
    private JPanel Admin_gui;
    private JLabel bienvenue;
    private JLabel virement_label;
    private JButton virement_button;
    private JLabel solde_label;
    private JLabel iban_label;
    private JLabel deco_label;
    private JButton déconnexionButton;
    private JLabel iban_receveur_label;
    private JTextField iban_receveur_field;
    private JLabel virement_montant_label;
    private JTextField virement_montant_field;
    private JButton envoyerButton;
    private JLabel erreur_virement_solde;
    private JButton validerVirementButton;
    private JLabel afficher_virement_valider;
    private JButton créerUneSessionButton;
    private JButton informationsClientsButton;
    private JLabel informationClientsLabel;
    private JLabel créerUneSessionLabel;

    public AdminFrame(){
        this.setContentPane(Admin_gui);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(720, 900));
        this.setMaximumSize(new Dimension(720, 900));
        this.setMinimumSize(new Dimension(720, 900));
        this.pack();

        iban_receveur_label.setVisible(false);
        iban_receveur_field.setVisible(false);
        envoyerButton.setVisible(false);
        virement_montant_field.setVisible(false);
        virement_montant_label.setVisible(false);
        erreur_virement_solde.setVisible(false);
        afficher_virement_valider.setVisible(false);

        bienvenue.setText("Bienvenue " + Main_Object.nom+", vous êtes actuellement sur une session : Administrateur");
        solde_label.setText("Solde : " + Main_Object.solde);
        iban_label.setText("Iban : " + Main_Object.iban);
        créerUneSessionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main_Object.session_create();
                Main_Object.sauvegarder_acc();
            }
        });
        informationsClientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main_Object.afficher_info();
            }
        });
        validerVirementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main_Object.virement_valide();


            }

        });

        virement_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deco_label.setVisible(false);
                déconnexionButton.setVisible(false);
                iban_receveur_label.setVisible(true);
                iban_receveur_field.setVisible(true);
                envoyerButton.setVisible(true);
                virement_montant_field.setVisible(true);
                virement_montant_label.setVisible(true);

            }
        });

        envoyerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main_Object.iban_receveur = iban_receveur_field.getText();
                Main_Object.sended_money = Integer.parseInt(virement_montant_field.getText());
                if (Main_Object.solde >= Main_Object.sended_money) {
                    erreur_virement_solde.setVisible(false);
                    Main_Object.virement();
                    Main_Object.sauvegarder_vir();
                    Main_Object.sauvegarder_acc();
                    iban_receveur_label.setVisible(false);
                    iban_receveur_field.setVisible(false);
                    envoyerButton.setVisible(false);
                    virement_montant_field.setVisible(false);
                    virement_montant_label.setVisible(false);
                    erreur_virement_solde.setVisible(false);
                    deco_label.setVisible(true);
                    déconnexionButton.setVisible(true);
                    erreur_virement_solde.setText("Virement bien pris un compte !");
                    erreur_virement_solde.setVisible(true);

                }else{
                    erreur_virement_solde.setVisible(true);

                }
            }
        });
        déconnexionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main_Object.isLog = false;
            }
        });
    }
}
