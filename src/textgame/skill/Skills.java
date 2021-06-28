package textgame.skill;

public enum Skills {
    easyBite("Easy bite", "Bite your ass", 25, 4),
    mediumBite("Medium bite", "Bite your ass", 35, 4),
    hardBite("Hard bite", "Bite your ass", 45, 4),
    oneShot("Ваншот", "One kill", 9000, 4),
    kiss("Поцелуй", "Gay move", 1, 4);

    private final String name;
    private final String description;
    private final int damage;
    private final int usagePerFight;

    Skills(String name, String description, int damage, int usagePerFight) {
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.usagePerFight = usagePerFight;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDamage() {
        return damage;
    }

    public int getUsagePerFight() {
        return usagePerFight;
    }

}
