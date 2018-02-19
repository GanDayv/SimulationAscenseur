// Vous pouvez ajouter des méthodes ou non.
public class EvenementFermeturePorteCabine extends Evenement {

    // Instant précis où les portes terminent de se fermer.
    
    public EvenementFermeturePorteCabine(long d) {
	super(d);
    }

    public void afficheDetails(Immeuble immeuble) {
	System.out.print("FPC");
    }

    public void traiter(Immeuble immeuble, Echeancier echeancier) {
	Cabine cabine = immeuble.cabine;
	assert cabine.porteOuverte;
	cabine.porteOuverte = false;
	//Ici
	
	immeuble.cabine.calculerStatus();
	
	if(immeuble.cabine.status() == '^'){
		long temps = date+tempsPourBougerLaCabineDUnEtage;
		echeancier.ajouter(new EvenementPassageCabinePalier(temps, immeuble.etage(immeuble.cabine.etage.numero()+1)));
		
	}else{
		notYetImplemented();
	}
	
	//app revif portes fermee, FCP changer status en fonction du premier passager; 
	
	
	//Jusqu'à là
	assert ! cabine.porteOuverte;
    }

    public void setDate(long d){
	this.date = d;
    }

}
