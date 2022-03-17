package DeutscheBank.Day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {

    int id;
    List<Product> products = new ArrayList<Product>();

    public void sortProduct()
    {
        Collections.sort(products);
    }
}

