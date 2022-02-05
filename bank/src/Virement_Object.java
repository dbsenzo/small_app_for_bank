import java.io.Serializable;

public class Virement_Object implements Serializable {
    private String Iban_receveur, Iban_envoyeur;
    private Integer valider,solde;
    public Virement_Object(Integer solde, String Iban_receveur, String Iban_envoyeur, Integer valider){
        this.Iban_envoyeur = Iban_envoyeur;
        this.Iban_receveur = Iban_receveur;
        this.valider = valider;
        this.solde = solde;
    }

    public String getIban_receveur() {
        return Iban_receveur;
    }

    public void setIban_receveur(String iban_receveur) {
        Iban_receveur = iban_receveur;
    }

    public String getIban_envoyeur() {
        return Iban_envoyeur;
    }

    public void setIban_envoyeur(String iban_envoyeur) {
        Iban_envoyeur = iban_envoyeur;
    }

    public Integer getValider() {
        return valider;
    }

    public void setValider(Integer valider) {
        this.valider = valider;
    }

    public Integer getSolde() {
        return solde;
    }

    public void setSolde(Integer solde) {
        this.solde = solde;
    }
}
