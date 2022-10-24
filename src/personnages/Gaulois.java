package personnages;
import villagegaulois.Musee;

public class Gaulois {
	private String nom;
	private int force; 
	private int nbTrophees;
    private int effetPotion =1;
    private Equipement[] trophees = new Equipement[100];
	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<" + texte + ">");
	}
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}

	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup(force*effetPotion/3);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] troph = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; troph != null && i < troph.length; i++,nbTrophees++) {
			this.trophees[nbTrophees] = troph[i];
		}
	}

	
	public void boirePotion(int forcePotion) {
		effetPotion=forcePotion;
		parler("Merci Druide, je sens que ma force est " +forcePotion +" fois décuplée");
	}
	public void faireUneDonnation(Musee musee) {
		if(nbTrophees>0) {
			parler("Je donne au musee tout mes trophees :");
			for(int i=0;i<nbTrophees;i++) {
				System.out.println("- "+trophees[i]);
			}
		}
	}
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix",  8);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		asterix.parler("Je vais attaquer.");
		Romain minus = new Romain("Minus",6);
		Druide panoramix = new Druide("Panoramix",5,10);
		asterix.boirePotion(panoramix.preparerPotion());
		asterix.frapper(minus);
		asterix.frapper(minus);
	}
}
