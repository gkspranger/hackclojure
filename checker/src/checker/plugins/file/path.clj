(ns checker.plugins.file.path
  (:require [checker.plugins.status :as status]
            [clojure.java.io :as io]))

(defn ok [path]
  (status/compose status/ok (str "File " path " exists.")))

(defn critical [path]
  (status/compose status/critical (str "File " path " does not exist.")))

(defn unknown [path]
  (status/compose status/unknown (str "Unable to determine if file "
                                       path
                                       " exists.")))

(defn check [path]
  (try
    (let [file (io/file path)
          exists (.exists file)]
      (if exists
        (ok path)
        (critical path)))
    (catch Exception _
      (unknown path))))

(comment

  (check "/tmp/hello")
  (check "/tmp/powerlog")
  
  )