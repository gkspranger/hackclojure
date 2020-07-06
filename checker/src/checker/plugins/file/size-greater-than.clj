(ns checker.plugins.file.size
  (:require [checker.plugins.status :as status]
            [clojure.java.io :as io]))

(defn check [path warning-size critical-size]
  (try()
    (let [file (io/file path)
          length (.length file)]
      (or
       (when (> length critical-size)
         length)
       (when (> length warning-size)
         length)
       (when (< length warning-size)
         length)))
    (catch Exception _
      "error")))

(comment

  (check "/tmp/hello" 1000 2000)
  (check "/tmp/aciseposture.pid" 1 2)
  
  )