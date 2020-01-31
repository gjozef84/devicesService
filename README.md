### Uruchamianie projektu

Aby uruchomić projekt należy:
- postawić kontenter z bazą danych PostgreSQL:
```
docker-compose up
```

- zbudować oraz uruchomić aplikację:
```
./mvnw clean install && ./mvnw spring-boot:run
```

### Testy jednostkowe

Domyślnie reaktor mavenowy zawiera testy jednostkowe uruchamiane przez `maven-surefire-plugin`.

Do omijania testów jednostkowych surefire plugin posiada flagę 
**-DskipTests**

W konfiguracji mavenowej został dołączony i skonfigurowany plugin `jacoco` sprawdzający czy kod został odpowiednio pokryty testami, tzw. coverage.

###  Checkstyle
W konfiguracji mavenowej został dołączony plugin checkstyle.

### Dane testowe
Aplikacja domyślnie ładuje do bazy dane testowe umieszczone w pliku `data.sql`

### Autoryzacja
Każda ścieżka w aplikacji wymaga autoryzacji. Aby wywołać zabezpieczoną usługę należy się zalogować. Domyślnie ustawiono poniższe credenciale:
```
login: admin
hasło: admin
```

### Endpointy
Każdy endpoint jest opisany za pomocą swaggera. Po uruchomieniu aplikacji dostęp do Swaggera znajduje się pod adresem `http://localhost:8080/swagger-ui.html#/`
Endpointy zawierają tagi, które grupują zasoby.
