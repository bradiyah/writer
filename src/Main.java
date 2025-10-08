import java.io.*;
import java.util.Scanner;
import java.io.*;
import java.util.Scanner;

public class Main {
    private static String directorioActual = System.getProperty("user.dir");

    public static void main(String[] args) {

                Scanner sc = new Scanner(System.in);
                int opcion;

                do {
                    welcome();
                    System.out.print("Selecciona una opción: ");
                    opcion = sc.nextInt();
                    sc.nextLine(); // Limpiar buffer

                    switch (opcion) {
                        case 1:
                            escribirArchivo(sc);
                            break;
                        case 2:
                            leerArchivo(sc);
                            break;
                        case 3:
                            borrarArchivo(sc);
                            break;
                        case 4:
                            listarArchivos();
                            break;
                        case 5:
                            establecerDirectorio(sc);
                            break;
                        case 0:
                            System.out.println("Saliendo del programa...");
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                } while (opcion != 0);

                sc.close();
            }

            public static void welcome() {
                System.out.println();
                System.out.println("############ Writer ############");
                System.out.println("################################");
                System.out.println("1 . Escribir en un archivo");
                System.out.println("2 . Leer un archivo");
                System.out.println("3 . Borrar un archivo");
                System.out.println("4 . Listar ficheros de un directorio");
                System.out.println("5 . Establecer directorio de trabajo");
                System.out.println("0 . Salir");
                System.out.println("################################");
            }

            // 1️⃣ Escribir en archivo
            public static void escribirArchivo(Scanner sc) {
                try {
                    System.out.print("Introduce el nombre del archivo: ");
                    String nombreArchivo = sc.nextLine();
                    File file = new File(directorioActual, nombreArchivo);

                    System.out.println("Escribe el contenido (termina con una línea vacía):");
                    StringBuilder contenido = new StringBuilder();
                    String linea;
                    while (!(linea = sc.nextLine()).isEmpty()) {
                        contenido.append(linea).append(System.lineSeparator());
                    }

                    FileWriter writer = new FileWriter(file);
                    writer.write(contenido.toString());
                    writer.close();

                    System.out.println("Archivo guardado correctamente en " + file.getAbsolutePath());
                } catch (IOException e) {
                    System.out.println("Error al escribir el archivo: " + e.getMessage());
                }
            }

            // 2️⃣ Leer archivo
            public static void leerArchivo(Scanner sc) {
                try {
                    System.out.print("Introduce el nombre del archivo: ");
                    String nombreArchivo = sc.nextLine();
                    File file = new File(directorioActual, nombreArchivo);

                    if (!file.exists()) {
                        System.out.println("El archivo no existe.");
                        return;
                    }

                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String linea;
                    System.out.println("Contenido del archivo:");
                    while ((linea = reader.readLine()) != null) {
                        System.out.println(linea);
                    }
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error al leer el archivo: " + e.getMessage());
                }
            }

            // 3️⃣ Borrar archivo
            public static void borrarArchivo(Scanner sc) {
                System.out.print("Introduce el nombre del archivo a borrar: ");
                String nombreArchivo = sc.nextLine();
                File file = new File(directorioActual, nombreArchivo);

                if (file.exists()) {
                    if (file.delete()) {
                        System.out.println("Archivo eliminado correctamente.");
                    } else {
                        System.out.println("No se pudo borrar el archivo.");
                    }
                } else {
                    System.out.println("El archivo no existe.");
                }
            }

            // 4️⃣ Listar archivos del directorio
            public static void listarArchivos() {
                File dir = new File(directorioActual);
                if (dir.isDirectory()) {
                    System.out.println("Archivos en el directorio actual (" + dir.getAbsolutePath() + "):");
                    String[] archivos = dir.list();
                    if (archivos != null && archivos.length > 0) {
                        for (String nombre : archivos) {
                            System.out.println(" - " + nombre);
                        }
                    } else {
                        System.out.println("(Directorio vacío)");
                    }
                } else {
                    System.out.println("El directorio actual no es válido.");
                }
            }

            // Cambiar directorio
            public static void establecerDirectorio(Scanner sc) {
                System.out.print("Introduce la ruta del nuevo directorio: ");
                String nuevaRuta = sc.nextLine();
                File nuevoDir = new File(nuevaRuta);

                if (nuevoDir.exists() && nuevoDir.isDirectory()) {
                    directorioActual = nuevoDir.getAbsolutePath();
                    System.out.println("Directorio cambiado a: " + directorioActual);
                } else {
                    System.out.println("La ruta no es válida o no existe.");
                }
            }
        };









