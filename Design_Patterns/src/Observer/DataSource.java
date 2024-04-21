package Observer;

public class DataSource extends Subject{
    private int value;

    public int getValue(){
        return value;
    }

    public void serValue(int value){
        this.value = value;
        notifyObservers();
    }
}
