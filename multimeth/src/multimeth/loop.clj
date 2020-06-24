(ns multimeth.loop
  (:gen-class))

(defmulti process-data
  (fn [data] (data :command)))

(defmethod process-data "do-side-effect1" [data]
  ;; imagine reading from a DB
  {:command "do-logic1"
   :data (data :data)
   :changelog ["read from DB"]})

(defmethod process-data "do-logic1" [data]
  {:command "do-side-effect2"
   :data (reduce + (data :data))
   :changelog (conj (data :changelog) "did addition")})

(defmethod process-data "do-side-effect2" [data]
  ;; imagine updating a DB
  {:command "do-logic2"
   :data (data :data)
   :changelog (conj (data :changelog) "updated DB")})

(defmethod process-data "do-logic2" [data]
  (let [new-data (data :data)]
    {:data (* new-data new-data)
     :changelog (conj (data :changelog) "did square")}))

(defmethod process-data :default [data]
  {:data (data :data)
   :changelog (data :changelog)})

(comment
  
  (process-data {:command "do-side-effect1"
                 :data [1 2 3]})

  (process-data {:command "do-logic1"
                 :data [1 2 3]
                 :changelog ["example 1"]})
  
  (process-data {:command "do-logic2"
                 :data 6
                 :changelog ["example 1"]})

  (process-data {:command "do-whatever"
                  :data 6
                  :changelog ["example 1"]})
  
  (if (empty? ({:data "123"
                :command "do"} :command))
    true
    false)
  
  (loop [ls [1 2 3]
         acc 0]
    (if (empty? ls)
      acc
      (recur (rest ls) (+ acc (first ls)))))
  
  ;; final output
  ;; {:data 36, :changelog ["read from DB" "did addition" "updated DB" "did square"]}
  (loop [data {:command "do-side-effect1"
               :data [1 2 3]}]
    (if (empty? (data :command))
      data
      (recur (process-data data))))

  )