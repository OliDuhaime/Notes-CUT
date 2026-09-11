[[THC017 - Architecture Ordi/Carte mère|Information complémentaire]]

Composante principal de l'ordinateur
Circuit imprimé où tous les composants de l'ordinateur se connectent
![[Pasted image 20260904092051.png]]

### Composants
**Support du processeur** (ou socket) :
- Partie spécifique d’une carte mère qui est spécialement conçue pour contenir un CPU.
- Conçu avec des milliers de broches ou de points de contact pour l’alimentation et le transfert de données entre le CPU et le reste des éléments de la carte mère.
- Conçus pour maintenir en toute sécurité le processeur sur la carte mère et aider à prévenir les dommages potentiels lorsque l’appareil est déplacé. 
- Détermine quel type de CPU fonctionnera avec l’ordinateur. Un CPU particulier ne marchera pas avec n’importe quel socket CPU.
**Prises GPA** (Pin Grid Array):
- Les broches sont sur le processeur, que l’on insère ensuite dans une prise avec des trous correctement placés
- AMD utilise aujourd’hui le style PGA pour la plupart de ses processeurs pour plusieurs raisons et avantages (facile à installer et réparer, etc.).
**Prises LGA** (Land Grid Array):
- Les broches sont sur le socket sur lesquelles on place le processeur
- Il coûte moins cher lors du remplacement de la carte mère par rapport au CPU lorsque les broches fragiles sont endommagées. Utilisé souvent par Intel.
**Prises BGA** (Ball Grid Array):
- La technique BGA relie (souder) en permanence le processeur à la carte mère pendant la production, ce qui rend les mises à niveau impossibles.
- Durable, moins d’espace et connexion (information) rapide.
**Bus**: [[Bus|TCH017-Bus pour plus d'information sur calculs]]
- Dédié au transfert de données.
- Communication entre les connecteurs d’extension (slots).
- Contient plusieurs fils (lignes de signal) avec des informations d’adressage décrivant l’emplacement mémoire où les données sont envoyées ou récupérées.
- Chaque fil du bus transporte un ou plusieurs bits d’information, ce qui signifie que plus un bus a de fils, plus il peut adresser d’informations.
- Exemple : un ordinateur avec un bus d’adresse 32 bits peut adresser 4 Go de mémoire et un ordinateur avec un bus 36 bits peut adresser 64 Go de mémoire.
- Types de Bus:
	- Bus **interne** : permet la communication entre les composants internes, tels qu’une carte vidéo et la mémoire.
	- Bus **externe** : capable de communiquer avec des périphériques externes, tels qu’un périphérique USB.
	- Bus **parallèle** : données sont transmises plusieurs bits à la fois.
	- Bus **série** : données sont transférées un bit à la fois
	- Bus **d’adresse** : contient l’emplacement mémoire (adresse mémoire) où se trouvent les données dans la mémoire de l’ordinateur.
	- Bus de **données** : Utilisé pour transférer les données.
	- Bus de **contrôle** : communique avec les périphériques, envoie les commandes et reçoit des signaux d’état.
	- **Vitesse des bus** : mesuré en bits par seconde ou mégabytes par seconde (Mbps).
	- **Exemple** de bus : SATA (connexion aux mémoires externes), PCI (connexion des périphériques à l’ordinateur), FSB (connecte le CPU à la mémoire centrale), etc.
	  ![[Pasted image 20260904093001.png|342]]

**Chipset**:
- Contrôle la communication entre le processeur, la RAM, le stockage et d’autres périphériques E/S.
- Composé d’une à quatre puces et des contrôleurs de fonctionnalités pour les périphériques (Clavier, souris, moniteur).
- Détermine le nombre de composants haut débit que la carte mère peut prendre en charge

La pile CMOS
Connecteurs d’entrée-sortie.