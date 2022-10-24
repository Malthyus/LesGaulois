package villagegaulois;
import personnages.Trophee;
import personnages.Gaulois;
import personnages.Equipement;

public class Musee {
	private Trophee[] trophee;
	private int nbTrophee =0;
	public Musee() {
		this.trophee = new Trophee[200];
	}
	public void donnerTrophees(Gaulois gaulois,Equipement equipement) {
		Trophee troph= new Trophee(gaulois,equipement);
		if (nbTrophee<200) {
			trophee[nbTrophee]=troph;
		} else {
			System.out.println("Musee plein");
		}
	}
}