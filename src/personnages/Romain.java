package personnages;

public class Romain {
	private static final int NB_EQUIPEMENT_MAX=2;
	private String nom;
	private int force;
	private Equipement[] equipement;
	private int nbEquipement =0;
	public Romain(String nom, int force) {	
		super();
		this.equipement =new Equipement[NB_EQUIPEMENT_MAX];
		this.nom = nom;
		this.force = force;
	}
	public Romain(String nom, int force) {
		super();
		assert force>=0;
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0: {
			this.equipement[0]=equipement;
			nbEquipement+=1;
			System.out.println("Le soldat "+nom+" s'équipe avec un "+equipement);
			break;
		}
		case 1: {
			if(this.equipement[0]!=equipement) {
				this.equipement[1]=equipement;
				nbEquipement+=1;
				System.out.println("Le soldat "+nom+" s'équipe avec un "+equipement);
			}
			else {
				System.out.println("Le soldat "+nom+" possède déjà un "+equipement);
			}
			break;
		}
		case 2: {
			System.out.println("Le soltat "+nom+" est déjà bien protégé");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + nbEquipement);
		}
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<" + texte + ">");
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		int ftemp=force;
		assert ftemp>=0;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert ftemp>force;
	}
	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
		minus.parler("Je vais attaquer");
		minus.recevoirCoup(8);
		System.out.println(Equipement.BOUCLIER);
		System.out.println(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}


