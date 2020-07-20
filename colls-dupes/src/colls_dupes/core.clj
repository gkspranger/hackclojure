(ns colls-dupes.core
  (:gen-class))

(def myset #{1 2 3})
; can't do this one
; (def mysetbad #{1 1 2 3})

; same goes for hashmaps -- can't define with dupes
(def mymap {:fname "Greg"
            :lname "Spranger"})

(comment
  
  ; when you create a def and set it cannot have dupes in it
  ; but you can conj dupes
  (conj myset 1 1 2 3 4)
  ; one thing to note is that when you conj a dupe in a set, the 1st is chosen
  ; a vector and list are considered equal if contents are equal
  (conj myset [1 2 3] (list 1 2 3))
  (conj myset (list 1 2 3) [1 2 3])
  
  ; the last conj/operand wins
  (conj mymap [:fname "Greg"] [:fname "Abby"])
  
  ; keep an eye out for hashmaps with a coll as its key
  ; it kept the 1st instance of the coll with same same values
  ; so even tho the coll changed types, it only updated the value
  (conj mymap [[1] "1V"] [(list 1) "1L"])
  (conj mymap [(list 1) "1L"] [[1] "1V"])
  
  
  
  
  
  )

