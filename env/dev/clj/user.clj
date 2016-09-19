(ns user
  (:require [mount.core :as mount]
            [booksharingapp.figwheel :refer [start-fw stop-fw cljs]]
            booksharingapp.core))

(defn start []
  (mount/start-without #'booksharingapp.core/repl-server))

(defn stop []
  (mount/stop-except #'booksharingapp.core/repl-server))

(defn restart []
  (stop)
  (start))


