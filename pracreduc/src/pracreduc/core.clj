(ns pracreduc.core
  (:gen-class))

(def myset [:a :a :a :b :c :c :d])

(def myvec [1 1 2 3 4 4 5 1 1 6 7 3 3 8])


(comment
  
  (reduce #(conj %1 %2) #{} myset)
  
  (partition-by #(>= 3 %) (sort myvec))
  
  (partition 3 myvec)
  (partition-all 3 myvec)
  
  
  
  
  
  
  )