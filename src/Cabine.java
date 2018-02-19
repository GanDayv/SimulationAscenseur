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
	
	public void calculerStatus(){
		if(!this.estVide()){
			Passager p = null;
			int i = 0;
			while(p == null){
				if(tableauPassager[i] != null){
					p = tableauPassager[i];
				}else{
					i++;
				}
				if(p.etageDestination().numero() > etage.numero()){
					this.changerStatus('^');
				}else{
					if(p.etageDestination().numero() < etage.numero()){
						this.changerStatus('v');
					}else{
						this.changerStatus('-');
					}
				}
			}
		}else{
			notYetImplemented();
		}
	}
}
