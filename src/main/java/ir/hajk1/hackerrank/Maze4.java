package ir.hajk1.hackerrank;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Maze4 {
    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        String widthStr = scanner.next();
        Integer width = Integer.parseInt(widthStr);
        String heightStr = scanner.next();
        Integer height = Integer.parseInt(heightStr);
        Cell[][] cells = new Cell[width][height];
        Matrix matrix = new Matrix(cells);
        for (int i = 0; i < height; i++) {
            String rowStr = scanner.next();
            char[] ch = new char[width];
            ch = rowStr.toCharArray();
            for (int j = 0; j < ch.length; j++) {
                cells[j][i] = new Cell();
                cells[j][i].setParent(matrix);
                cells[j][i].setValue(ch[j]);
                cells[j][i].setX(j);
                cells[j][i].setY(i);
            }
        }
        int result = matrix.getStart().traverse(new LinkedHashSet<Cell>());
        System.out.println(result - 1);
    }

    static class Matrix {
        private Cell[][] cells;
        private Cell start;

        public Matrix(Cell[][] cells) {
            this.cells = cells;
        }

        public Cell[][] getCells() {
            return cells;
        }

        public void setCells(Cell[][] cells) {
            this.cells = cells;
        }

        public Cell getStart() {
            return start;
        }

        public void setStart(Cell start) {
            this.start = start;
        }
    }

    static class Cell {
        int x, y;
        int value;
        boolean g, s;
        private Matrix parent;

        public Matrix getParent() {
            return parent;
        }

        public void setParent(Matrix parent) {
            this.parent = parent;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getValue() {
            return value;
        }

        public void setValue(char value) {
            if (value == ('S')) {
                setS(true);
                this.value = 1;
                getParent().setStart(this);
            } else if (value == ('G'))
                setG(true);
            else
                this.value = Character.getNumericValue(value);
        }

        public Set<Cell> getNextValidCells(Set<Cell> path) {
            Set<Cell> adjacentCells = new LinkedHashSet<>();
            System.out.println("this = " + this);
            if (x < getParent().getCells().length - 1)
                if (isTraversable(getParent().getCells()[x + 1][y]))
                    addtoAdjacentIfNotExistInPath(adjacentCells, getParent().getCells()[x + 1][y], path);
            if (x > 0)
                if (isTraversable(getParent().getCells()[x - 1][y]))
                    addtoAdjacentIfNotExistInPath(adjacentCells, getParent().getCells()[x - 1][y], path);
            if (y < getParent().getCells()[0].length - 1)
                if (isTraversable(getParent().getCells()[x][y + 1]))
                    addtoAdjacentIfNotExistInPath(adjacentCells, getParent().getCells()[x][y + 1], path);
            if (y > 0)
                if (isTraversable(getParent().getCells()[x][y - 1]))
                    addtoAdjacentIfNotExistInPath(adjacentCells, getParent().getCells()[x][y - 1], path);
            return adjacentCells;
        }

        private void addtoAdjacentIfNotExistInPath(Set<Cell> adjacentCells, Cell cell, Set<Cell> path) {
            if (!path.contains(cell)) {
                adjacentCells.add(cell);
            }
        }

        boolean isTraversable(Cell cell) {
            if (cell.getValue() == 0 || cell.isG())
                return true;
            else
                return false;
        }

        public boolean isG() {
            return g;
        }

        public void setG(boolean g) {
            this.g = g;
        }

        public boolean isS() {
            return s;
        }

        public void setS(boolean s) {
            this.s = s;
        }

        public int traverse(Set<Cell> path) {
            int shortestPath = -1;
            path.add(this);
            if (isG()) {
                System.out.println("G reached");
                return 1;
            }
            Set<Cell> set = getNextValidCells(path);
            if (set.isEmpty())
                return -1;
            for (Cell nextValidCell : set) {
                Set<Cell> newPath = new LinkedHashSet<>();
                newPath.addAll(path);
                int result = nextValidCell.traverse(newPath);
                if (result >= 0) {
                    if (shortestPath == -1)
                        shortestPath = result;
                    else if (result < shortestPath)
                        shortestPath = result;
                }
            }
            if (shortestPath > 0) {
//                System.out.println("Path = " + path);
//                System.out.println("shortestPath = " + ++shortestPath);
            }
            return shortestPath;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return x == cell.x &&
                    y == cell.y;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "x=" + (x) +
                    ", y=" + (y) +
                    '}';
        }
    }
}
