# File-Splitter
Uno strumento utile che da la possibilità di dividere, uno o più, file in parti e di ricomporre le parti nel file originale. 

### Varie modalità di divisione:
1. Divisione del file in più parti specificando la dimensione di ogni parte;
2. Divisione del file in più parti specificando il numero di parti;
3. Divisione del file in più parti specificando la dimensione di ogni parte e comprimendo il contenuto di ogni parte;
4. Divisione del file in più parti specificando la dimensione di ogni parte e criptando il contenuto di ogni parte.

In base al metodo di divisione scelto le parti del file avranno una specifica estensione.

### Ricomposizione del file:
Una volta scelta una delle parti del file che si vuole ricomporre il programma riesce a riconoscere quale metodo di divisione è stato usato in precedenza, mediante l'estensione, e lo ricompone con un metodo di ricomposizione specifico.

### Idea:
Tale progetto è stato assegnato agli studenti del Corso di Laurea in Informatica dell'Università degli Studi di Modena e Reggio Emilia per il corso di Programmazione ad Oggetti.
La traccia origianale [è disponibile qui.](http://didattica.agentgroup.unimore.it/wiki/images/4/48/Tesina1920.pdf)

# Installazione
### Clone repository
```console
$ git clone https://github.com/GoogleHelpMeEverytime/File-Splitter.git
```
### Open program
```console
$ java -jar File-Splitter.jar
```
