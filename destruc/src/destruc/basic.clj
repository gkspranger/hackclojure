(ns destruc.basic
  (:gen-class))

; the most basic kind of destructuring
; how a function gets its args
(defn afun [a b c & rst]
  :body)

(comment
  
  (afun 1 2 3 4 5 6 7 8)
  
  )