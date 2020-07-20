(ns sorted-map.core
  (:gen-class))

(def mymap
  {:fname "Greg"
   :mi "K"
   :lname "Wanger"
   :age 100})

; returns {:a 1, :b 2, :c 3}
(def sm (sorted-map :c 3 :b 2 :a 1))

(def smb (sorted-map-by (comparator <) 0 :a 1 :b 2 :c))

(comment
  
  (sm)
  (sorted-map-by (comparator <) 0 :a 1 :b 2 :c)
  (smb)
  
  (compare "a" "b")
  (compare "a" "a")
  (compare "b" "a")
  (- (compare "a" "b"))
  
  ; easy way to sort a map using normal map declarator
  (into (sorted-map) {:c 3
                      :b 2
                      :a 1})

  )