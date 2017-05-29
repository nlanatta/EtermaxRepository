# EtermaxRepository
Api Game

Requesitos: 
 - Ejecutar un servidor Redis (Se usa para persistir)
 - Maven.

Ejecutar dentro de roleGame, comando maven "mvn spring-boot:run"

Con esto corriendo pueden ejecutar los request por consola como los que estan descriptos a continuacion.

Create new Game
curl -X POST http://localhost:8080/api/game/

GET saved Game
curl -X GET http://localhost:8080/api/game/{gameId}

Attack with character some amount
curl -X POST http://localhost:8080/api/game/attack/{gameId}/{characterId}}/{amount}

Heal a character some amount
curl -X POST http://localhost:8080/api/game/heal/{gameId}/{characterId}/{amount}

Remove a faction to  a character 
curl -X POST http://localhost:8080/api/game/removefaction/{gameId}/{characterId}/{factionId}

