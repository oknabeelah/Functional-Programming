;; treasure hunt
;; program to explore a 2d array (vector of vectors)
;; Your program should display the cells that it visits during its search, 
;; and also a message that gives the location of the treasure.

;; The values in the array are clues:
;; Each cell contains an integer between 11 and 55.
;; For each value the ten’s digit represents the row number and the unit’s digit represents the column number of the cell containing the next clue.
;; Starting in the upper left corner (at 1,1), use the clues to guide your search of the array. (The first three clues are 11, 34, 42).
;; The treasure is a cell whose value is the same as its coordinates.

;;  +------------------------+
;; ¦ 34 ¦ 21 ¦ 32 ¦ 41 ¦ 25 ¦
;; +----+----+----+----+----+
;; ¦ 14 ¦ 42 ¦ 43 ¦ 14 ¦ 31 ¦
;; +----+----+----+----+----+
;; ¦ 54 ¦ 45 ¦ 52 ¦ 42 ¦ 23 ¦
;; +----+----+----+----+----+
;; ¦ 33 ¦ 15 ¦ 51 ¦ 31 ¦ 35 ¦
;; +----+----+----+----+----+
;; ¦ 21 ¦ 52 ¦ 33 ¦ 13 ¦ 23 ¦
;; +------------------------+

;; cell coordinates
;; 11 12 13 14 15
;; 21 22 23 24 25
;; 31 32 33 34 35
;; 41 42 43 44 45
;; 51 52 53 54 55

(let [treasure-map
      [[34 21 32 41 25]
       [14 42 43 14 31]
       [54 45 52 42 23]
       [33 15 51 31 35]
       [21 52 33 13 23] ]
      start 11 ]

(loop [cell start]
   (let [row (- (quot cell 10) 1)
         col (- (rem cell 10) 1)
         val ((treasure-map row) col) ]

     (prn (str row " " col " " val))
     (if (= val cell)
       val
       (recur val)
       )
     )
  ) )



