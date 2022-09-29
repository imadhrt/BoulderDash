td2:Héritage et polymorphisme


Question 1:

1)
(3.0, 6.0) - FF0000FF
x: 3.0
color : FF0000FF

2)

a)la ligne 10 pose problème car la méthode getColor() n'est pas implémenté dans la classe mère(Point)
mais plutot dans la classe fille(ColordePoint) donc la classe mère n'as pas accès au méthode de 
sa classe fille mais inversement oui.

b)non,il n'y a plus d'erreur.


3)
non car un point n'hérite pas de coloredPoint,cela signifie qu'un coloredPoint ne pas instancier 
un Point.Mais on peut faire par exemple: Point p2=new ColoredPoint(....).

4)
non car faire réference au attribut de la classe et donc pour avoir accès x et y,on doit faire 
appel à la classe mère en faisant super.x,super.y .

5)une classe ne peut pas hériter d'une classe qu'elle hérite deja.

6)Avec final,on peut pas créer de sous classe.


question 2:

1)oui
2)oui
3)oui on peut l'ajouter.Cette méthode est définie dans la classe Object.
Tout les classes qu'on crée ou qui sont crée hérite automatiquement de la classe Objet.

liste de méthode Objet:
-clone()
-equals​(Object obj)
-finalize()
-getClass()
-hashCode()
-notify()
-notifyAll()
-toString()
-wait()
-wait​(long timeoutMillis)
-wait​(long timeoutMillis, int nanos)

Question 3:

1) Il s'attend toujour à avoir à la premiere ligne l'appel du constrcuteur parent.
2)Il s'attend à avoir le constructeur de la classe parent mais si on ne le met pas
  alors elle le m'est implicitement si on a creer un constructeur sans parametre 
  dans la classe parent.
3)non,car dans la Point on a un constructeur sans paramètre donc il faire reférence implicitement.


Question 4:
1)
constructor of A
constructor of B
constructor of C

2)
constructor of A
constructor of B

3)oui,  c'est la même.

4)Il a un constructeur(Object()).

Question 5)

1)
(0.0, 0.0) - not pinned
(1.0, 1.0) - pinned

2)


 


  