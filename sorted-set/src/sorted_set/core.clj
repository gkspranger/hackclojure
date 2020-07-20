(ns sorted-set.core
  (:gen-class))

(comment
  
  #{1 2 3 4}
  (into #{} [1 1 2 3 4])
  (sorted-set 1 1 2 3 4 5)
  
  ; this wont work, have to be comparable
  (sorted-set :a 1)
  
  (into (sorted-set) [1 1 2 3 5 7 3 2 2 5 9])
  
  (sorted-set-by (comparator >) 3 2 1 4 5 8 2 9)
  (sorted-set-by (comparator <) 3 2 1 4 5 8 2 9)
  
  (sorted-set-by (fn [a b]
                   (compare (:age a) (:age b)))
                 {:age 100}
                 {:age 45}
                 {:age 23}
                 {:age 78})
  
  
  )