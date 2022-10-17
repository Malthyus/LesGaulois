package personnages;

/**
 * @author Mathis
 *
 */
public enum Equipement {
	BOUCLIER("bouclier"),CASQUE("casque");
	private String nom;

	private Equipement(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return nom;
	}
}
