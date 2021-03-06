// Ne pas ajouter ni modifier les attributs de cette classe.
// Ne pas exporter la collection passagers.
// Vous pouvez ajouter/modifier des méthodes.
import java.util.ArrayList;
import java.util.Iterator;

public class Etage extends Constantes {

    private int numero; // de l'Etage pour l'usager

    private Immeuble immeuble; // de l'Etage

    private LoiDePoisson poissonFrequenceArrivee; // dans l'Etage

    private ArrayList<Passager> passagers = new ArrayList<Passager>();

    public Etage(int n, int fa, Immeuble im) {
	numero = n;
	immeuble = im;
	int germe = n << 2;
	if (germe <= 0) {
	    germe = -germe + 1;
	}
	poissonFrequenceArrivee = new LoiDePoisson(germe, fa);
    }

    public void affiche() {
		if (numero() >= 0) {
			System.out.print(' ');
		}
		System.out.print(numero());
		if (this == immeuble.cabine.etage) {
			System.out.print(" C ");
			if (immeuble.cabine.porteOuverte) {
			System.out.print("[  ]: ");
			} else {
			System.out.print(" [] : ");
			}
		} else {
			System.out.print("   ");
			System.out.print(" [] : ");
		}
		int i = 0;
		boolean stop = passagers.size() == 0;
		while (!stop) {
			if (i >= passagers.size()) {
			stop = true;
			} else if (i > 6) {
			stop = true;
			System.out.print("...(");
			System.out.print(passagers.size());
			System.out.print(')');
			} else {
			passagers.get(i).affiche();
			i++;
			if (i < passagers.size()) {
				System.out.print(", ");
			}
			}
		}
		System.out.print('\n');
    }

    public int numero() {
		return this.numero;
    }

    public void ajouter(Passager passager) {
		assert passager != null;
		passagers.add(passager);
    }

    public long arriveeSuivant() {
	return poissonFrequenceArrivee.suivant();
    }
    
    public boolean doitStopper(){
    	boolean res = false;
    	int nb = passagers.size();
    	if(nb > 0){
    		res = true;
    	}
    	return res;
    }

    public boolean estVide(){
    	if(this.passagers.isEmpty())
    		return true;
		else
			return false;
	}
    
    public boolean essayerDeFaireRentrer(Passager p){
    	boolean res = false;
    	if(!immeuble.cabine.estPlein()){
    		immeuble.cabine.ajouterPassager(p);
    		immeuble.cabine.etage.passagers.remove(p);
    	}
    	return res;
    }

	public int faireRentrer(){
		//parcourrir passagers appeler méthode essayer... Si vrai, ajouter personne au return compteur sinon personne suivante test
		int res = 0;
		while(res < passagers.size()){
			if(!essayerDeFaireRentrer(passagers.get(res))){
				res++;
			}
		}
		return res;
	}

	public long dateArrPremier(){
		return passagers.get(0).dateDepart();
	}
}
