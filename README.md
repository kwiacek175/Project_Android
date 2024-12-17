# Tax Calculator

Aplikacja Tax Calculator umożliwia obliczanie różnych rodzajów podatków oraz kalkulację rat kredytów. Składa się z kilku aktywności, które pozwalają na:

- Kalkulację EMIs (rat kredytów)
- Kalkulację podatku dochodowego
- Rejestrację i logowanie użytkowników

## Technologie

Aplikacja jest napisana w języku Kotlin z wykorzystaniem Android SDK.

## Struktura projektu

Projekt zawiera następujące pliki:

### 1. **Database.kt**  
Plik odpowiedzialny za obsługę bazy danych SQLite, przechowujący dane użytkowników oraz ich dane logowania.

### 2. **LoginActivity.kt**  
Ekran logowania, który umożliwia użytkownikowi logowanie się za pomocą danych zapisanych w bazie danych.

### 3. **RegistrationActivity.kt**  
Ekran rejestracji, który pozwala na tworzenie nowych kont użytkowników. Użytkownicy muszą zaakceptować warunki użytkowania przed rejestracją.

### 4. **HomeActivity.kt**  
Główny ekran aplikacji, z którego użytkownik może przejść do różnych funkcji aplikacji, takich jak kalkulatory czy zarządzanie kontem.

### 5. **EMICalculatorActivity.kt**  
Aktywność kalkulatora EMI (Equated Monthly Installment), która pozwala obliczyć raty kredytu na podstawie kwoty pożyczki, oprocentowania, okresu kredytowania i opłat dodatkowych.

### 6. **IncomeTaxCalculatorActivity.kt**  
Aktywność kalkulatora podatku dochodowego, która umożliwia obliczenie podatku na podstawie dochodu, stawki podatkowej, ulg podatkowych na dzieci oraz osoby zależne.

## Instrukcja instalacji

Aby uruchomić projekt na swoim urządzeniu lokalnym, wykonaj poniższe kroki:

1. Sklonuj repozytorium:
    ```bash
    git clone https://github.com/<twoje-nazwa-uzytkownika>/Tax_Calculator.git
    ```

2. Otwórz projekt w Android Studio.

3. Zbuduj i uruchom aplikację na urządzeniu lub emulatorze Android.

## Zawartość

Aplikacja składa się z następujących funkcji:

- **Kalkulator EMI (EMICalculatorActivity):**  
  Użytkownicy mogą wprowadzić kwotę pożyczki, oprocentowanie, okres kredytowania oraz opłaty dodatkowe, aby obliczyć wysokość miesięcznej raty kredytu.

- **Kalkulator podatku dochodowego (IncomeTaxCalculatorActivity):**  
  Użytkownicy mogą obliczyć podatek dochodowy na podstawie swoich dochodów, stawki podatkowej oraz ulg podatkowych na dzieci i osoby zależne.

- **Rejestracja i logowanie (RegistrationActivity, LoginActivity):**  
  Użytkownicy mogą zarejestrować się, a następnie zalogować się do aplikacji, aby zapisać swoje dane.

## Przykładowe widoki

### Ekran kalkulatora EMI
- Użytkownik wprowadza kwotę pożyczki, oprocentowanie, okres kredytowania i opłaty dodatkowe.
- Aplikacja oblicza miesięczną ratę kredytu oraz całkowitą kwotę do zapłaty.

### Ekran kalkulatora podatku dochodowego
- Użytkownik wprowadza swoje dochody oraz wybiera stawkę podatkową.
- Aplikacja oblicza kwotę podatku dochodowego, uwzględniając ulgi na dzieci i osoby zależne.

### Ekran logowania i rejestracji
- Użytkownik może się zalogować na istniejące konto lub zarejestrować nowe, podając dane, takie jak nazwa użytkownika, hasło, e-mail oraz numer telefonu.

## Wykorzystane technologie

- **Kotlin:** Język programowania do tworzenia aplikacji Android.
- **SQLite:** Baza danych do przechowywania danych użytkowników.
- **Android SDK:** Zestaw narzędzi do tworzenia aplikacji na Androida.

## Licencja

Projekt jest dostępny na licencji MIT. Zobacz plik LICENSE, aby uzyskać szczegóły.
