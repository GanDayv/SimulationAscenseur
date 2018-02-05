// Vous pouvez ajouter des méthodes ou non.

public class EvenementArriveePassagerPalier extends Evenement {

    // Instant précis où un nouveau passager arrive sur un palier.
    
    private Etage etageDeDepart;

    public EvenementArriveePassagerPalier(long d, Etage edd) {
	super(d);
	etageDeDepart = edd;
    }

    public void afficheDetails(Immeuble immeuble) {
	System.out.print("APP ");
	System.out.print(etageDeDepart.numero());
    }

    public void traiter(Immeuble immeuble, Echeancier echeancier) {
		assert etageDeDepart != null;
		assert immeuble.etage(etageDeDepart.numero()) == etageDeDepart;
		Passager p = new Passager (date, etageDeDepart, immeuble);
		/*
		Code
		 */

		//ajout du passager à l'étage
		p.etageDepart().ajouter(p);

		if(immeuble.cabine.status() == '-'){
			if(p.etageDepart().numero() < immeuble.cabine.etage.numero()){
				immeuble.cabine.changerStatus('v');
				long temp = date+tempsPourBougerLaCabineDUnEtage;
				echeancier.ajouter(new EvenementPassageCabinePalier(temp, immeuble.etage(immeuble.cabine.etage.numero()-1)));
			} else {
				/*
				if(p.etageDepart().numero() > immeuble.cabine.etage.numero()){
					immeuble.cabine.changerStatus('^');
				} else {
					immeuble.cabine.porteOuverte = true;
				}
				*/
				notYetImplemented();
			}
		} else {
			notYetImplemented();
		}
    }
    
}
