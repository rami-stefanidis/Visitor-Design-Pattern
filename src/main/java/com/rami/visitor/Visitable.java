package com.rami.visitor;

/**
 * Created by Rami Stefanidis on 8/28/2017.
 */
public interface Visitable {

    public double accept(final Visitor visitor);
}
