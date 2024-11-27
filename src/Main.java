public class Main {
    public static void main(String[] args) {
        GreatSword greatsword1 = new GreatSword("jung");
        ShortBow shortbow1 = new ShortBow("bobobobob");

        Knight Fluke = new Knight("Fluke6655", 48, greatsword1);
        Ranger Kiw = new Ranger("rainny888", 50, shortbow1);

        Kiw.shoot(Fluke);
        shortbow1.upgrade(3);
        Kiw.shoot(Fluke);
        Kiw.arrowRain(Fluke);
        Kiw.printStats();
        Kiw.arrowRain(Fluke);
        Kiw.refillArrows();
        Kiw.printStats();


        greatsword1.upgrade(8);
        Fluke.printStats();
        Fluke.strike(Kiw);
        Fluke.spinAttack(Kiw);
        Fluke.printStats();
        Fluke.sharpenSword();
        Fluke.printStats();

        GreatSword greatsword2 = new GreatSword("jingjing");
        Fluke.equip(greatsword2);
        Fluke.printStats();


    }
}