# M223: Punchclock
Dies ist eine Beispielapplikation für das Modul M223.

## Loslegen
Folgende Schritte befolgen um loszulegen:
1. Sicherstellen, dass JDK 12 installiert und in der Umgebungsvariable `path` definiert ist.
1. Ins Verzeichnis der Applikation wechseln und über die Kommandozeile mit `./gradlew bootRun` oder `./gradlew.bat bootRun` starten
1. Unittest mit `./gradlew test` oder `./gradlew.bat test` ausführen.
1. Ein ausführbares JAR kann mit `./gradlew bootJar` oder `./gradlew.bat bootJar` erstellt werden.

Folgende Dienste stehen während der Ausführung im Profil `dev` zur Verfügung:
- REST-Schnittstelle der Applikation: http://localhost:8081
- Dashboard der H2 Datenbank: http://localhost:8081/h2-console

## Beschreibung des Files data.sql
Im Script data.sql sind zwei Beispieldatensätze definiert, welche beim Starten der Applikation geladen werden.

##Beschreibung der Applikation
Die Applikation erfasst Ihr Fahrrad anhand des Fahrradtypen wie zum Beispiel CityBike, 
Rennrad, etc. Zudem wird noch die Marke Ihres Fahrrads erfasst. Diese Daten werden 
in einer Datenbank gespeichert und in einer Liste angezeigt. Die gespeicherten Fahrräder
kann man entweder bearbeiten oder löschen. Die Applikation startet man indem man mit 
Rechtsklick auf PunchclockApplication drückt und auf Run Application geht. Eine Alternative
ist das grüne Dreieck oben rechts.
