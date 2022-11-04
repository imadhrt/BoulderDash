Td4:Gestion des événements

Question1:
 On remarque que du texte apparaît dans la console à chaque fois qu'on n'appuye n'importe où sur l'écran
 car à chaque fois que l'événement se déroule, on appelle la méthode handle automatique, qui fait un affichage sur la 
console de ce qui est en paramètre dans dans l'instanciation de GraphDisplayHandler.




Question2 :

1. l'effet de filtre est qu'il n'accepte plus rien du tout, je ne peux pas écrire car on a mis "consume", cela signifie qu'il a va refuservles évènements.
2. tfdText.addEventFilter(KeyEvent.KEY_TYPED, e -> {
            if (!e.getCharacter().matches("[0-9]*")) {
                e.consume();
            }
        });