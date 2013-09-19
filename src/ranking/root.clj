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
    [ranking.torneos.jugadoresxtorneo :only (jugadoresxtorneo)]
    [ranking.torneos.torneo :only (torneos)]
    [ranking.jugadores.jugador :only (jugadores)]
    ))


;System.setProperty( "sun.security.ssl.allowUnsafeRenegotiation", "true" )

;(System/setProperty "sun.security.ssl.allowUnsafeRenegotiation" "true")
;(set-ds! (new-datastore :implementation :postgres :connection-url "jdbc:postgresql://23.21.196.147:5432/dehdm1r23cnn6k?user=rflqvcnlvsqmzq&password=PdB7ouH8F1KV_DoY489UOzjkQg&ssl=true"))
(set-ds! (new-datastore :implementation :postgres :connection-url "jdbc:postgresql://localhost:5432/ranking?user=pablo"))


(defroutes ranking-routes
  (GET "/" [] (redirect "/index"))
  (controller-router 'ranking)
  (not-found (render-template "not_found" :template-root "ranking/util" :ns `ranking.util.view-helpers)))

(def app-handler
  (->
    ranking-routes
    (wrap-view-context :layout "util/layout" :template-root "ranking" :ns `ranking.util.view-helpers)))

