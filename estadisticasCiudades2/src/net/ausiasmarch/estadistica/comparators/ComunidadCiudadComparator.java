package net.ausiasmarch.estadistica.comparators;

import java.util.Comparator;

import net.ausiasmarch.estadistica.modelo.Ciudad;

public class ComunidadCiudadComparator implements Comparator<Ciudad> {

    @Override
    public int compare(Ciudad c1, Ciudad c2) {

        return c1.getComunidad().compareToIgnoreCase(c2.getComunidad());

    }
}