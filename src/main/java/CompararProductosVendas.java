import java.util.Comparator;

public class CompararProductosVendas implements Comparator<Producto> {

    public int compare(Producto p1,Producto p2){
        if(p1.getNumVendas()>p2.getNumVendas()) {
            return -1;
        }
        else if (p1.getNumVendas()==p2.getNumVendas()){
            return 0;
        }
        else{
            return 1;
        }
    }
}