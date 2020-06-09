(ns destruc.maps2
  (:gen-class))

(defn is-shadowed [a {:keys [a b c]}]
  ; the 1st a is shadowed
  (map #(println %) [a b c]))

(defn is-not-shadowed [a {a2 :a
                          :keys [b]
                          c 'c}]
  ; the 1st a is NOT shadowed and i have access to the second a
  (map #(println %) [a a2 b c]))

(defn fun-with-maps [{:keys [a b]
                      :strs [c d]
                      :syms [e f]}]
  (map #(println %) [a b c d e f]))

(comment
  
  (is-shadowed 1 {:a 2 :b 3 :c 4})
  
  (is-not-shadowed 1 {:a 2 :b 3 'c 4})
  
  (fun-with-maps {:a 1 :b 2
                  "c" 3 "d" 4
                  'e 5 'f 6})
  
  )