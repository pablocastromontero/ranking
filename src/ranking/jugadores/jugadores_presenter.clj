(ns ranking.jugadores.jugadores-presenter
  (:require [hyperion.api :refer :all]))

(defn detalle [key]
  (let [posiciones (filter (fn [x] (= key (x :jugador-key))) (find-by-kind :jugadoresxtorneo) )
        posiciones-presenter '()
        ]
      (for [posicion posiciones]
        (let [torneo (find-by-key (posicion :torneo-key))]
          (conj {:torneo-key (torneo :key) :nombre-torneo (torneo :nombre) :fecha-torneo (torneo :fecha) :posicion (posicion :posicion) :puntos (posicion :puntos)}
                posiciones-presenter
            )
          )
        )
    )

  )