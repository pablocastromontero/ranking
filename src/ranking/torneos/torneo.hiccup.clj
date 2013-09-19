(list
  [:h1.SectionTitle "Detalle"]
  [:table {}
    (let [torneo (:torneo *view-context*)]
       (list
         [:tr {}
           [:td "Nombre"] [:td (:nombre torneo)]
         ]
         [:tr {}
          [:td "Fecha"] [:td (:fecha torneo)]
          ]
         [:tr {}
          [:td "# Participantes"] [:td (:participantes torneo)]
          ]
       )
     )
   ]
  [:h1.SectionTitle "Participantes"]
  [:table {}
    [:thead {}
      [:tr
        [:th "Nombre"]
        [:th "Posicion"]
        [:th "Puntos"]
       ]
     ]
    (for [participante (:participantes *view-context*)]
      [:tr {}
       [:td {}
        [:a {:href (format "/jugadores/%s" (:key participante))} (:nombre participante)]
        ]
       [:td (:posicion participante)]
       [:td (:puntos participante)]])
   ]
)