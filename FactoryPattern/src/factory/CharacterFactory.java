package FactoryPattern.src.factory;

public class CharacterFactory {
    public Character createCharacter(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        switch (type.toLowerCase()) {
            case "warrior":
                return new Warrior();
            case "mage":
                return new Mage();
            case "archer":
                return new Archer();
            default:
                throw new IllegalArgumentException("Unknown character type " + type);
        }
    }
}
