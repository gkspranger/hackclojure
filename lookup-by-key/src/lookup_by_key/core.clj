(ns lookup-by-key.core
  (:gen-class))

; hash map
(def people {:big-russ 1
             :kriss 2
             :rusty 3
             :greg 4})

; vector
(def coordinates [1 2 3])
(def x (get coordinates 0))
(def y (get coordinates 1))
(def z (get coordinates 2))

; set
(def names-i-know #{:russ :kris :rusty :murphy})

(comment
  
  (get people :greg)
  (get people :frank :unknown)
  (:greg people)
  
  z
  
  (get names-i-know :russ)
  (get names-i-know :frank :unknown)
  
  )