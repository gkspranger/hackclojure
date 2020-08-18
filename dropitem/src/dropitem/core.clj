(ns dropitem.core
  (:gen-class))

(def myseq '(1 2 3 4))
(def myset #{1 2 3 4})
(def myvec [1 2 3 4])
(def myhash {:a 1 :b 2 :c 3})

(comment
  
  (println myseq)
  (println myset)
  
  (disj myset 1)
  ; no-op
  (disj myset 10)
  
  (dissoc myhash :b)
  
  (pop myvec)
  
  (vec myset)
  
  (vec (remove #(>= % 3) [1 2 3 4 5 6]))
  
  
  
  )