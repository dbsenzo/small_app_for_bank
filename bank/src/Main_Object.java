import java.io.*;
import java.util.*;

public class Main_Object extends MainFrame {
    static ArrayList<Personne_Object> account = new ArrayList<Personne_Object>();
    static ArrayList<Virement_Object> virement = new ArrayList<Virement_Object>();
    static Integer perm=2, solde,sended_money, perm_session;
    static String rep, mdp, nom, iban, iban_receveur;
    static boolean isLog;
    static Scanner sc = new Scanner(System.in);

    // Virement OK, Déconnexion à faire , fenetre à regler
    // Faire menu banquier Valider virement, virement, deconnexion
    // Faire menu admin Valider virement, infos clients, crée session , deconnexion
    // Pour afficher les textes / boucles faire des variables qui stock les lignes de code / String? comment faire ?
    public static void main(String[] args) {


        MainFrame frame = new MainFrame();


        do{
            lire_acc();
            lire_vir();
            // se Login
            frame.setVisible(true);
            login();
            frame.chargement_bar();
            // Check si il est co
            if(isLog){
                frame.setVisible(false);
                switch (perm){
                    case(0):
                        // Client
                        ClientFrame c_frame = new ClientFrame();

                        do {
                            c_frame.setVisible(true);

                        }while(isLog);
                        c_frame.dispose();
                        sauvegarder_vir();


                    case(1):
                        //Banquier
                        BanquierFrame b_frame = new BanquierFrame();
                        do{
                            b_frame.setVisible(true);

                        }while(isLog);
                        b_frame.dispose();
                        sauvegarder_vir();

                    case(2):
                        //admin
                        AdminFrame a_frame = new AdminFrame();
                        do{
                            a_frame.setVisible(true);

                        }while(isLog);
                        a_frame.dispose();
                        sauvegarder_vir();
                }

            }else{
                frame.valide_connexion();
            }
        }
        while (isLog ==false);


        sc.close();
    }

    public static void session_create() {

        if (perm.equals(2)) {
            System.out.println("Identifiant : ");
            String nom = sc.nextLine();

            if (account.isEmpty() == true) {

                System.out.println("Mot de passe : ");
                String mdp = sc.nextLine();
                System.out.println("Permission :");
                Integer perm = sc.nextInt();
                System.out.println("Solde du compte : ");
                Integer solde = sc.nextInt();
                System.out.println("Iban :");
                sc.nextLine();
                String iban = sc.nextLine();
                account.add(new Personne_Object(nom, mdp, iban, solde, perm));

            } else if (containsName(nom) == true) {

                System.out.println("Erreur : Identifiant non unique");

            } else {
                System.out.println("Mot de passe : ");
                String mdp = sc.nextLine();
                System.out.println("Permission ");
                Integer perm = sc.nextInt();
                System.out.println("Solde du compte : ");
                Integer solde = sc.nextInt();
                System.out.println("Iban :");
                sc.nextLine();
                String iban = sc.nextLine();
                account.add(new Personne_Object(nom, mdp, iban, solde, perm));
            }
        } else {
            System.out.println("Permission manquante");
            return;
        }

    }


    public static void login() {
        nom = null; mdp = null;
        if (account.isEmpty() == true) {
            System.out.println("Base de données des sessions vide. Merci de créer au moins une session.");


        } while(nom == null && mdp == null){
            System.out.print("");
            //System.out.println("Connexion Identifiant :");
            //nom = sc.nextLine();
            //System.out.println("Connexion Mot de passe :");
            //mdp = sc.nextLine();

        }
        if (mdpMatch()) {
            System.out.println("Connexion effectué");
            isLog = true;

        } else {
            System.out.println("Mot de passe et Identifiant ne match pas !");
        }


    }
    public static void virement_supp_add_money(){
        if(virement.isEmpty() == false) {
            for (int i = 0; i < account.size(); i++) {
                if (virement.get(virement.size()-1).getIban_envoyeur().equals(account.get(i).getIban())) {
                    account.get(i).setSolde(account.get(i).getSolde() - virement.get(virement.size()-1).getSolde());
                    for (int j = 0; j < account.size(); j++) {
                        if (virement.get(virement.size()-1).getIban_receveur().equals(account.get(j).getIban())) {
                            account.get(j).setSolde(account.get(j).getSolde() + virement.get(virement.size()-1).getSolde());
                            virement.remove(virement.size()-1);
                            System.out.println("Virement bien effectué !");
                            sauvegarder_vir();
                            sauvegarder_acc();
                            break;
                            }

                        }
                    break;
                    }
                }
        }
    }

    public static void virement_refus(){
            if(virement.isEmpty() == false) {
                for (int i = 0; i < account.size(); i++) {
                    if (virement.get(virement.size()-1).getIban_envoyeur().equals(account.get(i).getIban())) {
                    for (int j = 0; j < account.size(); j++) {
                        if (virement.get(virement.size()-1).getIban_receveur().equals(account.get(j).getIban())) {
                            virement.remove(virement.size()-1);
                            System.out.println("Virement à bien été refusé !");
                            sauvegarder_vir();
                            sauvegarder_acc();
                            break;
                        }

                    }
                    break;
                }
            }
        }
    }

    public static boolean iban_exist() {
        for (int i = 0; i < account.size(); i++) {
            if (iban_receveur.equalsIgnoreCase(account.get(i).getIban())) {
                return true;
            }
        }
        return false;
    }

    public static boolean mdpMatch() {
        for (int i = 0; i < account.size(); i++) {
            if (mdp.equals(account.get(i).getMdp())&& nom.equals(account.get(i).getNom())) {
                perm = account.get(i).getPerm();
                solde = account.get(i).getSolde();
                iban = account.get(i).getIban();
                return true;
            }
        }
        return false;
    }

    public static void virement_valide() {
        if (perm >= 1) {
            if (virement.isEmpty() == false) {
                for (int i = 0; i < virement.size(); i++) {

                    System.out.println(virement.get(i).getIban_envoyeur()
                            + " "
                            + virement.get(i).getSolde()
                            + " "
                            + virement.get(i).getIban_receveur()
                            + " "
                            + " Voulez vous autoriser la transaction :");
                    rep = sc.nextLine();
                    if (rep.equalsIgnoreCase("Oui")) {
                        virement_supp_add_money();

                    } else if (rep.equalsIgnoreCase("non")) {
                        virement_refus();
                    }
                }
            }else{
                System.out.println("Aucun virement à valider");
            }
        }else{
            System.out.println("Pas la permission");
        }
    }

    public static void virement() {
        if (isLog) {
            if(iban_receveur !=null && sended_money != null) {
                if (solde > 0) {
                    //System.out.println("Iban du receveur :");
                    //iban_receveur = sc.nextLine();
                    //System.out.println("Montant à envoyer :");
                    //sended_money = sc.nextInt();
                    if (solde - sended_money >= 0 && iban_exist()) {
                        virement.add(new Virement_Object(sended_money, iban_receveur, iban, 0));
                        //System.out.println("Demande de virement bien prise en compte. Elle apparaitra sous peu sur le compte du destinataire");
                    }
                } else {
                    //System.out.println("Vous ne pouvez pas effectuer de virement, votre solde est dans le négatif.");
                }
            }
        }
    }

    public static Object afficher_info() {
        // On affiche les User + Mdp ONLY ADMIN
        if (account.isEmpty() == false) {
            if (perm.equals(2)) {
                for (int i = 0; i < account.size(); i++)
                    System.out.println(account.get(i).getNom() + " " + account.get(i).getSolde() + " " + account.get(i).getIban() + " " + account.get(i).getPerm());
            } else {
                System.out.println("Accès refusé vous n'avez pas la permission.");
                return null;
            }
        } else {
            System.out.println("Base de données vide / Inéxistante.");
        }
        return null;
    }

    public static boolean containsName(String nom) {
        for (int i = 0; i < account.size(); i++) {
            if (nom.equalsIgnoreCase(account.get(i).getNom())) {
                return true;
            }
        }


        return false;
    }

    public static void sauvegarder_acc() {
        try {
            FileOutputStream fileOut = new FileOutputStream("save_id.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(account);
            out.close();
            fileOut.close();
            //System.out.println("\nSerialisation terminée avec succès...\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lire_acc() {
        try {
            FileInputStream fileIn = new FileInputStream("save_id.txt");
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            account = (ArrayList<Personne_Object>) ois.readObject();
            ois.close();
            fileIn.close();

        } catch (FileNotFoundException e) {


        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void sauvegarder_vir() {
        try {
            FileOutputStream fileOut = new FileOutputStream("save_vir.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(virement);
            out.close();
            fileOut.close();
            System.out.println("\nSerialisation terminée avec succès...\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lire_vir() {
        try {
            FileInputStream fileIn = new FileInputStream("save_vir.txt");
            ObjectInputStream ois = new ObjectInputStream(fileIn);
            virement = (ArrayList<Virement_Object>) ois.readObject();
            ois.close();
            fileIn.close();

        } catch (FileNotFoundException e) {


        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

