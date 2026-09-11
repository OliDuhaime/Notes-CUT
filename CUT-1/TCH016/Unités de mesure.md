Voir [[Bits et Octets|TCH017-Bits et Octets]] pour plus d'information
### Bits
- L’ordinateur (processeur) ne comprend que des instructions de très bas niveau se réduisant en une suite de 0 et 1 appelés BITS (Binary digIT).
- Pourquoi l’ordinateur ne comprends que le binaire ? Comment faire communiquer l’humain et la machine ? S’entendre sur un langage commun, le Binaire 
- Le codage binaire (base 2) consiste à utiliser deux états (représentés par les chiffres 0 et 1) pour coder les informations
- Un élément de base ayant ces deux états est appelé un bit. 
	- On encode les caractères en binaire. Caractère sur 8 bits. Ex : la lettre ‘a’ = 0110 0001 = 97 (décimal)
### Octets
- L’Octet (ou Byte) est une unité d’information composée de 8 bits. Il permet de stocker un caractère, telle qu’une lettre ou un chiffre.
- Un octet peut représenter des valeurs de 0 à 255.
- Table de conversion (taille mémoire) :

| 8 bits  | 1 octet (o)       |
| ------- | ----------------- |
| 1024 o  | 1 kilo-octet (Ko) |
| 1024 Ko | 1 mega-octet (Mo) |
| 1024 Mo | 1 giga-octet (Go) |
| 1024 Go | 1 tera-octet (To) |
### Conversion
#### Bit vers décimal
On reagarde la position des 1 et 0 et on multiplie par 2^0 jusqu'à 2^n-1 où n est le nombre de 0-1 qu'on à
Exemple pour le chiffre 10110101:

| 1   | 0   | 1   | 1   | 0   | 1   | 0   | 1   | total |
| --- | --- | --- | --- | --- | --- | --- | --- | ----- |
| 2^7 |     | 2^5 | 2^4 |     | 2^2 |     | 2^0 | x     |
| 128 | 0   | 32  | 16  | 0   | 4   | 0   | 1   | 181   |
#### Décimal vers bit
On divise par 2. Le restant est soit 0 ou 1. On répète l'oppération avec la partie entière de l'opération précédente.

#### Décimal vers hexadécimal
Même processus que décimal vers bit mais avec division par 16.

#### Hexadécimal vers décimal
On multiplie chaque chiffre par 16^n-1 ou n est la position du chiffre à partir de la droite.
Exemple pour le chiffre 2FA:

| 2      | F      | A      | total |
| ------ | ------ | ------ | ----- |
| 2*16^2 | F*16^1 | A*16^0 | x     |
| 512    | 240    | 10     | 763   |
