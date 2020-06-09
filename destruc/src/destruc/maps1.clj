(ns destruc.maps1
  (:gen-class))

; keyword and variable need to be identical
; :a == a ,, :b == b ,, etc
(defn afun [a {:keys [b c d]}]
  (prn a)
  (prn c))

(defn prn-name [{:keys [fname lname]}]
  (println (str "hello " fname " " lname)))

; can set a default, but would it be better to partial this ??
; i think param order matters then
(defn prn-name-or [{:keys [fname lname]
                    :or {lname "Doe"}}]
  (println (str "hello " fname " " lname)))

(defn prn-name-as [{:keys [fname lname]
                    :as person}]
  (println person))


(comment
  
  (afun 1 {:b 1 :c 2 :d 3})
  (prn-name {:fname "greg" :lname "spranger"})
  (prn-name-or {:fname "greg"})
  (prn-name-as {:fname "greg" :lname "spranger"})
  
  
  )
