(ns assockv.dissoc)

(def my-hash {:a 1
              :b 2
              :c 3
              :d 4})
(def my-vec [1 2 3 4])

(def my-1-atom (atom {}))

(comment
  
  (println (dissoc my-hash :b))
  (println (dissoc my-hash :abc))
  ;; will fail badly
  ;; (println (dissoc my-vec 1))
  
  (swap! my-1-atom assoc :a 1)
  (swap! my-1-atom assoc :b 2)
  (dotimes [_ 5]
    (swap! my-1-atom update "1.1.1.1" 0))
  
  )
