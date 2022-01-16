# Problem 6
## CUDA, Panie!

---
### Opis problemu

Zadanie polega na napisaniu programu, który przy pomocy CUDA oblicza kolejne konfiguracje (stany)
Gry w Życie (Game of Life). Program ma wczytywać konfigurację początkową podaną przez użytkownika
(tu przy testowaniu można założyć, że jest ona całkowicie losowa) i wyznaczać konfigurację GoL
po zadanych przez użytkownika N krokach czasowych. Zakładamy periodyczne warunki brzegowe.

Chciałbym, żebyście przetestowali ten program dla różnych typów pamięci, o których mówiłem
na ostatnich zajęciach. Tu już powinniśmy widzieć wyraźne różnice, z uwagi na wielokrotny
dostęp do tych samych miejsc w pamięci. Jeżeli możecie używać tego profilera, który pokazywałem,
to fajnie – w przeciwnym razie po prostu timingujcie wykonanie normalnie.

- Jeżeli ktoś chce być bardziej finezyjny, to [CUDA Dynamic Parallelism API and Principles](https://developer.nvidia.com/blog/cuda-dynamic-parallelism-api-principles/),
albo możecie zaczekać na kolejne zajęcia, na których będę mówił o streamach.
- Jeżeli ktoś chce bezpośrednio z C generować rysunki, to [stb](https://github.com/nothings/stb).