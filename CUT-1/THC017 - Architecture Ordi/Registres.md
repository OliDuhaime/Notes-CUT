Voir [[Processeur|TCH016-Processeur-Registres]] pour plus d'information

Stockage temporaire (vidés lorsque l'ordi est fermé) interne de l'[[Unité centrale de traitement|UCT]] pour les données en cours de traitement.

Optimisés pour la vitesse (**proximité physique**, architecture, matériaux, etc.).

Capacité restreinte (1-512 bits) par l'**espace** et les **coûts élevés**.

Exemple d’addition de x et y :
1. Charger x dans le registre A
2. Charger y dans le registre B
3. L’[[Unité de contrôle|UC]] achemine le code d’opération (+) vers un registre de l’[[Unité arithmétique et logique|UAL]]
4. L’[[Unité arithmétique et logique|UAL]] effectue l’addition
5. Le résultat est stocké dans le registre C de l’[[Unité centrale de traitement|UCT]] (par exemple)

