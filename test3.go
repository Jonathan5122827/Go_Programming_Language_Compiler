// test3.go

// This program tests function calls.

package main

import "fmt"

func area (x int, y int, h int) int {
  var z int;
  z = 2 * (x * y + (x * h) + y * h);
  return z;
}

func main() {
  var a int; var b int; var h int; var s int;
  fmt . Scanf ("%d", &a);
  fmt . Scanf ("%d", &b);
  fmt . Scanf ("%d", &h);
  s = area (a, b, h);
  fmt . Println (s);
}
