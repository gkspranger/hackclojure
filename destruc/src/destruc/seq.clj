(ns destruc.seq
  (:gen-class))

; having a seq inside a set of params
; while using "rest of args" function
(defn afun [a [b c & lrst] & rst]
  (prn lrst)
  (prn rst))

(defn asfun [a [b & lrst :as ls]]
  (prn a)
  (prn b)
  (prn ls))



(comment
  
  (afun 1 [2 3 4 5 6] 7 8 9 0)
  (asfun 1 [2 3 4 5])
  
  )
