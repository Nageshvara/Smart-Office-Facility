# Structural Design Patterns

Structural design patterns deal with object composition, focusing on how classes and objects can be composed to form larger structures. Here are two examples of structural design patterns:

## 1. Adapter Pattern in Cricket Score Display

### Pattern Explanation:
The Adapter pattern allows the interface of an existing class to be used as another interface. It is often used to make existing classes work with others without modifying their source code.

### Use Case:
Different score providers in cricket have varying data formats. The Adapter pattern is used to convert various formats to a unified format for the scoreboard. This enables the scoreboard to display scores consistently, regardless of the data provider's format.

## 2. Composite Pattern in Gaming Inventory System

### Pattern Explanation:
The Composite pattern allows you to compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.

### Use Case:
In a game, there is a complex inventory system with nested items (e.g., bags containing weapons and potions). The Composite pattern is used to represent the inventory hierarchy. This allows the game to manage and display the inventory in a structured way, treating both individual items and groups of items uniformly.
