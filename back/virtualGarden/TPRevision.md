# Travail Pratique : Le Jardin Botanique Virtuel

## Contexte :
Dans un monde toujours plus numérique, la nature trouve sa place sous une forme virtuelle. Vous êtes chargé de créer un jardin botanique virtuel. À travers une API REST et une interface utilisateur, les passionnés peuvent "planter" des plantes virtuelles, les "arroser", suivre leur croissance et en apprendre davantage sur leur botanique.

I. Fonctionnalités :

- Authentification :
    - Les utilisateurs doivent pouvoir s'inscrire, se connecter et se déconnecter.
    - Les informations des utilisateurs seront stockées en toute sécurité avec un mot de passe haché.

- Planter une Plante :
    - Après authentification, l'utilisateur peut ajouter une nouvelle plante à son jardin virtuel en fournissant le nom, une description, une image (URL) et des détails botaniques.

- Arroser une Plante :
    - Les plantes doivent être arrosées pour pousser. L'utilisateur peut "arroser" une plante, augmentant ainsi son niveau de croissance.

- Suivi de la Croissance :
    - La croissance de la plante est marquée par des étapes ou des niveaux basés sur le nombre de fois qu'elle est arrosée.

- Consulter les Plantes :
    - Les utilisateurs peuvent voir toutes les plantes disponibles, y compris celles des autres, avec des informations détaillées sur chaque plante.

- Commentaires :
    - Les utilisateurs peuvent laisser des commentaires sur chaque plante, partager des astuces ou des anecdotes.

II. Tests :
    - Assurez-vous de rédiger des tests unitaires et d'intégration pour votre backend et des tests pour votre frontend React.

III. Technologies et Architecture :

- Backend :
    - Utilisez Spring Boot pour créer votre API REST.
    - Adoptez une architecture hexagonale :
        - Domaine : Définissez vos entités comme Utilisateur et Plante, avec des ports comme PlanteService et PlanteRepository.
        - Infrastructure : Utilisez Spring Data JPA et Spring Security.
        - API : Des contrôleurs REST pour l'interaction.

- Frontend :
    - Utilisez ReactJS pour créer une interface utilisateur intuitive.
    - Utilisez des bibliothèques comme Axios pour les requêtes API.
    - Implémentez des routes protégées et une gestion d'état.

- Déploiement :
    - Containerisez à la fois le frontend et le backend à l'aide de Docker.
    - Utilisez docker-compose pour orchestrer vos services et dépendances (comme une base de données).