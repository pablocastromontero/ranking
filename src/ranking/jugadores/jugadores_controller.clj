(ns ranking.jugadores.jugadores-controller
  (:require [compojure.core :refer :all ]
            [joodo.views :refer [render-template render-html]]
            [chee.datetime :refer [now]]
            [ring.util.response :refer [redirect]]
            [joodo.views :refer [render-template render-html]]
            [joodo.env :refer [env *env*]]
            [hyperion.api :refer :all]
            ;[ranking.torneos.torneos-presenter :as presenter :refer [index]]
            ))


(defn- do-jugadores []
  (let  [jugadores (find-by-kind :jugadores :sorts [:puntos :desc])]
    (render-template "jugadores/jugadores" :jugadores jugadores))
  )

(defn- do-jugador [key]
    (render-template "jugadores/jugador")
  )



(defroutes jugadores-controller
  (GET "/jugadores" [] (do-jugadores))
  (context "/jugadores" []
    (GET "/:key" [key] (do-jugador key)
      )
    )
  )
