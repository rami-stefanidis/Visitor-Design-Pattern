package com.rami;

import com.rami.Products.Bond;
import com.rami.Products.Investment;
import com.rami.Products.Stock;
import com.rami.visitor.CanadianTaxVisitor;
import com.rami.visitor.USTaxVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * Author: Rami Stefanidis
 *
 */
@SpringBootApplication
public class VisitorPatternApplication implements CommandLineRunner
{
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private USTaxVisitor usTaxVisitor;

    @Autowired
    private CanadianTaxVisitor canadianTaxVisitor;


    @Override
    public void run(String... args) {

        final Bond tBill = new Bond(100);
        final Stock ibmStock = new Stock(55.3);
        final Investment investment = new Investment(12000);

        LOG.info("============ U.S. ============");
        LOG.info("US TBill : {}"+tBill.accept(usTaxVisitor));
        LOG.info("US IBM Stock : {}"+ibmStock.accept(usTaxVisitor));
        LOG.info("US investment : {}"+investment.accept(usTaxVisitor));

        LOG.info("============ Canada ============");
        LOG.info("Canada TBill : {}"+tBill.accept(canadianTaxVisitor));
        LOG.info("Canada IBM Stock : {}"+ibmStock.accept(canadianTaxVisitor));
        LOG.info("Canada investment : {}"+investment.accept(canadianTaxVisitor));

    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(VisitorPatternApplication.class, args);
    }
}


