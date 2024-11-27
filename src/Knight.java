public class Knight extends Character implements Warrior{
    private Sword sword;

    //scaling per level
    int dmgPerLevel = 4;
    int maxHpPerLevel = 20;

    //constructor for when no level is inputted
    public Knight(String name, Sword sword){
        this(name, 0, sword);
    }

    public Knight(String name, int level, Sword sword){
        //math
        this.name = name;
        this.level = level;
        this.levelProg = 0;
        this.damage = 10 + dmgPerLevel * level;
        this.maxHp = 150 + maxHpPerLevel * level;
        this.hp = maxHp;
        this.sword = sword;
        //print stats when first created the object
        this.printStats();
    }

    //print character stats
    public void printStats(){
        super.printStats();
        sword.printStats();
        System.out.println("--------------------------------------");
        System.out.println();
    }

    public void sharpenSword(){
        sword.sharpen();
    }

    @Override
    public void strike(Character target) {
        if(sword.getSharpness() < 1){
            System.out.println("Sword is too dull!");
            System.out.println();
        }else {
            int totalDamage = damage + sword.getDamage();
            System.out.println("Whoosh!");
            sword.dull(1);
            attack(target, totalDamage);
        }
    }

    @Override
    public void spinAttack(Character target) {
        if(sword.getSharpness() < 3){
            System.out.println("Sword is too dull!");
        }else{
            int totalDamage = damage + sword.getDamage();
            System.out.println("Spin Attack!");
            sword.dull(3);
            attack(target, totalDamage * 3);
        }
    }

    @Override
    public void levelUp(int lvl) {

        System.out.println(name + " levels Up!");
        level += lvl;
        this.damage = 10 + dmgPerLevel * level;
        this.maxHp = 150 + maxHpPerLevel * level;
        this.hp = maxHp;
    }

    @Override
    public void equip(Sword sword) {
        this.sword = sword;
    }

}
