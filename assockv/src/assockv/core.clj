(ns assockv.core)

; assoc key and value
; mainly we talking about hashmap here

(def my-hash (assoc {} :a 1))

; but we can be talking about a vector
(def my-vec (assoc [0 1 2] 3 100))

(comment
  
  (println (assoc my-hash
                  :b 2
                  :c 3
                  :a 5))
  (println (update my-hash :a inc))
  (println (update my-hash :a + 10 20 30))
  (println (assoc my-vec 0 100))
  ; this will be OOB because we don't have that many items
  ; (println (assoc my-vec 100 2))
  
  (update ["a" "b" "b"] 0 str "hello world")
  
  
  )