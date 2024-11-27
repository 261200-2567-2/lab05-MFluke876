public class ShortBow implements Bow{
    String name;
    private int damage;
    private int level = 1;

    private int arrowCount;

    public ShortBow(String name){
        this.name = name;
        this.damage = 4 + level * 8;
        this.arrowCount = 10;
    }

    @Override
    public void upgrade(int level) {
        System.out.println(name + " was upgraded!");
        this.level += level;
        damage = damage + (level * 8);
        arrowCount = arrowCount + level * 10;
        this.printStats();

    }

    @Override
    public void printStats() {
        System.out.println(name + " | ShortBow"+"*"+level + " damage: " + damage);
        System.out.println(name + " | ShortBow"+"*"+level + " arrow count: " + arrowCount);
        System.out.println();
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getArrow() {
        return arrowCount;
    }

    @Override
    public void refill() {
        arrowCount = arrowCount + level * 10;
    }

    @Override
    public void shot(int nums) {
        arrowCount-=nums;
    }
}
