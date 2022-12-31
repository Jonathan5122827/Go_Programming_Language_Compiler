// test4.go

// This program tests recursive functions.

package main

import "fmt"

func facto (x int) int {
  var s int;
  if x == 1 {
    s = 1;
  } else {
    s = x * facto (x - 1);
  };
  return s;
}

func main () {
  var i int; var fac int;
  fmt . Scanf ("%d", &i);
  fac = facto (i);
  fmt . Println (fac);
}
