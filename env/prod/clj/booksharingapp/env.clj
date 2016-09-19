(ns booksharingapp.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[booksharingapp started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[booksharingapp has shut down successfully]=-"))
   :middleware identity})
