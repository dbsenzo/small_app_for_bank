import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JPanel login_frame;
    private JTextField user_area;
    private JTextField pass_area;
    private JButton connexionButton;
    private JLabel error_label;
    private JProgressBar progressBar1;
    private JPanel Client_gui;
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


    public MainFrame(){
        this.setContentPane(login_frame);
        this.setVisible(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(450,450);

        progressBar1.setVisible(false);
        error_label.setVisible(false);
        connexionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main_Object.nom = user_area.getText();
                Main_Object.mdp = pass_area.getText();
                user_area.setText("");
                pass_area.setText("");


            }



        });
        // marche pas




    }
    public void valide_connexion(){
        error_label.setVisible(true);


    }
    public void chargement_bar(){
        progressBar1.setVisible(true);
        for(int i = 0; i <100; i++){
            try {
                Thread.sleep(6);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            progressBar1.setValue(i);
        }
        progressBar1.setVisible(false);
    }
    // Faire un nouveau FORM associer à un autre .java puis réaliser l'affichage client / Admin / banquier
}
