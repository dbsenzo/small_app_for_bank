# small_app_for_bank
Une petite application exclusivement en JAVA.

I - Fonctionnement / Fonctionnalités du programme 
  Ce programme fontionne très simplement, il est dôté d'un GUI (très simple). Il a pour but de "reproduire" une application de banque.
  Il dispose de fonctionnalités qui sont utilisables suivant la permission que le compte dispose.
   1 - Création de compte (admin, banquier, client) // Uniquement pour les administrateurs
   2 - Un système de connexion qui utilise une base de données locales. (pour faciliter l'utilisation un TXT servira de BDD)
   3 - Un système de virement
   4 - Un système de validation des virements // Uniquement pour les banquiers, administrateurs
   5 - Un système pour voir les informations des clients // Uniquement Administrateur
   6 - Un GUI
   
  
  
II - Comment créer des comptes et les utiliser
  Pour créer des comptes cela est simple, il suffit d'utiliser le compte par défaut fourni "Login : Admin | Mot de passe : Admin"
  avec ce dernier vous allez pouvoir créer des comptes qui auront : Identifiant (unique)
                                                                    Mot de passe
                                                                    Solde
                                                                    Permission ( 0 -> Permission client
                                                                                 1 -> Permission banquier
                                                                                 2 -> Permission administrateur )
                                                                    IBAN (unique)
                                                                    
  Juste après la création, les comptes sont accessibles. Ils sont stockés dans un fichier texte qui fait office de base de données.
  Pour utiliser un compte rien de plus simple, il suffit de l'avoir crée au préalable et de se connecter à ce dernier.

III - Virement / Validation des virements
  Les virements sont disponibles pour tous les clients, ils sont facilement réalisables en appuyant sur le bouton "Virement".
  Pour réaliser un virement vous devez vous munir de l'IBAN du compte receveur, et entrer juste en dessous le montant.
  Une fois cela fait, il reste juste à presser le bouton "Envoyer".
  
  /!\ Un virement n'apparaitra qu'une fois validé par un banquier / Administrateur, le solde sera débité une fois le virement validé.
  
  Les validations de virement doivent être effectuées par un banquier / administrateur, ils doivent simplement presser le bouton "Valider virements".
  Une fois cela fait, une demande de validation apparait. Il suffit de répondre "oui" ou "non" et cela autorisera ou non la transaction.
  Une fois les virements non validés effectués, le banquier / administrateur est informé qu'il n'y a aucun virement à valider.
  
IV - Informations des clients
  Seuls les administrateurs ont accès à cette fonctionnalité. Elle permet de voir le Username, Solde, niveau de permission, Iban de tous les clients.
  
V - Modification du programme
  Toutes les modifications du programme sont, bien entendu, autorisées même encouragées.
  
IV - Développeur
    Enzo Desbois 
