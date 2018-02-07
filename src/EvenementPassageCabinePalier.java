// Vous pouvez ajouter des méthodes ou non.
public class EvenementPassageCabinePalier extends Evenement {

    // Instant précis ou la cabine passe devant un étage.
    
    private Etage etage;

    public EvenementPassageCabinePalier(long d, Etage e) {
        super(d);
        etage = e;
    }

    public void afficheDetails(Immeuble immeuble) {
        System.out.print("PCP ");
        System.out.print(etage.numero());
    }
    
    public void traiter(Immeuble immeuble, Echeancier echeancier) {
        Cabine cabine = immeuble.cabine;
        assert !cabine.porteOuverte;
        assert etage.numero() != cabine.etage.numero();
<<<<<<< HEAD
	    cabine.etage = etage;

	    if(){ //si il y a personne sur le palier

        }
	    notYetImplemented();
	
=======
        cabine.etage = etage;
        //Ici
        if(cabine.etage.getListePerso().size() == 0){
        	
        	if(cabine.status() == 'v'){
        		
        		long temps = date+tempsPourBougerLaCabineDUnEtage;
        		echeancier.ajouter(new EvenementPassageCabinePalier(temps, immeuble.etage(immeuble.cabine.etage.numero()-1)));
        		
        	}else{
        		notYetImplemented();
        	}
        	
        }else{
        	if(true){
        		
        	}
        }
        
>>>>>>> 6a365e6dca7193e2cfb91341deb518c228cfb299
        assert !cabine.porteOuverte;
    }

}
