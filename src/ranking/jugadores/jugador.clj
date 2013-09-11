(ns ranking.torneos.torneo
  (:require [hyperion.api :refer :all]))

(defentity Torneo
  [nombre]
  [puntos]
  [created-at]
  [updated-at])
