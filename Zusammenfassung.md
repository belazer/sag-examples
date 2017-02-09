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
## Data Transfer Object
## Frontend Controller
## Application Service
## Service Facade
## Data Access Object / Integration Service
## Persistent Anemic Object / Entity Object

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
## Computation Independent Model
## Platform Independent Model
## Platform Specific Model
## Implementation specific Model

# Aspect Oriented Programming (AOP)
## Cross-Cutting Concerns

# Geschäftsprozesssteuerung / Buissneses Process Management
## IT-gestützt
## Adaptive Case Management und CMMN
