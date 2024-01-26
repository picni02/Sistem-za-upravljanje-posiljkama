# **Projekat PostExpress**
Jednostavna aplikacija za praćenje pošiljki kreirana pomoću Spring Framework i Thymeleaf tehnologija.
U aplikaciji se nalaze jednostavne CRUD operacije.
Koristite IntelliJ za lakše pokretanje.

## Trenutno zastupljene funkcije
### Za sve (prijavljeni i neprijavljeni korisnici): 
- Kreiranje korisničkog profila na path-u [/registration](http://localhost:8000/registracija).
- Prikaz početne stranice: forma za unos broja pošiljke, kao i dugmad za navigaciju i logout [/](http://localhost:8000/).
- Prikaz statusa pošiljke na [/posiljka/{idposiljke}](http://localhost:8000/posiljka/1).
- Prikaz detalja o korisniku [/profile](http://localhost:8000/profile).

### Samo za radnike (DOSTAVLJAC):
- Prikaz detalja o korisniku [/radnikProfile](http://localhost:8000//radnikProfile)
- Dodavanje novih pošiljki kao i prikaz istih [/radnikPanel](http://localhost:8000/radnikPanel).

### Samo za admin (ADMIN): 
- Prikaz detalja o korisniku [/radnikProfile](http://localhost:8000//radnikProfile)
- Dodavanje novih okruga [/adminpanel](http://localhost:8000//adminpanel)
- Dodavanje novih lokacija [/adminpanel](http://localhost:8000//adminpanel)
- Dodavanje novih vozila [/adminpanel](http://localhost:8000//adminpanel)
- Prikaz svih okruga filijale [/adminpanel](http://localhost:8000//adminpanel)
- Prikaz svih lokacija [/adminpanel](http://localhost:8000//adminpanel)
- Prikaz svih vozila filijale [/adminpanel](http://localhost:8000//adminpanel)

### Samo za admin (SUPERADMIN): 
- Prikaz detalja o korisniku [/radnikProfile](http://localhost:8000//radnikProfile)

# Napomena
Pošto je moguće registrovati se samo kao user ili korisnik ja sam ručno dodao u bazu:
- jednog dostavljača sa pristupnim podacima : username: adem.spahic@postexpress.ba , password: dostavljac
- jednog admina sa pristupnim podacima : username: amer.delic@postexpress.ba , password: admin
jednog superadmina sa pristupnim podacima : username: superadmin@postexpress.ba , password: superadmin
Osim toga kreiran je i jedan user koji se također može dodati putem registracijske forme i njegovi pristupni podaci su : username: mehomehic@gmail.com , password: meho1234

## Konfiguracija
Prije pokretanja same aplikacije potrebno je izvršiti prilagodbu određenih podataka u `application.properties` fajlu.

```properties
## Database connection ##
spring.datasource.url=jdbc:mysql://localhost:3306/ris_250?createDatabaseIfNotExist=true tj. ("vaša putanja/ris_250?createDatabaseIfNotExist=true")
spring.datasource.username= "vaš username za pristup bazi"
spring.datasource.password= "vaš password za pristup bazi"

Bazu ris_250 možete kreirati ukoliko pokrenete kod iz fajla ris_250.sql koji se nalazi u folderu.
Također potrebno je na opciji Database s desne strane dodati konekciju sa bazom i tu također unosite ove podatke iznad."# Sistem-za-upravljanje-posiljkama" 
