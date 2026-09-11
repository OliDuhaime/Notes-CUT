Une mémoire d’un bit se construit physiquement avec des **portes logiques NAND**.

Une porte NAND se construit physiquement avec des **transistors**.

Un transistor est un composant électronique qui agit comme **interrupteur** ou amplificateur.

### Hiérarchie
Largeur: espace physique
Hauteur: prix
Plus tu es prés du processeur (haut), plus tu es rapide, car l'électricité prend moins de temps a circuler
![[Memory-Hierarchy.jpg]]

#### Mémoire cache
Voir [[Processeur|TCH016-Processeur-Mémoire cache]] pour plus d'information
- Mémoire **tampon** entre le processeur et les mémoires moins rapides (RAM, SSD, etc.).
- Stockage **temporaire** pour les données les **plus fréquemment utilisées**.
- Qu’est-ce qu’on devrait y stocker?
	1. Principe de **localité temporelle** (infos rapprochées dans le temps --> piger dans les [[Registres|registres]])
	2. Principe de **localité spatiale** (infos près l'une de l'autre surement utilisées ensemble --> importance de bien placer les infos dans la mémoire)
- Analogie du bureau et de la bibliothèque: si tu cherche une info dans une bibliothèque sur un sujet, tu prends un livre de ce sujet et les livres de chaque côté. Si l'info n'est pas dans le livre central, elle est surement dans les livres de côté.

#### Mémoire vive
Voir [[Mémoire vive|TCH016-Mémoire-Vive]] pour plus d'information
- Stockage volatile pour les instructions et les données des programmes tels que le [[Système d'opération|système d’exploitation]] et les **applications**.
- On dit "**random access memory**" ou RAM en référence à la capacité à accéder à n’importe quelle adresse mémoire *sans faire de parcours séquentiel*.
- La "**static random access memory**" ou SRAM fonctionne avec des interrupteurs (ex: mémoire cache).
- La "dynamic random access memory" ou DRAM fonctionne avec des **condensateurs** constamment alimentés et rafraîchis (ex. barrette RAM).
- La *SRAM* est *plus rapide* et *consomme moins d’électricité* que la DRAM, mais elle coûte plus **cher**.

Pour ajouter de la RAM et bien la choisir, il faut regarder dans le manuel de la [[Carte mère|carte mère]]:
1. Le type (SDRAM, RDRAM, DDR SDRAM, DDR2/3/4/5)
2. Le facteur de forme (UDIMM, SODIMM, MicroDIMM)
3. Capacité aximale
4. Fréquences supportées
5. Le nombre de broches
Préférer l'uniformité des capacités et fréquences

#### Mémoire secondaire: SSD + HDD
- Mémoire **non volatile** pour les données qui ne sont pas en cours d’utilisation.
- Le "solid state drive" ou **SSD** est constitué de puces électroniques de type *flash NAND* (ex: clés USB). Il a un nombre d'écriture limité avant de baisser en efficacité
- Le "hard disk drive" ou **HDD** est constitué de disques magnétiques empilés en rotation. La surface des disques doit être absente d'impuretées sinon il peut malfonctionner
- Les deux sont de type RAM, mais le HDD (**100 – 200 Mo/s**) plus lent à cause du déplacement de la tête de lecture et des disques. **Le SSD est de 5 à 35 fois plus rapide** (**500 – 7000 Mo/s**).
- Le SSD est plus *silencieux* puisqu’il n’a pas de composants mobiles.

#### Mémoire morte ou "ROM"
- Mémoires non volatiles qui peuvent être lues, mais pas réécrites.
- Différents types :
	1. "Programmable Read-Only Memory" ou **PROM** qui se programme une seule fois.
	2. "Erasable Programmable Read-Only Memory" ou **EPROM** qui se reprogramme en l'exposant à des rayons UV.
	3. "Electrically Erasable Programmable Read-Only Memory" ou **EEPROM** qui se reprogramme par impulsions électriques.
- Servent à stocker les logiciels suivants :
	1. Le [[Carte mère|BIOS]]
	2. Les **codes de démarrage** ou "bootloader"
	3. Les **micrologiciels** ou "firmwares"
