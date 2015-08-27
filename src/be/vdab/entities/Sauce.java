package be.vdab.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author guillaume.vandecasteele
 */
public class Sauce implements Serializable {
private static final long serialVersionUID = 1L;
	private final long nummer;
	private final String naam;
	private final Set<String> ingredienten;
	private String imageName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sauce sauce = (Sauce) o;

        return nummer == sauce.getNummer() && naam == sauce.getNaam();

    }

    @Override
    public int hashCode() {
        return (int) (nummer ^ (nummer >>> 32));
    }

    public Sauce(long nummer, String naam, Set<String> ingredienten) {
		this.nummer = nummer;
		this.naam = naam;

		this.ingredienten = ingredienten;
	}

	public Sauce(long nummer, String naam, String... ingredienten) {
		this.nummer = nummer;
		this.naam = naam;
        this.imageName = naam.toLowerCase();
		this.ingredienten = new HashSet<>(Arrays.asList(ingredienten));
	}

    public String getImageName() {
        return imageName;
    }

	public long getNummer() {
		return nummer;
	}

	public String getNaam() {
		return naam;
	}

	public Iterable<String> getIngredienten() {
		return ingredienten;
	}

	public void addIngredient(String ingredient) {
		ingredienten.add(ingredient);
	}
}
