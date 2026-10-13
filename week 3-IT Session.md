06/10/2026

ArityException - passing in the wrong number of args

comparative function - 

`first` , `second`, `last` - used to access the i'th element of a list

```Clojure
 (defn foo
   [x]
   x)


 (foo (foo 5))
 (println (str "the result is " (foo 5)))
 (def five (foo 5))


 (defn Hello-World
   []
   (println (str "Hello, World!"))
 )
 (println (Hello-World))


 (defn square
   [x]
   (* x x))
 (println (square 2))
  

 (defn sum-of-squares
   [x y] (+ (square x) (square y)))
 (println (sum-of-squares 2 3))

  

 (defn equal?
   [x y]
   (if (= x y) 1 y))
 (println (equal? 3 4))

  
 (defn add2
   [a b]
   (+ 2 (if (> a b) a b)))
 (println (add2 4 5))
  

 (defn multi
   [a & b]
   (println a)
   ; if the size of b = 0 print "no other arguments"
   ; if the size of b = 1 print b[0]
   ; if the size of b > 1 print b[^2]
   (if (= (count b) 0) (println (str "No other arguments.")))
   (if (= (count b) 1) (println (last b)))
   (if (> (count b) 1) (println (second (sort > b)))))
 (println (multi 1 2 3 4 5))


 (let
  [x 3]
   (defn apply-anonymous-function
     [anonymous-function]
     (anonymous-function x))
 (println (apply-anonymous-function #(/ % %))))


;take 3 numeric args and return the sum of the largest two
 (defn sum-of-largest-two
     [& x]
     (+ (first(sort > x)) (second(sort > x)))
 )
 (println(sum-of-largest-two 1 2 3 4 5))
```

