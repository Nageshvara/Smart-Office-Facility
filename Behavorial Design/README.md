# Behavioral Design Patterns

Behavioral design patterns are concerned with algorithms and the assignment of responsibilities between objects. These patterns help to define how objects interact and communicate with each other. Here are two examples of behavioral design patterns:

## 1. Observer Pattern in Cricket Score Update System

### Pattern Explanation:
The Observer pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. This pattern is used to create a subscription mechanism to allow multiple objects to listen to and react to events or state changes in another object.

### Use Case:
In a cricket match, a scoreboard and various subscriber apps (like mobile apps, websites) need real-time updates. The scoreboard acts as the subject, while mobile apps and websites act as observers. When the score changes, all observers are notified and updated with the new score.

## 2. Strategy Pattern in Game AI

### Pattern Explanation:
The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. The strategy pattern lets the algorithm vary independently from the clients that use it. This is useful in situations where a class has multiple behaviors, which can be chosen at runtime.

### Use Case:
In a strategy game, players can select different AI difficulty levels (easy, medium, hard). The game AI can switch between strategies during gameplay based on player performance. This allows the game to adapt the AI's behavior dynamically, making the game more challenging and engaging for players.
