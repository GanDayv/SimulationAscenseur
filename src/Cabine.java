// Ne pas ajouter ni modifier les attributs de cette classe.
// Ne pas exporter tableauPassager.
// Vous pouvez ajouter/modifier des méthodes.

public class Cabine extends Constantes {
    
    public Etage etage; // actuel
    
    public boolean porteOuverte;
    
    private char status; // '-' ou 'v' ou '^'
    
    private Passager[] tableauPassager;
    
    public Cabine(Etage e) {
		etage = e;
		tableauPassager = new Passager[nombreDePlacesDansLaCabine];
		porteOuverte = false;
		status = '-';
    }
    
    public void afficheLaSituation() {
		System.out.print("Contenu de la cabine: ");
		for (int i = tableauPassager.length - 1; i >= 0 ; i--) {
			Passager p = tableauPassager[i];
			if (p != null) {
				p.affiche();
				System.out.print(' ');
			}
		}
		assert (status == 'v') || (status == '^') || (status == '-');
		System.out.println("\nStatus de la cabine: " + status);
    }
    
    public char status() {
		assert (status == 'v') || (status == '^') || (status == '-');
		return status;
    }
    
    public void changerStatus(char s){
		assert (s == 'v') || (s == '^') || (s == '-');
		status = s;
    }

    private boolean estVide(){
    	boolean vide = true;
    	for(int i = 0; i<this.tableauPassager.length; i++){
    		if(this.tableauPassager[i]!=null)
    			vide = false;
		}
		return vide;
	}

	public boolean estPlein(){
		int compteur = 0;
		boolean res = true;
		while(compteur < nombreDePlacesDansLaCabine && res){
			if(this.tableauPassager[compteur] == null){
				res = false;
			}else{
				compteur++;
			}
		}
		return res;
	}

	/**
	 * Fait sortir les personnes de la cabine
	 * @return le nombre de personnes sorties
	 */
	public int faireSortir(){
    	if(estVide()){
			return 0;
		} else {
    		notYetImplemented();
			return 0;
		}
	}

	public void ajouterPassager(Passager p){
		boolean add = false;
		int i = 0;
		while (!add){
			if(this.tableauPassager[i] == null){
				add = true;
				this.tableauPassager[i] = p;
			} else {
				i++;
			}
		}
	}
	
	private boolean continuerEtages(Immeuble im){

		assert status == '^' || status == 'v';
		
		boolean continuer = false;
		
		if(this.status == 'v'){
			int i = this.etage.numero();
			if(i != im.etageLePlusBas().numero()){
				i--;
				while(i >= im.etageLePlusBas().numero() && !continuer){
					System.out.println(i + " " + continuer);
					if(!im.etage(i).estVide()){
						continuer = true;
						System.out.println(i + " " + continuer + " seks");
					}else{
						i--;
					}
				}
			}
		}else{
			int i = this.etage.numero();
			i++;
			if(i != im.etageLePlusHaut().numero()){
				while(i <= im.etageLePlusHaut().numero() && !continuer){
					if(!im.etage(i).estVide()){
						continuer = true;
					}else{
						i++;
					}
				}
			}
		}
		return continuer;
	}
	
	public void calculerStatus(Immeuble im){
		assert status == '^' || status == 'v';
		
	if(!this.continuerEtages(im)){
		System.out.println("tu rentre");
			if(this.estVide()){
				this.inverserStatus();
			}else{
				boolean continuer = false;
				for(int i = 0; i < this.tableauPassager.length; i++){
					if(this.tableauPassager[i] != null){
						if(this.status == '^'){
							if(this.tableauPassager[i].etageDestination().numero() > this.etage.numero()){
								continuer = true;
							}
						}else{
							
							if(this.tableauPassager[i].etageDestination().numero() < this.etage.numero()){
								continuer = true;
							}
						}
					}
				}
				if(!continuer){
					this.inverserStatus();
				}
			}
		}
	}
	
	public void inverserStatus(){
		if(this.status == 'v'){
			status = '^';
		}else{
			if(this.status == '^'){
				status = 'v';
			}
		}
	}
}
