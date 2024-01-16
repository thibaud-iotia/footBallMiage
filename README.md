# footBallMiage

## Description

Il s'agit d'un projet contenant 5 micro services sur le thème du football: 
- Teamservice : CRUD autour d'une équipe de football
- Matchservice : CRUD pour gérer les matches de football 
- Playerservice : CRUD concernant les joueurs d'une équipe de football 
- StatsService : Service pour obtenir des informations sur une équipe ou un joueur
- Eureka server : Comme service de registration

Les micro services ont tous, à l'exception d'Euraka, une documentation Swagger afin de tester les différents services. 

Le projet utilise Spring Boot avec Java. Différentes technologies ont été utilisé comme Eureka, Hystrix (pour le circuit breaker), Actuator pour le monitoring des micro services ou encore Ribbon pour le Load balancing. 

## Les End-points : 
**Service d'équipe :**

- `GET /equipes/{id}` : Récupérer les détails d'une équipe par son identifiant.
- `POST /equipes` : Ajouter une nouvelle équipe.
- `PUT /equipes/{id}` : Mettre à jour les informations d'une équipe existante.
- `DELETE /equipes/{id}` : Supprimer une équipe par son identifiant.

**Service de joueur :**

- `GET /joueurs/{id}` : Récupérer les détails d'un joueur par leur identifiant.
- `POST /joueurs` : Ajouter un nouveau joueur.
- `PUT /joueurs/{id}` : Mettre à jour les informations d'un joueur existant.
- `DELETE /joueurs/{id}` : Supprimer un joueur par leur identifiant.

**Service de match :**

- `GET /matches/{id}` : Récupérer les détails d'un match par son identifiant.
- `POST /matches` : Ajouter un nouveau match.
- `PUT /matches/{id}` : Mettre à jour les informations d'un match existant.
- `DELETE /matches/{id}` : Supprimer un match par son identifiant.

**Service de statistiques :**

- `GET /stats-equipe/{idEquipe}` : Récupérer les statistiques de la saison pour une équipe.
- `GET /stats-joueur/{idJoueur}` : Récupérer les statistiques de la saison pour un joueur.
