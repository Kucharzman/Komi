Dawid K. ; klasa 4prT5

Interfejs użytkownika w większości jest skalowany dynamicznie.
Aplikacja wyświetla się na ekranie wertykalnie.
Na ekranie wyświetlają się dwa spinnery, pole z możliwością wprowadzenia liczby całkowitej oraz dwa przyciski.

Pierwszy spinner podpisany "Miasto startowe" ma rozwijaną listę z ośmioma miastami do wyboru. Wybieramy tutaj miasto w którym chcemy zacząć trasę komiwojażera bądź miasto z którego chcemy sprawdzić dystans do drugiego miasta(wybranego w drugim spinnerze).
Drugi spinner podpisany "Miasto końcowe" ma tę samą rozwijaną listę z ośmioma miastami. Wybieramy tutaj miasto w którym komiwojażer ma zakończyć trasę, bądź miasto do którego mierzymy odległość względem tego wybranego w pierwszym spinnerze.
Pole numeryczne podpisane "Dystans" wyświetla automatycznie po zmianie miast w spinnerach dystans między jednym wybranym miastem a drugim. Pole jest edytowalne w przypadku gdybyśmy chcieli zmienić dystans między wybranymi miastami.
Po zmianie wartości w polu numerycznym "Dystans" możemy zatwierdzić nowy dystans błękitnym przyciskiem "Zatwierdź dystans" poniżej pola numerycznego.
Przycisk podpisany "Komiwojażerowanie" uruchamia algorytm Problemu Komiwojażera (ang. Travelling Salesman Problem). Algorytm szuka najkrótszej trasy z miasta wybranego w pierwszym spinnerze do miasta wybranego w drugim spinnerze, odwiedzając po drodze wszystkie pozostałe miasta. Odpowiedź -lista miast odwiedzonych po kolei wraz z dystansem- wyświetlana jest poniżej przycisku.

Zaimplementowana jest obsługa niektórych błędów oraz walidacja niektórych pól. W momencie gdy wprowadzimy błędną wartość w jakieś pole program zwróci nam informację wyświetlaną za pomocą Toast'a.