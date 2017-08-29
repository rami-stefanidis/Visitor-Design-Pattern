package com.rami.visitor;

import com.rami.Products.Bond;
import com.rami.Products.Investment;
import com.rami.Products.Stock;

/**
 * Created by Rami Stefanidis on 8/28/2017.
 */
public interface Visitor {

    public double visit(final Bond bond);
    public double visit(final Stock stock);
    public double visit(final Investment investment);

}
