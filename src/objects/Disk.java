package objects;
// we use an integer for the size, because it's easy
public class Disk {
    private int size;
    private String texture;
    public Disk(int size){
        this.size=size;
        texture=createTexture(size);
    }
    public String createTexture(int size){
        StringBuilder str= new StringBuilder();
        for (int i = 0; i < 10-size; i++) {
            str.append(" ");
        }
        str.append("[");
        for (int i=0;i<size; i++){
            str.append("=");
        }
        str.append("]");
        return str.toString();
    }

    @Override
    public String toString() {
        return texture;
    }
}
