(ns seq.core
  (:gen-class))

;; list
(def l '(1 2 3 4))

;; vector
(def v [1 2 3 4])

;; queue
(def q clojure.lang.PersistentQueue/EMPTY)

(comment
  
  ;; stays in order
  (seq l)
  ;; add to front
  (conj l :A)
  (into l [:a :b :c])
  
  (seq v)
  ;; adds to end
  (conj v :A)
  
  
  (seq q)
  ;; adds to end of queue, remove from front
  (seq (conj q :A :B :C))

  (map #(println (str "item: " %)) (seq
                                    (conj l :A)))
  (map #(println (str "item: " %)) (seq
                                    (conj v :A)))
  (map #(println (str "item: " %)) (seq
                                    (conj q :A :B :C :D)))
  
  )