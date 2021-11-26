# Problem 3
## Wejście, wyjście i tym podobne sprawy

---
### Opis problemu

Pod adresem www.if.pw.edu.pl/~mrow/dyd/wdprir znajduje się strona internetowa - moje najwybitniejsze dzieło.
Program ma wchodzić na tę stronę i parsować ją, znajdując linki do wszystkich zdjęć w formacie PNG.
Te linki mają być wczytywane na bieżąco przez program, a nie zakodowane na sztywno. Jeżeli ktoś ma zacięcie
masochistyczne, to można ściągać programowo stronę i parsować ją przy pomocy wyrażeń regularnych. Wszystkim
innym polecam bibliotekę jsoup. Dokumentacja zawiera kilka przykładowych fragmentów kodu pokazujących, jak
wszystko zrobić. Następnie program ma ściągać te wszystkie obrazki sekwencyjnie (hint: URL, ImageIO - w
szczególności ImageIO.read itp., BufferedImage), zapisywać na dysku do osobnych plików i mierzyć łączny czas
tej operacji. To samo powtórzyć, ale ściąganie i zapisywanie ma się odbywać w osobnych wątkach,
np. przy pomocy puli wątków. W kolejnym kroku należy napisać funkcję, która przepuszcza obrazek przez filtr
rozmycia gaussowskiego w postaci macierzy 3x3. Dwa pierwsze eksperymenty należy powtórzyć, przepuszczając
każdy obrazek przez rozmycie gaussowskie przed zapisem.

