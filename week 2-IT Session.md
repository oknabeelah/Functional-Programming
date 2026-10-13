29/09/2026

using regex

Quickly finding the first occurrence of the pattern as a string.
```
(re-find #"dance" text)
```

read a txt file and find the first occurrence of dance
```
(re-find #"dance" (slurp "path/to/your/file.txt"))
```

In Clojure, `(def matcher (re-matcher #"dance" (slurp "./persuasion.txt")))` reads the entire text of the file persuasion.txt into memory and initializes a stateful Java `Matcher` object bound to the symbol matcher.

Because `re-matcher` is stateful, every time you call re-find on it, it will advance to the next match in the text until it runs out of matches.

```
(def matcher
  (re-matcher #"dance" (slurp "./persuasion.txt"))
)

(re-find matcher)
(re-find matcher)
(re-find matcher)
```

find `dance` and `dancing` and omit `dances`
```
danc(e|ing)\b
```

```
(let [book "persuasion.txt"
            p (re-pattern "\\bdanc(e|ing)\\b")]
        (count
          (re-seq p (slurp book))))
```

Clojure `vector` is analogous to java `Arraylist`
it is an extensible collection that has adequate read performance and adequate write performance. 
Unlike `ArrayList`, a Clojure `vector` can contain references to mixed data types. Vectors are space-separated lists of items inside square brackets.
```clojure
(def items [\a \b 1 2 "string"]) ;vectore with 5 items
(count items)
(items 3) ;return items[3]
(get items 3) ;same 
```

You can, of course, nest vectors inside each other: 
```clojure
(def vectorofvectors [ [1 2 3][4 5 6][7 8 9] ])
```

```clojure
(def items [ [1 2 3][4 5 6][7 8 9] ])
(count items)
(print ((items 1) 2)) ; return the 3rd element of the 2nd vector
;(print (get items 2))
```

```clojure
; conj operation.

(= [111 222 333] (conj [111 222] 333))
```

```clojure
; cons => (cons x seq)
;Returns a new seq where x is the first element and seq is the rest.
(cons 333 [111 222]) => (333 111 222)
```

```clojure
;The (subvec) function extracts elements from a vector.

(= [:butter :and] (subvec [:peanut :butter :and :jelly] 1 3))

				  (subvec v start)
                  (subvec v start end)
```
Returns a persistent vector of the items in vector from
start (inclusive) to end (exclusive).
If end is not supplied it defaults to (count vector). 
This operation is O(1) and very fast, as the resulting vector shares structure with the original and no trimming is done.

`we don’t reify the data` - it means to not turn an abstract concept or data relationship into a permanent, physical database table or object. and such reified data takes up a finite amount of space

```clojure
(let [data [\a \b 1 2 "string"]]
	(nth data 3)) => 2
	(nth data 7)) => IndexOutOfBoundsException
	(get data 7)) => nil
	(data 3) => 2 ; not a fan because function call is hidden

(let [data "test-string"] (nth data 23))

(let [data [[1 2 3] [4 5 6] [7 8 9]] ; use case of hidden func call
	 pos 2]
	(get (get data pos) pos)) => 9
```
`let` gives you scope

the interface to any bit of code is a contract that the calling code adheres to - bertrand mayo (microsoft)

exception handling code changes the flow of control of the program

what to do with exceptions? ans: ignore, catching it and executing an alternative path, throwing it

when you throw an exception where does it go? ans: back to the caller, and this repeatedly throws back up until an exception is found

this is also called a side effect and not what we intend in FP

`and` statement
This takes a series of expressions as arguments and evaluates them sequentially until one returns false or nil. 
If none of the expressions return false then the result of the last expression is returned.
```clojure
(and true true) => true
(and false false) => false
(and 0 1) => 1
```

defining `functions`
```clojure
;functions are defined with defn
(defn foo ;
 [x] ;params are placed in square brackets
 x)
```