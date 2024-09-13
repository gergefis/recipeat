# Recipe app to Eat quickly  - Recipeat
- Το Project είναι demo απλώς για επίδειξη.
Η εφαρμογή Recipeat είναι μια εφαρμογή πελάτης, η οποία θα καταναλώνει τα Web Services
  της σελίδας TheMealDB σχετικά με στοιχεία γευμάτων.

## Τεχνολογίες που χρησιμοποιήθηκαν για την εκτέλεση του έργου
-- Δημιουργήθηκε με Spring Boot 3.3.0, MySQL και Maven για το BackEnd κομμάτι. Για το View επέλεξα το thymeleaf για τη δημιουργία HTML σελίδων. CSS και Bootstrap για το style. Κάποιες μικρές λειτουργικότητες με vanilla JavaScript.
  
Την επικοινωνία με τη βάση δεδομένων, για την αποθήκευση των συνταγών εφόσων ο χρήστης το επιθυμεί, επέλεξα να την υλοποιήσω με **EntityManager** (αντι του JpaRepository) περισσότερο για σκοπους προσωπικής μάθησης.

## Dependencies used:
- Spring Boot DevTools;
- Lombok;
- Spring Web (MVC);
- Spring Security;
- - Spring Data JPA;
- MySQL Driver;
- Java Mail Sender;
- Thymeleaf;

  ## Info
Η εφαρμογή παίρνει δεδομένα web services ενός [εξωτερικού ΑPI](https://themealdb.com/api.php) με συνταγές μαγειρικής.
  
Δίνει την δυνατότητα στο χρήστης να κάνει αναζήτηση με το όνομα της συνταγής, αν το γνωρίζει. 

Είτε μπορεί να διαλέξει μια κατηγορία της επιλογής του απο το drop-down menu που θα εμφανίσει τις διαθέσιμες συνταγές ανά κατηγορία.

Στη συνέχεια μπορεί να κάνει αναζήτηση με το όνομα της συνταγής που τον ενδιαφέρει.

Το themealdb.com παρέχει διάφορα δεδομένα μ’ ένα API (Application Programming Interface) τύπου REST (Representational State Transfer), 
τα οποία επιστρέφονται σε μορφή JSON (JavaScript Object Notation). 

Η εφαρμογή αναλαμβάνει να τα αντλήσει, να τα εμφανίσει στον χρήστη και να τα αποθηκεύσει σε βάση δεδομένων για περαιτέρω επεξεργασία.

Η περιγραφή των δεδομένων που μπορούν να αντληθούν από το themealdb.com  περιγράφονται στην σελίδα https://themealdb.com/api.php. 

Τα κυριότερα από αυτά είναι:
- Αναζήτηση μιας συνταγής
- Αναζήτηση κατηγοριών, όπου εμφανίζονται οι συνταγές ανα κατηγορία

## Λειτουργικότητα Εφαρμογής Recipeat:
- Ο χρήστης θα μπορεί να κάνει ελεύθερα αναζήτηση συνταγών μέσω της εφαρμογής
- Θα δίνεται όμως, επιπλέον δυνατότητα για αποθήκευση, επεξεργασία και διαγραφή μιας συνταγης απο τη βάση δεδομένων σε εγγεγραμμένους χρήστες.
- Η δυνατότητα Εγγραφής με απλό λογαριασμό θα ξεκλειδώνει περισσότερες δυνατότητες στο χρήστη
- Κάθε Συνδεδεμένος χρήστης θα μπορεί να αποθηκεύει στη βάση δεδομένων μια συνταγής της επιλογής του
- Να την τροποποιήσει και να ενημερώσει τη βάση
- Να διαγράψει κάποια συνταγή από τη βάση δεδομένων αν το επιθυμεί
  
 # How to use:
1. Clone την εφαρμογή
2. Εισαγωγή του σχήματος της βάσης δεδομένων στη MySQL - περιέχεται στο directory /resources/templates/DB/
3. Run IDE (Intellij). 
4. Στο (http://localhost:8080/) επιλέγουμε ένα γεύμα πχ: "Saganaki", "Arrabiata" κλπ. ...
5. Εμφανίζονται τα δεδομένα της συνταγής που επιλέξαμε..
6. Στην Drop-down list εμφανίζονται οι διαθέσιμες κατηγορίες
7. Επιλέγοντας μια κατηγορία εμφανίζονται τα διαθέσιμα γεύματα της κατηγορίας (τίτλοι συνταγών μόνο)
8. Υπάρχει η δυνατότητα Εγγραφής με απλό λογαριασμό για να ξεκλειδώσει περισσότερες δυνατότητες ο χρήστης

