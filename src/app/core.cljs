(ns app.core
  (:require [reagent.dom.client :as r]
            ["@mantine/core" :refer [MantineProvider AppShell]]))

(comment
  "This breaks!"
  (defn app-shell
    [container]
    [:> AppShell {:header #js {:height 60} :padding "md"}
     [:> AppShell.Header [:div "[logo here]"]]
     [:> AppShell.Main container]]))

(defn app-shell
  [container]
  [:> AppShell {:header #js {:height 60} :padding "md"}
   [:> (.-Header AppShell) [:div "[logo here]"]]
   [:> (.-Main AppShell) container]])

(defonce root
  (r/create-root
   (js/document.getElementById "app")))

(defn render []
  (r/render root
   [:> MantineProvider
    [app-shell "Hello World"]]))

(defn ^:export init [] (render))
