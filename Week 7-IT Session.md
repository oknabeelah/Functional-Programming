03/11/2026

## Koans

```clojure
(defn is-even? [n]
  (if (= n 0)
    __
    (___ (is-even? (dec n)))))

(defn is-even-bigint? [n]
  (loop [n   n
         acc true]
    (if (= n 0)
      __
      (recur (dec n) (not acc)))))

(defn recursive-reverse [coll]
  __)

(defn factorial [n]
  __)
```

evaluate
```clojure
(defn is-even? [n]
  (if (= n 0)
    true
    (= false (is-even? (dec n)))))

(defn is-even-bigint? [n]
  (loop [n   n
         acc true]
    (if (= n 0)
      acc
      (recur (dec' n) (not acc)))))

(defn recursive-reverse [coll]
  (rseq coll))

(defn factorial [n]
    (loop [cnt n
           acc 1]
      (if (zero? cnt)
        acc
        (recur (dec cnt) (* acc cnt)))))

(println("1"))
(println(= true (is-even? 0)))

;; (println(= false (is-even? 1)))

;; (println(= false (is-even-bigint? 100003N)))

;; (println(= '(1) (recursive-reverse [1])))
;; (println(= '(5 4 3 2 1) (recursive-reverse [1 2 3 4 5])))

;; (println(= 1 (factorial 1)))
;; (println(= 2 (factorial 2)))
;; (println(= 6 (factorial 3)))
;; (println(= 24 (factorial 4)))
;; (println(< 1000000000000000000000000N (factorial 1000N)))

```

## Exercises
1. Find and return the minimum element in a vector, where the vector is given as a parameter. e.g. `(findmin [1 2 3 4 5])`

2. Compute and return the sum of all elements in a vector, where the vector is given as a parameter. e.g. `(findsum [1 2 3 4 5])`

3. Determine whether a vector is a palindrome. e.g. `(palindrome? [1 2 3 4 3 2 1])`

4. Do you like treasure hunts? In this problem you are to write a program to explore the 2-dimensional array shown above for treasure. Your program should display the cells that it visits during its search, and also a message that gives the location of the treasure.
```txt
 +------------------------+
 ¦ 34 ¦ 21 ¦ 32 ¦ 41 ¦ 25 ¦
 +----+----+----+----+----+
 ¦ 14 ¦ 42 ¦ 43 ¦ 14 ¦ 31 ¦
 +----+----+----+----+----+
 ¦ 54 ¦ 45 ¦ 52 ¦ 42 ¦ 23 ¦
 +----+----+----+----+----+
 ¦ 33 ¦ 15 ¦ 51 ¦ 31 ¦ 35 ¦
 +----+----+----+----+----+
 ¦ 21 ¦ 52 ¦ 33 ¦ 13 ¦ 23 ¦
 +------------------------+
```
The values in the array are clues:
Each cell contains an integer between 11 and55.
For each value the ten’s digit represents the row number and the unit’s digit represents the column number of the cell containing the next clue.
Starting in the upper left corner (at 1,1), use the clues to guide your search of the array. (The first three clues are 11, 34, 42).
The treasure is a cell whose value is the same as its coordinates.
Note
You only need the numbers from the treasure map. You don’t need to +--- and | separators.
