package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private int nbVillageoisMaximum;
	public Village(String nom, int nbVillageoisMaximum) {
		super();
		this.villageois = new Gaulois[nbVillageoisMaximum];
		this.nom = nom;
		this.nbVillageoisMaximum=nbVillageoisMaximum;
	}
	public String getNom() {
		return nom;
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
	}
	public Gaulois trouverHabitant(int num) {
		return villageois[num];
	}
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+chef.getNom()+" vivent les légendaires gaulois :");
		for(int i=0;i<nbVillageois;i++) {
			System.out.println(villageois[i].getNom());
		}
	}
	public static void main(String[] args) {
		Village village= new Village("Village des Irréductibles",30);
//		Gaulois gaulois = village.trouverHabitant(30);
		// On a une erreur par ce qu'on à donner un numéro qui comme une indice n'appartient pas au tableau
		Chef abraracourcix = new Chef("Abraracourcix",6,village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix",8);
 		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		ça affiche null car villageois[1] n'a pas encore était défini
		Gaulois obelix = new Gaulois("Obélix",25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}
