package Array;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Matriz {
        public static void main(String[] args) {
            Scanner teclado = new Scanner(System.in);
            int columnas, filas, i, j,contadorFilas=0,contadorColumnas=0,matrizNula=0, matrizEscalar=0;
            double matriz[][], traza=0;
            try {
                System.out.print("\033[34mIngrese la cantidad de filas de la Matriz: ");
                filas = teclado.nextInt();
                System.out.print("\033[34mIngrese la cantidad de columnas de la Matriz: ");
                columnas = teclado.nextInt();
                matriz = new double[filas][columnas];
                if (filas == 0 || columnas == 0) {
                    System.out.println("");
                    System.out.println("\033[31m---> La matriz no existe !!! ");
                    System.exit(0);
                }
                try {
                    System.out.println("\033[31mIngrese los valores de la Matriz");
                    for (i = 0; i < filas; i++) {
                        for (j = 0; j < columnas; j++) {
                            System.out.print("Posición (" + i + "," + j + "): ");
                            matriz[i][j] = teclado.nextDouble();
                            if (i == j) {
                                for (int m = 0; m < i; m++) {//Bucle Triangular Superior
                                    if (matriz[m][j] == 0)
                                        contadorColumnas = contadorColumnas + 1;
                                }

                                for (int a = 0; a < j; a++) {//Bucle Triangular Inferior
                                    if (matriz[i][a] == 0)
                                        contadorFilas = contadorFilas + 1;
                                }
                            }
                        }
                    }
                    System.out.println("-----------------------");
                    System.out.println("\033[31mLa matriz es: ");
                    for (i = 0; i < filas; i++) {
                        for (j = 0; j < columnas; j++) {
                            System.out.print("\033[34m" + "[" + matriz[i][j] + "]" + " ");
                        }
                        System.out.println("");
                    }
                    for (i = 0; i < filas; i++) {
                        for (j = 0; j < columnas; j++) {
                            if (matriz[i][j] == 0) {
                                matrizNula = matrizNula + 1;
                                if (matrizNula == filas * columnas) {
                                    System.out.println("\033[34mMatriz nula ");
                                    System.exit(0);
                                }
                            }
                        }
                    }
                    if (filas == 1 & columnas == 1) {
                        System.out.println("\033[34mEs una matriz columna o fila de 1x1");
                        System.exit(0);
                    }
                    if (columnas == 1) {
                        System.out.println("\033[34mEs una matriz columna");
                        System.exit(0);
                    }
                    if (filas == 1) {
                        System.out.println("\033[34mEs matriz fila");
                        System.exit(0);
                    }
                    if (columnas != filas) {
                        System.out.println("\033[34mEs una matriz rectangular");
                        System.exit(0);
                    }
                    System.out.println("-----------------------");
                    System.out.println("\033[31mLa transpuesta de la Matriz es: ");
                    for (j = 0; j < filas; j++) {
                        for (i = 0; i < columnas; i++) {
                            System.out.print("\033[34m" + "[" + matriz[i][j] + "]" + " ");
                        }
                        System.out.println("");
                    }
                    System.out.println("-----------------------");
                    System.out.println("\033[31mLa traza de la Matriz es ");
                    for (i = 0; i < filas; i++) {
                        for (j = 0; j < columnas; j++) {
                            if (j == i) {
                                traza = traza + matriz[i][j];
                            }
                        }
                    }
                    System.out.println("\033[34m" + traza);
                    System.out.println("-----------------------");
                    System.out.println("\033[31mCaracteristicas de la Matriz : ");
                    System.out.println("");
                    if_matrizEscalar:
                    if (filas == columnas) {
                        for (i = 0; i < filas; i++) {
                            for (j = 0; j < columnas; j++) {
                                if (i == j) {
                                    matrizEscalar = matrizEscalar + 1;
                                    if (matrizEscalar > 1 & matrizEscalar < filas + 1) {
                                        if (matriz[0][0] == matriz[i][j]) {

                                        } else {
                                            System.out.println("\033[34m-No es matriz escalar ");
                                            break if_matrizEscalar;
                                        }
                                    }
                                } else {
                                    if (matriz[i][j] != 0) {
                                        System.out.println("\033[34m-No es matriz escalar ");
                                        break if_matrizEscalar;
                                    }
                                }
                            }
                        }
                        System.out.println("\033[34m-Matriz escalar ");
                    }
                    if_matrizIdentidad:
                    if (filas == columnas) {
                        for (i = 0; i < filas; i++) {
                            for (j = 0; j < columnas; j++) {
                                if ((i == j & matriz[i][j] == 1)) {

                                } else {
                                    if (matriz[i][j] != 0) {
                                        System.out.println("\033[34m-No es matriz indentidad ");
                                        break if_matrizIdentidad;
                                    }
                                }
                            }
                        }
                        System.out.println("\033[34m-Matriz identidad ");
                    }
                    if_matrizDiagonal:
                    if (filas == columnas) {
                        for (i = 0; i < filas; i++) {
                            for (j = 0; j < columnas; j++) {
                                if (i == j & matriz[i][j] != 0) {

                                }else {
                                    if (matriz[i][j] != 0) {
                                        System.out.println("\033[34m-No es matriz diagonal ");
                                        break if_matrizDiagonal;
                                    }
                                }
                            }
                        }
                        System.out.println("\033[34m-Matriz diagonal ");
                    }
                    if_matrizSimetrica:
                    if (filas == columnas) {
                        for (i = 0; i < filas; i++) {
                            for (j = 0; j < columnas; j++) {
                                if (matriz[i][j] != matriz[j][i]) {
                                    System.out.println("\033[34m-No es matriz simétrica");
                                    break if_matrizSimetrica;
                                }
                            }
                        }
                        System.out.println("\033[34m-Matriz simétrica");
                    }
                    if_matrizAntisimetrica:
                    if (filas == columnas) {
                        for (i = 0; i < filas; i++) {
                            for (j = 0; j < columnas; j++) {
                                if (i == j) {
                                    if (matriz[i][j] == 0) {
                                        continue;
                                    } else {
                                        System.out.println("\033[34m-No es matriz antisimétrica");
                                        break if_matrizAntisimetrica;
                                    }
                                }
                                else {
                                    if (matriz[i][j] == matriz[j][i] * (-1)) {
                                        continue;
                                    } else {
                                        System.out.println("\033[34m-No es matriz antisimétrica");
                                        break if_matrizAntisimetrica;
                                    }
                                }
                            }
                        }
                        System.out.println("\033[34m-Matriz antisimétrica");
                    }
                    if_matrizTriangular:
                    if (contadorColumnas == ((columnas - 1) * (columnas - 1) + (columnas - 1)) / 2) {
                        if (contadorFilas != ((filas - 1) * (filas - 1) + (filas - 1)) / 2)
                            System.out.println("\033[34m-Matriz triangular Inferior");
                    } else {
                        if (contadorFilas == ((filas - 1) * (filas - 1) + (filas - 1)) / 2) {
                            if (contadorColumnas != ((columnas - 1) * (columnas - 1) + (columnas - 1)) / 2)
                                System.out.println("\033[34m-Matriz triangular Superior");
                        }
                    }


                } catch (InputMismatchException a) {
                    System.out.println("\033[31m ---> Caracteres Inválidos  !!!");
                }

            } catch (InputMismatchException a) {
                System.out.println("\033[31m ---> No se acepta letras ni números decimales !!! ");
            } catch (NegativeArraySizeException l) {
                System.out.println("\033[31m ---> Solo números positívos !!! ");
            }

        }
    }
