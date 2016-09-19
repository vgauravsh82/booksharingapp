(ns booksharingapp.routes.home
  (:require [booksharingapp.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [booksharingapp.db.core :as db]
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render "home.html"))

(defn user-book [{:keys [flash]}]
  (layout/render "book.html"
  (merge {:books (db/get-books)}
           (select-keys flash [:book_name :author :create_time]))))



(defn save-book! [{:keys [params]}]
    (do
      (db/save-book!
        (assoc params :create_time (java.util.Date.)))
      (response/found "/book")))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/book" request (user-book request))
  (POST "/saveBook" request (save-book! request))
  (GET "/docs" [] (response/ok (-> "docs/docs.md" io/resource slurp))))

