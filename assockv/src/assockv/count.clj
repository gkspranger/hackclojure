(ns assockv.count)

(def my-hash {:a 1
              :b 2
              :c 3
              :d 4})
(def my-nested {:a {
                    :b 2
                    :c 3}})
(def my-vec [1 2 3 4])

(comment
  
  ;; constant time
  (count my-hash)
  (count my-vec)
  (count my-nested)
  
  ;; lazy seqs are diff
  (count (range 0 10))
  (count (take 5 (range 0 10)))
  
  
  
  )