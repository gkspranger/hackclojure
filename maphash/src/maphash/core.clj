(ns maphash.core
  (:gen-class))

(def person {:fname "Greg"
             :lname "Spranger"
             :age 45
             :height_in_inches 75
             :books {
                     :tech ["release it" "the unicorn project"]
                     :adventure ["grey man" "chickenhawk"]}})

(comment
  
  (map #(println %) person)
  (map #(println (last %)) person)
  
  )