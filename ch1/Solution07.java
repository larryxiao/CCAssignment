/*********************************************************************************
*     File Name           :     Solution07.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-11 19:46]
*     Last Modified       :     [2015-09-13 11:03]
*     Description         :     Rotate Matrix 
**********************************************************************************/

import java.util.Arrays;

public class Solution07
{
    private int PIXELSIZE=4;
    public boolean matrixEquals(byte[][][] matrix1, byte[][][] matrix2, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < PIXELSIZE; k++) {
                    if (matrix1[i][j][k] == matrix2[i][j][k])
                        continue;
                    else
                        return false;
                }
            }
        }
        return true;
    }
    public void matrixPrint(byte[][][] matrix, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.format("%d", matrix[i][j][0]);
            }
            System.out.println();
        }
    }
    // Given an image represented by and NxN matrix, where each pixel in the
    // image is 4 bytes, write a method to rotate the image by 90 degrees.
    // (clockwise)
    public byte[][][] rotateMatrix(byte[][][] matrix, int N) {
        byte[][][] ret = new byte[N][N][PIXELSIZE];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int i = 0; i < PIXELSIZE; i++) {
                    ret[y][N-x-1][i] = matrix[x][y][i];
                }
            }
        }
        return ret;
    }
    // Can you do this in place?
    // *__     __*    ___    ___
    // ___  -> ___ -> ___ -> ___
    // ___     ___    __*    *__
    public int rotateMatrixInPlace(byte[][][] matrix, int N) {
        byte[][][] ret = new byte[N][N][PIXELSIZE];
        for (int x = 0; x < N/2; x++) {
            for (int y = 0; y < N/2+N%2; y++) {
                byte[] tmp = new byte[4];
                // save lower left pixel
                for (int i = 0; i < PIXELSIZE; i++) {
                    tmp[i] = matrix[N-y-1][x][i];
                }
                // move 3 pixels at the same time
                for (int i = 0; i < PIXELSIZE; i++) {
                    matrix[N-y-1][x][i] = matrix[N-x-1][N-y-1][i];
                    matrix[N-x-1][N-y-1][i] = matrix[y][N-x-1][i];
                    matrix[y][N-x-1][i] = matrix[x][y][i];
                }
                // fill in the saved pixel
                for (int i = 0; i < PIXELSIZE; i++) {
                    matrix[x][y][i] = tmp[i];
                }
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        byte[][][] matrix = {
            {{1,1,1,1}, {1,1,1,1}, {1,1,1,1}, {1,1,1,1}},
            {{2,2,2,2}, {2,2,2,2}, {2,2,2,2}, {2,2,2,2}},
            {{3,3,3,3}, {3,3,3,3}, {3,3,3,3}, {3,3,3,3}},
            {{4,4,4,4}, {4,4,4,4}, {4,4,4,4}, {4,4,4,4}}
        };
        byte[][][] target = {
            {{4,4,4,4}, {3,3,3,3}, {2,2,2,2}, {1,1,1,1}},
            {{4,4,4,4}, {3,3,3,3}, {2,2,2,2}, {1,1,1,1}},
            {{4,4,4,4}, {3,3,3,3}, {2,2,2,2}, {1,1,1,1}},
            {{4,4,4,4}, {3,3,3,3}, {2,2,2,2}, {1,1,1,1}}
        };
        assert matrix[0][0][0] == 1;
        assert matrix[3][0][0] == 4;
        assert matrix[0][3][0] == 1;
        assert matrix[3][3][0] == 4;
        Solution07 foo = new Solution07();

        // test extra space rotation
        byte[][][] ret;
        ret = foo.rotateMatrix(matrix, 4);
        assert ret[0][0][0] == 4;
        assert ret[3][0][0] == 4;
        assert ret[0][3][0] == 1;
        assert ret[3][3][0] == 1;
        assert foo.matrixEquals(ret, target, 4);
        assert Arrays.deepEquals(ret, target);

        // test in place rotation
        // N is even
        foo.rotateMatrixInPlace(matrix, 4);
        assert foo.matrixEquals(matrix, target, 4);
        assert Arrays.deepEquals(matrix, target);
        
        // N is odd
        byte[][][] matrix2 = {
            {{1,1,1,1}, {1,1,1,1}, {1,1,1,1}},
            {{2,2,2,2}, {2,2,2,2}, {2,2,2,2}},
            {{3,3,3,3}, {3,3,3,3}, {3,3,3,3}}
        };
        byte[][][] target2 = {
            {{3,3,3,3}, {2,2,2,2}, {1,1,1,1}},
            {{3,3,3,3}, {2,2,2,2}, {1,1,1,1}},
            {{3,3,3,3}, {2,2,2,2}, {1,1,1,1}}
        };
        foo.rotateMatrixInPlace(matrix2, 3);
        assert foo.matrixEquals(matrix2, target2, 3);
        assert Arrays.deepEquals(matrix2, target2);
    }
}

