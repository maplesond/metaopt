/*
 * Phylogenetics Tool suite
 * Copyright (C) 2017  UEA CMP Phylogenetics Group
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public
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


public interface Optimiser {

    /**
     * Given a problem, finds the solution.
     *
     * @param problem A description of the problem to solve
     * @return A solution to the problem that was posed.
     * @throws OptimiserException Thrown if any problems are encountered
     */
    Solution optimise(Problem problem) throws OptimiserException;

    /**
     * The identifier with which the user can locate this optimiser
     *
     * @return An identifier that can be used to locate this optimiser
     */
    String getIdentifier();

    /**
     * Whether or not this optimiser recognises the given id.
     *
     * @param id An identifier describing the optimiser to use
     * @return True if this optimiser recognises the identifier, false otherwise.
     */
    boolean acceptsIdentifier(String id);

    /**
     * Whether or not this optimiser can process a certain kind of objective.  i.e. linear or quadratic objectives
     *
     * @param objectiveType The objective type to check with this optimiser.
     * @return True, if this optimiser can accept this objective type, false otherwise.
     */
    boolean acceptsObjectiveType(Objective.ObjectiveType objectiveType);

    /**
     * Whether or not this optimiser can process a certain kind of constraint.  i.e. linear or quadratic constraints
     *
     * @param constraintType The constraint type to check with this optimiser
     * @return True, if this optimiser can accept this constraint type, false otherwise.
     */
    boolean acceptsConstraintType(Constraint.ConstraintType constraintType);


    /**
     * Whether or not this optimiser can process a certain kind of variable.  i.e. continuous, float or binary
     * @param variableType The variable type to check with this optimiser.
     * @return True if this optimiser accepts this variable type, false otherwise.
     */
    boolean acceptsVariableType(Variable.VariableType variableType);


    /**
     * Whether or not this optimiser is currently operational.  This is useful for optimisers that are external to phygen,
     * in order to ensure the necessary links are in place so that phygen can access the functions of the optimiser.
     *
     * @return True if this optimiser seems to be operational, false otherwise.
     */
    boolean isOperational();
}
