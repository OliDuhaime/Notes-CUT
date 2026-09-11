---
tags:
  - java
  - ets
  - cours
  - INF111
  - programmation-objet
date: 2026
cours: INF111 - Programmation Orientée Objet
session: CUT-01
---

# Cours #1 — Introduction à la programmation orientée objet

> [!info] Contexte
> Cours donné à l'ÉTS. Ce cours pose les bases : mise en place de l'environnement de développement, interface console, et introduction aux concepts fondamentaux de la POO en Java.

## Sommaire
- [[#1. Environnement de développement (IDE)]]
- [[#2. Interface utilisateur console]]
- [[#3. Programmation orientée objet]]
- [[#Questions de révision]]
- [[#Pistes d'approfondissement]]

---

## 1. Environnement de développement (IDE)

Deux choix possibles : **Eclipse** ou **IntelliJ**.

- IntelliJ est généralement considéré comme plus complet/moderne.
- Eclipse est préféré par le prof pour la gestion multi-projets.
- Java 1.8 (JavaSE-1.8) est utilisé dans le cours.
- Notepad++ recommandé comme éditeur de texte simple.

### Définition d'un IDE
Un **IDE** (environnement de développement intégré) connecte des outils et automatise la compilation/l'exécution du code. Il inclut généralement :
- Outils d'analyse et de complétion du code
- Outils d'IA (récent)
- Débuggeur
- Intégration avec Git

> On peut coder sans IDE, mais c'est beaucoup moins pratique.

### Premier programme (Hello World)

```java
public class ProgrammePrincipal {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

}
```

**Séquence Eclipse :**
1. Créer un nouveau projet Java → nommer (ex. `PremierProgramme`) → JavaSE-1.8 → Finish
2. Clic droit sur `src/` → New → Class
3. Nom : `ProgrammePrincipal`, cocher `public static void main(String[] args)`
4. Écrire le code, puis lancer avec la flèche verte (Run)

**Séquence IntelliJ :**
1. File → New Project → Java (installer JDK 1.8 / temurin-1.8 si besoin)
2. Clic droit sur `src` → New → Java Class → `ProgrammePrincipal`
3. Écrire le code, Run → Run…

---

## 2. Interface utilisateur console

Une **interface utilisateur** permet l'échange d'information entre le programme et l'utilisateur.

| Type d'interface | Description |
|---|---|
| **Console** | Communication textuelle via la fenêtre de commande. Utilisée pour les systèmes simples ou l'interaction occasionnelle. |
| **Graphique** | Interaction par éléments visuels. Norme actuelle (vu en fin de session avec Java Swing). |

Les interfaces utilisateur forment une **boucle** : entrée (clavier) → programme → sortie (écran).

### Sortie : `println` / `print` / `printf`

```java
System.out.println("Hello World!"); // affiche + saut de ligne
System.out.print("Hello ");         // affiche sans saut de ligne
System.out.print("World!");
```

- `println` : affiche une `String`, puis un saut de ligne.
- `print` : affiche une `String`, sans saut de ligne.
- On peut concaténer du texte avec des valeurs via `+` :

```java
int age = 25;
System.out.println("Vous avez " + age + " ans");
```

`printf` offre un formatage plus riche (utile pour les `double`), à la manière du C :

```java
double pi = Math.PI;
System.out.printf("%.3f%n", pi);  // 3 décimales
System.out.printf("%.6f%n", pi);  // 6 décimales
System.out.printf("%.10f%n", pi); // 10 décimales
```

> Référence : [printf format cheat sheet](https://alvinalexander.com/programming/printf-format-cheat-sheet/)

### Entrée : `Scanner`

Le `Scanner` interprète les données entrées au clavier (`System.in`).

**Étapes d'utilisation :**
1. Importer la librairie
2. Instancier l'objet (généralement `static`)
3. Utiliser les méthodes de capture

```java
import java.util.Scanner;

public class ProgrammePrincipal {

    static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Quel est votre prénom ? ");
        String prenom = clavier.nextLine();

        System.out.print("Quel est votre nom ? ");
        String nom = clavier.nextLine();

        System.out.print("Quel est votre âge ? ");
        int age = clavier.nextInt();

        System.out.println("Bonjour " + prenom + " " + nom + "!");
        System.out.println("Vous avez " + age + " ans");
    }
}
```

**Méthodes principales :**
- `clavier.nextInt()` → capture un entier
- `clavier.nextDouble()` → capture un double
- `clavier.nextLine()` → capture une chaîne jusqu'au `\n`

> [!warning] À retenir
> - Les appels à `nextX()` sont **bloquants** : l'exécution est suspendue jusqu'à une entrée valide.
> - `clavier` est `static` → l'instance existe pendant toute la durée du programme.
> - `System.out` = flux **sortant** vers la console ; `System.in` = flux **entrant** depuis la console.

---

## 3. Programmation orientée objet (POO)

### Deux styles de programmation
- **Procédurale** (ex. C) : suite d'instructions/fonctions.
- **Orientée objet** (Java) : organisation autour de classes et d'objets. C'est le style dominant, même si Java conserve des éléments procéduraux (méthodes `static`).

### La classe : point de départ de la POO

Une classe :
- possède de la **mémoire** (attributs / variables membres)
- offre des **services** (méthodes publiques)

```java
public class Voiture {
    private String marque;
    private String modele;
    private double poids;

    public Voiture(String marque, String modele, double poids) {
        this.marque = marque;
        this.modele = modele;
        this.poids = poids;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    // autres getters/setters...
}
```

### Instanciation

Une définition de classe est « du code en l'air » : il faut créer une **instance** (l'objet) pour l'utiliser, via le **constructeur**.

```java
Voiture maVoiture = new Voiture("Toyota", "RAV4", 1600.0);
//   ↑ type      ↑ référence      ↑ appel au constructeur (instanciation)
```

`Scanner` et `Random` sont des exemples d'instances **static** utilisées dans le cours.

### Encapsulation

L'encapsulation protège la mémoire des accès externes directs : les variables membres sont `private`.

```java
maVoiture.modele = "RAV4"; // ❌ interdit si "modele" est private
```

Pour accéder aux données, on passe par des **méthodes d'accès** :
- **accesseur** (`get`) → lecture
- **mutateur** (`set`) → écriture

```java
maVoiture.setModele("RAV4");     // ✅
String m = maVoiture.getModele(); // ✅
```

> `public` sur des variables contourne l'encapsulation → mauvaise pratique (sauf pour les constantes).
> `this` référence l'instance courante, utile pour désambiguïser paramètre vs attribut (`this.marque = marque;`).

### Modificateurs de visibilité

| Modifier | Class | Package | Subclasses | World |
|---|---|---|---|---|
| `public` | ✅ | ✅ | ✅ | ✅ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| *(aucun)* | ✅ | ✅ | ❌ | ❌ |
| `private` | ✅ | ❌ | ❌ | ❌ |

### Héritage par extension

Permet de créer une relation **généralisation / spécialisation** entre classes.

```
        Vehicule
       /    |    \
  Voiture Camion  Moto
```

```java
public class Vehicule {
    protected String marque;
    protected String modele;
    protected double poids;

    public Vehicule(String marque, String modele, double poids) {
        this.marque = marque;
        this.modele = modele;
        this.poids = poids;
    }
}

public class Voiture extends Vehicule {
    private int nbPortes;
    private String carburant;

    public Voiture(String marque, String modele, double poids, int nbPortes, String carburant) {
        super(marque, modele, poids); // appelle le constructeur de Vehicule
        this.nbPortes = nbPortes;
        this.carburant = carburant;
    }
}
```

- `extends` indique qu'une classe dérive d'une autre.
- Les attributs/méthodes publics (et `protected`) de la classe de base sont hérités.
- Une classe Java ne peut hériter **que d'une seule** classe (pas d'héritage multiple par extension).

### Héritage par implémentation (interfaces)

Pour contourner la limite d'héritage simple, on utilise des **interfaces** : une classe peut en implémenter plusieurs.

```java
public interface Roulant {
    void demarrer();
}

public interface Bruyant {
    void faireDuBruit();
}

public class Moto implements Roulant, Bruyant {
    public void demarrer() { /* ... */ }
    public void faireDuBruit() { /* ... */ }
}
```

### Overriding (sur-définition)

On peut redéfinir une méthode héritée pour changer son comportement.

```
      <<Abstract>> Animal
      quiEstTu() / faitDuBruit()
      /      |       \
   Chien   Chat     Singe
                       |
                    Ouistiti
```

```java
public abstract class Animal {
    public abstract String quiEstTu();

    public void faitDuBruit() {
        System.out.println("...");
    }
}

public class Chien extends Animal {
    public String quiEstTu() { return "Je suis un chien"; }

    @Override
    public void faitDuBruit() {
        System.out.println("Woof!");
    }
}

public class Ouistiti extends Singe {
    @Override
    public void faitDuBruit() {
        super.faitDuBruit(); // exécute d'abord le bruit du Singe
        System.out.println("Screech!");
    }
}
```

- Une classe **abstraite** (`abstract`) ne peut pas être instanciée directement.
- `super.methode()` permet d'appeler la version héritée d'une méthode.
- Une classe `final` ne peut pas être dérivée.

### Polymorphisme

« Plusieurs formes » — découle de l'héritage. Une référence de type parent peut pointer vers un objet d'une classe dérivée :

```java
Animal monAnimal = new Singe(); // ✅ un Singe EST un Animal
monAnimal.faitDuBruit();        // appelle la version de Singe (overriding)
```

Très utile pour manipuler des collections hétérogènes :

```java
Animal[] zoo = { new Chien(), new Chat(), new Singe() };
for (Animal a : zoo) {
    a.faitDuBruit();
}
```

On peut vérifier le type réel avec `instanceof` :

```java
if (monAnimal instanceof Singe) {
    System.out.println("C'est bien un singe !");
}
```

### Extra : programmation procédurale en Java

Les méthodes `static` (comme `main`, ou les méthodes de `java.lang.Math`) fonctionnent comme des fonctions procédurales classiques (ex. en C).
- Les classes composées uniquement de méthodes `static` n'ont pas besoin d'être instanciées.
- ⚠️ Une méthode `static` **ne peut pas** utiliser directement les variables membres (non-static) d'une instance.

---

## Questions de révision

**IDE**
- À quoi sert le *workspace* ? → Rassembler tous les projets.
- Nom de la fonction définie dans le premier programme ? → `main()`
- Que fait `System.out.println()` ? → Elle affiche du texte dans la console.
- Qu'est-ce qu'un IDE intègre en plus de la compilation/exécution ? → Complétion de code, IA, débuggeur, intégration Git.

**Console**
- `System.out` = flux sortant (console) ; `System.in` = flux entrant (console).
- Étapes du `Scanner` : import → instanciation `static` → utilisation.
- `clavier` static → l'instance existe pendant toute la durée du programme.
- `clavier.nextInt()` → appel **bloquant**, le programme attend une entrée valide.

**POO**
- méthode, encapsulation, `private`/`public`/`protected`, attributs, override, héritage par extension, constructeur, interface, polymorphisme, get/set, objet, classe de base/dérivée, `instanceof`, `static`.

---

## Pistes d'approfondissement

- IA et outils no-code/low-code dans le développement
- Configuration et maintien d'un IDE à l'échelle d'une organisation
- Publication (déploiement) d'un programme
- `printf` comme outil de débogage
- Contourner l'aspect bloquant du `Scanner`
- Validité des entrées utilisateur (ne jamais faire confiance aveuglément)
- Performance de `printf` vs `print`
- Autres types d'interfaces utilisateur (vocale, tactile, API, etc.)
- La classe `Object` en Java (classe racine de toute hiérarchie)
- La POO dans d'autres langages (Python, C++, C#...)

---

## Exemple intégrateur à venir
Point2D / Point3D (classe dérivée) + patron de conception **Factory**.


---
## 🔗 Liens connexes
- [[INF111-Cours02-Variables-ControleFlow]]
- [[INF111-01.pdf]]
