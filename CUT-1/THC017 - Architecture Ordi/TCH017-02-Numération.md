# Systèmes de numération

Décomposition d'un nombre en une somme avec $b­­­­­­\ge2$ et $m$ égal au nombre de chiffres:   
$$ 𝑛 = ∑ 𝑎_i𝑏^i = 𝑎_0𝑏^0 + 𝑎_1𝑏^1 + ⋯ + 𝑎_{m-1}𝑏^{𝑚−1} $$
![[Pasted image 20260914092402.png]]

71 en base 8

$$1 * 8^0 + 7 * 8^1 = 57$$

  
CAFE en base 16

$$14 * 16^0 + 15 * 16^1 + 10 * 16^2 + 12 * 16^3 = 51966$$

  

de base 2, 8 et 16 à base 10

base 10 à binaire:
![[Pasted image 20260914094033.png]]

= 100 000 0010

150 en base 16 vers le binaire: On prend chaque nombre du chiffre et on le converti vers la base désirée
$$ 150_{16} $$
$$1(0001)\ 5(0101)\ 0(0000)$$
$$0001\ 0101\ 0000_2$$

123 + 456 de base 8 donnent 601 base 8, validation en base 10
$$3 + 6 = 9_{10} - 8 = 11_8$$
Même procédure que addition/soustractions papier avec emprunt/retenue mais on modifie la base

$$$$
# Représentation interne des nombres entiers

### Non signés: $[0, 2^n-1]$ 


Quelle est la plage de valeurs que peut représenter un entier non signé codé sur 2 octets?
$$[0, 2^{2*8} -1]$$
$$[0, 65536]$$
### Signés: $[-(2^{n-1}-1), 2^{n-1}-1]$  
Si le MSB (*Le bit de gauche*) vaut 1 -> < 0, si vaut 0 -> > 0

Quelle est la plage de valeurs que peut représenter un entier en format signe valeur codé sur 5 bits?
$$1b1111$$
$$0b1111$$
$$[-(2^{5-1}-1), 2^{5-1}-1]$$
$$[-15, 15]$$
$$-23_{16}$$
$$$$