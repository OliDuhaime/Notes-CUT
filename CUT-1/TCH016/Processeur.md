Voir [[Unité centrale de traitement| TCH017-UCT]] pour plus d'information
Aussi appelé *microprocesseur* ou *CPU*:
- Puce intégré à la carte mère, responsable de la récupération, du décodage et de l’exécution des instructions.
- Effectue également des calculs mathématiques et logiques. 
- Sa vitesse est en partie déterminée par sa fréquence exprimée en Gigahertz (GHz).
- Sa fréquence caractérise le nombre d’opérations qu’il peut effectuer en une seconde. En général, plus le CPU a de Hz, plus il est rapide

### Caractéristiques d'un processeur
- **Puissance** : quantité d’énergie qu’il consomme (en Watts). 
- **Nombre de cœurs** : les cœurs permettent d’effectuer plusieurs tâches simultanément.
- **Threads** : chaque cœur a un nombre de threads.
- **Fréquence** de l’horloge : vitesse du processeur. Mesuré en Ghz; Le plus souvent on utilise le MIPS (Millions d’Instruction Par Seconde) qui dépend de l’ensemble des composants qui constitue l’environnement du processeur (RAM, vitesse du BUS, fréquence de l’horloge, etc.).

**Mémoire cache** : Voir [[Mémoire|TCH017-Mémoire-Cache]] pour plus d'informations
- Chaque processeur intègre une quantité variable de mémoire cache.
- Très rapide et permet de stocker les données les plus fréquemment demandées par le processeur.
- 3 niveaux de cache :
	- *Cache L1* (cache niveau 1) : la quantité intégrée est généralement faible (de 8 à 64 Ko).
	- *Cache L2* (cache niveau 2) : cette quantité varie de 128 Ko à 1 Mo, légèrement moins rapide que le cache L1.
	- *Cache L3* (cache niveau 3) : disponible sur certains processeurs, peut permettre de gagner 10% de performances supplémentaires. Plus lent que le cache L2 mais, en contrepartie dispose d’une taille bien plus grande (12 Mo est une valeur courante).

**Registres** : Voir [[Registres|TCH017-Registres]] pour plus d'information
- Petite mémoire de taille raisonnable (variant généralement de 32 à 128 bits).
- Une instruction peut faire appel aux registres. Ce type d’opérations est beaucoup plus rapide que de faire appel à la mémoire vive, les registres étant internes au processeur, contrairement à la mémoire vive.
- Il existe différents types de registres, voici les principaux :
	- *Registre d’instruction* (RI) : stocker l’instruction qui va être exécutée.
	- *Registre d’état* : stocker des indicateurs sur l’état du système après l’exécution d’une instruction. 
			Exemple : C (pour carry) : vaudra 1 si une retenue est présente.
	- *Registre PC* (Program counter) : stocker l’adresse de la prochaine instruction à exécuter.

**Core** : 
- Le core d’un processeur est toute sa partie centrale contenant les *unités de calcul*, les *registres* et la mémoire *cache*.
- Un processeur avec un seul coeur ne peut traiter qu’une seule instruction à la fois.
- Plusieurs instructions peuvent être traitées par le cœur d’un processeur mais ce sera toujours en série, c’est-à-dire une instruction à la fois.
- Un processeur multicœur est composé de deux ou plusieurs cœurs indépendants.

**Architecture X bits** :
- Processeurs sont souvent différenciés selon leur architecture 16, 32 ou 64 bits.
- *Registre* = mots mémoire internes au processeur. 
- Bus internes même taille que les registres. Définit la taille maximale de mémoire adressable par le processeur :
	- 32 bits : 232 octets = 4 Go de mémoire.
	- 64 bits : 264 octets = 18 Millions de To de mémoire (en théorie seulement). Peut gérer plus d'instructons en une seule charge

**Augmentation des performances**:
- **Hyper-Threading** : Permet d’émuler deux processeurs logiques sur une seule puce. Un cœur va pouvoir exécuter *deux threads à la fois au lieu d’un seul*. Par exemple, un Core i3, qui a seulement deux cœurs peut exécuter deux threads par coeur (au lieu d’un seul normalement) s’il possède l’HyperThreading, soit un total de quatre threads.
- L'optimisation d'Intel est apparue avec ses processeurs Pentium 4. Le système d’exploitation pense qu'il dispose de plus de processeurs qu'il n'en a réellement, ce qui surcharge le processeur avec plusieurs instructions.
- Processeurs **multicœurs** : exécution simultanée de plusieurs processus ou de plusieurs threads.
- Plusieurs processeurs, on dira plusieurs cœurs dans le même boîtier. Cette technique convient particulièrement au multitâche puisqu’il y a réellement autant de tâches qui peuvent s’exécuter en parallèle que de cœurs dans le processeur.Les applications pour bénéficier pleinement du multicœur doivent avoir été repensées pour pouvoir se subdiviser en tâches parallèles.