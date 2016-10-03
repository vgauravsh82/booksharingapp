(ns booksharingapp.routes.home
  (:require [booksharingapp.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [booksharingapp.db.core :as db]
            [clojure.java.io :as io]
            [bouncer.core :as b]
            [bouncer.validators :as v]
            [ring.util.response :refer [redirect]]))

(defn home-page []
  (layout/render "home.html"))

(defn user-book [{:keys [flash]}]
  (layout/render "book.html"
  (merge {:books (db/get-books)}
           (select-keys flash [:book_name :author :create_time]))))

(defn thankyou-page []
  (layout/render "thankyou.html") )

(defn register-page [{:keys [flash]}]
  (layout/render 
    "register.html"
    (merge {:messages (db/get-user)}
          (select-keys flash [:id :email :errors]))))

(defn validate-user [params]
  (first
    (b/validate
      params
      :first_name v/required
      :email v/required
      :pass [v/required [v/min-count 8]])))


(defn save-book! [{:keys [params]}]
    (do
      (db/save-book!
        (assoc params :create_time (java.util.Date.)))
      (response/found "/book")))

(defn create-user! [{:keys [params]}]
  (if-let [errors (validate-user params)]
    (-> (response/found "/register")
        (assoc :flash (assoc params :errors errors)))
    (do
      (db/create-user!
      (assoc params :timestamp (java.util.Date.)))
      (response/found "/thankyou"))))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/book" request (user-book request))
  (POST "/saveBook" request (save-book! request))
  (GET "/docs" [] (response/ok (-> "docs/docs.md" io/resource slurp)))
  (POST "/register" request (create-user! request))
  (GET "/thankyou" [] (thankyou-page))
  (GET "/register" request (register-page request)))

