---
tags:
  - INF111
  - java
  - programmation-objet
  - ets
  - cours
date: 2026
course: INF111 - Programmation Orientée Objet
session: CUT-01
---

# INF111 — Cours #2 : Variables, Contrôle de flow, Normes, Modules utilitaires

## 📑 Plan
1. [[#1. Variables]]
2. [[#2. Contrôle de flow]]
3. [[#3. Normes de programmation]]
4. [[#4. Modules utilitaires]]

---

## 1. Variables

### Relation avec la mémoire
Toute opération faite par un ordinateur implique, d'une façon ou d'une autre, une opération sur la **mémoire** (RAM, cache, registre, disque dur, I/O).

> [!info] Déclaration d'une variable
> Déclarer une variable = donner un **nom** à un espace mémoire + spécifier le **type** de l'information qui y sera stockée.

### Types primitifs en Java

| Type | Description | Valeur par défaut | Taille | Exemple |
|------|-------------|--------------------|--------|---------|
| `boolean` | vrai ou faux | `false` | 1 bit | `true`, `false` |
| `byte` | complément à 2 | `0` | 8 bits | — |
| `char` | caractère unicode | `\u0000` | 16 bits | `'a'`, `'\u0041'` |
| `short` | complément à 2 | `0` | 16 bits | — |
| `int` | complément à 2 | `0` | 32 bits | `-2, -1, 0, 1, 2` |
| `long` | complément à 2 | `0` | 64 bits | `-2L, 0L, 1L` |
| `float` | IEEE 754 point flottant | `0.0` | 32 bits | `1.23e100f`, `3.14F` |
| `double` | IEEE 754 point flottant | `0.0` | 64 bits | `1.23456e300d` |

### Types les plus utilisés
- **boolean** → état logique vrai/faux
- **char** → une lettre unicode (ex: `'a'`, `'z'`, `'1'`)
- **int** → un entier (ex: `-10, 0, 10000`)
- **double** → un nombre réel/décimal (ex: `10.5, -6.33`)

### Étendue (taille mémoire ↔ plage de valeurs)

| Type | Taille | Étendue |
|------|--------|---------|
| `byte` | 8 bits | -128 .. 127 |
| `short` | 16 bits | -32,768 .. 32,767 |
| `int` | 32 bits | -2,147,483,648 .. 2,147,483,647 |
| `long` | 64 bits | -9,223,372,036,854,775,808 .. 9,223,372,036,854,775,807 |
| `float` | 32 bits | ±3.4 × 10³⁸ |
| `double` | 64 bits | ±1.79 × 10³⁰⁸ |

### Déclaration
Voir fichier [ExVariables.java](file:///C:%5CUsers%5Colivi%5Ccode%5CINF111%5CCours2%5Csrc%5CExVariables.java)
```java
<type> nom [= valeur initiale];

int age = 25;
double prix = 19.99;
char lettre = 'a';
boolean estActif = true;
```

### Opérations sur les variables
Voir fichier [ExVariables.java](file:///C:%5CUsers%5Colivi%5Ccode%5CINF111%5CCours2%5Csrc%5CExVariables.java)
```java
var = 5;              // assignation d'une valeur littérale
var += 6;              // équivalent à var = var + 6
var = var2 - var3;     // assignation via une opération sur d'autres variables
```

| Type d'opération | Opérateurs |
|---|---|
| Mathématiques | `+`, `-`, `*`, `/` |
| Comparaison | `<`, `>`, `<=`, `>=`, `==`, `!=` |
| Booléens | `&&` (AND), `\|\|` (OR) |
| Raccourci (±1) | `var++`, `var--` |
| Raccourci (a = a op b) | `var += b`, `var *= b`, etc. |
	La conversion de type (`int -> double`) se fait après l'opération.
### Bloc de code
Tout ce qui se trouve entre une accolade ouvrante `{` et fermante `}`.
```java
{
    // Ici, c'est l'intérieur du bloc de code
}
```
Les blocs s'imbriquent (classe → méthode → boucle/condition...). Il n'est pas rare de voir **4-5 blocs imbriqués**.

### Portée d'une variable
Voir fichier [ExVariables.java](file:///C:%5CUsers%5Colivi%5Ccode%5CINF111%5CCours2%5Csrc%5CExVariables.java)
> [!important]
> Une variable **existe uniquement** pour l'étendue du bloc de code dans lequel elle a été déclarée.

C'est pour cela qu'on met le `Scanner clavier = new Scanner(System.in);` au début d'un bloc de code pour qu'il soit utilisable pour tout ce qui suit cette déclaration.
**NE PAS** tout mettre dans un même bloc pour éviter les conflits d'imports, noms, etc.
### 💡 Exemple en classe
Programme qui demande 2 entiers à l'utilisateur et affiche la somme (stockée d'abord dans une variable intermédiaire) :
```java
import java.util.Scanner;

public class Exemple1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez le premier entier: ");
        int a = sc.nextInt();

        System.out.print("Entrez le deuxième entier: ");
        int b = sc.nextInt();

        int somme = a + b; // variable intermédiaire
        System.out.println("La somme est: " + somme);
    }
}
```

### ❓ Questions de révision
- À quoi sert une variable ? → **Donner un nom à un espace mémoire**
- 4 types les plus utilisés ? → `boolean`, `char`, `int`, `double`
- Relation bloc de code ↔ portée ? → **La variable existe pour toute la durée du bloc de code où elle est définie.**

---

## 2. Contrôle de flow

### Expression / Condition
Une **condition** est un bout de code qui se résout en `true`/`false` (opération booléenne).

Exemples :
```java
(a == 5)               // vrai si a vaut 5
(a <= b)                // vrai si a est plus petit ou égal à b
(a <= b && a >= c)      // combinaison de conditions
```

### Pourquoi le contrôle de flow ?
Sans lui, le code s'exécute toujours de haut en bas, ligne par ligne, sans condition — ce qui limite énormément la flexibilité des programmes.

Trois outils : **IF**, **WHILE**, **FOR**

### IF / ELSE IF / ELSE
```java
if (condition) {
    // exécuté seulement si condition == true
}
```

```java
// IF - ELSE
if (cond1) {
    // exécuté si cond1 est vraie
} else {
    // exécuté si cond1 est fausse
}
```

```java
// IF - ELSE IF - ELSE
if (cond1) {
    // exécuté si cond1 est vraie
} else if (cond2) {
    // exécuté si cond1 est fausse et cond2 est vraie
} else {
    // exécuté si cond1 et cond2 sont fausses
}
```

> [!note] Règles
> - Pas de limite pratique au nombre de `else if`.
> - Un seul `else` possible, et il est **optionnel**.
> - `else` ne peut pas être suivi d'une autre condition.

Conditions combinées avec opérateurs booléens :
```java
((varA < varB) && (varA > varC))
((varA == varB) || (varA == varC))
```

### WHILE (« tant que » / « jusqu'à ce que »)
Répète le bloc de code **tant que** la condition est vraie.
Voir exemple [ExBoucle.java](file:///C:%5CUsers%5Colivi%5Ccode%5CINF111%5CCours2%5Csrc%5CExBoucle.java)
```java
while (cond1) {
    // bloc de code qui se répète
}
```

> [!warning]
> Ne pas confondre `if` (exécution unique conditionnelle) et `while` (répétition conditionnelle) !

### FOR (« pour tous les »)
Cas particulier du `while`, utilisé pour un compte inconditionnel (souvent avec des tableaux).

Équivalence WHILE ↔ FOR :
```java
// WHILE
int compte = 0;
while (compte < LIMITE) {
    // code exécuté
    compte++;
}

// FOR équivalent
for (int compte = 0; compte < LIMITE; compte++) {
    // code exécuté
}
```

Variantes du FOR :
```java
for (int i = 0; i < 10; i++) { }      // compter en montant
for (int i = 10; i > 0; i--) { }      // compter en descendant
for (int i = 0; i < 100; i += 5) { }  // par saut de 5
```

### FOR vs WHILE : comment choisir ?
> [!question] Question clé
> **Le nombre d'itérations est-il connu avant de lancer la boucle ?**
> - Oui → `FOR`
> - Non → `WHILE`

### 💡 Exemple en classe : jeu du nombre caché
```java
import java.util.Random;
import java.util.Scanner;

public class NombreCache {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int nombreCache = rand.nextInt(20) + 1; // entre 1 et 20 inclusivement
        int essai;
        int nbTentatives = 0;

        do {
            System.out.print("Devinez le nombre (1-20): ");
            essai = sc.nextInt();
            nbTentatives++;

            if (essai < nombreCache) {
                System.out.println("Trop petit !");
            } else if (essai > nombreCache) {
                System.out.println("Trop grand !");
            }
        } while (essai != nombreCache);

        System.out.println("Bravo ! Trouvé en " + nbTentatives + " tentatives.");
    }
}
```

### ❓ Questions de révision
- Choix entre `if` et `while` possible ? → **Non**, complètement différents.
- Ces deux blocs sont-ils équivalents ?
  ```java
  if (var == 20) { print("A"); }
  else if (var > 10) { print("B"); }
  ```
  ```java
  if (var == 20) { print("A"); }
  if (var > 10) { print("B"); }
  ```
  → **Non.** Premier cas : seulement `A` s'affiche (si var==20). Second cas : `A` **et** `B` s'affichent.

- `while(i < 20)` équivaut-il à `while(!(i >= 20))` ? → **Oui.**

- WHILE ou FOR ?
  - Mot de passe jusqu'à ce qu'il soit bon → **WHILE**
  - Lancer un dé 1000 fois → **FOR**
  - Mot de passe avec max 3 essais → **WHILE** (avec compteur/condition combinée)
  - Nombre de registres demandé puis rempli un à un → **FOR**

> [!danger] Boucle infinie
> Bug où la condition de sortie n'est jamais atteinte → le programme boucle indéfiniment. Stratégie de débogage : vérifier que la variable de contrôle est bien modifiée dans le bloc, et que la condition peut réellement devenir fausse.

---

## 3. Normes de programmation

Règles de **bienséance** (pas syntaxiques) qui uniformisent le code et améliorent la qualité.

### Nomination
| Élément | Convention | Exemple |
|---|---|---|
| Variables / méthodes | `camelCase` | `montantTotal`, `calculerSomme()` |
| Constantes | `TOUT_EN_MAJUSCULE` avec `_` | `VITESSE_MAX` |
| Classes | `PascalCase` | `ExempleDeNomDeClasse` |

### En-tête de fichier (Javadoc)
```java
/**
* La description de la classe s'écrit ici
*
* @author (le nom de tous les auteurs)
* @version (référence temporelle ex: Hiver 2025)
*/
```

### En-tête de méthode
```java
/**
* La description de la méthode est à écrire ici
*
* @param nom, description
* @param nom, description
* @return description
*/
```

### Commentaires en ligne
- Courts → `//`
- Longs → `/* ... */`
- Toujours **au même niveau d'indentation** que le code commenté.

```java
// Si le mot de passe est valide, notifie le système que
// l'utilisateur a été authentifié, tel que spécifié au
// requis 5.6
if (motDePasseValide(motDePasse)) {
    autoriseAuthentification();
}
```

### Autres normes
- **Indentation** : nombre de tabulations = profondeur du bloc de code.
- **Aération** : ligne vide entre chaque section logique (ne pas supprimer les lignes vides pour "gagner de la place").
- **Code mort** : supprimer le code commenté/inutile avant la remise.

### ❓ Questions de révision
- À quoi servent les normes ? → **Uniformiser le code, réduire les risques d'erreurs.**
- 3 normes à retenir → format des noms (variables/fonctions), indentation/aération, en-têtes + commentaires.

---

## 4. Modules utilitaires

Java offre une immense collection de modules/classes utilitaires pour accélérer le développement.

### Import
```java
import java.util.Random;   // importe une seule classe
import java.util.*;         // importe toutes les classes du package
```
- `java` = path de base du JDK
- `util` = sous-package (contient entre autres `Random`)

### Module `Math`
- Situé dans `java.lang.*` (pas besoin d'import explicite car `java.lang` est importé automatiquement)
- **Statique** → pas besoin d'instancier
- Peut être importé en `import static` → alors plus besoin d'écrire `Math.abs(...)`, juste `abs(...)`

```java
import static java.lang.Math.*;

double racine = Math.sqrt(16);   // = 4.0
double valeurAbsolue = abs(-5);  // avec import static
double puissance = Math.pow(2, 10); // = 1024.0
```
Documentation : https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html

### Module `Random`
- Situé dans `java.util.*`
- **Non statique** → il faut l'instancier

```java
import java.util.Random;

Random rand = new Random();
int monEntier = rand.nextInt(10); // entier aléatoire entre 0 et 9 (10 exclu)
```

| Méthode | Description |
|---|---|
| `nextInt()` | entier aléatoire entre 0 et 2³²-1 |
| `nextInt(int n)` | entier aléatoire entre 0 et n-1 |

Usages typiques : simuler un dé, ajouter de l'aléa dans une simulation, tirer un nombre caché.

Documentation : https://docs.oracle.com/javase/7/docs/api/java/util/Random.html

### Le modulo `%`
Retourne le **reste** d'une division entière.
```java
int restant = 5 % 2; // restant = 1
```

Applications :
```java
// Tester si un nombre est impair
var % 2 == 1 // vrai si var est impair

// Compteur circulaire (0,1,2,3,4,0,1,2,3,4,...)
int var = 0;
for (int i = 0; i < 100; i++) {
    var += 1;
    var %= 5;
    System.out.println(var);
}
```

### ❓ Questions de révision
- Fonctionnement du modulo ? → Retourne le reste de la division entière.
- Valeurs possibles de `var % 5` ? → **0 à 4**
- Nombre aléatoire entre :
  - `[50, 100]` → `rand.nextInt(51) + 50`
  - `[50, 100[` → `rand.nextInt(50) + 50`
- Importer `PriorityQueue` ? → Trouver le path dans la documentation puis :
  ```java
  import java.util.PriorityQueue;
  ```

---

## 🧩 Exercice récapitulatif

> Tirer un nombre aléatoire entre 0 et 100. L'utilisateur doit deviner ce nombre. Le programme boucle **tant que** le nombre entré est différent du nombre tiré. À chaque essai, indiquer si le nombre entré est trop petit ou trop grand.

```java
import java.util.Random;
import java.util.Scanner;

public class Exemple1 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int nombreSecret = rand.nextInt(101); // entre 0 et 100
        int nombreEntre;

        do {
            System.out.print("Entrez un nombre entre 0 et 100: ");
            nombreEntre = sc.nextInt();

            if (nombreEntre < nombreSecret) {
                System.out.println("Trop petit !");
            } else if (nombreEntre > nombreSecret) {
                System.out.println("Trop grand !");
            }
        } while (nombreEntre != nombreSecret);

        System.out.println("Bravo, vous avez trouvé !");
    }
}
```

**Points clés à retenir de cet exemple :**
- Utilisation du module `Random` pour obtenir un nombre aléatoire
- Utilisation d'une boucle pour répéter une opération jusqu'à obtention du résultat voulu
- Utilisation du `if` pour choisir le message à afficher

---

## 🔗 Liens connexes
- [[INF111-Cours01-IntroPOO]]
- [[INF111-02.pdf]]
