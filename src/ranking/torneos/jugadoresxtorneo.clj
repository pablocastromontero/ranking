(ns ranking.torneos.jugadoresxtorneo
  (:require [hyperion.api :refer :all]
            [hyperion.types :refer :all]))

(defentity jugadoresxtorneo
  [jugador-key :type (foreign-key :jugadores) :db-name :id-jugador]
  [torneo-key :type (foreign-key :torneos) :db-name :id-torneo]
  [posicion]
  [puntos])
