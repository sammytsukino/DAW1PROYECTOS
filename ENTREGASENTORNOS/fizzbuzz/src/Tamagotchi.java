public class Tamagotchi {
    private int hunger = 4;
    private int energy = 4;
    private int mood = 4;

    public Tamagotchi(int hunger, int energy, int mood) {
        this.hunger = hunger;
        this.energy = energy;
        this.mood = mood;
    }

    public int getHunger() {
        return hunger;
    }

    public int getEnergy() {
        return energy;
    }

    public int getMood() {
        return mood;
    }

    public void showStatus() {
        if (mood >= 8) {
            System.out.println(":-)");
        } else if (energy <= 3) {
            System.out.println("(-_-)");
        } else if (energy == 0) {
            System.out.println("(-_-) zZZ");
        } else if (mood <= 2) {
            System.out.println("o_o");
        } else {
            System.out.println(":-|");
        }
    }

    public void play() {
        hunger++;
        mood++;
        energy--;
        showStatus();
    }

    public void eat(){
        hunger= hunger-2; energy--;
        showStatus();
    }

    public void sleep(){
        energy= energy+2;
        showStatus();
    }

    public static void main(String[] args) {
        Tamagotchi tamagotchi = new Tamagotchi(4, 4,4);

        System.out.println("¿Cómo está nuestro Tamagotchi?");
        tamagotchi.showStatus();
        System.out.println("¿Jugamos");
        tamagotchi.play();
        System.out.println("Vamos a comer");
        tamagotchi.eat();
        System.out.println("Vamos a dormir");
        tamagotchi.sleep();
        System.out.println("¿Cómo está nuestro Tamagotchi al final del día?");
        tamagotchi.showStatus();

    }

}

