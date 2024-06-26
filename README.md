This is a java version of GetRich
- Uses Spring, maven
- H2 Database

1. What is Done
   - It checks the local DB
   - a. if empty, it fills up by pulling data from the DH website (url available)
   - b. if not empty, it checks the latest date of the draw stored in the db
   - c. if needed, it pulls latest data from the DH website
   - d. if not needed, it shows the latest data from the local db
     
3. To do List
   - Recommended numbers
   - etc, etc

4. To run, 
   - H2 or your selection of db must be running
   - mvn package -DskipTests
   - in \target\ folder, a jar file gets created
   - java -jar .\target\getRich-0.0.1-SNAPSHOT.jar

5. API
   - http://localhost:8080/result
     - it produces the last win number
   - http://localhost:8080/result/genNum
     - it shows the occurence numbers of 1..45
     - the api name will be changed
   - http://localhost:8080/result/csvFile
     - it produces all results from db to csvFile