# Patterns
- Vordefinierte Lösungen für konkrete Probleme
- Lösung zeigt in rezeptartiger Weise Zusammenspiel von Klassen
- Namen für Designs
- Als Konzept wieder verwendbar
- Basierend auf den Ideen des Haus-Architekten Christopher Alexander
- Buch für Haus Patterns „A Pattern Language, Towns, Buildings, Constructions“,Christopher
Alexander, 1977

Design Patterns beschreiben einfache und elegante Lösungen für spezifische Probleme im Objekt
Orientierten Design.
Ein Design-Pattern beschreibt in rezeptartiger Weise das Zusammenwirken von Klassen, Objekten
und Methoden.

Meist sind daran mehrere Algorithmen und/oder Datenstrukturen beteiligt. Design-Patterns stellen
wie Datenstrukturen oder Algorithmen vordefinierte Lösungen für konkrete Programmierprobleme
dar, allerdings auf einer höheren Abstraktionsebene.

Die Implementation erfordert meist etwas mehr Arbeit als die Implementation der ad hoc Lösung.
Die zusätzliche Mühe wird durch größere Flexibilität und Wiederverwendbarkeit belohnt.
Einer der wichtigsten Verdienste standardisierter Design-Patterns ist es, Softwaredesigns Namen
zu geben. Zwar ist es in der Praxis nicht immer möglich oder sinnvoll, ein bestimmtes DesignPattern
in allen Details zu übernehmen. Die konsistente Verwendung ihrer Namen und ihres
prinzipiellen Aufbaus erweitern jedoch das Handwerkszeug und die Kommunikationsfähigkeit des
OOP-Programmierers beträchtlich. Begriffe wie Factory, Iterator oder Singleton werden in OO-Projekten routinemäßig verwendet und sollten für jeden betroffenen Entwickler dieselbe Bedeutung
haben.

Design Patterns können auf diese Weise auch die Dokumentation und Wartung existierender
Systeme verbessern. Objektinteraktionen und die dahinter stehende Intention werden explizit
beschrieben.

Patterns beschreiben Techniken, die in unterschiedlichen Contexten nicht in derselben Weise
implementiert werden können.

Daher kann das Design nicht in Form von wiedervewerwertbaren Komponenten oder Frameworks
implementiert werden.

# GOF Design Patterns
## Observer

- Subject wird von Observer beobachtet
- Subject informiert Observer über Zustandsänderungen
- Observer erfragen Status und updaten sich

Ein Observer Pattern ist ein Design-Pattern, das eine Beziehung zwischen einem Subject und
seinen Observern aufbaut. Als Subject wird dabei ein Objekt bezeichnet, dessen
Zustandsänderung für andere Objekte interessant ist. Als Observer werden die Objekte bezeichnet,
die von Zustandsänderungen des Subjects abhängig sind; deren Zustand also dem Zustand des
Subjects konsistent folgen muss.

Alle Observer werden informiert, wenn der Status des subject sich ändert. Als Antwort erfragen sie
den Status des subject und updaten ihren eigenen Status.

Ein Interface Observer definiert eine Methode update, die immer dann aufgerufen wird, wenn sich
der Zustand des beobachteten Subjekts ändert.

Eine Klasse Subject definiert Methoden, mit denen sich Observer registrieren und deregistrieren
lassen können. Tritt eine Zustandsänderung des Subjekts auf, wird bei allen registrierten
Observern die update-Methode aufgerufen.

Ein konkretes Subjekt wird aus Subject abgeleitet (oder verwendet ein Subject-Objekt per
Delegation) und ruft nach jeder Zustandsänderung fireUpdate auf. Dadurch werden alle
registrierten Beobachter aufgerufen und können auf die Zustandsänderung reagieren.

Ein konkreter Beobachter implementiert das Interface Observer und registriert sich bei allen
Subjekten, über deren Zustandsänderungen er unterrichtet werden möchte. Er implementiert in
update den Code, der zur Bearbeitung der Zustandsänderung erforderlich ist.

- Alternative Bezeichnung : publish subscribe
- häufig bei der Programmierung grafischer Oberflächen angewendet
- Subject kennt nicht die konkreten Observer
- Information kann mittels push() oder pull() Model übertragen werden

## Adapter
- Ein Adapter konvertiert das Interface einer Server Klasse in ein solches Interface, welches
die Client Klasse erwartet.
- Eine alternative Bezeichnung ist Wrapper

Der Adapter kann die adaptierte Klasse einerben (Class Adapter) oder die Aufrufe an diese
delegieren (Object Adapter).

Der Class Adapter hat den Vorteil, dass man einige der Methoden der Adaptierten Klasse ohne
Zusatzaufwand verwenden kann.

Bei dem Object Adapter muss man hingegen alle Methoden wirklich schreiben.

Dafür ist der Object Adapter stärker entkoppelt.

Der Adapter muss ggf. Funktionalität hinzufügen, welche die adaptierte Klasse nicht liefert.
Ein einziger Object Adapter kann viele Subklassen der zu adaptierenden Klasse adaptieren. Man
übergibt die zu adaptierende Klasse dann im Rahmen des Adapter Konstruktors. Bei einem Class
Adapter muss man hingegen für jede Subklasse einen Adapter schreiben.

## Composite

- Eine (meist abstrakte) Basisklasse "Component" repräsentiert sowohl zusammengesetzte
als auch elementare Objekte
- Alle elementaren „Leaf“ Objekte sind aus dieser Basisklasse abgeleitet
- Daraus abgeleitet gibt es mindestens eine Containerklasse „Composite“, die in der Lage
ist, eine Menge von Objekten der Basisklasse aufzunehmen
- Der Container ermöglicht die Komposition der Objekte zu Baumstrukturen
- Die Basisklasse stellt die einheitliche Schnittstelle für elementare Objekte und Container
zur Verfügung.


- Composite vereinfacht Client Code
- Clients unterscheiden nicht zwischen leaf und composite
- Neue leafs oder composite arbeiten automatisch im Kontext des vorhandenen Client Codes
- so viele gemeinsame Operationen wie möglich
- zB add() und remove()im Rahmen der Component
- führt zu einer höheren Transparenz
- kostet Sicherheit, da Clients sinnlose add() oder remove() Aufrufe ausführen können
- Verwaltung von Vater Pointer vereinfacht die Traversierung

## Abstrakte Factory

Erzeuger Klasse (Factory Klasse)
- sammelt new-Aufrufe
- kapselt Wissen um die Erzeugung
- erzeugt mehrere Typen
- ist austauschbar

Eine Factory-Klasse kapselt das Wissen um die Erzeugung komplexer Objekte. Sie besteht
ausschließlich aus Factory-Methoden.

Eine Factory-Methode ruft implizit den new-Operator auf und führt alle Konfigurationen durch, um
ein Objekt in der gewünschten Weise zu konstruieren.

Sie erzeugt mehrere Objekttypen und soll austauschbar sein.

Dann kann auf einfache Weise eine andere Implementierungsvariante gemeinsam für alle zu
erzeugenden Objekte gewählt werden.

- Herstellung kann z.B. auch durch einen String zur Laufzeit gesteuert werden
- Aufrufer kennt lediglich Produkte und abstrakte Factory
- Neue Implementierungsvariante bedeutet keinen Aufwand
- Neues Produkt bedeutet hingegen viel Aufwand
- Im Beispiel baumartige Vererbungsstruktur innerhalb der Swing- bzw. AWT Komponenten
und Vererbungsstruktur zur Realisierung der Abstract Factory

## Command

- Ein Command kapselt eine Anforderung in einem Objekt.
- Die Anforderungen können daher in einer Liste aufbewahrt und z.B. für Undo Operationen
verwendet werde
- Der Client erzeugt ein konkretes Command Objekt und spezifiziert den Receiver.
- Der Invoker speichert das Command Objekt und ruft dessen execute() Methode zur
Ausführung.
- Das Concrete Command speichert den erforderlichen Status für eine mögliche undo()
Operation und ruft eine Operation auf dem Receiver zur Ausführung.


- Executed Commands werden in einer History Liste aufbewahrt. Wenn man diese Liste
traversiert und undo() bzw. execute() ausführt, kann man Unlimited-Level-Undo erreichen.
- Die execute() Operation kann vorausschauend schon einmal gewisse Variablen für die
Undo Operation im Rahmen des Command Objektes speichern.
- Das Speichern der Command Objekte unterstützt das Recovering im Falle eines
Crashes.In diesem Falle werden persistente Commands wieder geladen und erneut
ausgeführt.
- Das Command Pattern ermöglicht die Modellierung von Transactions.
- Man kann Method Calls in Command Objects verpacken (zB RMI)
- Commands können priorisiert werden (zB Steuerbefehle haben Vorrang)
- Häufig werden Commands nach dem Composite Pattern zu MakroCommands
zusammengesetzt.
- Man kann einem Button und einem Menu Item dasselbe Command Objekt zuordnen.
- Man kann Context sensitive Menus implementieren, indem man Commands dynamisch
ersetzt.

## State

- Jeder Zustand wird durch eine eigene Klasse modelliert.
- Die Zustandsklassen sind alle von dem Interface IState abgeleitet.
- Die Klasse SpardaBankKontoImpl verwaltet ein State Objekt, d.h. eine Instanz einer
Subklasse von IState (repräsentiert den aktuellen Status).
- SpardaBankKontoImpl delegiert alle Anforderungen an dieses Objekt.
- Die Operationen werden daher spezifisch für das Objekt und damit den Zustand des
Kontos ausgeführt.
- Ein Zustandswechsel wird durch Ersetzen der Instanz erreicht.


- Statusänderungen erfolgen durch Austausch des State Objektes
- Es scheint so, als würde das Objekt seine Klasse ändern
- Neuer Status kann sehr einfach hinzugefügt werden
- Neue Funktionalität erfordert Änderungen in allen State Klassen.

## Visitor

Das Visitor-Pattern besteht aus folgenden Teilen:

Einem Interface Visitor, das Methoden definiert, die beim Durchlaufen der Datenstruktur aufgerufen
werden. Typischerweise gibt es zu jeder Klasse der Datenstruktur eine einzelne Methode, die
genau dann aufgerufen wird, wenn ein Element dieses Typs durchlaufen wird.

Jede Methode des Visitors erhält ein Argument, das vom Typ der Klasse ist, die sie besucht. Die
Namen der Methoden setzen sich meist aus dem Präfix "visit" und dem Typ des besuchten
Elements zusammen.

Die Basisklasse der Datenstruktur (also die Komponentenklasse) erhält eine Methode accept, die
ein Visitor-Objekt als Argument erhält. accept ruft die zu seiner Klasse passende Methode des
Visitors auf. In jeder abgeleiteten Komponentenklasse kann accept überlagert werden, wenn für
diese Klasse eine eigene Methode im Visitor zur Verfügung steht, die anstelle der
Basisklassenmethode aufgerufen werden soll.

Bei Containern ruft accept zusätzlich die accept-Methoden der darin enthaltenen Elemente auf.
Für jede zu implementierende Operation wird ein konkreter Visitor definiert, der die benötigte
Funktionalität in den Aufrufen der "visit..."-Methoden implementiert.

Will ein Client die Funktionalität eines bestimmten Visitors benutzen, instanziert er ein passendes
konkretes Visitor-Objekt und übergibt es an das Hauptobjekt der Datenstruktur.

- macht das Einfügen neuer Operationen einfach
- verwandte Operationen sind nicht über sämtliche Objekte verteilt
- Hinzufügen von neuen Knotenklassen sehr schwer und fehleranfällig
- Aufbrechen der Kapselung, da der Besucher auf den konkreten Knotenklassen operiert
- accept() ist eine sogenannte „Double-Dispatch“ Operation

# Distributed System Patterns

## Stub-Skeleton

![Stub-Skeleton](/images/stub-skeleton.png)

** Stub **
- agiert als der Proxy (Stellvertreter) des Server Objects
- implementiert ein Interface mit denselben Business-Methoden wie das Server Object
- überträgt Name und Parameter der Methode als Stream (Marshalling) zum Skeleton
- liefert Ergebnis an Client


** Skeleton **
 - lauscht an einem Port auf Anforderungen des Stub
 - parst den Stream (Unmarshalling)
 - ruft die korrespondierende Methode des Server Objects
 - überträgt Ergebnis als Stream (Marshalling) zum Stub

** Proxy-Typen:**
- Ein Remote-Proxy ist eine lokale Repräsentation für ein Objekt in einem anderen Adressraum.
- Der Firewall-Proxy kontrolliert den Zugang zu einer Gruppe von Netzwerkressourcen und schützt diese vor „bösen“ Clients.
- Der Cache-Proxy ermöglicht die vorübergehende Speicherung der Ergebnisse von aufwendigen Operationen in einem Puffer.
- Der Synchronization-Proxy verhindert den gleichzeitigen Zugriff auf ein Objekt aus mehreren Threads.
- copy on write Proxy, manchmal werden Proxies auch für die Implementierung der copy on write Technik verwendet. Das Kopieren des Proxy erhöht zunächst nur den Referenz Count des realen Objektes. Erst, wenn das reale Objekt modifiziert werden soll, fertigt das Proxy eine wirkliche Kopie an.
- Smart pointer ist ein Ersatz für einen einfachen Pointer. Solche smart pointer erhöhen z.B. den Referenzcounter des Objektes, laden das persistente Objekt beim ersten Zugriff automatisch in den Speicher, prüfen die Zugriffsrechte oder sperren das Objekt für den Zugriff von anderen Threads.

## Service Delegate

![Service-Delegate](/images/service-delegate.png)

Service Delegate entkoppelt den Client vom Service (GoF Adapter Pattern)

Seine Aufgaben sind:
- Konvertierung der Methodenaufrufe, der Übergabeparameter und der Rückgabewerte (z.B. Exceptions)
- Verstecken der technologiespezifischen Logik für den Zugriff auf den Service
- Ggf. Implementierung eines Cachingmechanismus für die Präsentationsschicht
- Ggf. Transparente Durchführung von Zugriffswiederholungen oder sogar Recovery Operationen im Falle eine fehlgeschlagenen Service Zugriffs
- Ggf. Serialisierung der ankommendenn Methodenaufrufe

**Meist erstellen die Entwickler der Geschäftslogik den Service Delegate**

## Data Transfer Object

![Data-Transfer-Object](/images/Data-Transfer-Object.png)

- Datencontainer
- Transfer Object transportiert alle benötigten Informationen auf einmal zum oder vom Server
- serialisierbare Klasse ohne Business Logic

Um die hochfrequente Netzbelastung zu verhindern, verwenden Client und Server einen kleinen „Datencontainer“ um alle benötigten Informationen auf einmal zum Server zu transportieren oder vom Server zu holen.
Dazu wird eine Klasse erstellt, die alle relevanten Informationen, also z.B. Name und Passwort oder Name und EMail und Stadt und Alter, als Attribute enthält.

Mit Hilfe von Transfer Objects ist es auch möglich, komplexere Informationen zu übermitteln, die sich nicht nur in einer einzigen Klasse kapseln lassen. Es lassen sich z. B. Informationen über einen Kunden in einem Webshop nur schwer in einer Klasse zusammenfassen, wenn von dem Kunden neben der privaten Adresse ebenfalls die Anschrift seines Arbeitsplatzes gespeichert werden soll. In diesem Fall bietet es sich an, neben einer Klasse für den Kunden (CustomerTO) auch eine Klasse für die Adressinformationen (AdressTO) zu erstellen. TransferObjects werde oft als immutable designed (nur getter()). Das Setzen der Daten erfolgt dann mittels Konstruktor

## Frontend Controller

![Front-Controller](/images/Front-Controller.png)

- Front Controller als zentrale Steuereinheit
- Dispatcher zur Auswahl der Views

Ein so genannter Front Controller ist als zentrale Steuereinheit für die genannten Belange verantwortlich.  
Oft verwendet er einen Dispatcher zur Auswahl der Views.  
So muss nur ein kleiner Teil der Applikation geändert werden, wenn die Applikation z.B. um eine Validierung der Eingaben und die zugehörige Fehleransicht ergänzt werden soll.

- FrontController Bestandteil des MVC Patterns
- FrontController spaltet in generischen Teil, zB. verantwortlich für die Steuerung der Views, Validierung, Rendering und Seiten spezifisch codierte Controller

## Application Service

- Man orientiert die Zerlegung der Software an den angebotenen Diensten (Services)
- zB. KundenVerwaltungsService, KontenVerwaltungsService, BuchungsService, KreditService, InvestmentBankingService, ...

## Service Facade

![Service-Facade](/images/Service-Facade.png)

- Fassade schirmt das komplexe Subsystem ab
- einfache reduzierte Schnittstelle für Kunde
- Funktionalität auf einer höheren abstrakten Ebene
- ein Methodenaufruf über das Netzwerk anstatt vieler direkter Aufrufe der Services
- zB Abwicklung der Kreditanfrage in der Facade durch Aufruf von Kunden, Konten und Kredit Service

Das Service Facade Pattern basiert auf dem GoF Facade Pattern und stellt eine Möglichkeit dar, über eine einfache reduzierte Schnittstelle ein komplexes Subsystem zu erreichen und die Kommunikation auf ein Minimum zu reduzieren.  
Dabei schirmt eine Klasse, die so genannte Facade (deutsch: Fassade), das komplexe Subsystem ab und stellt dessen Funktionalität über vereinfachte, lesbare Methoden auf einer höheren abstrakten Ebene zur Verfügung.  
Der Client Online GUI hat somit nur noch Zugriff auf die Service Facade und der Aufruf der Geschäftslogik hat nur noch einen Methodenaufruf über das Netzwerk zur Folge, anstatt vieler direkter Aufrufe der Methoden verschiedener Komponenten.

- Änderungen der Geschäftslogikschicht betreffen Client erst, wenn sich Facade ändert, geringere Wahrscheinlichkeit
- Facade implementiert nur Logik zur Kombination der Services
- Facade realisiert meist logisch zusammenhängende Use Cases
- Facade kann Caching, Authorisierung implementieren
- An Stelle von dicken EJBs können ggf POJOs für die hinter der Facade liegenden Services verwendet werden


Die Geschäftslogik könnte theoretisch vollständig innerhalb der Service Facade implementiert werden.  
Dies hätte allerdings den Nachteil, dass Logik, die für die Realisierung der Use Cases innerhalb verschiedener Service Facades benötigt wird, mehrfach implementiert werden müsste. Darüber hinaus ist es die Aufgabe einer Service Facade, die Geschäftslogik für einen Client erreichbar zu machen, aber nicht diese selbst zu realisieren.  
Innerhalb der Service Facades wird daher nur die Logik implementiert, die weiss, auf welche Weise die verschieden Services miteinander kombiniert werden müssen, um die Anfrage eines Client an die Facade zu verarbeiten.

Beim Design der Service Facade kann man sich an den in der Modellierungsphase erarbeiteten Use Cases orientieren. Dabei ist allerdings zu beachten, dass die Realisierung jedes Use Case durch eine Service Facade eine zu grosse Anzahl ergibt. Ebenso problematisch wäre es auch, alle aus den Use Cases resultierende Methoden mit einer einzigen Service Facade realisieren zu wollen. Hierdurch würde eine Klasse erzeugt werden, die bei steigender Anzahl von Use Cases immer schwieriger zu warten wäre. Daher ist es sinnvoll in einer Service Facade eine Gruppe von Use Cases zu realisieren, die miteinander in Beziehung stehen. In einer e-Commerce Anwendung könnten die Use Cases, die mit dem Verkauf zu tun haben, in einer Service Facade und die Use Cases, die mit dem Katalog in Verbindung stehen, in einer anderen realisiert werden.

Ein weiterer Vorteil der Verwendung einer Service Facade ist die Möglichkeit, Geschäftslogik Komponenten nicht nur z.B. mit EJBs sondern auch mit so genannten POJOs (engl. Abk. für „plain old java object“) zu realisieren, da diese Komponenten nicht mehr für den Client über das Netzwerk erreichbar sein müssen. Somit vermeidet man das Antipattern, alle Komponenten mit der aufwändigen EJB Technologie zu realisieren.  
Durch die Verwendung von EJB Komponenten ensteht für den Server eine hohe Belastung, da die EJBs erstellt, lookup-Operationen durchgeführt, Referenzierungen unter Verwendung von JNDI vorgenommen und die verschiedenen Home, Remote und Local Interfaces verwaltet werden müssen. Aus diesem Grund ist es sinnvoll für manche Komponenten POJOs zu verwenden und die EJB Technolgie nur dann anzuwenden, wenn die Vorteile die eben beschriebenen Nachteile überwiegen. Das ist dann der Fall wenn die zu realisierende Komponente über Netzwerk erreichbar sein soll, Sicherheitsmechanismen realisieren soll, Transaktionen unterstützen soll oder einen abstrakten Persistenzmechanismus benötigt.


## Data Access Object / Integration Service

![Data Access Object](/images/DAO.png)

- Data Access Object (DAO) für Persistenzlogik
- Zugriff über Interface
- DAO-Implementierung und Datenquelle austauschbar
- Geschäftslogik vom SQL Zugriff abgeschirmt


- DAO fungiert als Adapter zwischen Geschäftslogik und Datenquelle
- Weitere Dienste, zB Liste von Produkten sortiert und nach Kategorien gefiltert
- DAO kann auch Caching oder Logging übernehmen
- Generisches DAO, Vgl. ORM Tool Hibernate oder JPA Java Persistence API

## Persistent Anemic Object / Entity Object

Ein Persistent Anemic Object (Anemic bedeutet ohne Vitalität) ist eine einfache, serialisierbare Java-klasse, die auf eine Tabelle einer relationalen Datenbank gemapped wird. Jedes Attribut entspricht einer Spalte der Tabelle und wird mittels getter() und setter() direkt veröffentlicht.


# Architectual Patterns

## Layers
- Horizontale Separation
- Man strukturiert das System in eine angemessene Zahl von übereinander liegenden
Schichten (Layer).
- Low-Level (Sensor-Input) und High-Level (Überweisung) Komponenten
- Einheitlicher Abstraktionslevel innerhalb Layer
- Realisierung Service J durch N Calls der Services J-1
- Kommunikation mittels Push
- Leichte Wiederverwendung, Standardisierung

Oft besteht ein System aus einem Gemisch aus Low-Level und High-Level Komponenten.
Low-Level Komponenten lesen z.B. Bits von einem File oder bearbeiten Sensor-Input oder lesen
elektrische Signale von einer Leitung oder lesen Daten aus einer Datenbank.
High-Level Komponenten generieren z.B. eine Bestellung oder eine Überweisung oder verkaufen
eine Aktie.

Wesentlich ist dabei, dass innerhalb eines Layers alle zugehörigen Softwarekomponenten auf
demselben Abstraktionslevel arbeiten.

In der Regel werden die Services, die der Layer J anbietet, ausschließlich mittels Services des
Layers J-1 gebildet.

Bereits die Verwendung einer Layer übergreifenden shared Component weicht dieses Prinzip auf.
Jeder Layer schützt alle darunter liegenden Layer vor einem direkten Zugriff durch übergeordnete
Layer.

Der Standardmechanismus für eine Top-Down Communication besteht darin, dass ein Client einen
Request an den höchsten Layer N sendet. Dieser übersetzt den einzelnen Request in mehrere
Requests an Layer N-1. Ein einzelner High-Level Service wird also in der Regel durch mehrere
Low-Level Services bedient.

Umgekehrt kondensieren oft mehrere Bottom-Up Low-Level Notifications in einer einzigen HighLevel
Notification des übergeordneten Layers.

Der gebräuchlichste Mechanismus für die Inter-Layer Kommuniaktion ist das Push Modell. Wenn
der Layer J+1 einen Service des Layers J ruft, wird jede benötigte Information als Teil des Service
Calls direkt mitgeliefert. Das Push Modell führt zu einem Kommunikationsfluss von oben nach
unten. Wenn sich der J Layer die vom J+1 Layer benötigte Information holt, spricht man vom Pull
Modell.

Vorteile des Layering:

- Leichte Wiederverwendung
- Standardisierung
- Codeänderungen haben nur beschränkte Auswirkungen
- Austauschbarkeit
- Reduktion der Komplexität
- Unterstützt Parallelentwicklung

Anmerkungen:

- Untere Layer besonders stabil
- Bottom Up Notifications über Observer Mechanismus, J Layer ruft Notification Callback Methode des J+1 Layers
- Fehlermeldungen an Abstraktionsniveau anpassen
- Geringere Performance

Nachteile des Layering:

- Niedrigere Effizienz
- Funktionsaufrufe, Message Transformationen mit Hinzufügen oder Wegnehmen von Headerinformationen kosten Zeit
- Unnötige Arbeit
- Die Zuverlässigkeit der unteren Layer ist ggf. obsolet, da darüberliegende Layer das Error
Handling sowieso übernehmen.
- Ggf. unnötige Komplexität für den Anwendungsbereich.

## Model-View-Controller
Separation von Daten Model, View und Controller (MVC)

Model:

- repräsentiert die Unternehmensdaten und die Geschäftsregeln, zB Business-Objekte, Services oder Daten im Backend.

View:

- präsentiert die Daten des Models.
- Er ist für die Konsistenz verantwortlich, wenn sich Daten ändern
- Die Synchronisation erfolgt oft mit Hilfe des Observer Patterns
- Die Views werden informiert, wenn sich die Daten ändern und holen die benötigten Daten direkt vom Model (Pull Mechanismus).

Controller:

- akzeptieren User Input (Button Click oder http Requests) als Events
- übersetzen die Events in Requests für Model oder View.
- rufen die vom Model angebotenen Funktionen im Auftrag des Users
- selektieren je nach return Wert den angemessenen View

Anmerkungen:

- strikte Trennung erlaubt Entwicklung durch Spezialisten
- Views können zur Laufzeit erzeugt oder ausgetauscht werden (Pluggable Views)
- Umschalten auf Read-Only durch Austausch des Controllers
- Document View Pattern als Variante
- Manchmal pollt der View auch, um auf dem aktuellen Stand zu bleiben (Poll Mechanismus).

Durch die strikte Trennung und gut definierte Schnittstellen ist es möglich, die Komponenten durch entsprechende Spezialisten entwickeln zu lassen. Z.B. können die Views von Spezialisten für Benutzerschnittstellen entwickelt werden und die Kernfunktionalitäten im Model von Entwicklern, die das mit der Geschäftslogik verbundene Fachwissen besitzen.

- Eine nach dem MVC-Prinzip entwickelte Anwendung ist leichter wartbar, da Änderungen
- der Funktionalitäten und Daten nur im Model
- der Abläufe nur in den Controller
- der Darstellung nur innerhalb der Views vorgenommen werden müssen.

Pluggable Views, Pluggable Look and Feel:

- Views können zur Laufzeit erzeugt oder ausgetauscht werden.

Pluggable Controllers:

- Die Trennung des Controllers vom View unterstützt die Kombination verschiedener Controller mit
ein und demselben View. Z.B. ermöglicht es das Umschalten auf Read-Only durch Austausch des
Controllers oder das Ersetzen der Maus durch ein eye-tracking-device für disabled people.

Document View Pattern :

- Controller ist im View integriert.
- In vielen GUI Plattformen sind View und Controller eng verwoben, so dass eine Trennung sehr
schwer fällt. Als Variante ergibt sich dann das Document View Pattern.


## Component Based Architecture

### Problem:

Zitat aus Systemanforderungen:

> “The designed system should have the following features :
Ease of maintenance, Isolation of defects, Ease of reusability, Ease of development”

Ein System soll insbesondere folgende Eigenschaften haben :
- Gute Wiederverwendbarkeit
- Gute Modifizierbarkeit.
- Gute Wartbarkeit

### Komponente:

Eine Komponente ist eine instanzierbare, ausführbare und austauschbare Softwareeinheit mit
definierten Schnittstellen. Sie besteht gewöhnlich aus einer Menge von Klassen.

- Austauschbare Softwareeinheit
- Assemblierung durch Verbinden der Interfaces
- Interface spezifiziert Vertrag

### Komponenten Framework:

Komponenten Framework, für das Laden und Verwalten der Komponenten verantwortlich,
besteht in der Regel aus Loader, Manager und Repository.

- Component Manager, verwaltet die Komponenten zur Laufzeit, Management Interface für
das Zusammenspiel mit dem Framework.
- Component Loader, Lädt die Komponenten auf Anfrage des Managers.
- Component Repository, alle Komponenten werden im Repository registriert..

Die Assemblierung der Komponenten erfolgt durch Verbinden der Interfaces.

Auf die enthaltene Funktionalität kann nur über die Interfaces zugegriffen werden. Aspekte der
Implementierung bleiben für den Nutzer verborgen.

Die Client Interfaces bieten die von der Komponent angebotenen Dienste an. Das Interface
spezifiziert einen Vertrag zwischen Client und Komponente. Dieser Vertrag beinhaltet Vor- und
Nachbedingungen für jeden Service, Zeitbedingungen und Exceptions.

### Anmerkungen:

Nachteile

- Geringere Performance
- Höherer Ressourcenverbrauch

Interface Definition Language (IDL)

- IDL Beschreibung eines Interface
- IDL Compiler bilden auf Programmiersprache ab

Nachteile der Verwendung von Komponenten : Geringere Performance, Höherer Ressourcenverbrauch.

Manche der Komponenten Architekturen stellen eine Interface Definition Language (IDL) zur
Verfügung. Verschiedene IDL Compiler bilden die IDL Beschreibung eines Interface auf die von der
Implementierung der Komponente verwendete Programmiersprache ab.

In größeren Systemen ist es üblich, die Komponenten auf verschiedene Schichten einer Schichten
Architektur aufzuteilen.


# Model Driven Architecture (MDA)

Wesentliche Repräsentation von Software auf Modellebene
- Model Driven Architecture (MDA)
- Standardisierungsvorschlag von Object Management Group (OMG)
- Hohes Abstraktionsniveau
- Softwarestruktur gut erkennbar
- Modifikation durch Änderung des Modells
- Vergleich mit Übergang Assembler - Hochsprache

Mit der Model Driven Architecture (MDA) liegt ein Standardisierungsvorschlag der Object Management Group (OMG) vor, der die Repräsentation von Software von der Programmcodeebene auf die Modellebene heben möchte.  
Modelle bilden die zentralen Elemente des Softwareentwicklungsprozesses.  
Änderungen an der Software erfolgen nun nicht mehr im Programmcode, sondern in einem der Modelle.


## Computation Independent Model

- Fachliche Beschreibung von Leistungsumfang und Anforderungen
- keine internen Strukturen oder das innere Verhalten
- unabhängig von technischen Aspekten der Implementierung
- Use-Case Diagramme, Interaktionsdiagramme und Aktivitätsdiagramme

Das Computation Independent Model (CIM) beschreibt ein Softwaresystem auf fachlicher Ebene. Es liegt in einer Sprache vor, die für die fachlichen Anwender des Systems verständlich ist, und dient zum Diskurs zwischen Softwarearchitekten und Anwendern über Leistungsumfang und Anforderungen.

Mit Hilfe des Computation Independent Models (CIM) wird die Geschäfts- oder Domänensicht des zu entwickelnden Softwaresystems modelliert. Das CIM ist im Rahmen der MDA der Modelltyp mit der höchsten Abstraktionsebene. Das CIM ist unabhängig von technischen Aspekten der Implementierung, d. h. es beschreibt keine internen Strukturen oder das innere Verhalten des Softwaresystems.

Bei der Modellierung des CIM mit Hilfe der UML werden Use-Case Diagramme, Interaktionsdiagramme und Aktivitätsdiagramme eingesetzt. Das CIM bildet die Ausgangsbasis für alle weiteren Modelltypen. Die Strukturen, Verhaltensbeschreibungen und Implementationen, die im PIM und PSM aufgestellt werden, müssen auf die Anforderungen im CIM rückführbar sein.

## Platform Independent Model

- Realisiert die Anforderung des CIM
- Modellierung unabhängig von der gegebenen Plattform

Platform Independent Model (PIM), plattformunabhängiges Modell für Geschäftsprozesse.

Das Platform Independent Model (PIM) modelliert die Funktionalität einer Komponente unabhängig von der gegebenen Plattform. Damit enthält ein PIM also den Teil eines Systems, der sich beschreiben lässt, ohne die endgültige Zielplattform zu kennen.

## Platform Specific Model

- Realisiert ein PIM
- Nutzt bereitgestellte Schnittstellen der Plattform

Platform Specific Model (PSM), plattformabhängiges Modell für Architektur, Services

Das Platform Specfic Model (PSM) kennt eine spezielle Plattform und realisiert ein PIM, wofür die von der Plattform bereitgestellten Schnittstellen genutzt werden.

Wenn das System basierend auf der Java-2-Enterprise-Edition (J2EE)-Plattform zu realisieren ist, ist das Plattform-Modell die Beschreibung von J2EE, das PIM die Beschreibung des Systems ohne J2EE-spezifische Details, während das PSM ein mit J2EE-spezifischen Details angereichertes Modell ist, aus dem schon der Programmcode generiert werden kann.

## Implementation Specific Model

Implementation Specific Model (ISM) ist das Codemodell in der Zielplattform.

## Domänen- bzw. plattformspezificshe Modellierungssprache

Die Standard-UML-Konzepte Attribute, Class und Operation werden im UML-Profil um die spezifischen Konzepte PrimaryKeyField, EJBEntityBean und EJBFinderMethod erweitert.

Ein UML Profil:
- ist die Erweiterung des Standard-UML-Sprachumfanges zur Bildung einer spezifischeren Designsprache
- wird benötigt, um domänen- oder plattformspezifische Semantiken abbilden zu können.
- im UML-Metamodell vorgegebenen Meta-Typen werden durch Stereotypen,
TaggedValues, Constraints, Custom Icons, weiter spezialisiert
- kann entweder für PIM oder PSM bestimmt sein
- definiert die Syntax der Modellierungssprache – analog der Grammatik einer klassischen Programmiersprache
- definiert die statische Semantik der Modellierungssprache durch Einschränkungen (Constraints)
- ist die Grundlage für automatische Transformationen – analog einer formalen Programmiersprache als Grundlage für einen Compiler

### UML Modell auf Basis des Metamodells

Eine Domäne:
- (z.B. EJB) ist ein „Interessens- oder Wissensgebiet“.

Das domänenspezifische Modell:
- verwendet ein Domänenexperte (z.B. EJB Experte), um eine konkrete Instanz eines Systems (z.B. EJB basiertes System) zu beschreiben.
- ist eine Instanz des Metamodells, wird also durch dieses reglementiert.

Somit ist es möglich, konkrekte Instanzen nicht durch einen Programmierer, sondern direkt vom Domänenexperten mit seinem Fachwissen modellieren zu lassen.

Eine formale domänenspezifische Sprache Domain Specific Language (DSL)
- dient zur Modellierung eines domänenspezifischen Systems (z.B. EJB basiertes System) durch einen Domänenexperten (z.B. EJB Experte).
- ermöglicht meist eine grafische Repräsentation.
- UML Profile ist eine interne/eingebettete DSL

## Transformationen zwischen Modellen

Transformation
- erzeugt aus den Elementen des Quellmodells die Elemente des Zielmodells
- von der abstrakteren Ebene in die konkretere Ebene (CIM-PIM-PSM-Code)
- besteht aus der Anwendung von Transformationsregeln
- Model Type Mappings, zB Entity-Typen auf Java EJBEntity Klassen abbilden
- Model Instance Mappings bilden konkrete Instanzen des PIMs auf konkrete Instanzen im PSM ab
- **Forward Engineering, kein Roundtrip Engineering**

*Forward Engineering*  CIM-PIM-PSM-Code  
Die Transformationen erzeugen aus den Elementen des Quellmodells die Elemente des Zielmodells. Die Transformation geschieht üblicherweise von der abstrakteren Ebene in die konkretere Ebene (CIM-PIM-PSM-Code). Dadurch kann aus einfacheren Modellelementen eine komplexere Anwendung erzeugt werden, indem erfahrene Architekten ihre Konstruktionsregeln in solche Transformationsprozesse einprogrammieren.

Jede Transformation besteht aus der Anwendung von Transformationsregeln, sogenannten Mappings, die für die automatische und semiautomatische Ausführung formal definiert sind. Die Transformation reichert die Information des PIMs durch zusätzliche Information der ausgewählten Plattform und der verwendeten Transformationsregeln an.


Ein *Record of Tranformations* protokolliert die angewendeten Transformationsregeln.

Transformationsregeln werden in Model Type Mapping und Model Instance Mapping und einer
Kombination von beiden, den Combined Type and Instance Mappings, unterschieden.

*Model Type Mappings* sind Transformationsregeln, die auf der Ebene der Sprachkonstrukte der Modellsprache definiert werden.  
Beispielsweise könnte ein Model Type Mapping für das Entity- Relationship-Modell als PIM- Sprache und Java als PSM-Sprache so aussehen, dass alle Entity-Typen eines konkreten ER- Modells auf Java EJBEntity - Klassen abgebildet werden.

Bei *Model Instance Mappings* definieren die Regeln, dass konkrete Instanzen des PIMs auf konkrete Instanzen im PSM abgebildet werden. Deshalb benötigt die Anwendung einer solchen Regel die Identifikation der zu transformierenden Instanzen durch Markierungen. Markierungen sind Plattformspezifisch, weil sie nur für die Transformation benötigt werden, und deshalb nicht Teil des eigentlichen PIMs sind.

*Roundtrip Engineering*  
Das PIM abstrahiert von technologischen Details, während das PSM die Konzepte einer Plattform verwendet, um ein System zu beschreiben. Der „Rückweg" -die Gewinnung eines PIMs aus einem PSM ist kaum automatisierbar. Dieser Weg erfordert manuelle, intellektuelle Arbeit in Form eines Refactorings, da mit dem PIM eine echte Abstraktion erreicht wird. Somit legt MDA einen Forward Engineering Prozess nahe und Tool-unterstütztes Roundtrip Engineering ist kaum möglich.

## Standardisierung

![Metamodellierung](/images/Metamodellierung.png)

Die Abstraktionshierarche zunächst am Beispiel :
- Zur Laufzeit wird eine Instanz der Klasse Person erzeugt. Die Klasse Person ist ein Element des Design Modells.
- Zur Design Zeit wird eine Klasse Person als Element des Modells erzeugt. Die Klasse Person ist eine Instanz des Metamodel Elementes Class.
- Zum Zeitpunkt der Programmierung des UML Editors wird eine Klasse Class als Element des Metamodells erzeugt. Diese ist eine Instanz des Meta-Metamodell Elementes MetaClass.
- Zum Zeitpunkt der Programmierung eines Editors für Metamodelle wird eine Klasse MetaClass als Element des MetaMetamodells erzeugt.

Die Abstraktionshierarche nun abstrakt :
- Domänenspezifisches und plattformbeschreibendes Modell
- Metamodell definiert sprachliche Elemente und Regeln für Modell
- Meta-Metamodell definiert sprachliche Elemente und Regeln für Metamodell

Das domänenspezifische Modell verwendet ein Domänenexperte (z.B. Banker für Domäne Bank), um eine konkrete Instanz eines Systems (z.B. Online Banking System) zu beschreiben. Dieses Modell ist eine Instanz des Metamodells, wird also durch dieses reglementiert.

Das plattformbeschreibende Modell gibt das Framework vor, in welches das Domänenmodell integriert und überführt werden muss und ergänzt die geschäftrelevanten um die fehlenden technischen Informationen.

Das Metamodell (z.B. UML Metamodell) definiert die sprachlichen Elemente und die Regeln, die zur Verfügung stehen, um ein System zu modellieren.  
Die abstrakte Syntax beschreibt die Elemente eines Modells.  
Die Semantik legt Regeln und Bedingungen fest, welche das Modell erfüllen muss.

Ebenso wie man zur Erzeugung einer Klasse Person des Modells eine Instanz des Elementes Class des Metamodells verwendet, nutzt man zur Erzeugung von Class des Metamodells eine Instanz der Klasse MetaClass des Meta-Metamodells.  
Das Meta-Metamodell definiert die sprachlichen Elemente und die Regeln, die zur Verfügung stehen, um ein Metamodell zu modellieren.  
Entsprechend der Korrektheitsprüfung eines UML-Modells durch das entsprechende Werkzeug kann auch die Korrektheit eines Metamodells geprüft werden.

## Vorteile

Befürworter sehen in MDA den nächsten großen Fortschritt der Softwareindustrie mit folgenden Vorteilen:
- sorgfältigere Konzeption der zu erstellenden Programme
- kein Auseinanderlaufen von Modell und Code, wild hacking
- kompakte Darstellung komplexer Systeme durch Modelle auf einer hohen Abstraktionsebene
- rapide Adaptierung an neue Technologien
- nahtlose Integration zwischen Werkzeugen unterschiedlicher Hersteller
- effiziente Kommunikation mit dem Kunden
- automatische Generierung beschleunigt den Entwicklungsprozess
- einheitliche Architektur für verschiedene Plattformen

## Probleme

Neben diesen Vorteilen trifft MDA auch auf Skepsis, insbesondere bei folgenden Punkten:
- hohe Abstraktionsgrad
- hoher Zeitaufwand für abstrakte Definition aller Objekte und Prozesse
- wesentlich formalere Beschreibung, als für Transformation durch Menschen
- nachträglich Änderungen von Hand, ggf. inkonsistent mit Modell
- Performanz des generierten Codes
- Interoperabilität von verschiedenen Werkzeugen funktioniert nur bedingt
- Modellierung des dynamischen Verhaltens eher problematisch


# Aspect Oriented Programming (AOP)
## Cross-Cutting Concerns

# Geschäftsprozesssteuerung / Buissneses Process Management
## IT-gestützt
## Adaptive Case Management und CMMN
