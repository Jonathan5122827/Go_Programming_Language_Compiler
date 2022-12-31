// test6.go

// This program performs matrix multiplication.

package main

import "fmt"

func main () {
  var matrixA [4][3] int;
  var matrixB [3][2] int;
  var matrixC [4][2] int;
  var i int; var j int; var k int; 
  var n1 int; var n2 int; var n3 int; 
  n1 = 4; n2 = 3; n3 = 2;
  // example from http://en.wikipedia.org/wiki/Matrix_multiplication
  matrixA [0][0] = 14; matrixA [0][1] =  9; matrixA [0][2] =  3;
  matrixA [1][0] =  2; matrixA [1][1] = 11; matrixA [1][2] = 15;
  matrixA [2][0] =  0; matrixA [2][1] = 12; matrixA [2][2] = 17;
  matrixA [3][0] =  5; matrixA [3][1] =  2; matrixA [3][2] =  3;
  matrixB [0][0] = 12; matrixB [0][1] = 25; 
  matrixB [1][0] =  9; matrixB [1][1] = 10;
  matrixB [2][0] =  8; matrixB [2][1] =  5;
  i = 0;
  for i < n1 {
    j = 0;
    for j < n3 {
      k = 0;
      matrixC [i][j] = 0;
      for k < n2 {
        matrixC [i][j] = matrixC [i][j] + matrixA [i][k] * matrixB [k][j];
        k = k + 1;
      };
      j = j + 1;
    };
    i = i + 1;
  };
  i = 0;
  for i < n1 {
    j = 0;
    for j < n3 {
      fmt . Println (matrixC [i][j]);
      j = j + 1;
    };
    i = i + 1;
  };
}
