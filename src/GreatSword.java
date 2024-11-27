public class GreatSword implements Sword{
    String name;
    private int damage;
    private int level = 1;

    private int sharpness;

    public GreatSword(String name){
        this.name = name;
        this.damage = 10 + level * 10;
        this.sharpness = 5;
    }

    @Override
    public void upgrade(int level) {
        System.out.println(name + " was upgraded!");
        this.level += level;
        damage = damage + (level * 10);
        this.sharpness = 5 + level * 2;
        this.printStats();
    }

    @Override
    public void printStats() {
        System.out.println(name + " | GreatSword"+"*"+level + " damage: " + damage);
        System.out.println(name + " | GreatSword"+"*"+level + " sharpness: " + sharpness);
        System.out.println();
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getSharpness() {
        return sharpness;
    }

    @Override
    public void sharpen(){
        sharpness = 5 + level * 2;
    }

    @Override
    public void dull(int nums) {
        sharpness-=nums;
    }

}
