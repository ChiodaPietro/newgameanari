package objects;

import java.util.Vector;

public class Pile<G> {
    Vector<G> tower;
    public Pile(int height){
        tower=new Vector<>(height);
    }
    public boolean push(G g){
        if(tower.capacity()>tower.size()){
            tower.add(g);
            return true;
        }
        return false;
    }
    public G pop(){
        return tower.remove(tower.size()-1);
    }
    public int getSize(){
        return tower.size();
    }
    public G getLastElement(){
        return tower.get(tower.size()-1);
    }
    public G getFirstElement(){
        return tower.get(0);
    }
    public int getCapacity(){
        return tower.capacity();
    }
    public G get(int index){
        return tower.get(index);
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        for (int i = tower.size()-1; i >=0; i--) {
            try {
                str.append(tower.get(i).toString() + "\n");
            }catch (Exception e){
                str.append("\n");
            }
        }
        return str.toString();
    }
}
