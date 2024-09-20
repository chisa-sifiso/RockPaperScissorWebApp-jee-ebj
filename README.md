Technologies Used
Java EE: Servlets, JSP, EJB
JPA: For database persistence with entities and facades
Oracle Database (ORA): Used as the database backend for storing game data
GlassFish Server: For deploying the application
NetBeans IDE 16: For development and project management
JDK 11: Java Development Kit
Project Structure
Source Packages:
Servlets:
StartSessionServlet: Initializes the session for users and tracks game progress.
GetWinnersServlet: Retrieves a list of users who won the game.
GetGamesInfoServlet: Provides information about played games.
Other servlets handle various parts of the game process, including logging out users and tracking session results.
EJB (Business Logic):
GameSummaryFacade: Manages database queries to retrieve game results, winners, and other game-related statistics.
AbstractFacade: Parent class for database interactions.
Entities:
GameSummary: Entity class representing game results stored in the database.
Libraries:
RockPaperScissorEJBModule: This includes the EJBModule.jar which contains the session beans and facades.
