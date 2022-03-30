public class Ammo extends Item {

    private int ammo;

    public Ammo(String name, int ammunition){
        super(name);
        this.ammo = ammunition;
    }

    public int getAmmo(){
        return ammo;
    }

    @Override
    public String toString() {
        return ammo + " Ammo";

    }
}
