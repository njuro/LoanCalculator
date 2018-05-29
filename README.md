# Loan Calculator
Pohovorová úloha pre *Lundegaard* - kalkulačka na výpočet výšky mesačnej splátky.

Živá ukážka na <http://loan-calculator.tk>

## Zadanie 
> **Vytvoř online kalkulačku, která vypočte výši splátky na základě vstupních parametrů.**
> * součástí odevzdaného příkladu bude 
>   * popis architektury aplikace + popis kódu
>   * odevzdání kódu v Bitbucket/GitHubu
>   * funkční ukázka aplikace + prezentace hotového kódu
> * k tvorbě front-endu (FE) vyber libovolný JS framework + back-end (BE) bude napsán v Javě
> * bude použito REST rozhranní mezi FE a BE
> * stylování nemusí být nutně přesně dodrženo, není třeba řešit další odkazy z aplikace
> * vzorec pro výpočet není důležitým faktorem příkladu, použijte Google

## Opis kalkulačky
Kalkulačka má 2 vstupy, *Loan Amount*, čiže suma v Kč, označujúca výšku pôžičky a *Loan Period*, dĺžka pôžičky v mesiacoch. Pomocou týchto údajov
a fixnej ročnej úrokovej miery vyjadrenej v percentách sa podľa vzorca vypočíta výška jednej mesačnej splátky, ktorá je potom prezentovaná uživateľovi.

## Technické riešenie
### Backend
Backend (zložka *server*) je písaný v jazyku Java za použitia frameworku *Spring Boot*, vhodného pre rapídne prototypovanie aplikácii. Backend svoju funkcionalitu zdieľa cez REST API endpoint.

### Frontend
Frontend (zložka *client*) je vytvorený v TypeScripte pomocou platformy *Angular 6*, použité UI komponenty sú zo sady *Angular Material 2* a sú prispôsobené aj na prezeranie na mobilných zariadeniach. S backendom komunikuje pomocou asynchrónnych HTTP dotazov na API endpointy.

### Deploy
Backend aj frontend sú deploynuté na VPS, na ktorom beží Ubuntu 18.04. Backend beží v pozadí ako spustiteľný java archív (.jar) vytvorený nástrojom Maven, statické súbory vygenerované Angularom sú zas umiestnené na HTTP serveri Nginx.

## Screenshot aplikácie
![Screenshot kalkulačky](https://i.imgur.com/wcCWVX4.png "Screenshot kalkulačky")
