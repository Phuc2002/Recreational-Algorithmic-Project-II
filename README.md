# Recreational Algorithmic Project II
## Solve the Metric Traveling Salesman Problem

Given various dataset containing city's coordination, find the minimum Halmiltonian path (i.e. a closed tour passing each city once with the least cost of distance). The project currently supports basic Graph DS Adjacency Matrix and Adjacency List and implements 2-Approximation Algorithm and heuristic Nearest Neighbor Algorithm, with the use of JavaFX GUI. 

The focus of the project is on OOP principles and MVC paradigm in software development as well as complexity.

This is the second project with the idea/theme of exploring the interconnection between CS and other creative discliplines such as art, music, game, etc... (hence the name "recreational"!) using algorithm (hence the name "algorithmic"!).

This is also the second final project for COMP1405/6 combined accelerated course "Intro to CS".

## Specification
- Java JDK 15.0.1
- JavaFX SDK 15.0.1
- IntelliJ IDE 2020.2.3

## Notes
- run Main in App package
- for large dataset, rerun the project to avoid out-of-memory error... or you don't need to because you know how to increase the memory limit of JVM or you just happen to have a warehouse of memory
- detailed analysis is in the project report

## Extension or Any Updates
- implement more algorithms to solve (e.g. 2-Approximation can be reduced to 3/2, etc. ...)
- implement a Graph DS that doesn't cost memory (I'm thinking Linked List would be sufficient, doesn't have to build an entire complete graph)
