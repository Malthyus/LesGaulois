package personnages;

public class Romain {
	private static final int NB_EQUIPEMENT_MAX=2;
	private String nom;
	private int force;
	private Equipement[] equipement;
	private int nbEquipement =0;
	public Romain(String nom, int force) {	
		super();
		assert force>=0;
		this.equipement =new Equipement[NB_EQUIPEMENT_MAX];
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
	
//	public void recevoirCoup(int forceCoup) {
//		int ftemp=force;
//		assert ftemp>=0;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert ftemp>force;
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		
		forceCoup = calculResistanceEquipement(forceCoup);
		
		force -= forceCoup;
		// if (force > 0) {
		// 	parler("Aïe");
		// } else {
		// 	equipementEjecte = ejecterEquipement();
		// 	parler("J'abandonne...");
		// }
		if (force > 0) {
			parler("Aïe");
		}
		else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
	//  post condition la force à diminuer
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if ((equipement[i] != null && equipement[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		if(resistanceEquipement>forceCoup) {
			forceCoup=0;
		}
		else {
			forceCoup -= resistanceEquipement;
		}
		return forceCoup;
	}
		
	public int getForce() {
		return force;
	}
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {	
			if (equipement[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipement[i];
				nbEquipementEjecte++;
				equipement[i] = null;
			}
		}
		return equipementEjecte;
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

