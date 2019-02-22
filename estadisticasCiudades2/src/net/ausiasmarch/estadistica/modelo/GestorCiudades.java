package net.ausiasmarch.estadistica.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import net.ausiasmarch.estadistica.comparators.CiudadComparator;
import net.ausiasmarch.estadistica.comparators.ComunidadCiudadComparator;
import net.ausiasmarch.estadistica.comparators.HabitantesComparator;

/**
 * GestorCiudades.java
 *
 * @author Desarrollador
 */
public class GestorCiudades {

    // Lista de ciudades
    private List<Ciudad> ciudades;

    /**
     * Constructor
     */
    public GestorCiudades() {
        ciudades = new ArrayList<Ciudad>();   // crea la lista de ciudades
    }

    /**
     * Obtiene la lista de ciudades
     *
     * @return List
     */
    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    /**
     * Establece la lista de ciudades
     *
     * @param ciudades
     */
    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    /**
     * Obtiene la suma de habitantes de todas las ciudades
     *
     * @return int
     */
   public int totalHabitantes() {
	Iterator<Ciudad> it = ciudades.iterator();
	int totalhab = 0;
	int i = 0;
	while(it.hasNext()) {
		totalhab += it.next().getHabitantes();
		
	}
	   return totalhab;

    }

    /**
     * Obtiene el numero de ciudades de la lista
     *
     * @return int
     */
   public int numCiudades() {
      
      return ciudades.size();
   }

    /**
     * Obtiene la media de habitantes de las ciudades
     *
     * @return double
     */
   public double mediaHabitantes() {
	return totalHabitantes() / numCiudades();
       
  }

    /**
     * Ordena las ciudades de menor a mayor habitantes
     */
   public void ordenarHabitantesAsc() {
        Collections.sort(ciudades, new HabitantesComparator());
    }

    /**
     * Ordena las ciudades por de mayor a menor habitantes
     */
   public void ordenarHabitantesDesc() {
       Collections.sort(ciudades, new HabitantesComparator());
       Collections.reverse(ciudades);
    }

    /**
     * Ordena las ciudades alfabetiamente por ciudad dentro de cada comunidad
     */
    public void ordenarComunidadCiudad() {
       Collections.sort(ciudades, new ComunidadCiudadComparator());
    }

    /**
     * Busca la ciudad con el nombre indicado
     *
     * @param nombreCiudad
     * @return List
     */
    public Ciudad buscarCiudad(String nombreCiudad) {
		Iterator<Ciudad>it = ciudades.iterator();
		while(it.hasNext()) {
			Ciudad ciudad = it.next();
			if(nombreCiudad.equalsIgnoreCase(ciudad.getCiudad())) {
				return ciudad;
			}
		}
    	return null;
    	
    }

    /**
     * Borra la ciudad con el nombre indicado de una comunidad
     *
     * @param nombre
     * @return List
     */
    public boolean borrarCiudad(String nombre) {
    	Iterator<Ciudad>it = ciudades.iterator();
		while(it.hasNext()) {
			Ciudad ciudad = it.next();
			if(ciudad.getCiudad().compareToIgnoreCase(nombre) == 0) {
				it.remove();
				return true;
			}
		}
		return false;
    }

    /**
     * Obtiene la ciudad con mayor habitantes
     *
     * @return Ciudad
     */
    public Ciudad ciudadMayorHabitantes() {
    	return Collections.max(ciudades, new HabitantesComparator());
        
    }

    /**
     * Convierte un Lista de objetos ciudad en un list de list con los datos de
     * cada ciudad
     *
     * @param ciudades
     * @return
     */
    public List<List> aslistaCiudades(List<Ciudad> ciudades) {
        List<List> listaCiudades = new ArrayList();
        for (Ciudad ciudad : ciudades) {
            List lista = new ArrayList();
            lista.add(ciudad.getComunidad());
            lista.add(ciudad.getCiudad());
            lista.add(ciudad.getHabitantes());
            listaCiudades.add(lista);
        }
        return listaCiudades;
    }

   
} // fin del gestor








