package personnages;
import java.util.Random;
public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int effetPotion =1;
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		super();
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force de " + effetPotionMin + " à " + effetPotionMax);
	}
	
	public int preparerPotion() {
		Random random= new Random();
		int val = random.nextInt(effetPotionMax-effetPotionMin)+effetPotionMin;
		if (val>7) {
			parler("J'ai préparé une super potion de force");
		} else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement une potion de force");
		}
		return val;
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom()=="Obélix") {
			parler("Non, Obélix !... Tu n'auras pas de potion maguique !");
		} else {
			gaulois.boirePotion(preparerPotion());
		}
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "< " + texte + ">");
	}
	private String prendreParole() {
		return "Le drude" + nom + " : ";
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10);
		panoramix.preparerPotion();
	}
}
