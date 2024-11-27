public class Ranger extends Character implements Archer{
    private Bow bow;

    //scaling per level
    int dmgPerLevel = 2;
    int maxHpPerLevel = 15;

    //constructor for when no level is inputted
    public Ranger(String name, Bow bow){
        this(name, 0, bow);
    }

    public Ranger(String name, int level, Bow bow){
        //math
        this.name = name;
        this.level = level;
        this.levelProg = 0;
        this.damage = 10 + dmgPerLevel * level;
        this.maxHp = 150 + maxHpPerLevel * level;
        this.hp = maxHp;
        this.bow = bow;
        //print stats when first created the object
        this.printStats();
    }

    //print character stats
    public void printStats(){
        super.printStats();
        bow.printStats();
        System.out.println("--------------------------------------");
        System.out.println();
    }

    public void refillArrows(){
        bow.refill();
    }

    @Override
    public void shoot(Character target) {
        if(bow.getArrow() < 1){
            System.out.println("Not enough arrow!");
            System.out.println();
        }else{
            int totalDamage = damage + bow.getDamage();
            System.out.println("Pew!");
            bow.shot(1);
            attack(target, totalDamage);
        }
    }

    @Override
    public void arrowRain(Character target) {
        if(bow.getArrow() < 20) {
            System.out.println("Not enough arrow!");
            System.out.println();
        }else{
            int totalDamage = damage + bow.getDamage();
            System.out.println("Arrow Rain!");
            bow.shot(20);
            attack(target, totalDamage * 2);
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
    public void equip(Bow bow) {
        this.bow = bow;
    }
}
