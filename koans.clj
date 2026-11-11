;; Complete the following functions so that the expressions in the Meditations section evaluate to true. 
;; You’ll need to replace the underscores with valid Clojure code.

(defn is-even? [n]
  (if (= n 0)
    true
    (= false (is-even? (dec n)))
    )
  )

(defn is-even-bigint? [n]
  (loop [n   n
         acc true]
    (if (= n 0)
      true
      (= false (dec n) (not acc))) ;; dec' ?
    )
  )

(defn recursive-reverse [coll]
  ;; reverse coll
  (loop [r (rest coll)
        acc (conj () (first coll)) ]
     (if (= (count r) 0)
       acc
       (recur (rest r) (conj acc (first r)))
       )
    )
  )

(defn factorial [n]
  (loop [r n
         acc 1]
    (if (= r 0)
      acc
      (recur (dec r) (* acc r))
      )
    )
  )

;;;;;;; Meditations

;; Recursion ends with a base case
 (= true (is-even? 0))

;; And starts by moving toward that base case
(= false (is-even? 1))

;; Having too many stack frames requires explicit tail calls with recur
(= false (is-even-bigint? 100003N))

;; Reversing directions is easy when you have not gone far
(= '(1) (recursive-reverse [1]))

;; Yet it becomes more difficult the more steps you take
(= '(5 4 3 2 1) (recursive-reverse [1 2 3 4 5]))

;; Simple things may appear simple.
(= 1 (factorial 1))

;; They may require other simple steps.
(= 2 (factorial 2))

;; Sometimes a slightly bigger step is necessary
(= 6 (factorial 3))

;; And eventually you must think harder
(= 24 (factorial 4))

;; You can even deal with very large numbers
(< 1000000000000000000000000N (factorial 1000N))


;;;;;;;;;; Exercises
;; 1. Find and return the minimum element in a vector, where the vector is given as a parameter. e.g. `(findmin [1 2 3 4 5])`
(defn findmin [v]
    (first (sort v)) ;; sort the vector and return the first element
  )

(findmin [1 2 3 4 5])

;;;; codio Solution
(defn find-min [v]
  (letfn [(min? [v m]
            (if (empty? v)
              m
              (if (< (first v) m)
                (recur (rest v) (first v))
                (recur (rest v) m))))]
    (min? v (first v))))
(find-min [2 4 3 5])

;; 2. Compute and return the sum of all elements in a vector, where the vector is given as a parameter. e.g. `(findsum [1 2 3 4 5])`
(defn findsum [v]
  (reduce + v) ;; reduce the vector by summing all elements
  )

(findsum [1 2 3 4 5]) 

;;;;;; codio Solution
(defn find-sum [v]
  (loop [sum 0 vals v]
    (if (empty? vals)
      sum
      (recur (+ (first vals) sum) (rest vals)))))
(find-sum [1 2 3 4 5])
; analogous to (reduce + [1 2 3 4 5])

;; 3. Determine whether a vector is a palindrome. e.g. `(palindrome? [1 2 3 4 3 2 1])`
(defn palindrome? [v]
  (= v (reverse v)) ;; check if the vector is equal to its reverse
  )

(palindrome? [1 2 3 4 3 2 1])

;;;;;;; codio Solution
(defn palindrome? [v]
  (loop [vals v pallie true]
    (cond
      (empty? vals) pallie
      (= 1 (count vals)) pallie
      (= false pallie) pallie
      :else (recur
             (subvec vals 1 (- (count vals) 1))
             (= (first vals) (last vals))))))

(palindrome? [1 2 3 4 3 2 1])