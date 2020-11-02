# credit-jee-soap
Mini-projet crédit calculateur on utilisant web service (SOAP)
* Axis2 1.6.2
  - Aide à créer, déployer et exécuter des services Web (SOAP).

* INSTALLATION
  - Il y a deux projets à importer CreditappWS est le service Web et le CreditappClient est le consommateur du webserivce
	- Pour que le projet marche sur votre machine vous devez : 
	- Importer la base de donnée credit.sql #(dans votre moteur de base donnée Mysql)
	- Dans le fichier CreditappWS --> src --> db --> DB.java 
	- Modifier: DriverManager.getConnection("jdbc:mysql://localhost:3306/credit", "root" , "") pour quel soit compatible avec votre base de donné
#### Mon Email ayoub.hrik@gmail.com
