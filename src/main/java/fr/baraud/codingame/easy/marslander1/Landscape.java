package fr.baraud.codingame.easy.marslander1;

import java.util.List;

public class Landscape {

    private final List<Edge> edges;
    private final Gravity gravity;

    public Landscape(List<Edge> edges, Gravity gravity) {
        this.edges = edges;
        this.gravity = gravity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Landscape landscape = (Landscape) o;

        if (edges != null ? !edges.equals(landscape.edges) : landscape.edges != null) return false;
        return gravity != null ? gravity.equals(landscape.gravity) : landscape.gravity == null;

    }

    @Override
    public int hashCode() {
        int result = edges != null ? edges.hashCode() : 0;
        result = 31 * result + (gravity != null ? gravity.hashCode() : 0);
        return result;
    }

    public boolean collide(Position positionLanding) {
        return positionLanding.Ycoord() < 100;
    }

    public Gravity gravity() {
        return gravity;
    }
}
