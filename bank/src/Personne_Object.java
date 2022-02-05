import java.io.Serializable;

public class Personne_Object implements Serializable {

    private String nom,prenom,user,mdp,iban;
    private Integer solde,perm;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Integer getSolde() {
        return solde;
    }

    public void setSolde(Integer solde) {
        this.solde = solde;
    }

    public Integer getPerm() {
        return perm;
    }

    public void setPerm(Integer perm) {
        this.perm = perm;
    }

    public Personne_Object(String nom, String mdp, String iban, Integer solde, Integer perm){
        this.nom=nom;
        this.prenom=prenom;
        this.user=user;
        this.mdp=mdp;
        this.iban=iban;
        this.solde=solde;
        this.perm=perm;
    }
}
