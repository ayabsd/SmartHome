# SmartHome

SmartHome est une application qui permet de paramétrer des composants comme la lumière , des volets roulants ou des radiateurs.
Model: Notre M (modèle) dans MVVM. Où j’ai effectué des opérations de données.
di: Injection de dépendances avec l'aide de Hilt.
ui : Nos Fragments et ViewModels aidant à afficher des données à l'utilisateur.
utils : classes et fonctions d'assistance.


## Architecture de projet 
Lors du développement d'une application Android, il est important de planifier l'architecture du projet. Cela nous permettra de créer des applications complexes, robustes, de bonne qualité et faciles à entretenir.
![1_3u5JnmqONR4UnwRE6tEV3Q (1)](https://user-images.githubusercontent.com/10687584/110926493-c27d8780-8324-11eb-80da-01e8298ff9ba.png)
## Structure de projet 
- Model: Notre M (modèle) dans MVVM. Où j’ai effectué des opérations de données.
- di: Injection de dépendances avec l'aide de Hilt.
- ui : Nos Fragments et ViewModels aidant à afficher des données à l'utilisateur.
- utils : classes et fonctions d'assistance.

## Librairies 
### Hilt 
Dans ce projet j’ai utilisé Hilt pour l’injection de dépendances , qui réduit l'utilisation standard de DI manuelle dans votre projet. Hilt facilite l'ajout d'une injection de dépendances à votre application Android.
Hilt fournit un moyen standard de faire l'injection DI dans votre application en fournissant des conteneurs à chaque composant Android de votre projet et en gérant automatiquement le cycle de vie du conteneur pour vous.
Les avantages de Hilt

- Réutilisabilité du code.
- Facilité de refactoring.
- Facilité de test.
- Passe-partout réduit
- Dépendances de build découplées

### Navigation Component

La navigation fait référence aux interactions qui permettent aux utilisateurs de naviguer, d'entrer et de revenir des différents éléments de contenu de votre application. Le composant de navigation d'Android Jetpack vous aide à implémenter la navigation, des simples clics sur des boutons aux modèles plus complexes, tels que les barres d'applications et le tiroir de navigation.

### Coroutines
Une coroutine est un modèle de conception d' accès concurrentiel que vous pouvez utiliser sur Android pour simplifier le code qui s'exécute de manière asynchrone. Les coroutines ont été ajoutées à Kotlin dans la version 1.3 et sont basées sur des concepts établis d'autres langages.
Sur Android, les coroutines aident à gérer les tâches de longue durée qui pourraient autrement bloquer le thread principal et empêcher votre application de répondre. Plus de 50% des développeurs professionnels qui utilisent des coroutines ont signalé une augmentation de leur productivité. Cette rubrique décrit comment utiliser les coroutines Kotlin pour résoudre ces problèmes, ce qui vous permet d'écrire un code d'application plus propre et plus concis.

Coroutines est  trés recommandée pour la programmation asynchrone sur Android. Les caractéristiques remarquables sont les suivantes:

 - Léger : vous pouvez exécuter de nombreuses coroutines sur un seul thread en raison de la prise en charge de la suspension , qui ne bloque pas le thread où la coroutine s'exécute. La suspension économise la mémoire par rapport au blocage tout en prenant en charge de nombreuses opérations simultanées.
- Moins de fuites de mémoire : utilisez la concurrence structurée pour exécuter des opérations dans une étendue.
Prise en charge intégrée de l'annulation : l' annulation est propagée automatiquement via la hiérarchie coroutine en cours d'exécution.
- Intégration Jetpack : De nombreuses bibliothèques Jetpack incluent des extensions qui fournissent une prise en charge complète des coroutines. Certaines bibliothèques fournissent également leur propre étendue de coroutine que vous pouvez utiliser pour la concurrence structurée.

### LiveData
 LiveData est un "observable data holder class". Contrairement à un observable ordinaire, LiveData est sensible au cycle de vie, ce qui signifie qu'il respecte le cycle de vie des autres composants de l'application, tels que les activités, les fragments ou les services. Cette prise de conscience garantit que LiveData ne met à jour que les observateurs de composants d'application qui sont dans un état de cycle de vi
 
- S'assure que votre interface utilisateur correspond à l'état de vos données
- Les observateurs sont liés aux Lifecycleobjets et nettoient après eux-mêmes lorsque leur cycle de vie associé est détruit.
- Fini la gestion manuelle du cycle de vie
- Données toujours à jour
- 
### Room 
Room est l’ORM officiel pour mettre en place une persistance de données dans une application Android. Cette librairie brille par son efficacité, sa simplicité et son système de mise en cache.

- Simple. Elle se base sur des annotations.
- (Relativement) Riche. Elle offre des mécanismes de migration, est bien documentée, force à découper son code…



# Taches effectués
![Capture d’écran 2021-03-12 à 11 43 04](https://user-images.githubusercontent.com/10687584/110929502-4d13b600-8328-11eb-8e4c-619c36987e96.png)


-   
# DARK MODE Anglais

![Screenshot_20210312-110453_SmartHome](https://user-images.githubusercontent.com/10687584/110925785-e7252f80-8323-11eb-92c0-9b4a945db03d.jpg)
![Screenshot_20210312-110456_SmartHome](https://user-images.githubusercontent.com/10687584/110925794-e9878980-8323-11eb-9f56-eea4f71d84df.jpg)
![Screenshot_20210309-193112_SmartHome](https://user-images.githubusercontent.com/10687584/110925797-ea202000-8323-11eb-902b-cd90e9efae12.jpg)

# LIGHT MODE Français

![Screenshot_20210312_110409_com moduloTech smarthome](https://user-images.githubusercontent.com/10687584/110926107-47b46c80-8324-11eb-870e-d97139681ee9.jpg)
![Screenshot_20210312_110431_com moduloTech smarthome (1)](https://user-images.githubusercontent.com/10687584/110926122-4b47f380-8324-11eb-927e-7b4337986e45.jpg)
![Screenshot_20210312_110438_com moduloTech smarthome (1)](https://user-images.githubusercontent.com/10687584/110926128-4d11b700-8324-11eb-8487-c9c38aec0b22.jpg)



[Ref]: <https://developer.android.com/kotlin/coroutines?hl=fr&gclid=Cj0KCQiAv6yCBhCLARIsABqJTjYLqZea84F14eEh0pj4oN_6nbpU0E_9g7XJez44kp0gXMjj0SULy3kaAh_oEALw_wcB&gclsrc=aw.ds>
[Ref]: <https://developer.android.com/guide/navigation>
[Ref]: <https://developer.android.com/training/dependency-injection/hilt-android>
[Ref]: <https://developer.android.com/topic/libraries/architecture/livedata>


