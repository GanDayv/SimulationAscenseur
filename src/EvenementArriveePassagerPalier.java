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
		//Ici
		p.etageDepart().ajouter(p);
		if(immeuble.cabine.status() == '-'){
			if(immeuble.cabine.etage.numero() > etageDeDepart.numero()){
				immeuble.cabine.changerStatus('v');
				long temps = date+tempsPourBougerLaCabineDUnEtage;
				echeancier.ajouter(new EvenementPassageCabinePalier(temps, immeuble.etage(immeuble.cabine.etage.numero()-1)));
					
			}else{
				notYetImplemented();
			}
		}else{
			notYetImplemented();
		}
		
		//ajouter evenement APP
		date += this.etageDeDepart.arriveeSuivant();
		echeancier.ajouter(this);
		//
		
	}

}
