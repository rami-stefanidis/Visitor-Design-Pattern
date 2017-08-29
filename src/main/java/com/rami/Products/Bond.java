package com.rami.Products;

import com.rami.visitor.Visitable;
import com.rami.visitor.Visitor;

/**
 * Created by Rami Stefanidis on 8/28/2017.
 */
public class Bond implements Visitable {

    private double price;

    public Bond(final double price) {
        this.price=price;
    }

    public double getPrice() {
        return price;
    }
    
    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
