package com.lcefesto;

import java.util.Arrays;
import java.util.Objects;

public class Matrix {
    public static final String REGEX = "-?(([1-9][0-9]*)|0)?(\\.[0-9]*)?([Ee][+-]?[0-9]+)?";
    int rows;
    int columns;
    double[][] data = new double[rows][columns];

    //FUNZIONI A CUI NON APPLICARE DIRETTAMENTE UN BUTTON
    public Matrix() {
    }

    public Matrix(double[] data, int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        if (data.length != rows * columns) {
            throw new IllegalArgumentException("The array passed as dataset for the matrix must have row*column size");
        }
        double[][] arr = new double[rows][columns];
        int q = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                arr[i][j] = data[q];
                ++q;
            }
        }
        this.data = arr;
    }

    public int getRow() {
        return rows;
    }

    public void setRow(int rows) {
        this.rows = rows;
    }

    public int getColumn() {
        return columns;
    }

    public void setColumn(int columns) {
        this.columns = columns;
    }

    public double[][] getData() {
        return data;
    }

    public void setData(double[] data) {
        double[][] arr = new double[rows][columns];
        int q = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                arr[i][j] = data[q];
                ++q;
            }
        }
        this.data = arr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Matrix matrix = (Matrix) o;
        return rows == matrix.rows && columns == matrix.columns && Arrays.equals(data, matrix.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rows, columns);
        result = 31 * result + Arrays.deepHashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "Matrix{" + "data=" + Arrays.toString(data) + ", rows=" + rows + ", columns=" + columns + '}';
    }

    public static double[] matrixGetDataArray(Matrix m) {
        double[] ret = new double[m.rows * m.columns];
        int q = 0;
        for (int i = 0; i < m.rows; ++i) {
            for (int j = 0; j < m.columns; ++j) {
                ret[q] = m.data[i][j];
                ++q;
            }
        }
        return ret;
    }

    public static Matrix matrixCopy(Matrix m) {
        Matrix ret = new Matrix();
        ret.rows = m.rows;
        ret.columns = m.columns;
        ret.data = m.data;
        return ret;
    }

    public static Matrix matrixCopy(double[] datas, int r, int c) {
        return new Matrix(datas, r, c);
    }

    public static boolean matrixContains(Matrix m, double element) {
        for (int i = 0; i < m.rows; ++i) {
            for (int j = 0; j < m.columns; ++j) {
                if (m.data[i][j] == element) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean matrixContains(Matrix m, double element, int rpos, int cpos) {
        return m.data[rpos][cpos] == element;
    }

    public static Matrix matrixComplementarMinor(Matrix m, double element, int rpos, int cpos) {
        if (!matrixIsSquared(m)) {
            throw new IllegalArgumentException("The passed matrix is not squared!");
        }
        if (!matrixContains(m, element, rpos, cpos)) {
            throw new IllegalArgumentException("The passed element is not contained in the passed matrix!");
        }
        Matrix minor = new Matrix();
        minor.rows = m.rows - 1;
        minor.columns = m.columns - 1;
        minor.data = new double[minor.rows][minor.columns];
        int q = 0, w = 0;
        for (int i = 0; i < m.rows; ++i) {
            for (int j = 0; j < m.columns; ++j) {
                if (i != rpos && j != cpos) {
                    minor.data[q][w] = m.data[i][j];
                    if (w < minor.columns - 1) {
                        ++w;
                    } else {
                        ++q;
                        w = 0;
                    }
                }
            }
        }
        return minor;
    }

    public static Matrix matrixNegate(Matrix m) {
        if (m == null) {
            return null;
        }
        for (int i = 0; i < m.rows; ++i) {
            for (int j = 0; j < m.columns; ++j) {
                m.data[i][j] = Mathematics.negate(m.data[i][j]);
            }
        }
        return m;
    }

    //FUNZIONI A CUI APPLICARE UN BOTTONE
    public static boolean matrixIsSquared(Matrix m) {
        return m.rows == m.columns;
    }

    public static double matrixDeterminant(Matrix m) {
        if (m == null) {
            return Double.MIN_VALUE;
        }
        if (!matrixIsSquared(m)) {
            //scrivere l'errore nel TextField corrispondente
            throw new IllegalArgumentException("The matrix passed must be squared!");
        }
        int n = m.rows;
        double det = 0;
        if (n == 1) {
            return m.data[0][0];
        }
        if (n == 2) {
            return (m.data[0][0] * m.data[1][1]) - (m.data[0][1] * m.data[1][0]);
        }
        if (n > 2) {
            for (int i = 0; i < m.columns; ++i) {
                if ((i % 2) == 0) {
                    det += (m.data[0][i] * matrixDeterminant(matrixComplementarMinor(m, m.data[0][i], 0, i)));
                } else {
                    det += (Mathematics.negate(m.data[0][i]) * matrixDeterminant(matrixComplementarMinor(m, m.data[0][i], 0, i)));
                }
            }
        }
        return det;
    }

    public static double[] matrixPrincipalDiagonal(Matrix m) {
        if (m == null || !matrixIsSquared(m)) {
            return null;
        }
        double[] diag = new double[m.rows];
        for (int i = 0; i < m.rows; ++i) {
            diag[i] = m.data[i][i];
        }
        return diag;
    }

    public static double[] matrixAntiDiagonal(Matrix m) {
        if (m == null || !matrixIsSquared(m)) {
            return null;
        }
        double[] diag = new double[m.rows];
        int j = 0;
        for (int i = m.rows - 1; i >= 0; --i) {
            diag[j] = m.data[j][i];
            ++j;
        }
        return diag;
    }

    public static Matrix matrixTranspose(Matrix m) {
        Matrix transpose = new Matrix();
        transpose.rows = m.columns;
        transpose.columns = m.rows;
        transpose.data = new double[transpose.rows][transpose.columns];
        int q = 0, w = 0;
        double[] arr = new double[transpose.columns * transpose.rows];
        for (int j = 0; j < m.columns; ++j) {
            for (int i = 0; i < m.rows; ++i) {
                arr[q] = m.data[i][j];
                ++q;
            }
        }
        transpose.setData(arr);
        return transpose;
    }

    public static double matrixAverage(Matrix m) {
        double average = 0;
        double som = 0;
        for (int i = 0; i < m.rows; ++i) {
            for (int j = 0; j < m.columns; ++j) {
                som += m.data[i][j];
            }
        }
        return som / (m.rows * m.columns);
    }

    public static boolean matrixIsHighTriangular(Matrix m) {
        if (m == null || !matrixIsSquared(m)) {
            return false;
        }
        for (int i = 0; i < m.rows; ++i) {
            for (int j = 0; j < m.columns; ++j) {
                if (j < i && m.data[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean matrixIsLowTriangular(Matrix m) {
        if (m == null || !matrixIsSquared(m)) {
            return false;
        }
        for (int i = 0; i < m.rows; ++i) {
            for (int j = 0; j < m.columns; ++j) {
                if (i < j && m.data[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Matrix matrixSum(Matrix m1, Matrix m2) {
        if (m1 == null && m2 == null) {
            return null;
        }
        if (m1 == null) {
            return m2;
        }
        if (m2 == null) {
            return m1;
        }
        if ((m1.rows != m2.rows) || (m1.columns != m2.columns)) {
            throw new IllegalArgumentException("The passed matrices have not the same dimension!");
        }
        Matrix sum = new Matrix(new double[m1.rows * m1.columns], m1.rows, m1.columns);
        for (int i = 0; i < m1.rows; ++i) {
            for (int j = 0; j < m1.columns; ++j) {
                sum.data[i][j] = m1.data[i][j] + m2.data[i][j];
            }
        }
        return sum;
    }

    public static Matrix matrixDifference(Matrix m1, Matrix m2) {
        if (m1 == null && m2 == null) {
            return null;
        }
        if (m1 == null) {
            return matrixNegate(m2);
        }
        if (m2 == null) {
            return m1;
        }
        if ((m1.rows != m2.rows) || (m1.columns != m2.columns)) {
            throw new IllegalArgumentException("The passed matrices have not the same dimension!");
        }
        Matrix difference = new Matrix(new double[m1.rows * m1.columns], m1.rows, m1.columns);
        for (int i = 0; i < m1.rows; ++i) {
            for (int j = 0; j < m1.columns; ++j) {
                difference.data[i][j] = m1.data[i][j] + matrixNegate(m2).data[i][j];
            }
        }
        return difference;
    }

    public static Matrix matrixProduct(Matrix m1, Matrix m2) {
        if (m1 == null && m2 == null) {
            return null;
        }
        if (m1 == null) {
            return matrixNegate(m2);
        }
        if (m2 == null) {
            return m1;
        }
        if (m1.columns != m2.rows) {
            throw new IllegalArgumentException("The matrix m1 has not the same column dimension as the same row dimension" + " of the matrix m2!");
        }
        Matrix prod = new Matrix(new double[m1.rows * m2.columns], m1.rows, m2.columns);
        for (int i = 0; i < m1.rows; ++i) {
            for (int j = 0; j < m2.columns; ++j) {
                for (int k = 0; k < m1.columns; ++k) {
                    prod.data[i][j] += m1.data[i][k] * m2.data[k][j];
                }
            }
        }
        return prod;
    }

    public static boolean matrixIsInvertible(Matrix m) {
        return matrixDeterminant(m) != 0;
    }

    public static Matrix matrixScale(Matrix m, double element) {
        if (m == null) {
            return null;
        }
        for (int i = 0; i < m.rows; ++i) {
            for (int j = 0; j < m.columns; ++j) {
                m.data[i][j] *= element;
            }
        }
        return m;
    }

    public static Matrix matrixInverse(Matrix m) {
        if (m == null || !matrixIsInvertible(m)) {
            return null;
        }
        Matrix inverse = new Matrix(new double[m.rows * m.columns], m.rows, m.columns);
        for (int i = 0; i < m.rows; ++i) {
            for (int j = 0; j < m.columns; ++j) {
                inverse.data[i][j] = Math.pow(m.data[i][j], i + j) * matrixDeterminant(matrixComplementarMinor(m, m.data[i][j], i, j));
            }
        }
        return (matrixScale(inverse, 1 / matrixDeterminant(m)));
    }

    public static Matrix matrixDivision(Matrix m1, Matrix m2) {
        return matrixProduct(m1, matrixInverse(m2));
    }

    public static boolean matrixIsSymmetric(Matrix m) {
        return m.equals(matrixTranspose(m));
    }

    public static boolean matrixIsDiagonal(Matrix m) {
        if (!matrixIsSquared(m)) {
            return false;
        }
        for (int i = 0; i < m.rows; ++i) {
            for (int j = 0; j < m.columns; ++j) {
                if (i != j && m.data[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
