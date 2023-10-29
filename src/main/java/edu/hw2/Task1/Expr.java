package edu.hw2.Task1;

public sealed interface Expr {
    double evaluate();

    record Constant(double x) implements Expr {
        public Constant(Expr a) {
            this(a.evaluate());
        }

        @Override
        public double evaluate() {
            return this.x();
        }
    }

    record Negate(double x) implements Expr {
        public Negate(Expr a) {
            this(a.evaluate());
        }

        @Override
        public double evaluate() {
            return -this.x();
        }
    }

    record Exponent(double base, double exponent) implements Expr {
        public Exponent(Expr base, Expr exponent) {
            this(base.evaluate(), exponent.evaluate());
        }

        public Exponent(double base, Expr exponent) {
            this(base, exponent.evaluate());
        }

        public Exponent(Expr base, double exponent) {
            this(base.evaluate(), exponent);
        }

        @Override
        public double evaluate() {
            return Math.pow(this.base, this.exponent);
        }
    }

    record Addition(double a, double b) implements Expr {
        public Addition(Expr a, Expr b) {
            this(a.evaluate(), b.evaluate());
        }

        public Addition(double a, Expr b) {
            this(a, b.evaluate());
        }

        public Addition(Expr a, double b) {
            this(a.evaluate(), b);
        }

        @Override
        public double evaluate() {
            return this.a + this.b;
        }
    }

    record Multiplication(double a, double b) implements Expr {
        public Multiplication(Expr a, Expr b) {
            this(a.evaluate(), b.evaluate());
        }

        public Multiplication(double a, Expr b) {
            this(a, b.evaluate());
        }

        public Multiplication(Expr a, double b) {
            this(a.evaluate(), b);
        }

        @Override
        public double evaluate() {
            return this.a * this.b;
        }
    }
}
