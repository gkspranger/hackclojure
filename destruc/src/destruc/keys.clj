(ns destruc.keys
  (:gen-class))

(defn fun-with-key-opts [required &
                         {:keys [opt1 opt2 opt3]
                          :or {opt1 "yoyo"
                               opt2 "mama"
                               opt3 "seesee"}}]
  (map #(println %) [required opt1 opt2 opt3]))

(comment
  
  (fun-with-key-opts "hello")
  (fun-with-key-opts "hello" :opt1 "greg")
  (fun-with-key-opts "yayfun" :opt2 3 :opt3 "great")
  
  )