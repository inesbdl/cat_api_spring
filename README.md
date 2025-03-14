### Récupérer le projet

- Cloner le projet avec `git clone https://github.com/inesbdl/spring_api.git`
- Ouvrir le projet 

### Mettre les variables d'environnement

Dans **application.properties** modifier : 
- spring.datasource.url=jdbc:mysql://localhost:port/nom_de_la_database
- spring.datasource.username=your_username
- spring.datasource.password=your_password

Et ajouter les variables de l'api source : 
- API_SCHEME=https
- API_HOST=api.thecatapi.com
- API_PATH=/v1/images/search
- API_KEY=cle_api_pdf
- COMPLETE_URL=https://api.thecatapi.com/v1/

### Créer la base de données

Créer un schéma ayant le même nom que celui dans **application.properties**

### Importer les routes

Importer les routes dans Bruno
Avant de tester les routes, bien penser à s'authentifier
