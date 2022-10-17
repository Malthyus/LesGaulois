package personnages;

public class Romain {
	private String nom;
	private int force;
	public Romain(String nom, int force) {
		super();
		assert force>=0;
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<" + texte + ">");
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
		minus.parler("Je vais attaquer");
		minus.recevoirCoup(8);
	}
}


