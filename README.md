# drones-on-cartesian-map

## Architecture 

For this project I use an Object Oriented Programing(OOP) paradigm with Java as a language,
 I also use [lombok library](https://projectlombok.org/setup/gradle) to facilitate the POJOs management.
 
As a conceptual project organization I used [Domain Driven Design](https://es.wikipedia.org/wiki/Dise%C3%B1o_guiado_por_el_dominio)
applying some strategical and tactical techniques.

Furthermore, for the tactical approach I use Hexagonal Architecture.     

![alt text](https://github.com/jhon0010/drones-on-cartesian-map/blob/master/docs/images/HexagonalArchitecture.png)


## Used Design Patterns

### Command
 
 Used for create an abstraction of Commands that are each letter in each line of the input file.

 ***
 
### Repository 

In memory implementation of repository.
 ***

### Factory

To get the correct instance of command given a char that id the identifier of this command in the input file.
 ***

### Builder

With the help of lombok library, each domain object can be built itself, and the external objects can use the builder method. 
 ***

## Test

For test library I choose [Spock Framework](http://spockframework.org/). 
