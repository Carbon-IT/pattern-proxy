# Application de Rencontre avec Proxy et Chaîne de Responsabilité

Vous développez une application de rencontre où les utilisateurs peuvent envoyer des messages à d'autres utilisateurs. Pour augmenter les chances de succès et ajouter une touche amusante, vous décidez d'intégrer un "Cupidon" qui agit comme un intermédiaire (proxy) entre l'expéditeur et le destinataire. Cupidon a pour rôle d'embellir, d'adoucir ou d'ajuster les messages avant qu'ils n'atteignent le destinataire, tout en laissant l'expéditeur penser qu'il communique directement.

## Structure de l'application

### User

Représente un utilisateur de l'application avec un nom et une méthode sendMessage(sender, recipient, message).

### IMessageService

- Cette interface définit la méthode sendMessage(sender, recipient, message).

### MessageService

- Cette classe implémente IMessageService et contient la logique d'envoi de message (dans un cas réel, cela pourrait impliquer l'envoi via un réseau, ici une impression console).

## Tâche

Créer un proxy qui permet de changer les messages (comme vous le souhaitez)

### Améliorations

L'implémentation actuelle de Cupidon est un bon point de départ, mais nous pouvons l'améliorer. Imaginons que nous souhaitions ajouter de nouvelles fonctionnalités, comme la possibilité de filtrer les messages provenant d'expéditeurs bannis. Pour cela, nous pourrions créer un nouveau proxy, par exemple FilterBannedUserProxy, qui intercepterait les messages avant Cupidon et vérifierait si l'expéditeur est autorisé à communiquer.

### Injection

Ne passez plus par une injection du proxy en dur dans App, mais utilisez la réflexion pour récupérer directement le proxy
Vous pouvez vous aider de [l'article suivant](https://communitycarbonit.medium.com/linversion-de-contr%C3%B4le-les-bases-via-un-exemple-simple-dcf0aa476020)
