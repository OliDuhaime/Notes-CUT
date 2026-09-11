### Qu’est ce qu’un **RAID**
- **RAID** : Redundant Array of Independent Disks
- Technologie pour augmenter les performances et/ou la fiabilité du stockage
- À partir de plusieurs disques durs physiques, on obtient un seul espace visible par le système d’exploitation.
- En fonction de l’objectif, le RAID permet d’accroître la performance d’accès et d’écriture des données ou améliorer la sécurité des informations.
- Consiste à dupliquer tout ou une partie des données

### RAID *matériel* vs RAID *logiciel*
##### **Matériel** : 
- La configuration est effectuée en connectant un lecteur à la carte mère via un matériel spécial appelé **contrôleur RAID**
- Avantages :
	- Performance 
	- Tolérance aux pannes
- Inconvénients : 
	- Couteux
##### **Logiciel**
- La configuration est effectuée en connectant des lecteurs directement à la carte mère dont la configuration est ensuite gérée par le logiciel utilitaire du système d’exploitation.
- N’utilise aucun matériel spécial pour connecter les périphériques de stockage
- Avantages : 
	- Pris en charge par la majorité des SE 
	- Pas couteux
- Inconvénients : 
	- Affecter les performances
	- Vulnérable aux virus et autres attaques de sécurité car fonctionne à l’intérieur du système informatique hôte

### Niveaux de RAID
- Chaque niveau est optimisé pour une situation spécifique.
- Pas de normalisation, chaque entreprise peut proposer son propre numéro et implémentations.
#### RAID 0
- Volume agrégé par bandes (Stripping) ;
- Configuration RAID permettant d’augmenter les performances en faisant travailler n disques durs en parallèle.
- Avantages :
	- Vitesse de transfert (v/n)
	- Pas de perte d’espace : Le RAID 0 n’apportant pas de redondance, tout l’espace disque disponible est utile.
	- Facile à implémenter
- Inconvénients :
- Fiabilité : la perte d’un seul disque entraîne la perte de toutes les données
#### RAID 1
- Duplication des données sur tous les disques durs de la matrice RAID
- Disques en miroir (mirroring)
- Avantages :
	- Plus sûre pour le stockage de données sensibles 
	- Facile à implémenter 
- Inconvénients : 
	- La capacité totale est égale à celle du plus petit disque 
	- Coût 
	- Pas possible de changer l’unité de stockage défectueux sans éteindre la machine
#### RAID 5
- Volume agrégé par bandes à parité répartie 
- Le plus utilisé en entreprise 
- Avantages :
	- Sécurité
	- Performance en lecture comme RAID 0
- Inconvénients :
	- Ne supporte la perte que d’un seul disque 
	- Écriture lente car calcul de la parité 
	- Technologie complexe
#### RAID 6
- Volume agrégé avec parité double
- Similaire au RAID 5 mais les données de parité sont écrites sur 2 disques
- Avantages :
	- Si perte de 2 disques, il y a toujours accès aux données ; Plus sécuritaire 
	- Performance en lecture comme RAID 5 
- Inconvénients :
	- Écriture plus lente car calcul de la double parité 
	- Technologie complexe
#### RAID 10
- Combinaison RAID 1 + 0
- Configuration imbriquée, combinaison des avantages et inconvénients 
- Avantages :
	- Si un des disques est défectueux, le temps de reconstruction est très rapide puisqu’il suffit de copier toutes les données du disque miroir non défectueux vers un nouveau disque 
- Inconvénients :
	- La moitié de la capacité de stockage va à la mise en miroir, donc coûteux à cause de la redondance