public class Cat extends Animal{
    public Cat(String n) {
        super(n);
    }
    public void chase(Mouse m) {
        System.out.println(getName() + " Catches " + m.getName());
    }

    @Override
    public int getRunSpeed() {
        return 10;
    }

    @Override
    public String getMyName() {
        return getName();
    }
}
