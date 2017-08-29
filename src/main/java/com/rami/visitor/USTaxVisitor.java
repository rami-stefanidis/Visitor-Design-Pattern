package com.rami.visitor;

import com.rami.Products.Bond;
import com.rami.Products.Investment;
import com.rami.Products.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;


/**
 * Created by Rami Stefanidis on 8/28/2017.
 */
@Component
public class USTaxVisitor implements Visitor {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Value("${tax.us.bond}")
    private double bondTax;

    @Value("${tax.us.stock}")
    private double stockTax;

    @Value("${tax.us.bond}")
    private double investmentTax;

    @Override
    public double visit(final Bond bond) {
        LOG.info("US Bond item: Price with Tax");
        return bond.getPrice() * bondTax + bond.getPrice();
    }

    @Override
    public double visit(final Stock stock) {
        LOG.info("US Stock item: Price with Tax");
        return stock.getPrice() * stockTax + stock.getPrice();
    }

    @Override
    public double visit(final Investment investment) {
        LOG.info("US Investment item: Price with Tax");
        return investment.getPrice() * investmentTax + investment.getPrice();
    }
}
