// test5.go

// This program tests arrays passed as parameters.

package main

import "fmt"

func f (a [100] int, i int) int {
  var x int;
  x = a [i];
  a [i] = 0;
  i = 622;
  return x;
}

func main () {
  var b [100] int;
  var i int; var n int;
  n = 40;
  i = 0;
  for i < 100 {
    b [i] = i * i;
    i = i + 1;
  };
  fmt . Println (n);
  fmt . Println (f (b, n));
  fmt . Println (n);     // n should be unchanged
  fmt . Println (b [n]); // b [n] should be unchanged
}
