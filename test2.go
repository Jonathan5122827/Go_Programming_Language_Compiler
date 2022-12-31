// test2.go

// This program tests one-dimensional arrays.

package main

import "fmt"

func main() {
  var my_list [100] int;
  var my_list_tl [100] int;
  var r int; var h int; var i int;
  r = 2;
  for r < 5 {
    my_list [r - 2] = r;
    r = r + 1;
  };
  h = my_list [0];
  i = r;
  for i > 0 {
    my_list_tl [i - 1] = my_list [i];
    i = i - 1;
  };
  fmt . Println (h);
  fmt . Println (my_list_tl [0]);
}
