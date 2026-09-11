[[INF111-01.pdf]]

Utiliser plan de cours comme checklist pour les examens intra et final
Plagiat: on PEUT parler aux autres équipes mais pas regarder le code ni le copier
On PEUT copier du code trouvé sur un forum, mais y indiquer la source en commentaire

### IA
on peut utiliser chat pour se pratiquer a programmer "donne moi des exercices pour me pratiquer sur ..."

### Notes print
%c, %f, %s
ex %.2f --­> affiche a 2 décimales flottantes

### Les Classes
les attributs sont les propriétés de la classe
```

public class Voiture{
	// attributs
	private String marque;
	
	// constructeur
	public Voiture(String marque){
		this.marque
	}
	
	// getter
	public String getMarque(){
		return marque;
	}
	
	// setter
	public void setMarque(String marque){
		this.marque = marque;
	}
	
	// méthode
	public void afficherDetails(){
		System.out.println("Marque: " + this.marque)
	}
}
```
mot clé this (this.marque) fait référence à l'élément courant


pour utiliser une classe et créer des objets dans main
```
import Voiture.Voiture;

// à mettre dans le main ou une autre fonction
Voiture maVoiture = new Voiture("Toyota");  
maVoiture.setMarque("Honda");
System.out.println("Marque: " + maVoiture.getMarque());
```

### Héritage
- monte vers le haut --­> généralisation
- vers le bas --­> spécialisation
Véhicule = classe de base, voiture/camion/moto = classes dérivées
diagramme UML, flèche intérieur blanch veut dire relation

### Héritage par extension
```
public class Voiture extends Vehicule {  
  
    // Attributs  
    private int nombreDePortes;  
  
    // Contstructeur  
    public Voiture(String marque, int nombreDePortes) {  
        super(marque);  
        this.nombreDePortes = nombreDePortes;   
    }  
  
    // getters  
    public int getNombreDePortes() {  
        return nombreDePortes;  
    }  
  
    // setters  
    public void setNombreDePortes(int nombreDePortes) {  
        this.nombreDePortes = nombreDePortes;  
    }  
}
```

Il est possible d’exécuter la fonction hérité en écrivant super.nomDeLaFonction
### Override
```
// Méthode pour afficher les détails de la voiture  
@Override  
public void afficherDetails() {  
    super.afficherDetails();  
    System.out.println("Nombre de portes: " + this.nombreDePortes + ", Type de carburant: " + this.typeDeCarburant + ", Volume du coffre: " + this.volumeCoffre);  
}
```

### interface
Définir un interface fait en sorte que les classes l'héritant doivent définir les méthodes en utilisant un override.
```
interface Vehicle {
	void startEngine();
	void brake();
}
```
Exemple de classe implémentant cette utilisation
```
class Bicycle implements Vehicle { 
	@Override
	public void startEngine() {
		System.out.println("No engine! Start pedaling.");
	}
	@Override
	public void brake() {
		System.out.println("Squeezing hand brakes.");
	}
}
```

### Polymorphisme
Les tableaux doivent contenir des éléments du même type. Le polymorphisme permet d'avoir plusieurs animaux même s'ils sont différents. On peut voir si c'est une instance d'une classe avec `monAnimal instanceof Singe` qui retourne true/false


**Savoir les concepts-clés de la slide 68 pour l'intra**