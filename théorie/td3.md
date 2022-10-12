TD3:Java FX

Question 1:

1) en fonction des valeurs(Scene(root,height,width)) qu'on entre en paramètre,on aggrandis ou rétrécis la fenètre.
2)il supprime le header(on y trouve le titre,fermeture d'onglet,minimiser la page,maximiser la page)
   les enumération:
-StageStyle.DECORATED
-StageStyle.UNDECORATED
-StageStyle.TRANSPARENT
-StageStyle.UTILITY

3)
setTop() -->place le composant Text tout en haut de l'écran.
setBottom() -->place le composant Text tout en bas de l'écran.
setLeft() --> place le composant Text tout en haut à gauche de l'écran.
setRight() --> place le composant Text tout en haut à droite de l'écran. 


Question 2:
1) Les trois checkBox sont différenciés pas leur emplacement à l'écran(checkbox1--> centré à gauche,...).
2) L'effet est que l'affichage de checkBox1 et checkBox3 ne seront pas centrer sur la page .



Question 3:
1)
Le texte entrée par l'utilisateur est caché par des points noirs. Donc on ne voit pas ce qui est écrit.

2)Quand on clique sur Enter,on ne peut plus modifier le texte entrée au clavier et on a message qui dit que "le nom de l'utilisateur est sauvegarder
et que vous ne pouvez pas changer ça".


Question 4:
1)Lors du pression sur le bouton de cet ecran, on remarque que sa affiche le 
texte entrée dans le textArea sur la console et si on appuye plusieur fois sur le boutton, ça ajoute à la suite de l'autre en passant à la ligne(C'est comme un append() en JS).

Question 5:
1)la méthode getChilderen() retourne ObservableList<Node>.
L'interet d'un tel type de retour est de recuperer les composants enfants de la classe parent et l'ajouter.

Question 6:
1)ligne 14: VBox root = new VBox(10);

2) root.getChildren().addAll(checkBox1,checkBox2,checkBox3);

3)je ne sais pas répondre à cette question car je n'ai pas compris.





Question 7:
1)Ils sont réparti en fonction des lignes et colonnes que vous donnez en param
 pour placer le composant dans la cellule.

2)Il affiche le password bien au centre entre le coté gauche vide et le début de l'entrée de texte(le rectangle pour écrire du texte). 

3)Le changement que j'ai remarquer est que le imput password à la même longeur et largeur que le imput user name or email.







  