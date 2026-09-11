---
tags: [TCH016, systeme-exploitation, processus, memoire, fichiers, ets, cours]
date: 2026
course: TCH016 - Système d'exploitation et services Internet
session: Cours #2 - Session
---

# TCH016 — Cours #2 : Système d'exploitation, Gestion des processus, Gestion de la mémoire, Système de fichiers

## 📑 Plan
1. [[#1. Système d'exploitation]]
2. [[#2. Gestion des processus]]
3. [[#3. Gestion de la mémoire]]
4. [[#4. Système de fichiers]]

---

## 1. Système d'exploitation

### Principe de base d'un ordinateur

> [!info] Composants de base d'un système informatique
> - **Entrée** : récupération et codage de l'information. Donne les informations au *UCT*
> - **Unité de traitement** : traitement des informations. Commnunique avec les mémoires et donne un résultat à la sortie 
> - **Mémoire** : stockage de l'information
> - **Sortie** : fourniture et décodage de l'information

Un système informatique moderne comprend un ou plusieurs processeurs, de la mémoire principale, des disques, des périphériques d'E/S, etc. Une couche logicielle intermédiaire — le **système d'exploitation (SE)** — est nécessaire pour gérer tous ces composants.

### Architecture en couches

| Couche                 | Rôle                                                               |
| ---------------------- | ------------------------------------------------------------------ |
| Utilisateurs           | Interagissent avec l'ordinateur                                    |
| Applications           | Logiciels utilisés par l'utilisateur (jeux, navigateurs, BD, etc.) |
| Système d'exploitation | Interface entre applications/utilisateurs et le matériel           |
| Matériel               | CPU, RAM, périphériques E/S                                        |

> [!note] Deux catégories de logiciels
> - **Logiciels de système** : anti-virus, compilateurs, etc.
> - **Logiciels d'application** : bases de données, jeux, navigateurs, etc.

### Le noyau (Kernel)

> [!important] Le noyau est la partie centrale du SE
> Il assure :
> - la communication entre logiciels et matériel
> - la gestion des tâches (démarrage, ordonnancement)
> - la gestion du matériel (mémoire, processeur, périphériques, stockage)

La plupart des SE sont construits autour de la notion de noyau : un programme unique responsable de la communication entre matériel et logiciel.

### Mode utilisateur vs mode noyau

| Aspect               | Mode utilisateur                     | Mode noyau                                     |
| -------------------- | ------------------------------------ | ---------------------------------------------- |
| Accès matériel       | Limité (mode restreint/esclave)      | Complet (fonctions de confiance de bas niveau) |
| Espace d'adressage   | Propre à chaque processus            | Espace du noyau                                |
| Panne d'un processus | N'affecte pas le SE                  | —                                              |
| Accès aux ressources | Via requête au noyau (appel système) | Direct                                         |

> [!note] Basculement de mode
> Lorsqu'un processus en mode utilisateur nécessite une ressource matérielle (RAM, imprimante, etc.), il envoie une requête au noyau via un **appel système (syscall)**. Le processeur passe alors du mode utilisateur au mode noyau, exécute l'appel, puis repasse en mode utilisateur.

> [!question] Pourquoi séparer mode utilisateur et mode noyau ?
> Pour isoler les processus les uns des autres et protéger le SE : l'échec d'un processus en mode utilisateur n'affecte pas le système, car il n'a pas d'accès direct au matériel ni à l'espace d'adressage du noyau.

### Fonctionnalités d'un système d'exploitation

Parmi les fonctionnalités importantes :

1. Gestion de la mémoire
2. Gestion du processeur
3. Gestion des périphériques
4. Gestion des fichiers
5. Gestion des réseaux
6. Contrôle de la performance du système
7. Détection des erreurs
8. Coordination des applications
9. La sécurité

### Interfaces utilisateur

| Type d'interface               | Description                              | Exemples                                                       |
| ------------------------------ | ---------------------------------------- | -------------------------------------------------------------- |
| CLI (Command Line Interface)   | Interpréteur de commande via un terminal | **sh**, **bash** (Linux), **MS-DOS**, **PowerShell** (Windows) |
| GUI (Graphical User Interface) | Interface graphique                      | Windows 11 (Microsoft), GNOME (Linux)                          |

L'interpréteur de commande constitue l'interface principale entre l'utilisateur et le SE. Le GUI peut être utilisé en complément.

### Sécurité du système d'exploitation

> [!warning] Une vulnérabilité dans le SE peut compromettre la sécurité de l'application
> Sécuriser le SE permet de stabiliser l'environnement et de contrôler l'accès aux ressources et à l'environnement externe.

Aspects de sécurité à considérer :

1. Comptes utilisateur
2. Système de fichiers
3. Services réseau
4. Correctifs système
5. Minimisation du SE (installer uniquement le nécessaire)
6. Intégrité du système

### Classes de systèmes d'exploitation

> [!info] Mono-usager vs multi-usager
> La différence principale réside dans la capacité à gérer plusieurs utilisateurs simultanément.

| Classe | Exemples |
|---|---|
| Mono-usager | MS-DOS, premières versions de MacOS, Windows 95 |
| Multi-usager | UNIX, Linux, Android 4.3, Windows récents (NT, 2000, XP, Vista, 7, 8, 10, 11), macOS, mainframes |

### ❓ Questions de révision

- Quels sont les 4 composants de base d'un système informatique ? → **Entrée, unité de traitement, mémoire, sortie.**
- Quel est le rôle du noyau (kernel) d'un système d'exploitation ? → **Assurer la communication entre logiciels et matériel, gérer les tâches et gérer le matériel.**
- Est-ce que le mode utilisateur et le mode noyau offrent le même niveau d'accès au matériel ? → **Non, le mode noyau a un accès complet alors que le mode utilisateur est restreint et doit passer par des appels système (syscalls).**
- Que se passe-t-il lorsqu'un processus en mode utilisateur a besoin d'une ressource matérielle ? → **Il envoie une requête au noyau via un appel système, ce qui fait basculer le processeur en mode noyau.**
- Un système multi-usager peut-il gérer plusieurs utilisateurs simultanément, contrairement à un système mono-usager ? → **Oui, c'est exactement la différence : le multi-usager (ex. Linux, Windows récents) gère plusieurs utilisateurs à la fois, contrairement au mono-usager (ex. MS-DOS).**

---

## 2. Gestion des processus

### Notion de processus

> [!info] Définition
> Un **processus** est un programme en cours d'exécution (à l'état actif).

Chaque processus possède un **PCB (Process Control Block)** qui inclut :
- un espace d'adressage (programme exécutable, données, pile)
- un ensemble de registres (compteurs, pointeur de pile)
- d'autres informations : statut, priorité, entrées-sorties, etc.

> [!note] Contenu détaillé du PCB
> - L'état du processus
> - Compteur d'instructions (adresse de la prochaine instruction à exécuter)
> - Informations sur le scheduling CPU (priorité)
> - Informations sur la gestion de la mémoire (registres, tables de pages)
> - Informations sur l'état des E/S (périphériques alloués, fichiers ouverts)

> [!important] Un seul processus est exécuté à la fois sur un processeur (cœur)
> Le processeur commute constamment entre les différents processus. Une des tâches du SE est d'allouer à chacun les ressources nécessaires (mémoire, E/S, temps CPU) tout en évitant que les processus se gênent entre eux.

### États d'un processus

| État | Description |
|---|---|
| Nouveau | Le processus est en cours de création |
| Prêt | En attente du processeur |
| Exécution | En cours d'exécution |
| Bloqué | En attente d'un événement (ex. E/S) |
| Fin | Le processus a terminé son exécution |

> [!note] Transitions
> Chaque transition correspond à un changement d'état (ex. Admis, Élu, Interruption, Fin d'E/S, En attente d'E/S, Terminé). Ces changements peuvent survenir dans différents cas (attente CPU, attente E/S, fin d'exécution, etc.).

### Changement de contexte

Lorsqu'une interruption ou un appel système survient, le SE :
1. Sauvegarde l'état du processus courant dans son PCB
2. Recharge l'état du prochain processus depuis son PCB
![[Pasted image 20260911105646.png|499]]

> [!warning] Le changement de contexte est un coût
> Pendant ce mécanisme, aucun des deux processus n'avance réellement (période "idle" pour chacun d'eux le temps de la sauvegarde/restauration).

### Création d'un processus

> [!info] Évènements conduisant à la création
> Requête utilisateur, démarrage du système, création par un processus déjà en cours, etc.

| Mode d'exécution | Description | Exemple de SE |
|---|---|---|
| Séquentielle | Le processus père est suspendu jusqu'à la fin du fils | MS-DOS |
| Asynchrone | Le père continue de s'exécuter en concurrence avec ses fils | Unix |

### Hiérarchisation des processus

- Lorsqu'un processus en crée un autre, le père et l'enfant restent associés.
- L'enfant peut lui-même créer d'autres processus, formant une **hiérarchie**.
- Un processus et l'ensemble de ses descendants forment un **groupe de processus**.

### Communication et ordonnancement

> [!important] Coopération vs compétition
> - Certains processus doivent **coopérer** : communication et synchronisation nécessaires pour gérer l'accès concurrent aux ressources.
> - D'autres processus entrent en **compétition** pour les ressources, ce qui peut entraîner des incohérences ou des interblocages.

**Solution** : l'**ordonnancement (scheduling)**. L'**ordonnanceur** est le composant du noyau qui choisit l'ordre d'exécution des processus sur les processeurs.

> [!note] Multiprogrammation
> Un processeur (cœur) ne peut exécuter qu'une seule instruction à la fois, mais il peut basculer constamment d'un processus à l'autre pour donner l'illusion d'exécution simultanée : c'est la **multiprogrammation**.
> ![[Pasted image 20260911105506.png]]

### Critères d'un algorithme d'ordonnancement

- L'équité
- L'efficacité
- La minimisation du temps de réponse pour les utilisateurs
- La minimisation du temps d'exécution (traitement par lots)
- Le rendement (nombre de travaux réalisés par unité de temps)

### Algorithmes d'ordonnancement

| Algorithme | Principe |
|---|---|
| **FCFS** (First-Come, First-Served) | Les processus sont exécutés dans l'ordre de leur arrivée |
| **SJF** (Shortest Job First) | Le processus avec le temps d'exécution le plus court est exécuté en premier (non préemptif) |
| **Round Robin (RR)** | Chaque processus reçoit un quantum de temps fixe avant que le CPU passe au suivant dans la file |

> [!warning] Piège fréquent
> Ne pas confondre le **temps d'attente pour être élu** (temps entre l'arrivée du processus et son premier passage sur le CPU) avec le **temps d'attente total** (turnaround time − temps d'exécution), qui inclut aussi les attentes entre plusieurs tranches d'exécution (cas du Round Robin).

### 💡 Exemple en classe — Exercice 1 (quantum = 2 s)

| Processus | Arrivée (s) | Exécution (s) |
|---|---|---|
| P1 | 0 | 4 |
| P2 | 1 | 3 |
| P3 | 2 | 1 |
| P4 | 3 | 2 |

**FCFS** — ordre d'arrivée :
```
P1 : 0 → 4
P2 : 4 → 7
P3 : 7 → 8
P4 : 8 → 10
```
Temps d'attente de P3 pour être élu = début (7) − arrivée (2) = **5 s**

**SJF (non préemptif)** :
```
t=0 : seul P1 est arrivé → P1 s'exécute (0→4)
t=4 : disponibles P2(3), P3(1), P4(2) → le plus court est P3 → P3 (4→5)
t=5 : disponibles P2(3), P4(2) → le plus court est P4 → P4 (5→7)
t=7 : P2 (7→10)
```
Temps d'attente de P4 pour être élu = début (5) − arrivée (3) = **2 s**

**Round Robin (quantum = 2 s)** :
```
t=0-2 : P1 (reste 2)      | files après: P2, P3, P1
t=2-4 : P2 (reste 1)      | files après: P3, P1, P4
t=4-5 : P3 (fin)          | files après: P1, P4, P2
t=5-7 : P1 (fin)          | files après: P4, P2
t=7-9 : P4 (fin)
t=9-10: P2 (fin)
```
Temps d'attente de P4 pour être élu = début (7) − arrivée (3) = **4 s**

> [!note] Hypothèse
> Ces déroulements supposent une absence d'interruption externe et l'ajout des processus nouvellement arrivés en fin de file, avant la remise en file du processus dont le quantum vient d'expirer.

### 💡 Exemple en classe — Exercice 2 (quantum = 3 s)

| Processus | Arrivée (s) | Exécution (s) |
|---|---|---|
| P1 | 0 | 6 |
| P2 | 2 | 8 |
| P3 | 4 | 7 |
| P4 | 5 | 3 |

**FCFS** :
```
P1 : 0 → 6
P2 : 6 → 14
P3 : 14 → 21
P4 : 21 → 24
```
Temps d'attente de P3 pour être élu = début (14) − arrivée (4) = **10 s**

**SJF (non préemptif)** :
```
t=0 : seul P1 arrivé → P1 (0→6)
t=6 : disponibles P2(8), P3(7), P4(3) → le plus court est P4 → P4 (6→9)
t=9 : disponibles P2(8), P3(7) → le plus court est P3 → P3 (9→16)
t=16 : P2 (16→24)
```
Temps d'attente de P3 pour être élu = début (9) − arrivée (4) = **5 s**

**Round Robin (quantum = 3 s)** :
```
t=0-3  : P1 (reste 3)
t=3-6  : P2 (reste 5)
t=6-9  : P1 (fin)
t=9-12 : P3 (reste 4)
t=12-15: P4 (fin)
t=15-18: P2 (reste 2)
t=18-21: P3 (fin)
t=21-23: P2 (fin)
t=23-24: P3... 
```
> [!note] Signalement
> Le PDF source ne précise pas l'ordre exact de mise en file lorsque plusieurs processus arrivent pendant qu'un autre s'exécute (ex. P3 et P4 arrivant tous deux pendant la tranche de P2). Le déroulement ci-dessus applique la convention « ajout à l'arrivée, avant remise en file du processus interrompu ». Avec cette convention, le temps d'attente de P4 pour être élu = début (12) − arrivée (5) = **7 s**.

### ❓ Questions de révision

- Qu'est-ce qu'un PCB et à quoi sert-il ? → **Le Process Control Block est la structure qui stocke l'état, le compteur d'instructions, les informations de scheduling, de mémoire et d'E/S d'un processus.**
- Combien de processus peuvent s'exécuter simultanément sur un seul cœur de processeur ? → **Un seul à la fois ; le processeur bascule entre les processus (multiprogrammation).**
- Quelle est la différence entre exécution séquentielle et asynchrone lors de la création d'un processus ? → **En séquentielle, le père attend la fin du fils (ex. MS-DOS) ; en asynchrone, le père continue en concurrence avec son fils (ex. Unix).**
- Dans quel cas privilégier FCFS plutôt que SJF ? → **FCFS est simple et équitable dans l'ordre d'arrivée, mais peut pénaliser un petit processus arrivé après un gros ; SJF minimise le temps d'attente moyen mais nécessite de connaître le temps d'exécution à l'avance.**
- Est-ce que le Round Robin garantit un temps d'attente plus court que FCFS pour tous les processus ? → **Non, cela dépend des quantums et des temps d'arrivée/exécution : RR favorise la réactivité (temps de réponse) mais pas nécessairement le temps d'attente total de chaque processus.**

---

## 3. Gestion de la mémoire

### Rôle du gestionnaire de mémoire

> [!info] Fonctions principales
> - Hiérarchisation de la mémoire (cache, RAM, disque dur)
> - Coordination de l'utilisation des différentes mémoires
> - Conserver la trace de la mémoire utilisée ou libre
> - Allouer la mémoire aux processus qui en ont besoin
> - Gérer le va-et-vient (swapping) entre mémoire principale et disque

### Allocation de la mémoire aux processus

- Répertorier les emplacements libres de la mémoire
- Allouer la mémoire nécessaire aux nouveaux processus
- Récupérer la mémoire des processus qui s'achèvent

> [!note] Réallocation dynamique
> La récupération de mémoire peut nécessiter une réallocation des processus en cours pour optimiser son emploi. La zone mémoire attribuée à un processus peut donc changer au cours de son exécution.

### Protection mémoire

> [!important] Isolation des espaces d'adressage
> Il faut s'assurer que les adresses générées par chaque processus ne concernent que la zone mémoire qui lui est impartie, sans quoi l'intégrité du SE et des autres processus n'est pas garantie.

> [!note] Exception : partage volontaire
> Certaines zones mémoire doivent pourtant servir simultanément à plusieurs processus : le code de fonctions partagées entre plusieurs applications, ou des données utilisées simultanément par divers processus.

### Mémoire virtuelle

> [!info] Définition
> Le gestionnaire de mémoire offre aux applications une mémoire de taille **supérieure** à celle de la mémoire physique disponible.

La taille du programme, des données et de la pile peut dépasser la capacité de mémoire disponible. Le SE conserve dans la mémoire principale seulement les parties de programme en cours d'utilisation, et laisse le reste sur le disque (mémoire auxiliaire, plus vaste mais plus lente et non directement accessible au processeur).

### Mécanisme de va-et-vient (swapping)

| Opération    | Description                                                                                                                         |
| ------------ | ----------------------------------------------------------------------------------------------------------------------------------- |
| **Swap-out** | Lorsque le SE manque de RAM, il transfère des processus complets de la RAM vers le disque pour libérer de la mémoire                |
| **Swap-in**  | Lorsqu'un processus précédemment transféré sur le disque est requis à nouveau, le SE le ramène de la mémoire secondaire vers la RAM |

> [!question] Mémoire virtuelle et swapping sont-ils la même chose ?
> Non : la **mémoire virtuelle** est le concept qui permet à un processus de « voir » plus de mémoire qu'il n'y en a physiquement ; le **swapping** est le mécanisme concret (swap-in/swap-out) qui déplace les données entre RAM et disque pour réaliser ce concept.
> ![[Pasted image 20260911114045.png]]
> 

### ❓ Questions de révision

- Quelles sont les trois grandes responsabilités du gestionnaire de mémoire ? → **Conserver la trace de la mémoire libre/utilisée, allouer la mémoire aux processus, et gérer le swapping entre RAM et disque.**
- Pourquoi la protection mémoire est-elle essentielle ? → **Pour empêcher qu'un processus accède à la zone mémoire d'un autre processus ou du SE, ce qui garantit l'intégrité du système.**
- Qu'est-ce que la mémoire virtuelle permet de faire ? → **Offrir aux applications un espace d'adressage plus grand que la mémoire physique réellement disponible, en utilisant le disque comme extension.**
- Quelle est la différence entre swap-in et swap-out ? → **Le swap-out déplace un processus de la RAM vers le disque pour libérer de la mémoire ; le swap-in fait l'inverse lorsque le processus est requis à nouveau.**

---

## 4. Système de fichiers

### Objectifs du système de fichiers

> [!info] Contraintes que le SE doit satisfaire
> - Pouvoir enregistrer l'information
> - Pouvoir conserver les informations après la fin du processus qui les utilise
> - Permettre l'accès simultané à l'information pour deux processus différents

La partie du SE qui gère les fichiers est appelée **système de fichiers (file system)**.

> [!note] Abstraction
> Le système de fichiers est un mécanisme d'abstraction : l'utilisateur n'a pas à se soucier de l'emplacement ni de la manière dont les informations sont physiquement stockées sur le disque.

### Typage des fichiers

| Typage | Description | Exemple de SE |
|---|---|---|
| Fort | Le type est défini par l'extension du fichier | Windows |
| Déduit | L'extension n'est qu'indicative ; le système inspecte le contenu pour déterminer la nature du fichier | Linux |

### Répertoires et chemins d'accès

Les répertoires (dossiers) permettent le regroupement logique des fichiers dans un système hiérarchique.

| Type de chemin | Description |
|---|---|
| Absolu | Depuis la racine du système de fichiers |
| Relatif | Depuis le répertoire courant |

### Fonctionnalités clés d'un système de fichiers

- Nommage
- Protection
- Persistance
- Accès rapide

> [!note] Organisation physique
> Les données sont coupées en petits morceaux sur le disque ; le système tient à jour un index des fichiers, leur emplacement, les autorisations d'accès, leurs attributs, etc.

### Fichiers : nommage et types

> [!info] Nommage
> Un fichier = une suite d'octets. Le nom est généralement composé de deux parties séparées par un point ; la partie après le point est l'**extension** (ex. `prog.c`, `fichier.doc`, `archive.pdf`).

> [!warning] Sensibilité à la casse
> Les SE de la famille UNIX/Linux respectent la casse pour les noms de fichiers ; Windows ne la respecte pas.

| Type de fichier | Description |
|---|---|
| Ordinaire | Informations des utilisateurs (ASCII ou binaire) |
| Répertoire | Mémorise la structure du système |
| Spécial | Représente des périphériques E/S comme s'ils étaient des fichiers (typiquement Unix/Linux) |

### Formatage et structure arborescente

> [!important] Formatage
> Le **formatage** d'un support de données prépare celui-ci à stocker des données en définissant une structure comprise par le SE. Le système de fichiers **est** cette structure qui organise le stockage et la récupération des fichiers/répertoires.

Tous les systèmes de fichiers utilisent une structure arborescente débutant par le **répertoire racine**, d'où se ramifient les dossiers et sous-dossiers.

> [!danger] Incompatibilité entre systèmes de fichiers
> Les SF ne sont généralement pas compatibles entre eux. Exemple : un disque dur formaté en APFS (Apple, depuis 2017) ne fonctionnera pas nativement sur un ordinateur Windows.

### Comparatif des systèmes de fichiers courants

| SF | Nom complet | Taille max fichier | Compatibilité | Usage idéal |
|---|---|---|---|---|
| **FAT32** | File Allocation Table | 4 Go | Windows, Mac, Linux, consoles, lecteurs DVD/Blu-Ray — compatibilité maximale | Clés USB, disques externes, cartes mémoire pour compatibilité universelle |
| **NTFS** | New Technology File System | Jusqu'à 16 To (256 To pour les partitions) | Windows (depuis XP) ; Mac en lecture seule par défaut | Système principal Windows, disques internes |
| **exFAT** | Extended File Allocation Table | Jusqu'à 128 Po | Windows (depuis XP), Mac OS X, Linux (avec paquets) | Clés USB, cartes mémoire, disques externes avec fichiers > 4 Go |
| **APFS** | Apple File System | — | macOS (natif) | Disques internes Mac (depuis 2017) |

> [!note] Sécurité
> Contrairement au FAT32, le **NTFS** offre des fonctionnalités de sécurité avancées : permissions d'accès, journal de modifications, chiffrement des données, quotas d'utilisation.

> [!question] FAT32 ou exFAT pour une clé USB ?
> Si l'appareil cible est compatible exFAT, il est préférable de l'utiliser plutôt que FAT32 dès qu'on manipule des fichiers de plus de 4 Go (limite technique du FAT32). FAT32 reste préférable uniquement pour une compatibilité maximale avec de très vieux appareils.

### ❓ Questions de révision

- Quelles sont les trois contraintes fondamentales qu'un SE doit satisfaire pour le stockage de l'information ? → **Pouvoir enregistrer l'information, la conserver après la fin du processus, et permettre l'accès simultané par plusieurs processus.**
- Quelle est la différence entre typage fort et typage déduit ? → **Le typage fort se base sur l'extension du fichier (Windows) alors que le typage déduit inspecte le contenu du fichier (Linux).**
- Qu'est-ce que le formatage d'un support de stockage ? → **Le processus qui prépare le support à stocker des données en y définissant la structure du système de fichiers.**
- Est-ce qu'un disque APFS fonctionne nativement sur Windows ? → **Non, les systèmes de fichiers ne sont généralement pas compatibles entre eux ; APFS est propre à macOS.**
- Dans quel cas choisir NTFS plutôt qu'exFAT ? → **NTFS est préférable pour le disque interne principal sous Windows grâce à ses fonctionnalités de sécurité (permissions, chiffrement, quotas), alors qu'exFAT est mieux adapté aux supports amovibles partagés entre plusieurs OS.**

---

## 🧩 Exercice récapitulatif

> Un système Linux multi-usager exécute quatre processus (P1 à P4) qui arrivent à des moments différents. Le SE doit : (1) créer un PCB pour chacun, (2) les ordonnancer en Round Robin avec un quantum de 3 secondes, (3) allouer la mémoire nécessaire à chacun en la libérant à leur terminaison, et (4) permettre à chacun d'écrire ses résultats dans un fichier sur une partition NTFS.

**Démarche combinant les concepts du cours :**

1. **Gestion des processus** : chaque processus est créé (mode noyau via appel système), reçoit un PCB (état, compteur d'instructions, priorité, registres, fichiers ouverts) et passe par les états Nouveau → Prêt → Exécution → (Bloqué) → Fin.
2. **Ordonnancement** : l'ordonnanceur applique le Round Robin (quantum = 3 s) en faisant basculer le processeur entre les processus prêts, comme illustré dans les exercices en classe.
3. **Gestion de la mémoire** : à la création de chaque processus, le gestionnaire de mémoire alloue l'espace nécessaire (programme, données, pile) ; à la fin d'un processus, cette mémoire est récupérée et peut être réallouée à d'autres processus en attente. Si la mémoire physique est insuffisante, le SE peut recourir au swapping (swap-out des processus bloqués, swap-in au besoin).
4. **Système de fichiers** : l'écriture des résultats sur une partition NTFS bénéficie des permissions d'accès et de la robustesse du SF, contrairement à un FAT32 qui ne supporterait pas les mêmes garanties de sécurité.

**Points clés à retenir de cet exemple :**
- Les quatre grandes fonctions du SE (gestion des processus, de la mémoire, des fichiers, des périphériques) interagissent constamment lors de l'exécution d'un simple programme.
- Le PCB est la structure centrale qui permet au SE de suivre et de restaurer l'état de chaque processus lors des changements de contexte.
- Le choix de l'algorithme d'ordonnancement (FCFS, SJF, RR) influence directement le temps d'attente des processus.
- Le choix du système de fichiers (FAT32, exFAT, NTFS, APFS) dépend du compromis entre compatibilité et fonctionnalités de sécurité/performance.

---

## 🔗 Liens connexes
- [[Introduction à l'ordinateur]]
- [[Processeur]]
