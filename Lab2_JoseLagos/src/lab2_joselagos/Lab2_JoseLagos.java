package lab2_joselagos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Tony
 */
public class Lab2_JoseLagos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean res = false;
        int resp = 1;
        ArrayList listado = new ArrayList();
        while (res == false) {
            String nombre = JOptionPane.showInputDialog("              Login\n"
                    + "Ingrese nombre de usuario");
            String contra = JOptionPane.showInputDialog("Ingrese la contraseña");

            if (!"david".equals(nombre) || !"99".equals(contra)) {
                JOptionPane.showMessageDialog(null, "El nombre de usuario o la contraseña son invalidos");
            } else {
                res = true;
            }
        }
        while (resp == 1) {

            int opcion = Integer.parseInt(JOptionPane.showInputDialog("      Menu\n"
                    + "1. Reporte de restaurantes\n"
                    + "2. Manejo de restaurantes\n"
                    + "3. Salir\n"
                    + "Ingrese su opcion"));

            switch (opcion) {
                case 1: {
                    int option = Integer.parseInt(JOptionPane.showInputDialog("1. Listar segun estado\n"
                            + "2. Listar nombre, ubicacion y especialidad de restaurantes premium\n"
                            + "3. Nombre, especialidad y ubicacion de restaurantes segun su franquicia\n"
                            + "Ingrese su opcion"));

                    switch (option) {
                        case 1: {
                            String reporte = JOptionPane.showInputDialog("Ingrese el estado de los restaurantes que desea ver");
                            String salida = "";
                            int cont = 0;
                            for (Object i : listado) {
                                if (i instanceof restaurantes) {
                                    String estado = ((restaurantes) listado.get(cont)).getEstado();
                                    cont++;
                                    if (estado.equals(reporte.toLowerCase())) {
                                        salida += listado.indexOf(i) + " - " + i + "\n";
                                    }
                                }

                            }
                            JOptionPane.showMessageDialog(null, salida);
                            break;
                        }
                        case 2: {
                            int cont = 0;
                            String salida = "";
                            for (Object i : listado) {
                                if (i instanceof restaurantes) {
                                    boolean juegos = ((restaurantes) listado.get(cont)).getJuegos();
                                    boolean parqueo = ((restaurantes) listado.get(cont)).getParqueo();

                                    if (juegos && parqueo) {
                                        salida += listado.indexOf(i) + " - Nombre: " + ((restaurantes) listado.get(cont)).getNombre() + ", Ubicacion: " + ((restaurantes) listado.get(cont)).getUbicacion() + ", Especialidad: " + ((restaurantes) listado.get(cont)).getEspecialidad();
                                    }
                                }
                                cont++;
                            }
                            JOptionPane.showMessageDialog(null, salida);
                            break;

                        }
                        case 3: {
                            int cont = 0;
                            String salida = "";
                            String fran = JOptionPane.showInputDialog("Ingrese el nombre de la franquicia");
                            for (Object i : listado) {
                                if (i instanceof restaurantes) {
                                    String franquicia = ((restaurantes) listado.get(cont)).getFranquicia();

                                    if (fran == franquicia) {
                                        salida += listado.indexOf(i) + " - Nombre: " + ((restaurantes) listado.get(cont)).getNombre() + ",  Especialidad: " + ((restaurantes) listado.get(cont)).getEspecialidad() + ",  Ubicacion: " + ((restaurantes) listado.get(cont)).getUbicacion();
                                    }
                                }
                                cont++;
                            }
                            JOptionPane.showMessageDialog(null, salida);
                            break;
                        }
                        default:
                            JOptionPane.showMessageDialog(null, "Opcion invalida");
                            break;
                    }
                    break;
                }
                case 2: {
                    int option = Integer.parseInt(JOptionPane.showInputDialog("1. Crear\n"
                            + "2. Listar\n"
                            + "3. Modificar\n"
                            + "4. Eliminar\n"
                            + "Ingrese su opcion"));

                    switch (option) {
                        case 1: {
                            String franquicia = JOptionPane.showInputDialog("Ingrese el nombre de la franquicia: ");
                            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del restaurante: ");
                            String ubicacion = JOptionPane.showInputDialog("Ingrese la ubicacion: ");
                            int empleados = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de empleados: "));
                            String parqueo = JOptionPane.showInputDialog("Tiene parqueo? [si/no]: ");
                            String juegos = JOptionPane.showInputDialog("Tiene area de juegos? [si/no]: ");
                            int cajeros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de cajeros: "));
                            String estado = JOptionPane.showInputDialog("Ingrese el estado del restaurante: ");
                            if ("remodelacion".equals(estado) || "demolicion".equals(estado)) {
                                String gerente = "", especialidad = "";
                                int mesas = 0;

                                listado.add(new restaurantes(franquicia, nombre, estado, ubicacion, empleados, parqueo, juegos, mesas, cajeros, gerente, especialidad));
                                break;
                            }
                            int mesas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de mesas: "));
                            String gerente = JOptionPane.showInputDialog("Ingrese el nombre del gerente: ");
                            String especialidad = JOptionPane.showInputDialog("Ingrese la especialidad del restaurante: ");

                            listado.add(new restaurantes(franquicia, nombre, estado, ubicacion, empleados, parqueo, juegos, mesas, cajeros, gerente, especialidad));
                            break;
                        }
                        case 2: {
                            String salida = "";
                            for (Object t : listado) {
                                if (t instanceof restaurantes) {
                                    salida += listado.indexOf(t) + " - " + t + "\n";
                                }
                            }
                            JOptionPane.showMessageDialog(null, salida);
                            break;
                        }

                        case 3: {
                            int position = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion del restaurante a modificar: "));

                            if (listado.get(position) instanceof restaurantes) {
                                int p = Integer.parseInt(JOptionPane.showInputDialog("¿Que desea modificar?\n"
                                        + "1. Franquicia\n"
                                        + "2. Nombre de Restaurante\n"
                                        + "3. Ubicacion\n"
                                        + "4. Parqueo\n"
                                        + "5. Area de juegos\n"
                                        + "6. Cantidad de mesas\n"
                                        + "7. Cantidad de empleados\n"
                                        + "8. Cantidad de cajeros\n"
                                        + "9. Nombre de gerente\n"
                                        + "10. Especialidad"));

                                switch (p) {
                                    case 1: {
                                        String aux = JOptionPane.showInputDialog("Ingrese la nueva franquicia");
                                        ((restaurantes) listado.get(position)).setFranquicia(aux);
                                        break;
                                    }
                                    case 2: {
                                        String aux = JOptionPane.showInputDialog("Ingrese el nuevo nombre del restaurante");
                                        ((restaurantes) listado.get(position)).setNombre(aux);
                                        break;
                                    }
                                    case 3: {
                                        String aux = JOptionPane.showInputDialog("Ingrese la nueva ubicacioon");
                                        ((restaurantes) listado.get(position)).setUbicacion(aux);
                                        break;
                                    }
                                    case 4: {
                                        String aux = JOptionPane.showInputDialog("Hay parqueo?[si/no]");
                                        ((restaurantes) listado.get(position)).setParqueo(aux);
                                        break;
                                    }
                                    case 5: {
                                        String aux = JOptionPane.showInputDialog("Hay area de juegos?[si/no]");
                                        ((restaurantes) listado.get(position)).setJuegos(aux);
                                        break;
                                    }
                                    case 6: {
                                        int aux = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de mesas"));
                                        ((restaurantes) listado.get(position)).setMesas(aux);
                                        break;
                                    }
                                    case 7: {
                                        int aux = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de empleados"));
                                        ((restaurantes) listado.get(position)).setEmpleados(aux);
                                        break;
                                    }
                                    case 8: {
                                        int aux = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de cajeros"));
                                        ((restaurantes) listado.get(position)).setCajeros(aux);
                                        break;
                                    }
                                    case 9: {
                                        String aux = JOptionPane.showInputDialog("Ingrese el nuevo nombre del gerente");
                                        ((restaurantes) listado.get(position)).setGerente(aux);
                                        break;
                                    }
                                    case 10: {
                                        String aux = JOptionPane.showInputDialog("Ingrese la nueva especialidad");
                                        ((restaurantes) listado.get(position)).setEspecialidad(aux);
                                        break;
                                    }
                                    default:
                                        JOptionPane.showMessageDialog(null, "Opcion invalida");
                                        break;
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "La posicion ingresada no existe");
                            }
                            break;
                        }
                        case 4: {
                            int position = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la posicion del restaurante que desea eliminar"));

                            if (listado.get(position) instanceof restaurantes) {
                                listado.remove(position);
                            } else {
                                JOptionPane.showMessageDialog(null, "La posicion que ingreso no se encuentra en la lista o es invalida");
                            }
                            break;
                        }
                        default:
                            JOptionPane.showMessageDialog(null, "Opcion invalida");
                            break;
                    }
                    break;
                }

                case 3: {
                    resp = 2;
                    JOptionPane.showMessageDialog(null, "Usted ha salido del programa");
                    break;
                }
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");

            }

        }
    }

}
