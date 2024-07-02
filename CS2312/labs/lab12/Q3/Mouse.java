public class Mouse extends Animal{
    public Mouse(String n) {
        super(n);
    }

    @Override
    public int getRunSpeed() {
        return 5;
    }

    @Override
    public String getMyName() {
        return getName();
    }
    
}
