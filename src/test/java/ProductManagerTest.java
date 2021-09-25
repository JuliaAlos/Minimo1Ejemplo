import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class ProductManagerTest {
    HashMap<String,Cliente> clientes = new HashMap<>();

    @After


    @Before
    public void settup() {
        clientes.put("Julia",new cliente("Julia"));
        clientes.put("Paco",new cliente("Paco"));
        clientes.put("Lorena",new cliente("Lorena"));
    }

    @Test
    public void testSuma(){
        Assert.assertEquals(6, this.v[0].area(), 0);
        Assert.assertEquals(3.14, this.v[1].area(), 0);
        Assert.assertEquals(4, this.v[2].area(), 0);
        Assert.assertEquals(3, this.v[3].area(), 0);
        Assert.assertEquals(16.14, GestorFiguras.suma(this.v),0);
    }

    @Test
    public void testSort(){
        GestorFiguras.sort(this.v);
        Assert.assertEquals(3,this.v[0].area(),0);

    }

}
