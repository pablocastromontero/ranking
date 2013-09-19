(ns ranking.torneos.torneos-presenter
  (:require [hyperion.api :refer :all]
            [chee.datetime :refer [now]]))

(defn index [key]
  (let [participantes (filter (fn[x] (= key (x :torneo-key))) (find-by-kind :jugadoresxtorneo))
        participantes-presenter '()
        ]
    (for [participante participantes]
      (let [jugador (find-by-key (participante :jugador-key))]
        (conj {:key (:key jugador) :nombre (:nombre jugador) :posicion (:posicion participante) :puntos (:puntos participante)}
              participantes-presenter
          )
        )
      )
    )
  )