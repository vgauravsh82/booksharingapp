(ns booksharingapp.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [booksharingapp.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[booksharingapp started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[booksharingapp has shut down successfully]=-"))
   :middleware wrap-dev})
