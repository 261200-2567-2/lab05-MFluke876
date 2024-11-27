public abstract class Character{
    //default stats
    protected String name;
    protected int level;
    protected int levelProg;
    protected int damage;
    protected int hp;
    protected int maxHp;
    protected boolean alive = true;


    public void printStats() {
        System.out.println("---------" + name + "'s stats----------");
        System.out.println("Level: " + level);
        System.out.println("Level Progress: " + levelProg + "/100");
        System.out.println("Damage: " + damage);
        System.out.println("HP: " + hp + "/" + maxHp);
        System.out.println("Status: " + (alive ? "alive" : "dead"));
    }

    public abstract void levelUp(int lvl);
    public void getExperience(Character target){
        //get difference in level
        int difference = Math.abs(target.level - level);
        int levelGain =0;
        int progress;

        //if same level get 1 level
        if(target.level == level){
            progress = 100;
        }else if(target.level > level){ //if target is higher level, killer get more exp
            //exp = half of the difference in level
            levelGain = (int)(difference * 0.5);

            //excess lvl go to progress bar
            progress = ((int)(difference * 0.5 * 100)) % 100;
        }else{
            //lower target level means less exp = 1/difference to the progress bar
            progress = (int)((1.0 / difference) * 100);
        }

        //if whole number then increment level
        if(levelGain > 0){
            levelUp(levelGain);
        }

        //if added to progressBar equals more than 100 level up
        if(levelProg + progress >= 100){
            levelUp(1);

            //excess exp go towards new bar
            levelProg = (levelProg+progress)%100;
        }else{
            levelProg = levelProg+progress;
        }
    }

    public void attack(Character target, int damage){
        //if target already dead
        if(!target.alive) {
            System.out.println(target.name + " is dead");
            System.out.println();
            return;
        }

        //if user is not dead else
        if(alive){
            System.out.println(name + " attacks " + target.name + "!");


            target.hp -= damage;

            //print info
            System.out.println("-"+damage+"!");
            System.out.println(target.name + " HP: " + target.hp + "/" + target.maxHp);

            //if target takes fatal dmg, they die and killer get exp
            if(target.hp <= 0) {
                target.alive = false;
                System.out.println(target.name + " died!");
                getExperience(target);
            }
            System.out.println();
        }else{
            System.out.println(name + " is dead");
            System.out.println();
        }
    }
}
