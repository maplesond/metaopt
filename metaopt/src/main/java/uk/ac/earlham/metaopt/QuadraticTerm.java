/*
 * Phylogenetics Tool suite
 * Copyright (C) 2013  UEA CMP Phylogenetics Group
 *
 * This program is free software: you can redistribute it and/or modify it under the term of the GNU General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */

package uk.ac.earlham.metaopt;

/**
 * Created with IntelliJ IDEA.
 * User: dan
 * Date: 20/10/13
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class QuadraticTerm {

    private double coefficient;
    private Variable variable1;
    private Variable variable2;


    public QuadraticTerm(double coefficient, Variable variable1, Variable variable2) {
        this.coefficient = coefficient;
        this.variable1 = variable1;
        this.variable2 = variable2;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public Variable getVariable1() {
        return variable1;
    }

    public Variable getVariable2() {
        return variable2;
    }
}
