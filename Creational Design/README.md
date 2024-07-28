# Creational Design Patterns

Creational design patterns deal with object creation mechanisms, trying to create objects in a manner suitable for the situation. Here are two examples of creational design patterns:

## 1. Singleton Pattern in Cricket Umpire Decision System

### Pattern Explanation:
The Singleton pattern ensures that a class has only one instance and provides a global point of access to it. This is useful in scenarios where exactly one object is needed to coordinate actions across the system.

### Use Case:
The Decision Review System (DRS) in cricket should have a single instance to ensure consistent decisions. By using the Singleton pattern, we ensure that only one instance of the DRS is created and used throughout the match, maintaining consistency and reliability in umpire decisions.

## 2. Factory Pattern in Game Character Creation

### Pattern Explanation:
The Factory pattern defines an interface for creating an object but lets subclasses alter the type of objects that will be created. This pattern is used to instantiate objects without exposing the creation logic to the client and refers to the newly created object through a common interface.

### Use Case:
In a game, there are various types of characters (warrior, mage, archer). The factory pattern is used to create instances of different characters based on the player's choice. This allows the game to create new characters dynamically, depending on the player's selection, without altering the client code.
