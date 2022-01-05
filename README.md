# Cinespring

Ce projet a pour but de mettre en eplace une API REST pour la gestion de sceances de cinéma.

## Prérequis
1. Un IDE JAVA
2. JDK 11+
3. Docker
4. Postman

## Utilisation
1. Lancer la base de données:
dans un terminal a la racine du projet, taper la commande suivante:
```shell script
docker compose up -d
```

2. Dans votre IDE favori, lancer le projet avec maven. Vous pouvez aussi utiliser la commande suivante:
```shell script
mvnw spring-boot:run
```

3. Dans postman, Ajouter des acteurs, seances et des films grace aux APIs REST sur le port 8080.

Vous pouvez voir les routes disponible avec sur la route:
[Swagger-ui](http://localhost:8080/swagger-ui.html)

4. Vous pouvez utiliser Kibana pour la visualisation des données sauvegarder dans elasticsearch avec le port 5601.


## Documentation Utiles:
* Documentation de springBoot starter Data Mongo: [Baeldung Mongo](https://www.baeldung.com/spring-data-mongodb-tutorial)
* Documentation de springBoot starter Data Elasticsearch: [Baeldung Elasticsearch](https://www.baeldung.com/spring-data-elasticsearch-tutorial)
* Documentation d'elasticsearch: [Elastic.co](https://www.elastic.co/guide/index.html?ultron=B-Stack-Trials-EMEA-S-FR-Exact&gambit=Stack-Documentation&blade=adwords-s&hulk=paid&Device=c&thor=elasticsearch%20docs&gclid=Cj0KCQiAoNWOBhCwARIsAAiHnEh4MP9m7R2NKB-RpuqJ-qDblqpje4nXeTRj2UnqmNgQUyq2hlLLWLoaApZlEALw_wcB)
