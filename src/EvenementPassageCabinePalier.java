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
        cabine.etage = etage;
        //Ici
        if(!cabine.etage.doitStopper() && !cabine.veutSarreter()){
        	
        	if(cabine.status() == 'v'){
        		
        		long temps = date+tempsPourBougerLaCabineDUnEtage;
        		echeancier.ajouter(new EvenementPassageCabinePalier(temps, immeuble.etage(immeuble.cabine.etage.numero()-1)));
        		
        	}else{
        		if(cabine.status() == '^'){
        			long temps = date+tempsPourBougerLaCabineDUnEtage;
            		echeancier.ajouter(new EvenementPassageCabinePalier(temps, immeuble.etage(immeuble.cabine.etage.numero()+1)));
        	
        		}
            		
            }
        	
        }else{
        	long temps = date+tempsPourOuvrirOuFermerLesPortes;
        	echeancier.ajouter(new EvenementOuverturePorteCabine(temps));
        }
        
        assert !cabine.porteOuverte;
    }

}
