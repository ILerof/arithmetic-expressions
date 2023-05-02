package com.epam.rd.autotasks.arithmeticexpressions;

import java.util.StringJoiner;

public class Expressions {

    public static Variable var(String name, int value) {
        return new Variable(name, value);
    }

    public static Expression val(int value) {
        Expression exp = new Expression() {
            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                return value>0?value+"":"("+value+")";
            }
        };
        return exp;
    }

    public static Expression sum(Expression... members){
        Expression exp = new Expression() {
            @Override
            public int evaluate() {
                int sum = 0;
                for (Expression exps: members) {
                    sum += exps.evaluate();
                }
                return sum;
            }

            @Override
            public String toExpressionString() {
                String string = "(";
                for (int i = 0; i < members.length; i++) {
                    if (i == members.length-1){
                        string += members[i].toExpressionString();
                    } else {
                        string += members[i].toExpressionString() + " + ";
                    }
                }
                return string+")";
            }
        };
        return exp;
    }

    public static Expression product(Expression... members){
        Expression exp = new Expression() {
            @Override
            public int evaluate() {
                int product = 1;
                for (Expression exps: members) {
                    product *= exps.evaluate();
                }
                return product;
            }

            @Override
            public String toExpressionString() {
                String string = "(";
                for (int i = 0; i < members.length; i++) {
                    if (i == members.length-1){
                        string += members[i].toExpressionString();
                    } else {
                        string += members[i].toExpressionString() + " * ";
                    }
                }
                return string+")";
            }
        };
        return exp;
    }

    public static Expression difference(Expression minuend, Expression subtrahend){
        Expression exp = new Expression() {
            @Override
            public int evaluate() {
                return minuend.evaluate()-subtrahend.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "("+minuend.toExpressionString()+" - "+ subtrahend.toExpressionString()+")";
            }
        };
        return exp;
    }

    public static Expression fraction(Expression dividend, Expression divisor){
        //implement this method
        Expression exp = new Expression() {
            @Override
            public int evaluate() {
                return dividend.evaluate()/divisor.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "("+dividend.toExpressionString()+" / "+ divisor.toExpressionString()+")";
            }
        };
        return exp;
    }

}