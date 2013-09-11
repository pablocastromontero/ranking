(ns ranking.torneos.torneo
  (:require [hyperion.api :refer :all]))

(defentity Torneo
  [nombre]
  [fecha]
  [participantes]
  [created-at]
  [updated-at])
