## Application de Rencontre avec Proxy et Chaîne de Responsabilité

Ce projet met en œuvre une application de rencontre simple où les utilisateurs peuvent envoyer des messages à d'autres utilisateurs. Pour pimenter les échanges et améliorer l'expérience utilisateur, un "Cupidon" intervient en tant que proxy entre l'expéditeur et le destinataire.

### Cupidon: Le Messager Magique 💘

Cupidon est un proxy qui intercepte les messages envoyés entre les utilisateurs. Son rôle est d'embellir, d'adoucir ou d'ajuster les messages avant qu'ils n'atteignent leur destinataire. Par exemple, Cupidon peut:

* Corriger les fautes d'orthographe et de grammaire.
* Ajouter des émojis pour exprimer les émotions.
* Reformuler les phrases pour les rendre plus positives ou romantiques.
* Censurer les mots inappropriés.

L'expéditeur a l'illusion d'une communication directe avec le destinataire, ignorant l'intervention bienveillante de Cupidon.

**Voici un schéma illustrant le flux de communication:**

```
+---------+    +----------+    +---------+
|         |    |          |    |         |
| Expéditeur  -->  Cupidon  -->  Destinataire |
|         |    |          |    |         |
+---------+    +----------+    +---------+
```

### Architecture de l'application

L'application est structurée autour des classes suivantes:

* **User:** Représente un utilisateur de l'application avec un nom.
* **IMessageService:** Interface définissant la méthode `sendMessage` pour envoyer un message.
* **MessageService:** Implémente `IMessageService` et gère l'envoi effectif des messages (dans ce cas simplifié, l'envoi se traduit par un affichage dans la console).
* **Cupidon:** Proxy qui étend `MessageService` et interceptant les messages pour les modifier avant de les envoyer via le `MessageService`.

### Injection de dépendances avec réflexion

Au lieu d'instancier directement le proxy dans la classe `App`, on utilise la réflexion pour récupérer le proxy à utiliser. Cela permet de modifier le comportement de l'application sans recompiler le code.

**Exemple de code (simplifié):**

```java
// Dans la classe App
String proxyClassName = "com.example.Cupidon"; // Nom du proxy à utiliser
Class<?> proxyClass = Class.forName(proxyClassName);
IMessageService messageService = (IMessageService) proxyClass.newInstance();
```

### Installation et exécution

**Prérequis:**

* Java JDK 17 ou supérieur
* Maven

**Instructions:**

1. Cloner le projet depuis le dépôt Git.
2. Compiler le projet avec la commande `mvn compile`.
3. Exécuter l'application avec la commande `mvn exec:java -Dexec.mainClass="com.exo.cupidon.App"`.

### Exemples d'utilisation

**Envoyer un message simple:**

1. Lancer l'application.
2. Saisir le nom de l'expéditeur, le nom du destinataire et le message dans les champs correspondants.
3. Cliquer sur le bouton "Envoyer".
4. Le message s'affiche dans la console.

**Ajouter un nouveau proxy:**

1. Créer une nouvelle classe implémentant `IMessageService`.
2. Implémenter la logique du proxy dans la méthode `sendMessage`.
3. Modifier le nom du proxy à utiliser dans la classe `App`.
4. Recompiler et exécuter l'application pour observer le nouveau comportement.