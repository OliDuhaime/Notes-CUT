Système basé sur la **logique binaire**:
- Entrée: 0 = aucune action, 1 = action
- Sortie: 0 = désactivée, 1 = activée
- Il y a 2^n lignes, où n est le nombre d'éléments d'entrée 

| Entrées |     | Sorties |
| :-----: | :-: | :-----: |
|    a    |  b  |    y    |
|    0    |  0  |    0    |
|    0    |  1  |    0    |
|    1    |  0  |    0    |
|    1    |  1  |    1    |

### Fonction OUI
$$X = A$$
$$TL1 = BP2$$

| BP2 | TL1 |
| --- | --- |
| 0   | 0   |
| 1   | 1   |
### Fonction ET
$$X = A \bullet B$$
$$TL1 = BP2 \bullet BP4$$

| BP1 | BP2 | TL1 |
| --- | --- | --- |
| 0   | 0   | 0   |
| 0   | 1   | 0   |
| 1   | 0   | 0   |
| 1   | 1   | 1   |
### Fonction OU
$$X = A + B$$
$$TL1 = BP2 + BP4$$

| BP1 | BP2 | TL1 |
| --- | --- | --- |
| 0   | 0   | 0   |
| 0   | 1   | 1   |
| 1   | 0   | 1   |
| 1   | 1   | 1   |
### Fonction NON
$$X = \overline A$$
$$TL1 = \overline{BP2}$$

| BP2 | TL1 |
| --- | --- |
| 0   | 1   |
| 1   | 0   |

### Circuit mémoire "marche - arrêt"
Circuit fondamental à l'automatisation: permet de mémoriser une action en utilisant un relais électrique auto maintenue. $$CR1 = (marche + CR1)\bullet \overline{arret}$$ ![[Pasted image 20260902145623.png]]