(ns ranking.root
  (:use
    [ring.util.response :only [redirect]]
    [compojure.core :only (defroutes GET)]
    [compojure.route :only (not-found)]
    [joodo.middleware.view-context :only (wrap-view-context)]
    [joodo.views :only (render-template render-html)]
    [joodo.env :refer [env *env*]]
    [joodo.controllers :only (controller-router)]
    [hyperion.api]
    [hyperion.postgres]
    ))


(set-ds! (new-datastore :implementation :postgres :connection-url "jdbc:postgresql://ec2-23-21-196-147.compute-1.amazonaws.com:5432/d3dgs2ne7auio9?user=gdpdllhwvtgaec&password=vQ9c4rUmyoeGXRHkpM1LrqO8iG&ssl=true"))
;(set-ds! (new-datastore :implementation :postgres :connection-url "jdbc:postgresql://localhost:5432/ranking?user=pablo"))


(defroutes ranking-routes
  (GET "/" [] (redirect "/index"))
  (controller-router 'ranking)
  (not-found (render-template "not_found" :template-root "ranking/util" :ns `ranking.view.view-helpers)))

(def app-handler
  (->
    ranking-routes
    (wrap-view-context :layout "util/layout" :template-root "ranking" :ns `ranking.view.view-helpers)))

