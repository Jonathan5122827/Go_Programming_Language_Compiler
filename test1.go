// test1.go

// This program tests basic arithmetic and for loops.

package main

import "fmt"

func main() {
  var q int; var r int; var x int; var y int;
  fmt . Scanf ("%d", &x);
  fmt . Scanf ("%d", &y);
  q = 0;
  r = x;
  for r >= y {
    q = q + 1;
    r = r - y;
  };
  fmt . Println (q);
  fmt . Println (r);
}
